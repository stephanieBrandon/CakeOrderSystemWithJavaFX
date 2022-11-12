package com.example.bakeryass2gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;

public class BakeryApplication extends Application {
    @Override
    public void start(Stage stage) {
        //Create a pane
        //the pane is the layout container that contains other JavaFX components
        GridPane gridPane = new GridPane();
        //Create a label and pass it through the pane layout
        Label orderTitle = new Label("Place your Cake Order Below");
        Label nameTitle = new Label("First and Last Name");
        Label numberTitle = new Label("Please enter your phone number:");
        Label deliveryFeettl = new Label("Please enter your delivery address:");
        //Create a text field area
        TextField name = new TextField();
        TextField number = new TextField();
        TextField deliveryFeeInput = new TextField();

        Label cakeSizeTtl = new Label("Please select your Cake Size:");
        RadioButton cakeSm = new RadioButton("Small");

        RadioButton cakeMd = new RadioButton("Medium");

        RadioButton cakeLg = new RadioButton("Large");


        ToggleGroup cakeSize = new ToggleGroup();
        cakeSm.setToggleGroup(cakeSize);
        cakeMd.setToggleGroup(cakeSize);
        cakeLg.setToggleGroup(cakeSize);

        Label cakeTypeTtl = new Label("Please select your Cake Type:");
        //Combo Box
        ComboBox<String> cakeSelection = new ComboBox<>();
        cakeSelection.getItems().addAll("Apple","Carrot", "Cheesecake","Chocolate", "Coffee", "Opera", "Tiramisu");
        cakeSelection.setValue("Cake Type");

        //create a save and quit button
        Button saveBtn = new Button("Save");
        Button quitBtn = new Button("Quit");
        Button deliveryBtn = new Button("Submit");

        deliveryBtn.setOnAction(e ->{
            //Creating an alert for delivery fee or no fee
            Alert deliveryAlert = new Alert(Alert.AlertType.INFORMATION);
                    deliveryAlert.setContentText("Your delivery address qualifies for free delivery!");
                    deliveryAlert.show();

        });
        //Events for buttons
        saveBtn.setOnAction(e -> {

                    try {
                        BufferedWriter writer = new BufferedWriter( new FileWriter("Order.txt"));
                        writer.write("Customers phone number is:");
                        writer.write(number.getText());
                        writer.newLine();
                        writer.write("Customers name is:");
                        writer.write(name.getText());
                        writer.newLine();
                        writer.write("Customers delivery address is:");
                        writer.write(deliveryFeeInput.getText());
                        writer.newLine();
                        writer.write("Cake size desired is:");
                        writer.write(cakeSize.getSelectedToggle().toString());
                        writer.newLine();
                        writer.write("Type of Cake desired is:");
                        writer.write(cakeSelection.getValue());
                        //add cakeSize selection
                        writer.close();
                    } catch (IOException err) {
                        err.printStackTrace();
                    }
                });

        //handles click event on quit button to exit program
        quitBtn.setOnAction(e ->{
            Platform.exit();
        });
        //add an HBox to hold the buttons and arrange them horizontally
        HBox buttonBox = new HBox(10, saveBtn, quitBtn);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        //node, column, row
        gridPane.setConstraints(orderTitle,2,0);
        gridPane.setConstraints(nameTitle,2,1);
        gridPane.setConstraints(name, 2, 2);
        gridPane.setConstraints(numberTitle,2,3);
        gridPane.setConstraints(number, 2, 4);
        gridPane.setConstraints(cakeSizeTtl, 3, 5);
        gridPane.setConstraints(cakeSm, 3, 6);
        gridPane.setConstraints(cakeMd, 3, 7);
        gridPane.setConstraints(cakeLg, 3, 8);
        gridPane.setConstraints(cakeTypeTtl, 2, 5);
        gridPane.setConstraints(cakeSelection, 2, 6);
        gridPane.setConstraints(buttonBox, 3, 11);
        gridPane.setConstraints(deliveryFeettl,3,1);
        gridPane.setConstraints(deliveryFeeInput,3,2);
        gridPane.setConstraints(deliveryBtn, 3, 3);
        gridPane.setPadding(new Insets(20));
        //use getChildren and add method to  place the label node in the pane layout
       gridPane.getChildren().addAll(buttonBox, orderTitle, name, number, nameTitle, numberTitle, cakeSm, cakeMd, cakeLg, cakeSizeTtl, cakeSelection, cakeTypeTtl, deliveryFeettl, deliveryFeeInput, deliveryBtn);
        //Use BorderPane to aid in layout
        //controls are typically inserted into a different
        //type  of layout and then added into the BorderPane accordingly
        //like how our buttons and title are in a GridPane right now
        BorderPane mainPain = new BorderPane();
        mainPain.setCenter(gridPane);
        //add the pane to the scene
        Scene scene = new Scene(mainPain, 600, 600);
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
