package via.sdj3.grpcspringbootx.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * service definitions
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: Slaughterhouse.proto")
public final class SlaughterhouseGrpc {

  private SlaughterhouseGrpc() {}

  public static final String SERVICE_NAME = "Slaughterhouse";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<via.sdj3.grpcspringbootx.protobuf.RequestAnimalsInProduct,
      via.sdj3.grpcspringbootx.protobuf.ResponseAnimalsInProduct> getGetAnimalIdsOfProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAnimalIdsOfProduct",
      requestType = via.sdj3.grpcspringbootx.protobuf.RequestAnimalsInProduct.class,
      responseType = via.sdj3.grpcspringbootx.protobuf.ResponseAnimalsInProduct.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sdj3.grpcspringbootx.protobuf.RequestAnimalsInProduct,
      via.sdj3.grpcspringbootx.protobuf.ResponseAnimalsInProduct> getGetAnimalIdsOfProductMethod() {
    io.grpc.MethodDescriptor<via.sdj3.grpcspringbootx.protobuf.RequestAnimalsInProduct, via.sdj3.grpcspringbootx.protobuf.ResponseAnimalsInProduct> getGetAnimalIdsOfProductMethod;
    if ((getGetAnimalIdsOfProductMethod = SlaughterhouseGrpc.getGetAnimalIdsOfProductMethod) == null) {
      synchronized (SlaughterhouseGrpc.class) {
        if ((getGetAnimalIdsOfProductMethod = SlaughterhouseGrpc.getGetAnimalIdsOfProductMethod) == null) {
          SlaughterhouseGrpc.getGetAnimalIdsOfProductMethod = getGetAnimalIdsOfProductMethod =
              io.grpc.MethodDescriptor.<via.sdj3.grpcspringbootx.protobuf.RequestAnimalsInProduct, via.sdj3.grpcspringbootx.protobuf.ResponseAnimalsInProduct>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAnimalIdsOfProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcspringbootx.protobuf.RequestAnimalsInProduct.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcspringbootx.protobuf.ResponseAnimalsInProduct.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseMethodDescriptorSupplier("getAnimalIdsOfProduct"))
              .build();
        }
      }
    }
    return getGetAnimalIdsOfProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sdj3.grpcspringbootx.protobuf.RequestProductsWithAnimal,
      via.sdj3.grpcspringbootx.protobuf.ResponseProductsWithAnimal> getGetProductIdsWithAnimalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProductIdsWithAnimal",
      requestType = via.sdj3.grpcspringbootx.protobuf.RequestProductsWithAnimal.class,
      responseType = via.sdj3.grpcspringbootx.protobuf.ResponseProductsWithAnimal.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sdj3.grpcspringbootx.protobuf.RequestProductsWithAnimal,
      via.sdj3.grpcspringbootx.protobuf.ResponseProductsWithAnimal> getGetProductIdsWithAnimalMethod() {
    io.grpc.MethodDescriptor<via.sdj3.grpcspringbootx.protobuf.RequestProductsWithAnimal, via.sdj3.grpcspringbootx.protobuf.ResponseProductsWithAnimal> getGetProductIdsWithAnimalMethod;
    if ((getGetProductIdsWithAnimalMethod = SlaughterhouseGrpc.getGetProductIdsWithAnimalMethod) == null) {
      synchronized (SlaughterhouseGrpc.class) {
        if ((getGetProductIdsWithAnimalMethod = SlaughterhouseGrpc.getGetProductIdsWithAnimalMethod) == null) {
          SlaughterhouseGrpc.getGetProductIdsWithAnimalMethod = getGetProductIdsWithAnimalMethod =
              io.grpc.MethodDescriptor.<via.sdj3.grpcspringbootx.protobuf.RequestProductsWithAnimal, via.sdj3.grpcspringbootx.protobuf.ResponseProductsWithAnimal>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProductIdsWithAnimal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcspringbootx.protobuf.RequestProductsWithAnimal.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcspringbootx.protobuf.ResponseProductsWithAnimal.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseMethodDescriptorSupplier("getProductIdsWithAnimal"))
              .build();
        }
      }
    }
    return getGetProductIdsWithAnimalMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SlaughterhouseStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseStub>() {
        @java.lang.Override
        public SlaughterhouseStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseStub(channel, callOptions);
        }
      };
    return SlaughterhouseStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SlaughterhouseBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseBlockingStub>() {
        @java.lang.Override
        public SlaughterhouseBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseBlockingStub(channel, callOptions);
        }
      };
    return SlaughterhouseBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SlaughterhouseFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseFutureStub>() {
        @java.lang.Override
        public SlaughterhouseFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseFutureStub(channel, callOptions);
        }
      };
    return SlaughterhouseFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * service definitions
   * </pre>
   */
  public static abstract class SlaughterhouseImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAnimalIdsOfProduct(via.sdj3.grpcspringbootx.protobuf.RequestAnimalsInProduct request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcspringbootx.protobuf.ResponseAnimalsInProduct> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnimalIdsOfProductMethod(), responseObserver);
    }

    /**
     */
    public void getProductIdsWithAnimal(via.sdj3.grpcspringbootx.protobuf.RequestProductsWithAnimal request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcspringbootx.protobuf.ResponseProductsWithAnimal> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductIdsWithAnimalMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAnimalIdsOfProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sdj3.grpcspringbootx.protobuf.RequestAnimalsInProduct,
                via.sdj3.grpcspringbootx.protobuf.ResponseAnimalsInProduct>(
                  this, METHODID_GET_ANIMAL_IDS_OF_PRODUCT)))
          .addMethod(
            getGetProductIdsWithAnimalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sdj3.grpcspringbootx.protobuf.RequestProductsWithAnimal,
                via.sdj3.grpcspringbootx.protobuf.ResponseProductsWithAnimal>(
                  this, METHODID_GET_PRODUCT_IDS_WITH_ANIMAL)))
          .build();
    }
  }

  /**
   * <pre>
   * service definitions
   * </pre>
   */
  public static final class SlaughterhouseStub extends io.grpc.stub.AbstractAsyncStub<SlaughterhouseStub> {
    private SlaughterhouseStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseStub(channel, callOptions);
    }

    /**
     */
    public void getAnimalIdsOfProduct(via.sdj3.grpcspringbootx.protobuf.RequestAnimalsInProduct request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcspringbootx.protobuf.ResponseAnimalsInProduct> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnimalIdsOfProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProductIdsWithAnimal(via.sdj3.grpcspringbootx.protobuf.RequestProductsWithAnimal request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcspringbootx.protobuf.ResponseProductsWithAnimal> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductIdsWithAnimalMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * service definitions
   * </pre>
   */
  public static final class SlaughterhouseBlockingStub extends io.grpc.stub.AbstractBlockingStub<SlaughterhouseBlockingStub> {
    private SlaughterhouseBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseBlockingStub(channel, callOptions);
    }

    /**
     */
    public via.sdj3.grpcspringbootx.protobuf.ResponseAnimalsInProduct getAnimalIdsOfProduct(via.sdj3.grpcspringbootx.protobuf.RequestAnimalsInProduct request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnimalIdsOfProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sdj3.grpcspringbootx.protobuf.ResponseProductsWithAnimal getProductIdsWithAnimal(via.sdj3.grpcspringbootx.protobuf.RequestProductsWithAnimal request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductIdsWithAnimalMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * service definitions
   * </pre>
   */
  public static final class SlaughterhouseFutureStub extends io.grpc.stub.AbstractFutureStub<SlaughterhouseFutureStub> {
    private SlaughterhouseFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sdj3.grpcspringbootx.protobuf.ResponseAnimalsInProduct> getAnimalIdsOfProduct(
        via.sdj3.grpcspringbootx.protobuf.RequestAnimalsInProduct request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnimalIdsOfProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sdj3.grpcspringbootx.protobuf.ResponseProductsWithAnimal> getProductIdsWithAnimal(
        via.sdj3.grpcspringbootx.protobuf.RequestProductsWithAnimal request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductIdsWithAnimalMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ANIMAL_IDS_OF_PRODUCT = 0;
  private static final int METHODID_GET_PRODUCT_IDS_WITH_ANIMAL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SlaughterhouseImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SlaughterhouseImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ANIMAL_IDS_OF_PRODUCT:
          serviceImpl.getAnimalIdsOfProduct((via.sdj3.grpcspringbootx.protobuf.RequestAnimalsInProduct) request,
              (io.grpc.stub.StreamObserver<via.sdj3.grpcspringbootx.protobuf.ResponseAnimalsInProduct>) responseObserver);
          break;
        case METHODID_GET_PRODUCT_IDS_WITH_ANIMAL:
          serviceImpl.getProductIdsWithAnimal((via.sdj3.grpcspringbootx.protobuf.RequestProductsWithAnimal) request,
              (io.grpc.stub.StreamObserver<via.sdj3.grpcspringbootx.protobuf.ResponseProductsWithAnimal>) responseObserver);
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

  private static abstract class SlaughterhouseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SlaughterhouseBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return via.sdj3.grpcspringbootx.protobuf.SlaughterhouseOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Slaughterhouse");
    }
  }

  private static final class SlaughterhouseFileDescriptorSupplier
      extends SlaughterhouseBaseDescriptorSupplier {
    SlaughterhouseFileDescriptorSupplier() {}
  }

  private static final class SlaughterhouseMethodDescriptorSupplier
      extends SlaughterhouseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SlaughterhouseMethodDescriptorSupplier(String methodName) {
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
      synchronized (SlaughterhouseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SlaughterhouseFileDescriptorSupplier())
              .addMethod(getGetAnimalIdsOfProductMethod())
              .addMethod(getGetProductIdsWithAnimalMethod())
              .build();
        }
      }
    }
    return result;
  }
}
