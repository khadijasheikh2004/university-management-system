package com.example.javagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Button button = new Button("Click me!");

        button.setOnAction(actionEvent -> {
            AddLabGUI.display();
            System.out.println("THE COMPONENT IS RETURNING"+ AddLabGUI.getLabs().toString());
        });
        Button button2 = new Button("Return");
        button2.setOnAction(actionEvent -> {
            System.out.println("THE COMPONENT IS RETURNING"+ AddLabGUI.getLabs().toString());
        });
        StackPane root = new StackPane();
        root.getChildren().addAll(button,button2);
        Scene scene1 = new Scene(root, 300, 250);

        stage.setTitle("Hello!");
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}