package com.startgame.gamemode;

import com.ingame.GameStatus;
import javafx.event.ActionEvent;
import javafx.scene.Node;

/**
 * A controller for
 * <a href="file:C:\Users\lisah\IdeaProjects\COMP2042_CW_hfylh2\src\main\resources\com\Game\game_modes.fxml">
 * game_modes.fxml</a>.
 *
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class GameModesController {
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
            case "4x4" -> status.setN(4);
            case "5x5" -> status.setN(5);
            case "6x6" -> status.setN(6);
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
        game.gameStart();
    }
}
