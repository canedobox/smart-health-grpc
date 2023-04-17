package com.learn.service3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import com.learn.service3.Service3Grpc.Service3ImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

/**
 * Service 3 server class.
 * 
 * @author canedobox
 */
public class Service3Server extends Service3ImplBase {
	/**
	 * Calculate Body Mass Index (BMI).
	 */
	@Override
	public void calculateBMI(BMIRequest request, StreamObserver<BMIResponse> responseObserver) {
		// Print request message.
		System.out.println("calculateBMI(); Receiving request: " + request);
		
		// Calculate the BMI. Convert cm to m.
		double bmi = request.getWeight() / ((request.getHeight() / 100) * (request.getHeight() / 100));
		
		// Set category based of the BMI result.
		String category = "";
		if (bmi > 40) {
			category = "Morbidly Obese";
		} else if (bmi > 35) {
			category = "Severely Obese";
		} else if (bmi > 30) {
			category = "Moderately Obese";
		} else if (bmi > 25) {
			category = "Overweight";
		} else if (bmi > 18.5) {
			category = "Normal";
		} else if (bmi > 16) {
			category = "Underweight";
		} else {
			category = "Severely Underweight";
		}
		
		// Prepare the response
		BMIResponse response = BMIResponse.newBuilder().setBmi(bmi).setCategory(category).build();

		// Send response.
		responseObserver.onNext(response);
		responseObserver.onCompleted();

		// Print a divider between requests.
		System.out.println("--------------------");
	}
	
	/**
	 * Get a weight loss weekly target.
	 */
	@Override
	public void getWeightLossWeeklyTarget(WeightLossWeeklyTargetRequest request, StreamObserver<WeightLossWeeklyTargetResponse> responseObserver) {
		// Print request message.
		System.out.println("getWeightLossWeeklyTarget(); Receiving request: " + request);
		
		// Calculate the weight loss weekly target.
		double weightLossWeeklyTarget = (request.getCurrentWeight() - request.getWeightGoal()) / request.getNumberOfWeeks();
		
		// Prepare the response
		WeightLossWeeklyTargetResponse response = WeightLossWeeklyTargetResponse.newBuilder().setWeightLossWeeklyTarget(weightLossWeeklyTarget).build();

		// Send response.
		responseObserver.onNext(response);
		responseObserver.onCompleted();

		// Print a divider between requests.
		System.out.println("--------------------");
	}
	
	/**
	 * Get service 3 properties.
	 * 
	 * @return Properties
	 */
	private Properties getProperties() {
		Properties properties = null;

		// Try get the properties.
		try (InputStream input = new FileInputStream("src/main/resources/service3.properties")) {
			// Load the service properties file.
			properties = new Properties();
			properties.load(input);

			// Print service properties values.
			System.out.println("Service 3 properties:");
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
		// Set the service 3 server.
		Service3Server service3Server = new Service3Server();
		
		// Get the service properties.
		Properties properties = service3Server.getProperties();
		// Register the jmDNS service.
		service3Server.registerService(properties);
				
		// Set the port to be used by the service.
		int port = Integer.valueOf(properties.getProperty("service_port"));
		
		// Build the server.
		Server server = ServerBuilder.forPort(port).addService(service3Server).build().start();

		// Print server info
		System.out.println("Service 3 server started, listening on port: " + port);
		System.out.println("--------------------");

		// Await server termination.
		server.awaitTermination();
	}
}
