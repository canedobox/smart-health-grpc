package com.learn.sample;

import java.util.Iterator;
import java.util.Random;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class SampleClient {
	private static Logger logger = Logger.getLogger(SampleClient.class.getName());

	private static SampleServiceGrpc.SampleServiceBlockingStub blockingStub;
	private static SampleServiceGrpc.SampleServiceStub asyncStub;

	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		logger.info("Client started");

		System.out.println("--------------------");

		blockingStub = SampleServiceGrpc.newBlockingStub(channel);
		asyncStub = SampleServiceGrpc.newStub(channel);

		unary();

		System.out.println("--------------------");

		serverStream();

		System.out.println("--------------------");

		clientStream();

		System.out.println("--------------------");

		bidirectionalStream();

		System.out.println("--------------------");
	}

	public static void unary() {
		UnaryRequest request = UnaryRequest.newBuilder().setMessage("unaryClient").build();

		try {
			UnaryResponse response = blockingStub.unary(request);
			System.out.println("unary; Response: " + response.getMessage());
		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}
	}

	public static void serverStream() {
		ServerStreamRequest request = ServerStreamRequest.newBuilder().setMessage("message").build();

		try {
			Iterator<ServerStreamResponse> response = blockingStub.serverStream(request);

			System.out.println("serverStream; Response: ");

			while (response.hasNext()) {
				ServerStreamResponse temp = response.next();
				System.out.println(temp.getMessage());
			}
		} catch (StatusRuntimeException e) {

		}
	}

	public static void clientStream() {

		StreamObserver<ClientStreamResponse> responseObserver = new StreamObserver<ClientStreamResponse>() {

			@Override
			public void onNext(ClientStreamResponse response) {
				System.out.println("clientStream; Response: " + response.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("clientStream; Completed!");
			}

		};

		//
		StreamObserver<ClientStreamRequest> requestObserver = asyncStub.clientStream(responseObserver);

		try {
			System.out.println("clientStream; Preparing requests...");

			requestObserver.onNext(ClientStreamRequest.newBuilder().setMessage("m").build());
			System.out.println("-> m");
			requestObserver.onNext(ClientStreamRequest.newBuilder().setMessage("e").build());
			System.out.println("-> e");
			requestObserver.onNext(ClientStreamRequest.newBuilder().setMessage("s").build());
			System.out.println("-> s");
			requestObserver.onNext(ClientStreamRequest.newBuilder().setMessage("s").build());
			System.out.println("-> s");
			requestObserver.onNext(ClientStreamRequest.newBuilder().setMessage("a").build());
			System.out.println("-> a");
			requestObserver.onNext(ClientStreamRequest.newBuilder().setMessage("g").build());
			System.out.println("-> g");
			requestObserver.onNext(ClientStreamRequest.newBuilder().setMessage("e").build());
			System.out.println("-> e");

			System.out.println("clientStream; Sending requests...");

			// Mark the end of requests
			requestObserver.onCompleted();

			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);

		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void bidirectionalStream() {

		StreamObserver<BidirectionalStreamResponse> responseObserver = new StreamObserver<BidirectionalStreamResponse>() {

			@Override
			public void onNext(BidirectionalStreamResponse response) {
				System.out.println("bidirectionalStream; Response: " + response.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("BidirectionalStreamRequest; Completed!");
			}

		};

		//
		StreamObserver<BidirectionalStreamRequest> requestObserver = asyncStub.bidirectionalStream(responseObserver);

		try {
			System.out.println("BidirectionalStreamRequest; Preparing requests...");
			
			requestObserver.onNext(BidirectionalStreamRequest.newBuilder().setMessage("m").build());
			System.out.println("-> m");
			requestObserver.onNext(BidirectionalStreamRequest.newBuilder().setMessage("e").build());
			System.out.println("-> e");
			requestObserver.onNext(BidirectionalStreamRequest.newBuilder().setMessage("s").build());
			System.out.println("-> s");
			requestObserver.onNext(BidirectionalStreamRequest.newBuilder().setMessage("s").build());
			System.out.println("-> s");
			requestObserver.onNext(BidirectionalStreamRequest.newBuilder().setMessage("a").build());
			System.out.println("-> a");
			requestObserver.onNext(BidirectionalStreamRequest.newBuilder().setMessage("g").build());
			System.out.println("-> g");
			requestObserver.onNext(BidirectionalStreamRequest.newBuilder().setMessage("e").build());
			System.out.println("-> e");

			System.out.println("BidirectionalStreamRequest; Sending requests...");

			// Mark the end of requests
			requestObserver.onCompleted();

			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);

		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
