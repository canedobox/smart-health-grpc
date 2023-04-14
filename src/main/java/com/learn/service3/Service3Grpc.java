package com.learn.service3;

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
    comments = "Source: service3.proto")
public final class Service3Grpc {

  private Service3Grpc() {}

  public static final String SERVICE_NAME = "Service3";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.learn.service3.BMIRequest,
      com.learn.service3.BMIResponse> getCalculateBMIMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "calculateBMI",
      requestType = com.learn.service3.BMIRequest.class,
      responseType = com.learn.service3.BMIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learn.service3.BMIRequest,
      com.learn.service3.BMIResponse> getCalculateBMIMethod() {
    io.grpc.MethodDescriptor<com.learn.service3.BMIRequest, com.learn.service3.BMIResponse> getCalculateBMIMethod;
    if ((getCalculateBMIMethod = Service3Grpc.getCalculateBMIMethod) == null) {
      synchronized (Service3Grpc.class) {
        if ((getCalculateBMIMethod = Service3Grpc.getCalculateBMIMethod) == null) {
          Service3Grpc.getCalculateBMIMethod = getCalculateBMIMethod = 
              io.grpc.MethodDescriptor.<com.learn.service3.BMIRequest, com.learn.service3.BMIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Service3", "calculateBMI"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service3.BMIRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service3.BMIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Service3MethodDescriptorSupplier("calculateBMI"))
                  .build();
          }
        }
     }
     return getCalculateBMIMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learn.service3.WeightLossWeeklyPlanRequest,
      com.learn.service3.WeightLossWeeklyPlanResponse> getCreateWeightLossWeeklyPlanMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createWeightLossWeeklyPlan",
      requestType = com.learn.service3.WeightLossWeeklyPlanRequest.class,
      responseType = com.learn.service3.WeightLossWeeklyPlanResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.learn.service3.WeightLossWeeklyPlanRequest,
      com.learn.service3.WeightLossWeeklyPlanResponse> getCreateWeightLossWeeklyPlanMethod() {
    io.grpc.MethodDescriptor<com.learn.service3.WeightLossWeeklyPlanRequest, com.learn.service3.WeightLossWeeklyPlanResponse> getCreateWeightLossWeeklyPlanMethod;
    if ((getCreateWeightLossWeeklyPlanMethod = Service3Grpc.getCreateWeightLossWeeklyPlanMethod) == null) {
      synchronized (Service3Grpc.class) {
        if ((getCreateWeightLossWeeklyPlanMethod = Service3Grpc.getCreateWeightLossWeeklyPlanMethod) == null) {
          Service3Grpc.getCreateWeightLossWeeklyPlanMethod = getCreateWeightLossWeeklyPlanMethod = 
              io.grpc.MethodDescriptor.<com.learn.service3.WeightLossWeeklyPlanRequest, com.learn.service3.WeightLossWeeklyPlanResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Service3", "createWeightLossWeeklyPlan"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service3.WeightLossWeeklyPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service3.WeightLossWeeklyPlanResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Service3MethodDescriptorSupplier("createWeightLossWeeklyPlan"))
                  .build();
          }
        }
     }
     return getCreateWeightLossWeeklyPlanMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Service3Stub newStub(io.grpc.Channel channel) {
    return new Service3Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Service3BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Service3BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Service3FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Service3FutureStub(channel);
  }

  /**
   */
  public static abstract class Service3ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Calculate BMI (Body Mass Index).
     * </pre>
     */
    public void calculateBMI(com.learn.service3.BMIRequest request,
        io.grpc.stub.StreamObserver<com.learn.service3.BMIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculateBMIMethod(), responseObserver);
    }

    /**
     * <pre>
     * Create a weight loss weekly plan.
     * </pre>
     */
    public void createWeightLossWeeklyPlan(com.learn.service3.WeightLossWeeklyPlanRequest request,
        io.grpc.stub.StreamObserver<com.learn.service3.WeightLossWeeklyPlanResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateWeightLossWeeklyPlanMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCalculateBMIMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learn.service3.BMIRequest,
                com.learn.service3.BMIResponse>(
                  this, METHODID_CALCULATE_BMI)))
          .addMethod(
            getCreateWeightLossWeeklyPlanMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.learn.service3.WeightLossWeeklyPlanRequest,
                com.learn.service3.WeightLossWeeklyPlanResponse>(
                  this, METHODID_CREATE_WEIGHT_LOSS_WEEKLY_PLAN)))
          .build();
    }
  }

  /**
   */
  public static final class Service3Stub extends io.grpc.stub.AbstractStub<Service3Stub> {
    private Service3Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service3Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service3Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service3Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Calculate BMI (Body Mass Index).
     * </pre>
     */
    public void calculateBMI(com.learn.service3.BMIRequest request,
        io.grpc.stub.StreamObserver<com.learn.service3.BMIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCalculateBMIMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Create a weight loss weekly plan.
     * </pre>
     */
    public void createWeightLossWeeklyPlan(com.learn.service3.WeightLossWeeklyPlanRequest request,
        io.grpc.stub.StreamObserver<com.learn.service3.WeightLossWeeklyPlanResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCreateWeightLossWeeklyPlanMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class Service3BlockingStub extends io.grpc.stub.AbstractStub<Service3BlockingStub> {
    private Service3BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service3BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service3BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service3BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Calculate BMI (Body Mass Index).
     * </pre>
     */
    public com.learn.service3.BMIResponse calculateBMI(com.learn.service3.BMIRequest request) {
      return blockingUnaryCall(
          getChannel(), getCalculateBMIMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create a weight loss weekly plan.
     * </pre>
     */
    public java.util.Iterator<com.learn.service3.WeightLossWeeklyPlanResponse> createWeightLossWeeklyPlan(
        com.learn.service3.WeightLossWeeklyPlanRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getCreateWeightLossWeeklyPlanMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Service3FutureStub extends io.grpc.stub.AbstractStub<Service3FutureStub> {
    private Service3FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service3FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service3FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service3FutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Calculate BMI (Body Mass Index).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learn.service3.BMIResponse> calculateBMI(
        com.learn.service3.BMIRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCalculateBMIMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALCULATE_BMI = 0;
  private static final int METHODID_CREATE_WEIGHT_LOSS_WEEKLY_PLAN = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Service3ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Service3ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE_BMI:
          serviceImpl.calculateBMI((com.learn.service3.BMIRequest) request,
              (io.grpc.stub.StreamObserver<com.learn.service3.BMIResponse>) responseObserver);
          break;
        case METHODID_CREATE_WEIGHT_LOSS_WEEKLY_PLAN:
          serviceImpl.createWeightLossWeeklyPlan((com.learn.service3.WeightLossWeeklyPlanRequest) request,
              (io.grpc.stub.StreamObserver<com.learn.service3.WeightLossWeeklyPlanResponse>) responseObserver);
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

  private static abstract class Service3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Service3BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.learn.service3.Service3Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service3");
    }
  }

  private static final class Service3FileDescriptorSupplier
      extends Service3BaseDescriptorSupplier {
    Service3FileDescriptorSupplier() {}
  }

  private static final class Service3MethodDescriptorSupplier
      extends Service3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Service3MethodDescriptorSupplier(String methodName) {
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
      synchronized (Service3Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Service3FileDescriptorSupplier())
              .addMethod(getCalculateBMIMethod())
              .addMethod(getCreateWeightLossWeeklyPlanMethod())
              .build();
        }
      }
    }
    return result;
  }
}
