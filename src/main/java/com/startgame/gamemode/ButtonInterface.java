package com.startgame.gamemode;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.stage.Stage;

/**
 * @author  Lisa Ho Yen Xin
 * @version 2022-12-03
 * @since   2022-11-01
 */
public interface ButtonInterface {
    void quitButtonListener(ActionEvent event, Stage primaryStage, Group root, long score);
}
