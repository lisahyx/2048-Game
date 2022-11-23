package com.StartGame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu {
    @FXML
    private Button startGame;

    @FXML
    private Button colorTheme;

    public void initialize() {
        startGame.setOnAction(displayGameModes);
        colorTheme.setOnAction(displayThemeChooser);
    }

    @FXML
    EventHandler<ActionEvent> displayGameModes = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage;
            Parent root;

            stage = (Stage) startGame.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("/com/Game/gameModes.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    };

    @FXML
    EventHandler<ActionEvent> displayThemeChooser = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage;
            Parent root;

            stage = (Stage) startGame.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("/com/Game/colorTheme.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    };
};


