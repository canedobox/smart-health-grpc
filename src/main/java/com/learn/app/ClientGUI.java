package com.learn.app;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.learn.service1.GetUserProfileRequest;
import com.learn.service1.GetUserProfileResponse;
import com.learn.service1.Service1Grpc;
import com.learn.service1.SetUserProfileRequest;
import com.learn.service1.SetUserProfileResponse;
import com.learn.service2.Service2Grpc;
import com.learn.service2.StepCountAverageRequest;
import com.learn.service2.StepCountAverageResponse;
import com.learn.service2.StepCountHistoryRequest;
import com.learn.service2.StepCountHistoryResponse;
import com.learn.service2.StepCountRequest;
import com.learn.service2.StepCountResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

/**
 * Creates the client user interface for the services.
 * 
 * @author canedobox
 */
public class ClientGUI implements ActionListener {
	/* SERVICE 1 GUI components */
	// JTextFields used for setUserProfile() request.
	private JTextField usernameSetUserProfileRequest,
			nameSetUserProfileRequest, 
			heightSetUserProfileRequest,
			weightSetUserProfileRequest, 
			stepCountGoalSetUserProfileRequest, 
			weightGoalSetUserProfileRequest;
	// JLabel used for setUserProfile() response.
	private JLabel messageSetUserProfileResponse;
	
	// JTextFields used for getUserProfile() request.
	private JTextField usernameGetUserProfileRequest;
	// JLabels used for getUserProfile() response.
	private JLabel nameGetUserProfileResponse, 
	heightGetUserProfileResponse,
	weightGetUserProfileResponse, 
	stepCountGoalGetUserProfileResponse, 
	weightGoalGetUserProfileResponse,
	messageGetUserProfileResponse;
	
	/* SERVICE 2 GUI components */
	// JTextFields used for incrementStepCount() request.
	private JTextField usernameStepCountRequest, numberOfStepsStepCountRequest;
	// JLabel used for incrementStepCount() response.
	private JLabel stepCountStepCountResponse, messageStepCountResponse;
	
	// JTextFields used for getStepCountHistory() request.
	private JTextField usernameStepCountHistoryRequest;
	// JLabel used for getStepCountHistory() response.
	private JLabel stepCountHistoryResponse, messageStepCountHistoryResponse;
	
	// JTextFields used for calculateStepCountAverage() request.
	private JTextField stepCount1Request, stepCount2Request, stepCount3Request, stepCount4Request, stepCount5Request;
	// JLabel used for calculateStepCountAverage() response.
	private JLabel averageStepCountStepCountAverageResponse, messageStepCountAverageResponse;

	/**
	 * Created a tab navigation menu to switch between services.
	 * 
	 * @return JTabbedPane.
	 */
	private JTabbedPane tabNavigationMenu() {
		JTabbedPane tabMenu = new JTabbedPane();

		// Add service 1 to the tab menu.
		tabMenu.addTab("Service 1", service1JPanel());
		tabMenu.setMnemonicAt(0, KeyEvent.VK_1);

		// Add service 2 to the tab menu.
		tabMenu.addTab("Service 2", service2JPanel());
		tabMenu.setMnemonicAt(1, KeyEvent.VK_2);

		// Add service 3 to the tab menu.
		tabMenu.addTab("Service 3", service3JPanel());
		tabMenu.setMnemonicAt(2, KeyEvent.VK_3);

		return tabMenu;
	}
	
	/**
	 * Create a centred JPanel for a subtitle text.
	 * @param text String to be display as subtitle.
	 * @return JPanel
	 */
	private JPanel subtitlePanel(String text) {
		// Subtitle
		JPanel container = new JPanel();
		JLabel subtitle = new JLabel("<html>" + text + "<br></html>");
		subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
		subtitle.setHorizontalAlignment(JLabel.CENTER);
		container.add(subtitle);
		
		return container;
	}
	
	/**
	 * Add a titled border around a JPanel.
	 * 
	 * @param title String to be displayed as title for the border JPanel.
	 * @param content JPanel to be added as content.
	 * @return JPanel
	 */
	private JPanel addTitledBorder(String title, JPanel content) {
		JPanel container = new JPanel();

		// Setting up the titled border.
		TitledBorder border = new TitledBorder(title);
		border.setTitleJustification(TitledBorder.CENTER);
		border.setTitlePosition(TitledBorder.TOP);
		container.setBorder(border);

		// Add content to the titled border.
		container.add(content);

		return container;
	}

	/**
	 * Create the service 1 JPanel.
	 * 
	 * @return JPanel
	 */
	private JPanel service1JPanel() {
		JPanel container = new JPanel();

		// Set container layout to be X_AXIS: from left to right.
		BoxLayout containerLayout = new BoxLayout(container, BoxLayout.X_AXIS);
		container.setLayout(containerLayout);

		// Set padding for the container panel.
		container.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

		// Add JPanels for the service methods.
		container.add(addTitledBorder(" setUserProfile( ) ", setUserProfilePanel()));
		container.add(addTitledBorder(" getUserProfile( ) ", getUserProfilePanel()));

		return container;
	}
	
	/**
	  * Create the service 2 JPanel.
	 * 
	 * @return JPanel
	 */
	private JPanel service2JPanel() {
		JPanel container = new JPanel();

		// Set container layout to be X_AXIS: from left to right.
		BoxLayout containerLayout = new BoxLayout(container, BoxLayout.X_AXIS);
		container.setLayout(containerLayout);

		// Set padding for the container panel.
		container.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

		// Add JPanels for the service methods.
		container.add(addTitledBorder(" incrementStepCount( ) ", incrementStepCountPanel()));
		container.add(addTitledBorder(" getStepCountHistory( ) ", getStepCountHistoryPanel()));
		container.add(addTitledBorder(" calculateStepCountAverage( ) ", calculateStepCountAveragePanel()));
		
		return container;
	}
	
	/**
	  * Create the service 3 JPanel.
	 * 
	 * @return JPanel
	 */
	private JPanel service3JPanel() {
		JPanel container = new JPanel();

		// Set container layout to be X_AXIS: from left to right.
		BoxLayout containerLayout = new BoxLayout(container, BoxLayout.X_AXIS);
		container.setLayout(containerLayout);

		// Set padding for the container panel.
		container.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

		// Add JPanels for the service methods.
		container.add(addTitledBorder(" method1( ) ", new JPanel()));
		container.add(addTitledBorder(" method2( ) ", new JPanel()));
		
		return container;
	}

	/**
	 * Create the setUserProfile method JPanel (service 1).
	 * 
	 * @return JPanel
	 */
	private JPanel setUserProfilePanel() {
		// JPanels
		JPanel container = new JPanel();
		JPanel componentPanel = new JPanel();

		// Set padding for the container panel.
		container.setBorder(new EmptyBorder(new Insets(10, 20, 10, 20)));

		// Set container layout to be Y_AXIS: from top to bottom.
		BoxLayout containerLayout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(containerLayout);
		
		// Add subtitle.
		container.add(subtitlePanel("Enter user details:"));

		// Username (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("Username:"));
		usernameSetUserProfileRequest = new JTextField("user1", 10);
		componentPanel.add(usernameSetUserProfileRequest);
		container.add(componentPanel);

		// Name (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("Name:"));
		nameSetUserProfileRequest = new JTextField("User 1", 10);
		componentPanel.add(nameSetUserProfileRequest);
		container.add(componentPanel);

		// Height (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("Height:"));
		heightSetUserProfileRequest = new JTextField("180", 5);
		componentPanel.add(heightSetUserProfileRequest);
		container.add(componentPanel);

		// Weight (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("Weight:"));
		weightSetUserProfileRequest = new JTextField("100", 5);
		componentPanel.add(weightSetUserProfileRequest);
		container.add(componentPanel);

		// Step Count Goal (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("Step Count Goal:"));
		stepCountGoalSetUserProfileRequest = new JTextField("6000", 5);
		componentPanel.add(stepCountGoalSetUserProfileRequest);
		container.add(componentPanel);

		// Weight Goal (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("Weight Goal:"));
		weightGoalSetUserProfileRequest = new JTextField("80", 5);
		componentPanel.add(weightGoalSetUserProfileRequest);
		container.add(componentPanel);

		// Save button used to send the request.
		componentPanel = new JPanel();
		JButton button = new JButton("SAVE");
		button.setPreferredSize(new Dimension(200, 30));
		button.addActionListener(this);
		componentPanel.add(button);
		container.add(componentPanel);

		// Message (response).
		componentPanel = new JPanel();
		messageSetUserProfileResponse = new JLabel("");
		componentPanel.add(messageSetUserProfileResponse);
		container.add(componentPanel);
		
		return container;
	}
	
	/**
	 * Create the getUserProfile method JPanel (service 1).
	 * 
	 * @return JPanel
	 */
	private JPanel getUserProfilePanel() {
		// JPanels
		JPanel container = new JPanel();
		JPanel componentPanel = new JPanel();

		// Set padding for the container panel.
		container.setBorder(new EmptyBorder(new Insets(10, 20, 10, 20)));
		
		// Set container layout to be Y_AXIS: from top to bottom.
		BoxLayout containerLayout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(containerLayout);

		// Add subtitle.
		container.add(subtitlePanel("Search for an user:"));

		// Username (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("Username:"));
		usernameGetUserProfileRequest = new JTextField("user1", 10);
		componentPanel.add(usernameGetUserProfileRequest);
		container.add(componentPanel);
		
		// Search button used to send the request.
		componentPanel = new JPanel();
		JButton button = new JButton("SEARCH");
		button.setPreferredSize(new Dimension(200, 30));
		button.addActionListener(this);
		componentPanel.add(button);
		container.add(componentPanel);

		// Add subtitle.
		container.add(subtitlePanel("Response:"));
				
		// Name (response).
		componentPanel = new JPanel();
		nameGetUserProfileResponse = new JLabel("");
		componentPanel.add(nameGetUserProfileResponse);
		container.add(componentPanel);

		// Height (response).
		componentPanel = new JPanel();
		heightGetUserProfileResponse = new JLabel("");
		componentPanel.add(heightGetUserProfileResponse);
		container.add(componentPanel);

		// Weight (response).
		componentPanel = new JPanel();
		weightGetUserProfileResponse = new JLabel("");
		componentPanel.add(weightGetUserProfileResponse);
		container.add(componentPanel);

		// Step Count Goal (response).
		componentPanel = new JPanel();
		stepCountGoalGetUserProfileResponse = new JLabel("");
		componentPanel.add(stepCountGoalGetUserProfileResponse);
		container.add(componentPanel);

		// Weight Goal (response).
		componentPanel = new JPanel();
		weightGoalGetUserProfileResponse = new JLabel("");
		componentPanel.add(weightGoalGetUserProfileResponse);
		container.add(componentPanel);

		// Message (response).
		componentPanel = new JPanel();
		messageGetUserProfileResponse = new JLabel("");
		componentPanel.add(messageGetUserProfileResponse);
		container.add(componentPanel);
		
		return container;
	}
	
	/**
	 * Reset fields and labels for the setUserProfile method JPanel (service 1).
	 */
	private void resetSetUserProfilePanel() {
		usernameSetUserProfileRequest.setText("");
		nameSetUserProfileRequest.setText("");
		heightSetUserProfileRequest.setText("");
		weightSetUserProfileRequest.setText("");
		stepCountGoalSetUserProfileRequest.setText("");
		weightGoalSetUserProfileRequest.setText("");
		messageSetUserProfileResponse.setText("");
	}
	
	/**
	 * Reset fields and labels for the resetGetUserProfile method JPanel (service 1).
	 */
	private void resetGetUserProfilePanel() {
		nameGetUserProfileResponse.setText("");
		heightGetUserProfileResponse.setText("");
		weightGetUserProfileResponse.setText("");
		stepCountGoalGetUserProfileResponse.setText("");
		weightGoalGetUserProfileResponse.setText("");
		messageGetUserProfileResponse.setText("");
	}
	
	/**
	 * Create the setUserProfile method JPanel (service 2).
	 * 
	 * @return JPanel
	 */
	private JPanel incrementStepCountPanel() {
		// JPanels
		JPanel container = new JPanel();
		JPanel componentPanel = new JPanel();

		// Set padding for the container panel.
		container.setBorder(new EmptyBorder(new Insets(10, 20, 10, 20)));

		// Set container layout to be Y_AXIS: from top to bottom.
		BoxLayout containerLayout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(containerLayout);
		
		// Add subtitle.
		container.add(subtitlePanel("Increment step count:"));

		// Username (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("Username:"));
		usernameStepCountRequest = new JTextField("user1", 10);
		componentPanel.add(usernameStepCountRequest);
		container.add(componentPanel);

		// Number of steps (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("Number of Steps:"));
		numberOfStepsStepCountRequest = new JTextField("10", 5);
		componentPanel.add(numberOfStepsStepCountRequest);
		container.add(componentPanel);

		// Add steps button used to send the request.
		componentPanel = new JPanel();
		JButton button = new JButton("ADD STEPS");
		button.setPreferredSize(new Dimension(200, 30));
		button.addActionListener(this);
		componentPanel.add(button);
		container.add(componentPanel);
		
		// Add subtitle.
		container.add(subtitlePanel("Response:"));
		
		// Step Count (response).
		componentPanel = new JPanel();
		stepCountStepCountResponse = new JLabel("");
		componentPanel.add(stepCountStepCountResponse);
		container.add(componentPanel);

		// Message (response).
		componentPanel = new JPanel();
		messageStepCountResponse = new JLabel("");
		componentPanel.add(messageStepCountResponse);
		container.add(componentPanel);
		
		return container;
	}
	
	/**
	 * Create the getStepCountHistory method JPanel (service 2).
	 * 
	 * @return JPanel
	 */
	private JPanel getStepCountHistoryPanel() {
		// JPanels
		JPanel container = new JPanel();
		JPanel componentPanel = new JPanel();

		// Set padding for the container panel.
		container.setBorder(new EmptyBorder(new Insets(10, 20, 10, 20)));

		// Set container layout to be Y_AXIS: from top to bottom.
		BoxLayout containerLayout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(containerLayout);
		
		// Add subtitle.
		container.add(subtitlePanel("Get step count history:"));

		// Username (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("Username:"));
		usernameStepCountHistoryRequest = new JTextField("user1", 10);
		componentPanel.add(usernameStepCountHistoryRequest);
		container.add(componentPanel);

		// Get step count history button used to send the request.
		componentPanel = new JPanel();
		JButton button = new JButton("GET HISTORY");
		button.setPreferredSize(new Dimension(200, 30));
		button.addActionListener(this);
		componentPanel.add(button);
		container.add(componentPanel);
		
		// Add subtitle.
		container.add(subtitlePanel("Response (Date: stepCount):"));
		
		// Step Count History (response).
		componentPanel = new JPanel();
		stepCountHistoryResponse = new JLabel("");
		componentPanel.add(stepCountHistoryResponse);
		container.add(componentPanel);

		// Message (response).
		componentPanel = new JPanel();
		messageStepCountHistoryResponse = new JLabel("");
		componentPanel.add(messageStepCountHistoryResponse);
		container.add(componentPanel);
		
		return container;
	}
	
	/**
	 * Create the calculateStepCountAverage method JPanel (service 2).
	 * 
	 * @return JPanel
	 */
	private JPanel calculateStepCountAveragePanel() {
		// JPanels
		JPanel container = new JPanel();
		JPanel componentPanel = new JPanel();

		// Set padding for the container panel.
		container.setBorder(new EmptyBorder(new Insets(10, 20, 10, 20)));

		// Set container layout to be Y_AXIS: from top to bottom.
		BoxLayout containerLayout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(containerLayout);
		
		// Add subtitle.
		container.add(subtitlePanel("Calculate step count average:"));

		// Step Count 1 (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("1:"));
		stepCount1Request = new JTextField("5340", 10);
		componentPanel.add(stepCount1Request);
		container.add(componentPanel);
		
		// Step Count 2 (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("2:"));
		stepCount2Request = new JTextField("10840", 10);
		componentPanel.add(stepCount2Request);
		container.add(componentPanel);
		
		// Step Count 3 (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("3:"));
		stepCount3Request = new JTextField("3880", 10);
		componentPanel.add(stepCount3Request);
		container.add(componentPanel);
		
		// Step Count 4 (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("4:"));
		stepCount4Request = new JTextField("7590", 10);
		componentPanel.add(stepCount4Request);
		container.add(componentPanel);
		
		// Step Count 5 (request).
		componentPanel = new JPanel();
		componentPanel.add(new JLabel("5:"));
		stepCount5Request = new JTextField("8320", 10);
		componentPanel.add(stepCount5Request);
		container.add(componentPanel);

		// Calculate step count average button used to send the request.
		componentPanel = new JPanel();
		JButton button = new JButton("CALCULATE AVERAGE");
		button.setPreferredSize(new Dimension(200, 30));
		button.addActionListener(this);
		componentPanel.add(button);
		container.add(componentPanel);
		
		// Step Count Average (response).
		componentPanel = new JPanel();
		averageStepCountStepCountAverageResponse = new JLabel("");
		componentPanel.add(averageStepCountStepCountAverageResponse);
		container.add(componentPanel);

		// Message (response).
		componentPanel = new JPanel();
		messageStepCountAverageResponse = new JLabel("");
		componentPanel.add(messageStepCountAverageResponse);
		container.add(componentPanel);
		
		return container;
	}
	
	/**
	 * Reset fields and labels for the incrementStepCount method JPanel (service 2).
	 */
	private void resetIncrementStepCountPanel() {
		messageStepCountResponse.setText("");
	}
	
	/**
	 * Reset fields and labels for the getStepCountHistory method JPanel (service 2).
	 */
	private void resetGetStepCountHistoryPanel() {
		stepCountHistoryResponse.setText("");
		messageStepCountHistoryResponse.setText("");
	}
	
	/**
	 * Reset fields and labels for the calculateStepCountAverage method JPanel (service 2).
	 */
	private void resetCalculateStepCountAveragePanel() {
		averageStepCountStepCountAverageResponse.setText("");
		messageStepCountAverageResponse.setText("");
	}
	
	
	/**
	 * Build the GUI.
	 */
	private void build() {
		// Setting up the frame.
		JFrame frame = new JFrame("Smart Health Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);

		// Set a container JPanel.
		JPanel container = new JPanel();

		// Set container layout to be Y_AXIS: from top to bottom.
		BoxLayout containerLayout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(containerLayout);

		// Set border for the panel
		container.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));

		// Add the tab navigation menu to switch between services.
		container.add(tabNavigationMenu());

		// Add container JPanel to the frame.
		frame.add(container);
		frame.pack();
		// Set the window to be visible.
		frame.setVisible(true);
	}

	
	/**
	 * Set the colour a message will be display.
	 * 
	 * Red for error messages and green for success messages.
	 * 
	 * @param isError If it is an error message.
	 * @param message Message to be added.
	 * @return String
	 */
	private String setMessageColour(boolean isError, String message) {
		if (isError) {
			return "<html><font color='red'>" + message + "</font></html>";
		}

		return "<html><font color='green'>" + message + "</font></html>";
	}

	/**
	 * Listen to button action events.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the source of the action event.
		JButton button = (JButton) e.getSource();
		String label = button.getActionCommand();

		// Save button for setUserProfile the method (Service 1).
		if (label.equals("SAVE")) {
			System.out.println("Invoking setUserProfile()...");
			
			// Build the channel.
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			// Get blocking stubs.
			Service1Grpc.Service1BlockingStub blockingStub = Service1Grpc.newBlockingStub(channel);

			// Prepare the request.
			SetUserProfileRequest request = SetUserProfileRequest.newBuilder()
					.setUsername(usernameSetUserProfileRequest.getText())
					.setName(nameSetUserProfileRequest.getText())
					.setHeight(Double.parseDouble(heightSetUserProfileRequest.getText()))
					.setWeight(Double.parseDouble(weightSetUserProfileRequest.getText()))
					.setStepCountGoal(Integer.parseInt(stepCountGoalSetUserProfileRequest.getText()))
					.setWeightGoal(Double.parseDouble(weightGoalSetUserProfileRequest.getText()))
					.build();

			// Try to send the request.
			try {
				// Send the request and store the response.
				SetUserProfileResponse response = blockingStub.setUserProfile(request);
				
				// Print response on console.
				System.out.println("setUserProfile(); Response: " + response.getMessage());
				
				// Reset setUserProfile panel.
				resetSetUserProfilePanel();
				
				// Display success message.
				messageSetUserProfileResponse.setText(setMessageColour(false, String.valueOf(response.getMessage())));
			}
			// If an errors.
			catch (StatusRuntimeException error) {
				// Display error message.
				messageSetUserProfileResponse.setText(setMessageColour(true, error.getMessage()));
				error.printStackTrace();
			}
			
			// Print a divider between requests.
			System.out.println("--------------------");

		}
		// Search button for the getUserProfile method (Service 1).
		else if (label.equals("SEARCH")) {
			System.out.println("Invoking getUserProfile()...");
			
			// Reset getUserProfile panel.
			resetGetUserProfilePanel();
			
			// Build the channel.
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			// Get blocking stubs.
			Service1Grpc.Service1BlockingStub blockingStub = Service1Grpc.newBlockingStub(channel);
			
			// Prepare the request.
			GetUserProfileRequest request = GetUserProfileRequest.newBuilder()
					.setUsername(usernameGetUserProfileRequest.getText())
					.build();

			// Try to send the request.
			try {
				// Send the request and store the response.
				GetUserProfileResponse response = blockingStub.getUserProfile(request);
				
				// If the response is empty.
				if(response.equals(GetUserProfileResponse.newBuilder().build()) || response == null) {
					// Display error message.
					messageGetUserProfileResponse.setText(setMessageColour(true, "User not found!"));
					System.out.println("User not found!");
				}
				// If the response returned a user profile.
				else {
					// Display user profile info.
					nameGetUserProfileResponse.setText("Name: " + String.valueOf(response.getName()));
					heightGetUserProfileResponse.setText("Height: " + String.valueOf(response.getHeight()));
					weightGetUserProfileResponse.setText("Weight: " + String.valueOf(response.getWeight()));
					stepCountGoalGetUserProfileResponse.setText("Step Count Goal: " + String.valueOf(response.getStepCountGoal()));
					weightGoalGetUserProfileResponse.setText("Weight Goal: " + String.valueOf(response.getWeightGoal()));
					System.out.println("getUserProfile(); Response: " + response);
				}
			}
			// If an errors.
			catch (StatusRuntimeException error) {
				// Display error message.
				messageGetUserProfileResponse.setText(setMessageColour(true, error.getMessage()));
				error.printStackTrace();
			}
			
			// Print a divider between requests.
			System.out.println("--------------------");
		}
		// Add steps button for the incrementStepCount method (Service 2).
		else if (label.equals("ADD STEPS")) {
			System.out.println("Invoking incrementStepCount()...");
			
			// Reset incrementStepCount panel.
			resetIncrementStepCountPanel();
			
			// Build the channel.
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			// Get async stubs.
			Service2Grpc.Service2Stub asyncStub = Service2Grpc.newStub(channel);
			
			// Prepare the response stream observer.
			StreamObserver<StepCountResponse> responseObserver = new StreamObserver<StepCountResponse>() {
				@Override
				public void onNext(StepCountResponse response) {
					// Display current step count.
					stepCountStepCountResponse.setText("Step Count: " + String.valueOf(response.getStepCount()));
					System.out.println("incrementStepCount(); Response: " + response.getStepCount());
					
					try {
						// Sleep for a bit before sending the next one.
						Thread.sleep(500);
					} catch (RuntimeException error) {
						// Display error message.
						messageStepCountResponse.setText(setMessageColour(true, error.getMessage()));
						error.printStackTrace();
					} catch (InterruptedException error) {
						// Display error message.
						messageStepCountResponse.setText(setMessageColour(true, error.getMessage()));
						error.printStackTrace();
					}
				}

				@Override
				public void onError(Throwable t) {
					/// Print error message.
					messageStepCountResponse.setText(setMessageColour(true, t.getMessage()));
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {
					// Display success message.
					messageStepCountResponse.setText(setMessageColour(false, String.valueOf("Steps added succesfully!")));
					// Print message.
					System.out.println("incrementStepCount(); Completed!");
					// Print a divider between requests.
					System.out.println("--------------------");
				}
			};

			// Prepare the request stream observer.
			StreamObserver<StepCountRequest> requestObserver = asyncStub.incrementStepCount(responseObserver);

			// Try to send the request.
			try {
				System.out.println("StepCountRequest; Preparing requests...");
				
				// Loop the number of steps to be added.
				for (int i = 0; i < Integer.parseInt(numberOfStepsStepCountRequest.getText()); i++) {
					// Prepare and send request.
					requestObserver.onNext(StepCountRequest.newBuilder()
							.setUsername(usernameStepCountRequest.getText())
							.build());
				}
				
				System.out.println("StepCountRequest; Sending requests...");

				// Mark the end of requests
				requestObserver.onCompleted();

				// Sleep for a bit before sending another request.
				Thread.sleep(new Random().nextInt(1000) + 500);

			} catch (RuntimeException error) {
				// Display error message.
				messageStepCountResponse.setText(setMessageColour(true, error.getMessage()));
				error.printStackTrace();
			} catch (InterruptedException error) {
				// Display error message.
				messageStepCountResponse.setText(setMessageColour(true, error.getMessage()));
				error.printStackTrace();
			}
		}
		// Get step count history button for the getStepCountHistory method (Service 2).
		else if (label.equals("GET HISTORY")) {
			System.out.println("Invoking getStepCountHistory()...");
			
			// Reset getStepCountHistory panel.
			resetGetStepCountHistoryPanel();
			
			// Build the channel.
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			// Get blocking stubs.
			Service2Grpc.Service2BlockingStub blockingStub = Service2Grpc.newBlockingStub(channel);
			
			// Prepare the request
			StepCountHistoryRequest request = StepCountHistoryRequest.newBuilder()
					.setUsername(usernameStepCountHistoryRequest.getText())
					.build();

			// Try to send the request.
			try {
				// Display message.
				System.out.println("getStepCountHistory(); Response (Date: stepCount): ");
				
				// Send the request and store the responses.
				Iterator<StepCountHistoryResponse> response = blockingStub.getStepCountHistory(request);
				
				// Label for stepCountHistoryResponse.
				String stepCountHistoryLabel = "<html>";
				
				// Loop while the is a response.
				while (response.hasNext()) {
					// Store response temporarily.
					StepCountHistoryResponse temp = response.next();
					
					// If user has no step count history yet.
					if (temp.getStepCount() == -1) {
						// Display error message.
						messageStepCountHistoryResponse.setText(setMessageColour(true, temp.getDate()));
						System.out.println(temp.getDate());
					}
					// If user has step count history.
					else {
						// Add to the step count history label.
						stepCountHistoryLabel += temp.getDate() + ": " + temp.getStepCount() + "<br>";
						System.out.println(temp.getDate() + ": " + temp.getStepCount());
					}
				}
				
				// Display step count history.
				stepCountHistoryResponse.setText(stepCountHistoryLabel += "</html>");
				
			} catch (StatusRuntimeException error) {
				// Display error message.
				messageStepCountHistoryResponse.setText(setMessageColour(true, error.getMessage()));
				error.printStackTrace();
			}
		}
		// Calculate step count average button for the calculateStepCountAverage method (Service 2).
		else if (label.equals("CALCULATE AVERAGE")) {
			System.out.println("Invoking calculateStepCountAverage()...");
			
			// Reset calculateStepCountAverage panel.
			resetCalculateStepCountAveragePanel();
			
			// Build the channel.
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			// Get async stubs.
			Service2Grpc.Service2Stub asyncStub = Service2Grpc.newStub(channel);
			
			// Prepare the response stream observer.
			StreamObserver<StepCountAverageResponse> responseObserver = new StreamObserver<StepCountAverageResponse>() {
				@Override
				public void onNext(StepCountAverageResponse response) {
					// Display step count average.
					averageStepCountStepCountAverageResponse.setText("Step Count Average: " + response.getAverageStepCount());
					// Print response.
					System.out.println("calculateStepCountAverage(); Response: " + response.getAverageStepCount());
				}

				@Override
				public void onError(Throwable t) {
					/// Print error message.
					messageStepCountAverageResponse.setText(setMessageColour(true, t.getMessage()));
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {
					// Print message.
					System.out.println("getStepCountHistory(); Completed!");
					// Print a divider between requests.
					System.out.println("--------------------");
				}
			};

			// Prepare the request stream observer.
			StreamObserver<StepCountAverageRequest> requestObserver = asyncStub.calculateStepCountAverage(responseObserver);

			try {
				System.out.println("StepCountAverageRequest; Preparing requests...");
				
				requestObserver.onNext(StepCountAverageRequest.newBuilder().setStepCount(Integer.parseInt(stepCount1Request.getText())).build());
				requestObserver.onNext(StepCountAverageRequest.newBuilder().setStepCount(Integer.parseInt(stepCount2Request.getText())).build());
				requestObserver.onNext(StepCountAverageRequest.newBuilder().setStepCount(Integer.parseInt(stepCount3Request.getText())).build());
				requestObserver.onNext(StepCountAverageRequest.newBuilder().setStepCount(Integer.parseInt(stepCount4Request.getText())).build());
				requestObserver.onNext(StepCountAverageRequest.newBuilder().setStepCount(Integer.parseInt(stepCount5Request.getText())).build());
							
				System.out.println("StepCountAverageRequest; Sending requests...");

				// Mark the end of requests
				requestObserver.onCompleted();

				// Sleep for a bit before sending another request.
				Thread.sleep(new Random().nextInt(1000) + 500);

			} catch (RuntimeException error) {
				// Display error message.
				messageStepCountAverageResponse.setText(setMessageColour(true, error.getMessage()));
				error.printStackTrace();
			} catch (InterruptedException error) {
				// Display error message.
				messageStepCountAverageResponse.setText(setMessageColour(true, error.getMessage()));
				error.printStackTrace();
			}
		}

	}
	
	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ClientGUI gui = new ClientGUI();

		// Build the GUI.
		gui.build();

		// Print message.
		System.out.println("GUI started.");
		System.out.println("--------------------");
	}
}
