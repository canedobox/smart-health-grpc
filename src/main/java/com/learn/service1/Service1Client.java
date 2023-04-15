package com.learn.service1;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

/**
 * Testing the service 1 server.
 * 
 * @author canedobox
 */
public class Service1Client {
	private static Service1Grpc.Service1BlockingStub blockingStub;

	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		System.out.println("Client started");
		System.out.println("--------------------");

		blockingStub = Service1Grpc.newBlockingStub(channel);

		setUserProfile();

		System.out.println("--------------------");

		getUserProfile("user1");

		System.out.println("--------------------");
		
		getUserProfile("user2");

		System.out.println("--------------------");
	}

	public static void setUserProfile() {
		SetUserProfileRequest request = SetUserProfileRequest.newBuilder()
				.setUsername("user1")
				.setName("User 1")
				.setHeight(180)
				.setWeight(100)
				.setStepCountGoal(6000)
				.setWeightGoal(80)
				.build();

		try {
			SetUserProfileResponse response = blockingStub.setUserProfile(request);
			System.out.println("setUserProfile(); Response: " + response.getMessage());
		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}
	}

	public static void getUserProfile(String username) {
		GetUserProfileRequest request = GetUserProfileRequest.newBuilder().setUsername(username).build();

		try {
			GetUserProfileResponse response = blockingStub.getUserProfile(request);
			
			if(response.equals(GetUserProfileResponse.newBuilder().build()) || response == null) {
				System.out.println("User not found!");
			} else {
				System.out.println("getUserProfile(); Response: " + response);
			}
		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}
	}
}
