package com.example.javagui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CampusGUI implements Serializable {
    private Director director;
    private ArrayList<Department> departments = new ArrayList<>();

    private Campus campus;


    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }


    public void display() {
        Stage primaryStage = new Stage();

        primaryStage.setTitle("Campus GUI");

        // Create the GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Set column constraints
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(30);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(70);
        gridPane.getColumnConstraints().addAll(col1, col2);

        // Add label and text field for Campus name
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);

        // Add label and text field for Campus address
        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();
        gridPane.add(addressLabel, 0, 1);
        gridPane.add(addressField, 1, 1);

        // Add label and text field for Director's name and grade
        Label directorNameLabel = new Label("Director Name:");
        TextField directorNameField = new TextField();
        gridPane.add(directorNameLabel, 0, 2);
        gridPane.add(directorNameField, 1, 2);

        Label directorGradeLabel = new Label("Director Grade:");
        TextField directorGradeField = new TextField();
        gridPane.add(directorGradeLabel, 0, 3);
        gridPane.add(directorGradeField, 1, 3);

        // Add button to add departments
        Button addDepartmentButton = new Button("Add Department");
        addDepartmentButton.setOnAction(e -> {
            // Create an instance of AddDepartmentGUI and retrieve the Department object
            DepartmentGUI addDepartmentGUI = new DepartmentGUI();
            addDepartmentGUI.display();
            Department department = new Department(addDepartmentGUI.getHod(), addDepartmentGUI.getLabs());

            if (department != null) {
                departments.add(department);
            }
        });

        gridPane.add(addDepartmentButton, 0, 4, 2, 1); // Span the button across two columns

        // Add button to submit the form
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            // Get the values from the text fields
            String campusName = nameField.getText();
            String campusAddress = addressField.getText();
            String directorName = directorNameField.getText();
            String directorGrade = directorGradeField.getText();

            // Create an instance of Campus with the retrieved values
            campus = new Campus(campusName, campusAddress, new Director(directorName, directorGrade), departments);

            // Display the values
            System.out.println("Campus: " + campus);

            Connection connection = null;

            try {
               String url = "jdbc:mysql://localhost:3306/university";
               String user = "root";
               String pass = "Legend030012345@";

                connection = DriverManager.getConnection(url, user, pass);
                // Handle database operations here
                String query = "INSERT INTO campus (name, director, address) VALUES (?, ?, ?)";

                try {
                    assert connection != null;
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, nameField.getText());  // Get the name from GUI field
                    preparedStatement.setString(2, directorNameField.getText());  // Get the director from GUI field
                    preparedStatement.setString(3, addressField.getText());  // Get the address from GUI field

                    preparedStatement.executeUpdate();
                    System.out.println("Data inserted successfully!");
                } catch (SQLException E) {
                    E.printStackTrace();
                }
            } catch (SQLException E) {
                E.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException E) {
                        E.printStackTrace();
                    }
                }
            }


            // Save the campus object to a file or perform other operations


        });

        gridPane.add(submitButton, 1, 4); // Place the submit button in the second column and sixth row

        // Align the grid pane within the screen
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setMinSize(400, 200); // Set a minimum size for the grid pane

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

