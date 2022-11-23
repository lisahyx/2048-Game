package com.StartGame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu {
    @FXML
    private Button startGame;

    public void initialize() {
        startGame.setOnAction(displayGameModes);
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
    Pane startPane;
    @FXML
    private ColorPicker gameTheme;

    public void changeColor(ActionEvent event) {
        Color myColor = gameTheme.getValue();
        startPane.setBackground(new Background(new BackgroundFill(myColor, null, null)));
    }
};


