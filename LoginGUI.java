package com.example.javagui;

import com.example.javagui.Employee;
import com.example.javagui.UniversityGUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class LoginGUI extends Application {
    private Employee loggedInEmployee;
    private String url = "jdbc:mysql://localhost:3306/university";
    private String user = "root";
    private String pass = "Legend030012345@";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        // Create the login GridPane layout
        GridPane loginGridPane = createLoginGridPane();

        Scene loginScene = new Scene(loginGridPane, 300, 200);

        // Set the login scene as the root scene
        primaryStage.setScene(loginScene);
        primaryStage.show();

        // Handle login button click
        Button loginButton = (Button) loginGridPane.lookup("#loginButton");
        loginButton.setOnAction(e -> {
            String email = ((TextField) loginGridPane.lookup("#emailField")).getText();
            String password = ((PasswordField) loginGridPane.lookup("#passwordField")).getText();

            // Perform authentication
            boolean authenticated = authenticate(email, password);
            if (authenticated) {
                loggedInEmployee = new Employee(email, "", email, password); // Create a temporary Employee object with email as the username
                // Switch to another scene or perform desired functionality
                System.out.println("Logged in as: " + loggedInEmployee.getName());
                // Switch the scene here

                UniversityGUI universityGUI = new UniversityGUI();
                try {
                    universityGUI.display(primaryStage);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                //testing change
            } else {
                System.out.println("Invalid email or password. Please try again.");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Wrong Credentials");
            }

        });
    }

    private GridPane createLoginGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add label and text field for email
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        emailField.setId("emailField"); // Set the ID for lookup
        gridPane.add(emailLabel, 0, 0);
        gridPane.add(emailField, 1, 0);

        // Add label and password field for password
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setId("passwordField"); // Set the ID for lookup
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);

        // Add login button
        Button loginButton = new Button("Login");
        loginButton.setId("loginButton"); // Set the ID for lookup
        gridPane.add(loginButton, 1, 2);

        return gridPane;
    }

    public boolean authenticate(String username, String password) {


        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE username = ? AND password = ?")) {

            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            System.out.println(resultSet);

            return resultSet.next(); // Returns true if there is a matching record
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Authentication failed
    }
}
