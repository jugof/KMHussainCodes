package app.rest;

import java.util.Collection;

import org.springframework.stereotype.Service;

import io.grpc.ManagedChannelBuilder;
import sales.OrderManagerGrpc;
import sales.OrderManagerOuterClass.CustomerInput;
import sales.OrderManagerOuterClass.OrderInput;

@Service
public class SalesAgentModel {
    
    public void loadOrders(String customerId, Collection<OrderResource> entries) {
        var channel = ManagedChannelBuilder.forAddress("localhost", 4030)
                        .usePlaintext()
                        .build();
        try{
            var remote = OrderManagerGrpc.newBlockingStub(channel);
            var request = CustomerInput.newBuilder()
                            .setCustomerCode(customerId)
                            .build();
            var reply = remote.fetchOrders(request);
            reply.forEachRemaining(message -> {
                var entry = new OrderResource();
                entry.productNo = message.getItemCode();
                entry.quantity = message.getItemCount();
                entry.orderDate = message.getConfirmationDate();
                entries.add(entry);
            });
        }finally{
            channel.shutdown();
        }
    }

    public void saveOrder(OrderResource entry) {
        var channel = ManagedChannelBuilder.forAddress("localhost", 4030)
                        .usePlaintext()
                        .build();
        try{
            var remote = OrderManagerGrpc.newBlockingStub(channel);
            var request = OrderInput.newBuilder()
                            .setCustomerCode(entry.customerId)
                            .setItemCode(entry.productNo)
                            .setItemCount(entry.quantity)
                            .build();
            var reply = remote.placeOrder(request);
            entry.orderNo =  reply.getConfirmationCode();
        }finally{
            channel.shutdown();
        }
    }
}
