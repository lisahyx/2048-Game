package com.StartGame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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

    public void paneBlack() {
        pane.setStyle("-fx-background-color: black");
        colorBlack();
    }

    public void paneWhite() {
        pane.setStyle("-fx-background-color: white");
        colorWhite();
    }

    public void paneGreen() {
        pane.setStyle("-fx-background-color: green");
        colorGreen();
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

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    };
}
