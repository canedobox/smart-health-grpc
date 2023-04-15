package com.learn.app;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

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
		container.add(addTitledBorder(" method1( ) ", new JPanel()));
		container.add(addTitledBorder(" method2( ) ", new JPanel()));
		container.add(addTitledBorder(" method3( ) ", new JPanel()));
		
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
	 * Create the setUserProfilePanel method JPanel (service 1).
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
		JButton button = new JButton("Save");
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
	 * Create the getUserProfilePanel method JPanel (service 1).
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
		JButton button = new JButton("Search");
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
		container.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

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
		if (label.equals("Save")) {
			System.out.println("Invoking setUserProfile()...");
			
			// Build the channel.
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			// Get blocking stubs generated from the proto file.
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

		}
		// Search button for the getUserProfile method (Service 1).
		else if (label.equals("Search")) {
			System.out.println("Invoking getUserProfile()...");
			
			// Reset getUserProfile panel.
			resetGetUserProfilePanel();
			
			// Build the channel.
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			// Get blocking stubs generated from the proto file.
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
		} else {
			
		}
		
		// Print a divider between requests.
		System.out.println("--------------------");

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
