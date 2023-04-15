package com.learn.service3;

import java.io.IOException;

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
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// Set the service 3 server.
		Service3Server service3Server = new Service3Server();
		// Set the port to be used by the service.
		int port = 50053;
		// Build the server.
		Server server = ServerBuilder.forPort(port).addService(service3Server).build().start();

		// Print server info
		System.out.println("Service 3 server started, listening on port: " + port);
		System.out.println("--------------------");

		// Await server termination.
		server.awaitTermination();
	}
}
