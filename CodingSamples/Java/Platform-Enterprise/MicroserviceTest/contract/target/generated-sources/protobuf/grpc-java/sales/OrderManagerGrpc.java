package sales;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.1)",
    comments = "Source: order_manager.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OrderManagerGrpc {

  private OrderManagerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "sales.OrderManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sales.OrderManagerOuterClass.OrderInput,
      sales.OrderManagerOuterClass.OrderStatus> getPlaceOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PlaceOrder",
      requestType = sales.OrderManagerOuterClass.OrderInput.class,
      responseType = sales.OrderManagerOuterClass.OrderStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sales.OrderManagerOuterClass.OrderInput,
      sales.OrderManagerOuterClass.OrderStatus> getPlaceOrderMethod() {
    io.grpc.MethodDescriptor<sales.OrderManagerOuterClass.OrderInput, sales.OrderManagerOuterClass.OrderStatus> getPlaceOrderMethod;
    if ((getPlaceOrderMethod = OrderManagerGrpc.getPlaceOrderMethod) == null) {
      synchronized (OrderManagerGrpc.class) {
        if ((getPlaceOrderMethod = OrderManagerGrpc.getPlaceOrderMethod) == null) {
          OrderManagerGrpc.getPlaceOrderMethod = getPlaceOrderMethod =
              io.grpc.MethodDescriptor.<sales.OrderManagerOuterClass.OrderInput, sales.OrderManagerOuterClass.OrderStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PlaceOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sales.OrderManagerOuterClass.OrderInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sales.OrderManagerOuterClass.OrderStatus.getDefaultInstance()))
              .setSchemaDescriptor(new OrderManagerMethodDescriptorSupplier("PlaceOrder"))
              .build();
        }
      }
    }
    return getPlaceOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sales.OrderManagerOuterClass.CustomerInput,
      sales.OrderManagerOuterClass.CustomerOrder> getFetchOrdersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchOrders",
      requestType = sales.OrderManagerOuterClass.CustomerInput.class,
      responseType = sales.OrderManagerOuterClass.CustomerOrder.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<sales.OrderManagerOuterClass.CustomerInput,
      sales.OrderManagerOuterClass.CustomerOrder> getFetchOrdersMethod() {
    io.grpc.MethodDescriptor<sales.OrderManagerOuterClass.CustomerInput, sales.OrderManagerOuterClass.CustomerOrder> getFetchOrdersMethod;
    if ((getFetchOrdersMethod = OrderManagerGrpc.getFetchOrdersMethod) == null) {
      synchronized (OrderManagerGrpc.class) {
        if ((getFetchOrdersMethod = OrderManagerGrpc.getFetchOrdersMethod) == null) {
          OrderManagerGrpc.getFetchOrdersMethod = getFetchOrdersMethod =
              io.grpc.MethodDescriptor.<sales.OrderManagerOuterClass.CustomerInput, sales.OrderManagerOuterClass.CustomerOrder>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchOrders"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sales.OrderManagerOuterClass.CustomerInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sales.OrderManagerOuterClass.CustomerOrder.getDefaultInstance()))
              .setSchemaDescriptor(new OrderManagerMethodDescriptorSupplier("FetchOrders"))
              .build();
        }
      }
    }
    return getFetchOrdersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderManagerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderManagerStub>() {
        @java.lang.Override
        public OrderManagerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderManagerStub(channel, callOptions);
        }
      };
    return OrderManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderManagerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderManagerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderManagerBlockingStub>() {
        @java.lang.Override
        public OrderManagerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderManagerBlockingStub(channel, callOptions);
        }
      };
    return OrderManagerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderManagerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderManagerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderManagerFutureStub>() {
        @java.lang.Override
        public OrderManagerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderManagerFutureStub(channel, callOptions);
        }
      };
    return OrderManagerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void placeOrder(sales.OrderManagerOuterClass.OrderInput request,
        io.grpc.stub.StreamObserver<sales.OrderManagerOuterClass.OrderStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPlaceOrderMethod(), responseObserver);
    }

    /**
     */
    default void fetchOrders(sales.OrderManagerOuterClass.CustomerInput request,
        io.grpc.stub.StreamObserver<sales.OrderManagerOuterClass.CustomerOrder> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchOrdersMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OrderManager.
   */
  public static abstract class OrderManagerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return OrderManagerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OrderManager.
   */
  public static final class OrderManagerStub
      extends io.grpc.stub.AbstractAsyncStub<OrderManagerStub> {
    private OrderManagerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderManagerStub(channel, callOptions);
    }

    /**
     */
    public void placeOrder(sales.OrderManagerOuterClass.OrderInput request,
        io.grpc.stub.StreamObserver<sales.OrderManagerOuterClass.OrderStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void fetchOrders(sales.OrderManagerOuterClass.CustomerInput request,
        io.grpc.stub.StreamObserver<sales.OrderManagerOuterClass.CustomerOrder> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getFetchOrdersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OrderManager.
   */
  public static final class OrderManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OrderManagerBlockingStub> {
    private OrderManagerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderManagerBlockingStub(channel, callOptions);
    }

    /**
     */
    public sales.OrderManagerOuterClass.OrderStatus placeOrder(sales.OrderManagerOuterClass.OrderInput request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPlaceOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<sales.OrderManagerOuterClass.CustomerOrder> fetchOrders(
        sales.OrderManagerOuterClass.CustomerInput request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getFetchOrdersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OrderManager.
   */
  public static final class OrderManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<OrderManagerFutureStub> {
    private OrderManagerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderManagerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sales.OrderManagerOuterClass.OrderStatus> placeOrder(
        sales.OrderManagerOuterClass.OrderInput request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PLACE_ORDER = 0;
  private static final int METHODID_FETCH_ORDERS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PLACE_ORDER:
          serviceImpl.placeOrder((sales.OrderManagerOuterClass.OrderInput) request,
              (io.grpc.stub.StreamObserver<sales.OrderManagerOuterClass.OrderStatus>) responseObserver);
          break;
        case METHODID_FETCH_ORDERS:
          serviceImpl.fetchOrders((sales.OrderManagerOuterClass.CustomerInput) request,
              (io.grpc.stub.StreamObserver<sales.OrderManagerOuterClass.CustomerOrder>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getPlaceOrderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              sales.OrderManagerOuterClass.OrderInput,
              sales.OrderManagerOuterClass.OrderStatus>(
                service, METHODID_PLACE_ORDER)))
        .addMethod(
          getFetchOrdersMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              sales.OrderManagerOuterClass.CustomerInput,
              sales.OrderManagerOuterClass.CustomerOrder>(
                service, METHODID_FETCH_ORDERS)))
        .build();
  }

  private static abstract class OrderManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sales.OrderManagerOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderManager");
    }
  }

  private static final class OrderManagerFileDescriptorSupplier
      extends OrderManagerBaseDescriptorSupplier {
    OrderManagerFileDescriptorSupplier() {}
  }

  private static final class OrderManagerMethodDescriptorSupplier
      extends OrderManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OrderManagerMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (OrderManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderManagerFileDescriptorSupplier())
              .addMethod(getPlaceOrderMethod())
              .addMethod(getFetchOrdersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
