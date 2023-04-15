package com.learn.service1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.learn.service1.Service1Grpc.Service1ImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

/**
 * Service 1 server class.
 * 
 * @author canedobox
 */
public class Service1Server extends Service1ImplBase {	
	// Mapping to store the user profiles.
	private Map<String, GetUserProfileResponse> users = new HashMap<String, GetUserProfileResponse>();

	/**
	 * Set or update user's profile details.
	 */
	@Override
	public void setUserProfile(SetUserProfileRequest request, StreamObserver<SetUserProfileResponse> responseObserver) {
		// Display request message.
		System.out.println("setUserProfile(); Receiving request: " + request);
		
		String message = "";
		// If new user.
		if (users.get(request.getUsername()) == null) {
			message = "User added succesfully!";
		}
		// If existing user.
		else {
			message = "User updated succesfully!";
		}
		
		// Stores user's profile details.
		users.put(request.getUsername(), GetUserProfileResponse.newBuilder()
				.setName(request.getName())
				.setHeight(request.getHeight())
				.setWeight(request.getWeight())
				.setStepCountGoal(request.getStepCountGoal())
				.setWeightGoal(request.getWeightGoal())
				.build());
		
		// Print message.
		System.out.println(message);
		
		// Prepare the response
		SetUserProfileResponse response = SetUserProfileResponse.newBuilder().setMessage(message).build();

		// Send response.
		responseObserver.onNext(response);
		responseObserver.onCompleted();

		// Print a divider between requests.
		System.out.println("--------------------");
	}
	
	/**
	 * Get a user's profile details.
	 */
	@Override
	public void getUserProfile(GetUserProfileRequest request, StreamObserver<GetUserProfileResponse> responseObserver) {
		// Print request message.
		System.out.println("getUserProfile(); Receiving request: " + request);
		
		// Prepare the response
		GetUserProfileResponse response = users.get(request.getUsername());
		
		// If no user profile was found.
		if (response == null) {
			// Print message.
			System.out.println("User not found!");
		}

		// Send response.
		responseObserver.onNext(response);
		responseObserver.onCompleted();

		// Print a divider between requests.
		System.out.println("--------------------");
	}
	
	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// Set the service 1 server.
		Service1Server service1Server = new Service1Server();
		// Set the port to be used by the service.
		int port = 50051;
		// Build the server.
		Server server = ServerBuilder.forPort(port).addService(service1Server).build().start();

		// Print server info
		System.out.println("Service 1 server started, listening on port: " + port);
		System.out.println("--------------------");

		// Await server termination.
		server.awaitTermination();
	}
}
