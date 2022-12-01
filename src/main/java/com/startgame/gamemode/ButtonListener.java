package com.startgame.gamemode;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.stage.Stage;

public interface ButtonListener {
    void quitButtonListener(ActionEvent event, Stage primaryStage, Group root, long score);
}
