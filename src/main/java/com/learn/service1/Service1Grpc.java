package com.learn.service1;

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
    comments = "Source: service1.proto")
public final class Service1Grpc {

  private Service1Grpc() {}

  public static final String SERVICE_NAME = "Service1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.learn.service1.SetUserProfileRequest,
      com.learn.service1.SetUserProfileResponse> getSetUserProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setUserProfile",
      requestType = com.learn.service1.SetUserProfileRequest.class,
      responseType = com.learn.service1.SetUserProfileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learn.service1.SetUserProfileRequest,
      com.learn.service1.SetUserProfileResponse> getSetUserProfileMethod() {
    io.grpc.MethodDescriptor<com.learn.service1.SetUserProfileRequest, com.learn.service1.SetUserProfileResponse> getSetUserProfileMethod;
    if ((getSetUserProfileMethod = Service1Grpc.getSetUserProfileMethod) == null) {
      synchronized (Service1Grpc.class) {
        if ((getSetUserProfileMethod = Service1Grpc.getSetUserProfileMethod) == null) {
          Service1Grpc.getSetUserProfileMethod = getSetUserProfileMethod = 
              io.grpc.MethodDescriptor.<com.learn.service1.SetUserProfileRequest, com.learn.service1.SetUserProfileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Service1", "setUserProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service1.SetUserProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service1.SetUserProfileResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Service1MethodDescriptorSupplier("setUserProfile"))
                  .build();
          }
        }
     }
     return getSetUserProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learn.service1.GetUserProfileRequest,
      com.learn.service1.GetUserProfileResponse> getGetUserProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUserProfile",
      requestType = com.learn.service1.GetUserProfileRequest.class,
      responseType = com.learn.service1.GetUserProfileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learn.service1.GetUserProfileRequest,
      com.learn.service1.GetUserProfileResponse> getGetUserProfileMethod() {
    io.grpc.MethodDescriptor<com.learn.service1.GetUserProfileRequest, com.learn.service1.GetUserProfileResponse> getGetUserProfileMethod;
    if ((getGetUserProfileMethod = Service1Grpc.getGetUserProfileMethod) == null) {
      synchronized (Service1Grpc.class) {
        if ((getGetUserProfileMethod = Service1Grpc.getGetUserProfileMethod) == null) {
          Service1Grpc.getGetUserProfileMethod = getGetUserProfileMethod = 
              io.grpc.MethodDescriptor.<com.learn.service1.GetUserProfileRequest, com.learn.service1.GetUserProfileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Service1", "getUserProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service1.GetUserProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.service1.GetUserProfileResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Service1MethodDescriptorSupplier("getUserProfile"))
                  .build();
          }
        }
     }
     return getGetUserProfileMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Service1Stub newStub(io.grpc.Channel channel) {
    return new Service1Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Service1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Service1BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Service1FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Service1FutureStub(channel);
  }

  /**
   */
  public static abstract class Service1ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sets or updates a user's profile.
     * </pre>
     */
    public void setUserProfile(com.learn.service1.SetUserProfileRequest request,
        io.grpc.stub.StreamObserver<com.learn.service1.SetUserProfileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetUserProfileMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a user's profile.
     * </pre>
     */
    public void getUserProfile(com.learn.service1.GetUserProfileRequest request,
        io.grpc.stub.StreamObserver<com.learn.service1.GetUserProfileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserProfileMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetUserProfileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learn.service1.SetUserProfileRequest,
                com.learn.service1.SetUserProfileResponse>(
                  this, METHODID_SET_USER_PROFILE)))
          .addMethod(
            getGetUserProfileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learn.service1.GetUserProfileRequest,
                com.learn.service1.GetUserProfileResponse>(
                  this, METHODID_GET_USER_PROFILE)))
          .build();
    }
  }

  /**
   */
  public static final class Service1Stub extends io.grpc.stub.AbstractStub<Service1Stub> {
    private Service1Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service1Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service1Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service1Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets or updates a user's profile.
     * </pre>
     */
    public void setUserProfile(com.learn.service1.SetUserProfileRequest request,
        io.grpc.stub.StreamObserver<com.learn.service1.SetUserProfileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetUserProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a user's profile.
     * </pre>
     */
    public void getUserProfile(com.learn.service1.GetUserProfileRequest request,
        io.grpc.stub.StreamObserver<com.learn.service1.GetUserProfileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserProfileMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class Service1BlockingStub extends io.grpc.stub.AbstractStub<Service1BlockingStub> {
    private Service1BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service1BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service1BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service1BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets or updates a user's profile.
     * </pre>
     */
    public com.learn.service1.SetUserProfileResponse setUserProfile(com.learn.service1.SetUserProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetUserProfileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a user's profile.
     * </pre>
     */
    public com.learn.service1.GetUserProfileResponse getUserProfile(com.learn.service1.GetUserProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserProfileMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Service1FutureStub extends io.grpc.stub.AbstractStub<Service1FutureStub> {
    private Service1FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service1FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service1FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service1FutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets or updates a user's profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learn.service1.SetUserProfileResponse> setUserProfile(
        com.learn.service1.SetUserProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetUserProfileMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a user's profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learn.service1.GetUserProfileResponse> getUserProfile(
        com.learn.service1.GetUserProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserProfileMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_USER_PROFILE = 0;
  private static final int METHODID_GET_USER_PROFILE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Service1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Service1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_USER_PROFILE:
          serviceImpl.setUserProfile((com.learn.service1.SetUserProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.learn.service1.SetUserProfileResponse>) responseObserver);
          break;
        case METHODID_GET_USER_PROFILE:
          serviceImpl.getUserProfile((com.learn.service1.GetUserProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.learn.service1.GetUserProfileResponse>) responseObserver);
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

  private static abstract class Service1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Service1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.learn.service1.Service1Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service1");
    }
  }

  private static final class Service1FileDescriptorSupplier
      extends Service1BaseDescriptorSupplier {
    Service1FileDescriptorSupplier() {}
  }

  private static final class Service1MethodDescriptorSupplier
      extends Service1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Service1MethodDescriptorSupplier(String methodName) {
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
      synchronized (Service1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Service1FileDescriptorSupplier())
              .addMethod(getSetUserProfileMethod())
              .addMethod(getGetUserProfileMethod())
              .build();
        }
      }
    }
    return result;
  }
}
