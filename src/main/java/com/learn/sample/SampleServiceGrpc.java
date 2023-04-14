package com.learn.sample;

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
    comments = "Source: sampleService.proto")
public final class SampleServiceGrpc {

  private SampleServiceGrpc() {}

  public static final String SERVICE_NAME = "SampleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.learn.sample.UnaryRequest,
      com.learn.sample.UnaryResponse> getUnaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "unary",
      requestType = com.learn.sample.UnaryRequest.class,
      responseType = com.learn.sample.UnaryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learn.sample.UnaryRequest,
      com.learn.sample.UnaryResponse> getUnaryMethod() {
    io.grpc.MethodDescriptor<com.learn.sample.UnaryRequest, com.learn.sample.UnaryResponse> getUnaryMethod;
    if ((getUnaryMethod = SampleServiceGrpc.getUnaryMethod) == null) {
      synchronized (SampleServiceGrpc.class) {
        if ((getUnaryMethod = SampleServiceGrpc.getUnaryMethod) == null) {
          SampleServiceGrpc.getUnaryMethod = getUnaryMethod = 
              io.grpc.MethodDescriptor.<com.learn.sample.UnaryRequest, com.learn.sample.UnaryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SampleService", "unary"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.sample.UnaryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.sample.UnaryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SampleServiceMethodDescriptorSupplier("unary"))
                  .build();
          }
        }
     }
     return getUnaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learn.sample.ServerStreamRequest,
      com.learn.sample.ServerStreamResponse> getServerStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "serverStream",
      requestType = com.learn.sample.ServerStreamRequest.class,
      responseType = com.learn.sample.ServerStreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.learn.sample.ServerStreamRequest,
      com.learn.sample.ServerStreamResponse> getServerStreamMethod() {
    io.grpc.MethodDescriptor<com.learn.sample.ServerStreamRequest, com.learn.sample.ServerStreamResponse> getServerStreamMethod;
    if ((getServerStreamMethod = SampleServiceGrpc.getServerStreamMethod) == null) {
      synchronized (SampleServiceGrpc.class) {
        if ((getServerStreamMethod = SampleServiceGrpc.getServerStreamMethod) == null) {
          SampleServiceGrpc.getServerStreamMethod = getServerStreamMethod = 
              io.grpc.MethodDescriptor.<com.learn.sample.ServerStreamRequest, com.learn.sample.ServerStreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "SampleService", "serverStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.sample.ServerStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.sample.ServerStreamResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SampleServiceMethodDescriptorSupplier("serverStream"))
                  .build();
          }
        }
     }
     return getServerStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learn.sample.ClientStreamRequest,
      com.learn.sample.ClientStreamResponse> getClientStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "clientStream",
      requestType = com.learn.sample.ClientStreamRequest.class,
      responseType = com.learn.sample.ClientStreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.learn.sample.ClientStreamRequest,
      com.learn.sample.ClientStreamResponse> getClientStreamMethod() {
    io.grpc.MethodDescriptor<com.learn.sample.ClientStreamRequest, com.learn.sample.ClientStreamResponse> getClientStreamMethod;
    if ((getClientStreamMethod = SampleServiceGrpc.getClientStreamMethod) == null) {
      synchronized (SampleServiceGrpc.class) {
        if ((getClientStreamMethod = SampleServiceGrpc.getClientStreamMethod) == null) {
          SampleServiceGrpc.getClientStreamMethod = getClientStreamMethod = 
              io.grpc.MethodDescriptor.<com.learn.sample.ClientStreamRequest, com.learn.sample.ClientStreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "SampleService", "clientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.sample.ClientStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.sample.ClientStreamResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SampleServiceMethodDescriptorSupplier("clientStream"))
                  .build();
          }
        }
     }
     return getClientStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learn.sample.BidirectionalStreamRequest,
      com.learn.sample.BidirectionalStreamResponse> getBidirectionalStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bidirectionalStream",
      requestType = com.learn.sample.BidirectionalStreamRequest.class,
      responseType = com.learn.sample.BidirectionalStreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.learn.sample.BidirectionalStreamRequest,
      com.learn.sample.BidirectionalStreamResponse> getBidirectionalStreamMethod() {
    io.grpc.MethodDescriptor<com.learn.sample.BidirectionalStreamRequest, com.learn.sample.BidirectionalStreamResponse> getBidirectionalStreamMethod;
    if ((getBidirectionalStreamMethod = SampleServiceGrpc.getBidirectionalStreamMethod) == null) {
      synchronized (SampleServiceGrpc.class) {
        if ((getBidirectionalStreamMethod = SampleServiceGrpc.getBidirectionalStreamMethod) == null) {
          SampleServiceGrpc.getBidirectionalStreamMethod = getBidirectionalStreamMethod = 
              io.grpc.MethodDescriptor.<com.learn.sample.BidirectionalStreamRequest, com.learn.sample.BidirectionalStreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "SampleService", "bidirectionalStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.sample.BidirectionalStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.sample.BidirectionalStreamResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SampleServiceMethodDescriptorSupplier("bidirectionalStream"))
                  .build();
          }
        }
     }
     return getBidirectionalStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SampleServiceStub newStub(io.grpc.Channel channel) {
    return new SampleServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SampleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SampleServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SampleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SampleServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SampleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void unary(com.learn.sample.UnaryRequest request,
        io.grpc.stub.StreamObserver<com.learn.sample.UnaryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUnaryMethod(), responseObserver);
    }

    /**
     */
    public void serverStream(com.learn.sample.ServerStreamRequest request,
        io.grpc.stub.StreamObserver<com.learn.sample.ServerStreamResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getServerStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.learn.sample.ClientStreamRequest> clientStream(
        io.grpc.stub.StreamObserver<com.learn.sample.ClientStreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getClientStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.learn.sample.BidirectionalStreamRequest> bidirectionalStream(
        io.grpc.stub.StreamObserver<com.learn.sample.BidirectionalStreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBidirectionalStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUnaryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learn.sample.UnaryRequest,
                com.learn.sample.UnaryResponse>(
                  this, METHODID_UNARY)))
          .addMethod(
            getServerStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.learn.sample.ServerStreamRequest,
                com.learn.sample.ServerStreamResponse>(
                  this, METHODID_SERVER_STREAM)))
          .addMethod(
            getClientStreamMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.learn.sample.ClientStreamRequest,
                com.learn.sample.ClientStreamResponse>(
                  this, METHODID_CLIENT_STREAM)))
          .addMethod(
            getBidirectionalStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.learn.sample.BidirectionalStreamRequest,
                com.learn.sample.BidirectionalStreamResponse>(
                  this, METHODID_BIDIRECTIONAL_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class SampleServiceStub extends io.grpc.stub.AbstractStub<SampleServiceStub> {
    private SampleServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SampleServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SampleServiceStub(channel, callOptions);
    }

    /**
     */
    public void unary(com.learn.sample.UnaryRequest request,
        io.grpc.stub.StreamObserver<com.learn.sample.UnaryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnaryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void serverStream(com.learn.sample.ServerStreamRequest request,
        io.grpc.stub.StreamObserver<com.learn.sample.ServerStreamResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getServerStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.learn.sample.ClientStreamRequest> clientStream(
        io.grpc.stub.StreamObserver<com.learn.sample.ClientStreamResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getClientStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.learn.sample.BidirectionalStreamRequest> bidirectionalStream(
        io.grpc.stub.StreamObserver<com.learn.sample.BidirectionalStreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBidirectionalStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class SampleServiceBlockingStub extends io.grpc.stub.AbstractStub<SampleServiceBlockingStub> {
    private SampleServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SampleServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SampleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.learn.sample.UnaryResponse unary(com.learn.sample.UnaryRequest request) {
      return blockingUnaryCall(
          getChannel(), getUnaryMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.learn.sample.ServerStreamResponse> serverStream(
        com.learn.sample.ServerStreamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getServerStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SampleServiceFutureStub extends io.grpc.stub.AbstractStub<SampleServiceFutureStub> {
    private SampleServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SampleServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SampleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learn.sample.UnaryResponse> unary(
        com.learn.sample.UnaryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUnaryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UNARY = 0;
  private static final int METHODID_SERVER_STREAM = 1;
  private static final int METHODID_CLIENT_STREAM = 2;
  private static final int METHODID_BIDIRECTIONAL_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SampleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SampleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UNARY:
          serviceImpl.unary((com.learn.sample.UnaryRequest) request,
              (io.grpc.stub.StreamObserver<com.learn.sample.UnaryResponse>) responseObserver);
          break;
        case METHODID_SERVER_STREAM:
          serviceImpl.serverStream((com.learn.sample.ServerStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.learn.sample.ServerStreamResponse>) responseObserver);
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
        case METHODID_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.clientStream(
              (io.grpc.stub.StreamObserver<com.learn.sample.ClientStreamResponse>) responseObserver);
        case METHODID_BIDIRECTIONAL_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bidirectionalStream(
              (io.grpc.stub.StreamObserver<com.learn.sample.BidirectionalStreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SampleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SampleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.learn.sample.SampleServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SampleService");
    }
  }

  private static final class SampleServiceFileDescriptorSupplier
      extends SampleServiceBaseDescriptorSupplier {
    SampleServiceFileDescriptorSupplier() {}
  }

  private static final class SampleServiceMethodDescriptorSupplier
      extends SampleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SampleServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SampleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SampleServiceFileDescriptorSupplier())
              .addMethod(getUnaryMethod())
              .addMethod(getServerStreamMethod())
              .addMethod(getClientStreamMethod())
              .addMethod(getBidirectionalStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
