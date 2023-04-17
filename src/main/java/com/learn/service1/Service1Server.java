package com.learn.service1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

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
	// User profiles map.
	private Map<String, GetUserProfileResponse> users = new HashMap<String, GetUserProfileResponse>();

	/**
	 * Set or update user's profile details.
	 */
	@Override
	public void setUserProfile(SetUserProfileRequest request, StreamObserver<SetUserProfileResponse> responseObserver) {
		// Print request message.
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
	 * Get service 1 properties.
	 * 
	 * @return Properties
	 */
	private Properties getProperties() {
		Properties properties = null;

		// Try get the properties.
		try (InputStream input = new FileInputStream("src/main/resources/service1.properties")) {
			// Load the service properties file.
			properties = new Properties();
			properties.load(input);

			// Print service properties values.
			System.out.println("Service 1 properties:");
			System.out.println("- service_type: " + properties.getProperty("service_type"));
			System.out.println("- service_name: " + properties.getProperty("service_name"));
			System.out.println("- service_description: " + properties.getProperty("service_description"));
			System.out.println("- service_port: " + properties.getProperty("service_port"));
		}
		// If any errors.
		catch (IOException e) {
			// Print error message.
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return properties;
	}

	/**
	 * Register jmDNS service.
	 * 
	 * @param properties Service properties.
	 */
	private void registerService(Properties properties) {
		// Try to register the jmDNS service.
		try {
			// Create a JmDNS instance.
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Get service properties.
			String service_type = properties.getProperty("service_type");
			String service_name = properties.getProperty("service_name");
			int service_port = Integer.valueOf(properties.getProperty("service_port"));
			String service_description = properties.getProperty("service_description");

			// Register the service.
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description);
			jmdns.registerService(serviceInfo);

			// Print message.
			System.out.println("Registering service with type '" + service_type + "' and name '" + service_name + "'...");

			// Wait a bit before continuing.
			Thread.sleep(500);
		}
		// If any errors.
		catch (IOException e) {
			// Print error message.
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			// Print error message.
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

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

		// Get the service properties.
		Properties properties = service1Server.getProperties();
		// Register the jmDNS service.
		service1Server.registerService(properties);

		// Set the port to be used by the service.
		int port = Integer.valueOf(properties.getProperty("service_port"));
		
		// Build the server.
		Server server = ServerBuilder.forPort(port).addService(service1Server).build().start();

		// Print server info
		System.out.println("Service 1 server started, listening on port: " + port);
		System.out.println("--------------------");

		// Await server termination.
		server.awaitTermination();
	}
}
