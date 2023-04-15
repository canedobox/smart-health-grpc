package com.learn.service2;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service2.proto")
public final class Service2Grpc {

  private Service2Grpc() {}

  public static final String SERVICE_NAME = "Service2";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.learn.service2.StepCountRequest,
      com.learn.service2.StepCountResponse> getIncrementStepCountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "incrementStepCount",
      requestType = com.learn.service2.StepCountRequest.class,
      responseType = com.learn.service2.StepCountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.learn.service2.StepCountRequest,
      com.learn.service2.StepCountResponse> getIncrementStepCountMethod() {
    io.grpc.MethodDescriptor<com.learn.service2.StepCountRequest, com.learn.service2.StepCountResponse> getIncrementStepCountMethod;
    if ((getIncrementStepCountMethod = Service2Grpc.getIncrementStepCountMethod) == null) {
      synchronized (Service2Grpc.class) {
        if ((getIncrementStepCountMethod = Service2Grpc.getIncrementStepCountMethod) == null) {
          Service2Grpc.getIncrementStepCountMethod = getIncrementStepCountMethod = 
              io.grpc.MethodDescriptor.<com.learn.service2.StepCountRequest, com.learn.service2.StepCountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Service2", "incrementStepCount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service2.StepCountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service2.StepCountResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Service2MethodDescriptorSupplier("incrementStepCount"))
                  .build();
          }
        }
     }
     return getIncrementStepCountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learn.service2.StepCountHistoryRequest,
      com.learn.service2.StepCountHistoryResponse> getGetStepCountHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStepCountHistory",
      requestType = com.learn.service2.StepCountHistoryRequest.class,
      responseType = com.learn.service2.StepCountHistoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.learn.service2.StepCountHistoryRequest,
      com.learn.service2.StepCountHistoryResponse> getGetStepCountHistoryMethod() {
    io.grpc.MethodDescriptor<com.learn.service2.StepCountHistoryRequest, com.learn.service2.StepCountHistoryResponse> getGetStepCountHistoryMethod;
    if ((getGetStepCountHistoryMethod = Service2Grpc.getGetStepCountHistoryMethod) == null) {
      synchronized (Service2Grpc.class) {
        if ((getGetStepCountHistoryMethod = Service2Grpc.getGetStepCountHistoryMethod) == null) {
          Service2Grpc.getGetStepCountHistoryMethod = getGetStepCountHistoryMethod = 
              io.grpc.MethodDescriptor.<com.learn.service2.StepCountHistoryRequest, com.learn.service2.StepCountHistoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Service2", "getStepCountHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service2.StepCountHistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service2.StepCountHistoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Service2MethodDescriptorSupplier("getStepCountHistory"))
                  .build();
          }
        }
     }
     return getGetStepCountHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learn.service2.StepCountAverageRequest,
      com.learn.service2.StepCountAverageResponse> getCalculateStepCountAverageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "calculateStepCountAverage",
      requestType = com.learn.service2.StepCountAverageRequest.class,
      responseType = com.learn.service2.StepCountAverageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.learn.service2.StepCountAverageRequest,
      com.learn.service2.StepCountAverageResponse> getCalculateStepCountAverageMethod() {
    io.grpc.MethodDescriptor<com.learn.service2.StepCountAverageRequest, com.learn.service2.StepCountAverageResponse> getCalculateStepCountAverageMethod;
    if ((getCalculateStepCountAverageMethod = Service2Grpc.getCalculateStepCountAverageMethod) == null) {
      synchronized (Service2Grpc.class) {
        if ((getCalculateStepCountAverageMethod = Service2Grpc.getCalculateStepCountAverageMethod) == null) {
          Service2Grpc.getCalculateStepCountAverageMethod = getCalculateStepCountAverageMethod = 
              io.grpc.MethodDescriptor.<com.learn.service2.StepCountAverageRequest, com.learn.service2.StepCountAverageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Service2", "calculateStepCountAverage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service2.StepCountAverageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service2.StepCountAverageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Service2MethodDescriptorSupplier("calculateStepCountAverage"))
                  .build();
          }
        }
     }
     return getCalculateStepCountAverageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Service2Stub newStub(io.grpc.Channel channel) {
    return new Service2Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Service2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Service2BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Service2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Service2FutureStub(channel);
  }

  /**
   */
  public static abstract class Service2ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Increment a user's step count (current date).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.learn.service2.StepCountRequest> incrementStepCount(
        io.grpc.stub.StreamObserver<com.learn.service2.StepCountResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getIncrementStepCountMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a user's step count history.
     * </pre>
     */
    public void getStepCountHistory(com.learn.service2.StepCountHistoryRequest request,
        io.grpc.stub.StreamObserver<com.learn.service2.StepCountHistoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStepCountHistoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Calculate step count average.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.learn.service2.StepCountAverageRequest> calculateStepCountAverage(
        io.grpc.stub.StreamObserver<com.learn.service2.StepCountAverageResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getCalculateStepCountAverageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getIncrementStepCountMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.learn.service2.StepCountRequest,
                com.learn.service2.StepCountResponse>(
                  this, METHODID_INCREMENT_STEP_COUNT)))
          .addMethod(
            getGetStepCountHistoryMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.learn.service2.StepCountHistoryRequest,
                com.learn.service2.StepCountHistoryResponse>(
                  this, METHODID_GET_STEP_COUNT_HISTORY)))
          .addMethod(
            getCalculateStepCountAverageMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.learn.service2.StepCountAverageRequest,
                com.learn.service2.StepCountAverageResponse>(
                  this, METHODID_CALCULATE_STEP_COUNT_AVERAGE)))
          .build();
    }
  }

  /**
   */
  public static final class Service2Stub extends io.grpc.stub.AbstractStub<Service2Stub> {
    private Service2Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service2Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service2Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Increment a user's step count (current date).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.learn.service2.StepCountRequest> incrementStepCount(
        io.grpc.stub.StreamObserver<com.learn.service2.StepCountResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getIncrementStepCountMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a user's step count history.
     * </pre>
     */
    public void getStepCountHistory(com.learn.service2.StepCountHistoryRequest request,
        io.grpc.stub.StreamObserver<com.learn.service2.StepCountHistoryResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStepCountHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Calculate step count average.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.learn.service2.StepCountAverageRequest> calculateStepCountAverage(
        io.grpc.stub.StreamObserver<com.learn.service2.StepCountAverageResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCalculateStepCountAverageMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class Service2BlockingStub extends io.grpc.stub.AbstractStub<Service2BlockingStub> {
    private Service2BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service2BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service2BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service2BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Retrieves a user's step count history.
     * </pre>
     */
    public java.util.Iterator<com.learn.service2.StepCountHistoryResponse> getStepCountHistory(
        com.learn.service2.StepCountHistoryRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStepCountHistoryMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Service2FutureStub extends io.grpc.stub.AbstractStub<Service2FutureStub> {
    private Service2FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service2FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service2FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service2FutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_STEP_COUNT_HISTORY = 0;
  private static final int METHODID_INCREMENT_STEP_COUNT = 1;
  private static final int METHODID_CALCULATE_STEP_COUNT_AVERAGE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Service2ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Service2ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STEP_COUNT_HISTORY:
          serviceImpl.getStepCountHistory((com.learn.service2.StepCountHistoryRequest) request,
              (io.grpc.stub.StreamObserver<com.learn.service2.StepCountHistoryResponse>) responseObserver);
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
        case METHODID_INCREMENT_STEP_COUNT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.incrementStepCount(
              (io.grpc.stub.StreamObserver<com.learn.service2.StepCountResponse>) responseObserver);
        case METHODID_CALCULATE_STEP_COUNT_AVERAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.calculateStepCountAverage(
              (io.grpc.stub.StreamObserver<com.learn.service2.StepCountAverageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Service2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Service2BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.learn.service2.Service2Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service2");
    }
  }

  private static final class Service2FileDescriptorSupplier
      extends Service2BaseDescriptorSupplier {
    Service2FileDescriptorSupplier() {}
  }

  private static final class Service2MethodDescriptorSupplier
      extends Service2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Service2MethodDescriptorSupplier(String methodName) {
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
      synchronized (Service2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Service2FileDescriptorSupplier())
              .addMethod(getIncrementStepCountMethod())
              .addMethod(getGetStepCountHistoryMethod())
              .addMethod(getCalculateStepCountAverageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
