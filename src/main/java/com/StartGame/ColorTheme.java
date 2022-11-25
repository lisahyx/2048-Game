package com.StartGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ColorTheme {
    @FXML
    private Pane pane;

    @FXML
    private Button backButton;

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
}
