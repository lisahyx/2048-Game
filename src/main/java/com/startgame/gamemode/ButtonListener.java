package com.startgame.gamemode;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.stage.Stage;

/**
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
public interface ButtonListener {
    void quitButtonListener(ActionEvent event, Stage primaryStage, Group root, long score);
}
