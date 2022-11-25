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

    public void initialize() {
        backButton.setOnAction(backToMenu);
    }

    public void changeColor (ActionEvent event) throws Exception {
        String id = ((Node) event.getSource()).getId();
        GameModes a = new GameModes();

        switch(id) {
            case "black":
                pane.setStyle("-fx-background-color: black");
                break;

            case "white":
                pane.setStyle("-fx-background-color: white");
                break;

            case "green":
                pane.setStyle("-fx-background-color: green");
                break;
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

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    };
}
