package app.services;


import java.util.Date;

import app.data.Counter;
import app.data.Order;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import jakarta.persistence.Persistence;
import sales.OrderManagerGrpc.OrderManagerImplBase;
import sales.OrderManagerOuterClass.CustomerInput;
import sales.OrderManagerOuterClass.CustomerOrder;
import sales.OrderManagerOuterClass.OrderInput;
import sales.OrderManagerOuterClass.OrderStatus;

public class OrderManagerService extends OrderManagerImplBase {

    @Override
    public void fetchOrders(CustomerInput request, StreamObserver<CustomerOrder> responseObserver) {
        var emf = Persistence.createEntityManagerFactory("app.data");
        try(var em = emf.createEntityManager()){
            var orders = em.createQuery("SELECT e FROM Order e WHERE e.customerId=?1", Order.class)
                            .setParameter(1, request.getCustomerCode())
                            .getResultList();
            for(var entity : orders){
                var message = CustomerOrder.newBuilder()
                                .setItemCode(entity.getProductNo())
                                .setItemCount(entity.getQuantity())
                                .setConfirmationDate(entity.orderDateAsString())
                                .build();
                responseObserver.onNext(message);
            }
            responseObserver.onCompleted();

        }
    }

    @Override
    public void placeOrder(OrderInput request, StreamObserver<OrderStatus> responseObserver) {
        var emf = Persistence.createEntityManagerFactory("app.data");
        try(var em = emf.createEntityManager()){
            var tx = em.getTransaction();
            tx.begin();
            int orderNo = em.find(Counter.class, "orders")
                            .nextValue() + 1000;
            var entity = new Order();
            entity.setOrderNo(orderNo);
            entity.setOrderDate(new Date());
            entity.setCustomerId(request.getCustomerCode());
            entity.setProductNo(request.getItemCode());
            entity.setQuantity(request.getItemCount());
            em.persist(entity);
            tx.commit();
            var result = OrderStatus.newBuilder()
                            .setConfirmationCode(orderNo)
                            .build();
            responseObserver.onNext(result);
            responseObserver.onCompleted();
        }catch(Exception e){
            var fault = Status.INTERNAL
                            .withCause(e)
                            .withDescription("Order Failed")
                            .asRuntimeException();
            responseObserver.onError(fault);
        }
    }
    
}
