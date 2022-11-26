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
import java.util.Objects;

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

    int counter;
    static String myColor;

    public static String getMyColor() {
        return myColor;
    }

    public void paneBlack() {
        pane.setStyle("-fx-background-color: black"); // set bg color

        //disable other buttons
        white.setDisable(true);
        green.setDisable(true);

        counter++; // increase when button is clicked once
        myColor = "black"; // indicate which bg color is chosen

        // enable other buttons when button is clicked twice
        if(counter==2) {
            white.setDisable(false);
            green.setDisable(false);
            counter=0; // reset counter
            myColor=null; // reset variable
        }
    }

    public void paneWhite() {
        pane.setStyle("-fx-background-color: white");

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


    public void paneGreen() {
        pane.setStyle("-fx-background-color: green");

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

    public static void fxmlColor(Parent root) {
        if(Objects.equals(ColorTheme.myColor, "black")) {
            root.setStyle("-fx-background-color: black");
        } else if(Objects.equals(ColorTheme.myColor, "white")) {
            root.setStyle("-fx-background-color: white");
        } else if (Objects.equals(ColorTheme.myColor, "green")) {
            root.setStyle("-fx-background-color: green");
        } else {
            root.setStyle("-fx-background-color: rgb(189, 177, 92)");
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

            // link bg color across stages
            if(myColor == "black") {
                root.setStyle("-fx-background-color: black");
            } else if(myColor=="white") {
                root.setStyle("-fx-background-color: white");
            } else if (myColor =="green") {
                root.setStyle("-fx-background-color: green");
            } else {
                root.setStyle("-fx-background-color: rgb(189, 177, 92)");
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    };
}
