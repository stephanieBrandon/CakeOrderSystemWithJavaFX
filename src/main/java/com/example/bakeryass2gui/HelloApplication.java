package com.example.bakeryass2gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Create a pane
        //the pane is the layout container that contains other JavaFX components
        Pane pane = new Pane();
        //Create a label and pass it through the pane layout
        Label orderTitle = new Label("Place your Cake order Below");
        //use getChildren and add method to  place the label node in the pane layout
        pane.getChildren().add(orderTitle);
        //add the pane to the scene
        Scene scene = new Scene(pane, 200, 200);
        stage.setTitle("Assignment2 Order Your Cake!");
        //Placing the Scene in the stage
        stage.setScene(scene);
        //Displays the Stage
        stage.show();
    }

    public static void main(String[] args) {
        //launches the Stage
        launch();
    }
}