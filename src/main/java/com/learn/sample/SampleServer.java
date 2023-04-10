package com.learn.sample;

import java.io.IOException;
import java.util.logging.Logger;

import com.learn.sample.SampleServiceGrpc.SampleServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class SampleServer extends SampleServiceImplBase {
	private static Logger logger = Logger.getLogger(SampleClient.class.getName());

	public static void main(String[] args) throws IOException, InterruptedException {
		SampleServer userServer = new SampleServer();

		int port = 50051;
		Server server = ServerBuilder.forPort(port).addService(userServer).build().start();

		logger.info("Server started, listening on port: " + port);

		System.out.println("--------------------");

		server.awaitTermination();
	}

	@Override
	public void unary(UnaryRequest request, StreamObserver<UnaryResponse> responseObserver) {
		System.out.println("unary; Receiving request: " + request.getMessage());
		UnaryResponse response = UnaryResponse.newBuilder().setMessage("unaryServer").build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();

		System.out.println("--------------------");
	}

	@Override
	public void serverStream(ServerStreamRequest request, StreamObserver<ServerStreamResponse> responseObserver) {
		System.out.println("serverStream; Receiving request: " + request.getMessage());

		char[] characters = request.getMessage().toCharArray();

		System.out.println("serverStream; Streamming response...");

		for (char c : characters) {
			responseObserver.onNext(ServerStreamResponse.newBuilder().setMessage(Character.toString(c)).build());
			System.out.println("-> " + Character.toString(c));
		}

		responseObserver.onCompleted();

		System.out.println("serverStream; Streamming completed!");

		System.out.println("--------------------");
	}

	@Override
	public StreamObserver<ClientStreamRequest> clientStream(StreamObserver<ClientStreamResponse> responseObserver) {
		System.out.println("clientStream; Receiving request: ");

		return new StreamObserver<ClientStreamRequest>() {
			String message = "";

			@Override
			public void onNext(ClientStreamRequest request) {
				System.out.println(request.getMessage());
				message += request.getMessage();
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onCompleted() {
				ClientStreamResponse response = ClientStreamResponse.newBuilder().setMessage(message).build();
				responseObserver.onNext(response);
				
				responseObserver.onCompleted();

				System.out.println("--------------------");
			}
		};
	}

	@Override
	public StreamObserver<BidirectionalStreamRequest> bidirectionalStream(StreamObserver<BidirectionalStreamResponse> responseObserver) {
		System.out.println("bidirectionalStream; Receiving request: ");
		
		return new StreamObserver<BidirectionalStreamRequest>() {
			String message = "";

			@Override
			public void onNext(BidirectionalStreamRequest request) {
				System.out.println(request.getMessage());
				message += request.getMessage();

				BidirectionalStreamResponse response = BidirectionalStreamResponse.newBuilder().setMessage(message.toString()).build();

				responseObserver.onNext(response);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();
				
				System.out.println("--------------------");
			}

		};
	}
}
