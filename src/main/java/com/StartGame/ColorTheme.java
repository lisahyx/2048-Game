package com.StartGame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ColorTheme {
    @FXML
    private Pane pane;

    @FXML
    private Button backButton;

    @FXML
    private Button black;

    @FXML
    private Button white;

    @FXML
    private Button green;

    public ColorTheme() {
        this.myColor=myColor;
    }

    public void initialize() {
        backButton.setOnAction(backToMenu);
        black.setOnAction(e ->{
            paneBlack();
        });
        white.setOnAction(e ->{
            paneWhite();
        });
        green.setOnAction(e ->{
            paneGreen();
        });
    }

    public String colorBlack() {
        return "black";
    }

    public String colorWhite() {
        return "white";
    }
    public String colorGreen() {
        return "green";
    }

    int counter;

    public void paneBlack() {
        pane.setStyle("-fx-background-color: black");
        colorBlack();
        white.setDisable(true);
        green.setDisable(true);

        counter++;
        myColor = "black";
        if(counter==2) {
            white.setDisable(false);
            green.setDisable(false);
            counter=0;
            myColor=null;
        }
    }

    public void paneWhite() {
        pane.setStyle("-fx-background-color: white");
        colorWhite();
        black.setDisable(true);
        green.setDisable(true);

        counter++;
        myColor = "white";
        if(counter==2) {
            black.setDisable(false);
            green.setDisable(false);
            counter=0;
            myColor = null;
        }
    }

    public static String getMyColor() {
        return myColor;
    }

    static String myColor;

    public void paneGreen() {
        pane.setStyle("-fx-background-color: green");
        colorGreen();
        black.setDisable(true);
        white.setDisable(true);

        counter++;
        myColor = "green";
        if(counter==2) {
            black.setDisable(false);
            white.setDisable(false);
            counter=0;
            myColor = "null";
        }
    }

    @FXML
    EventHandler<ActionEvent> backToMenu = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage;
            Parent root;

            stage = (Stage) backButton.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("/com/Game/main_menu.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(myColor == "black") {
                root.setStyle("-fx-background-color: black");
            } else if(myColor=="white") {
                root.setStyle("-fx-background-color: white");
            } else if (myColor =="green") {
                root.setStyle("-fx-background-color: green");
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    };
}
