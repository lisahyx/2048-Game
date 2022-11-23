package com.StartGame;

import com.Game.Game;
import com.Game.GameScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ColorTheme {
    @FXML
    Pane pane;

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
