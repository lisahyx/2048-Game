package com.startgame.gamemode;

import com.ingame.GameStatus;
import javafx.event.ActionEvent;
import javafx.scene.Node;

/**
 * A controller for the game modes selection scene.
 *
 * @author  Lisa Ho Yen Xin
 * @version 2022-12-03
 * @since   2022-11-01
 */
public class GameModesController {
    static String mode = null;

    public static String getMode() {
        return mode;
    }

    /**
     * Gets ids of buttons and sets the number of cells on the game board
     * according to the button selected before loading the game.
     *
     * @param event action event
     */
    public void gameMode(ActionEvent event) {
        String id = ((Node) event.getSource()).getId();
        GameStatus status = new GameStatus();
        GameScene game = new GameScene();

        switch (id) {
            case "3x3" -> status.setN(3);
            case "4x4" -> status.setN(4);
            case "5x5" -> status.setN(5);
            case "blackout" -> mode = "blackout";
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
        game.gameStart();
    }
}
