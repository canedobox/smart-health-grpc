package com.learn.service2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import com.learn.service2.Service2Grpc.Service2ImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

/**
 * Service 2 server class.
 * 
 * @author canedobox
 */
public class Service2Server extends Service2ImplBase {	
	// Users' step count history map.
	private Map<String, Map<String, Integer>> usersStepCountHistory = new HashMap<String, Map<String, Integer>>(); 
	
	/**
	 * Adds mock data to usersStepCountHistory.
	 */
	private void addMockData() {		
		// Add step count history for "user1".
		usersStepCountHistory.put("user1", new TreeMap<String, Integer>());
		Map<String, Integer> userStepCountHistory = usersStepCountHistory.get("user1");
		userStepCountHistory.put(LocalDate.now().minusDays(4).toString(), 5680);
		userStepCountHistory.put(LocalDate.now().minusDays(3).toString(), 7820);
		userStepCountHistory.put(LocalDate.now().minusDays(2).toString(), 5430);
		userStepCountHistory.put(LocalDate.now().minusDays(1).toString(), 6270);
		userStepCountHistory.put(LocalDate.now().toString(), 0);
		
		// Print message.
		System.out.println("Mock data added to usersStepCountHistory (user1).");
		System.out.println("--------------------");
	}
	
	/**
	 * Increment user's step count for the current date.
	 */
	@Override
	public StreamObserver<StepCountRequest> incrementStepCount(StreamObserver<StepCountResponse> responseObserver) {
		return new StreamObserver<StepCountRequest>() {
			@Override
			public void onNext(StepCountRequest request) {
				// Print request message.
				System.out.println("incrementStepCount(); Receiving request: " + request);
				
				// Get user's step count history.
				Map<String, Integer> userStepCountHistory = usersStepCountHistory.get(request.getUsername());
				int userCurrentStepCount = 0;
				
				// If user has no step count history yet.
				if (userStepCountHistory == null) {
					// Add step count history for request username.
					usersStepCountHistory.put(request.getUsername(), new TreeMap<String, Integer>());
					userStepCountHistory = usersStepCountHistory.get(request.getUsername());
				}
				// If user already have step count history.
				else {
					// Get step count for current date.
					userCurrentStepCount = userStepCountHistory.get(LocalDate.now().toString());
				}
				
				// increase the user's step count for the current date.
				userStepCountHistory.put(LocalDate.now().toString(), userCurrentStepCount + 1);

				// Prepare response.
				StepCountResponse response = StepCountResponse.newBuilder()
						.setStepCount(userStepCountHistory.get(LocalDate.now().toString()))
						.build();
				// Send response.
				responseObserver.onNext(response);
			}

			@Override
			public void onError(Throwable t) {
				// Print error message.
				System.out.println(t.getMessage());
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();
				// Print a divider between requests.
				System.out.println("--------------------");
			}

		};
	}
	
	/**
	 * Get a user's step count history.
	 */
	@Override
	public void getStepCountHistory(StepCountHistoryRequest request, StreamObserver<StepCountHistoryResponse> responseObserver) {
		// Print request message.
		System.out.println("getStepCountHistory; Receiving request: " + request);

		// Get user's step count history.
		Map<String, Integer> userStepCountHistory = usersStepCountHistory.get(request.getUsername());

		// If user has no step count history yet.
		if (userStepCountHistory == null) {
			// Send an error response.
			responseObserver.onNext(StepCountHistoryResponse.newBuilder()
					.setDate("User has no step count history!")
					.setStepCount(-1)
					.build());
			// Print error message.
			System.out.println("User has no step count history!");
		}
		// If user already have step count history.
		else {
			System.out.println("getStepCountHistory; Streamming response...");
			
			// Loop through the step count history.
			for (Map.Entry<String, Integer> entry : userStepCountHistory.entrySet()) {
				// Sent response.
				responseObserver.onNext(StepCountHistoryResponse.newBuilder()
						.setDate(entry.getKey())
						.setStepCount(entry.getValue())
						.build());
				// Print message.
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
			
			System.out.println("getStepCountHistory; Streamming completed!");
		}

		responseObserver.onCompleted();
		// Print a divider between requests.
		System.out.println("--------------------");
	}
	
	/**
	 * Calculate step count average.
	 */
	@Override
	public StreamObserver<StepCountAverageRequest> calculateStepCountAverage(StreamObserver<StepCountAverageResponse> responseObserver) {
		return new StreamObserver<StepCountAverageRequest>() {
			// Variables used to calculate the step count average.
			private int totalStepCount = 0, stepCountCounter = 0;
			
			@Override
			public void onNext(StepCountAverageRequest request) {
				// Print request message.
				System.out.println("calculateStepCountAverage(); Receiving request: " + request);
				
				// Add to variables.
				totalStepCount += request.getStepCount();
				stepCountCounter++;
			}

			@Override
			public void onError(Throwable t) {
				// Print error message.
				System.out.println(t.getMessage());
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				// Send response.
				StepCountAverageResponse response = StepCountAverageResponse.newBuilder()
						.setAverageStepCount(totalStepCount / stepCountCounter)
						.build();
				responseObserver.onNext(response);
				
				responseObserver.onCompleted();
				// Print a divider between requests.
				System.out.println("--------------------");
			}

		};
	}
	
	/**
	 * Get service 2 properties.
	 * 
	 * @return Properties
	 */
	private Properties getProperties() {
		Properties properties = null;

		// Try get the properties.
		try (InputStream input = new FileInputStream("src/main/resources/service2.properties")) {
			// Load the service properties file.
			properties = new Properties();
			properties.load(input);

			// Print service properties values.
			System.out.println("Service 2 properties:");
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
		// Set the service 2 server.
		Service2Server service2Server = new Service2Server();
		
		// Get the service properties.
		Properties properties = service2Server.getProperties();
		// Register the jmDNS service.
		service2Server.registerService(properties);
				
		// Set the port to be used by the service.
		int port = Integer.valueOf(properties.getProperty("service_port"));
		
		// Build the server.
		Server server = ServerBuilder.forPort(port).addService(service2Server).build().start();

		// Print server info
		System.out.println("Service 2 server started, listening on port: " + port);
		System.out.println("--------------------");
		
		// Adds mock data to usersStepCountHistory.
		service2Server.addMockData();

		// Await server termination.
		server.awaitTermination();
	}
}
