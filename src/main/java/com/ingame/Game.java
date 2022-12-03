package com.ingame;

import com.cell.Cell;
import com.cell.TextMaker;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Formats the elements of the game scene and handles the operations when a key is pressed.
 *
 * @author  Lisa Ho Yen Xin
 * @version 2022-12-03
 * @since   2022-11-01
 */
public class Game extends GameStatus {
    Group root;
    static final TextMaker textMaker = TextMaker.getSingleInstance();

    /**
     * Formats the elements of the game scene and handles the operations when a key is pressed.
     *
     * @param gameScene    game scene
     * @param root         root
     * @param primaryStage stage
     * @param endGameScene game over scene
     * @param endGameRoot  root for game over scene
     */
    public void gamePlay(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < getN(); i++) {
            for (int j = 0; j < getN(); j++) {
                cells[i][j] = new Cell((j) * getLENGTH() + (j + 1) * getDistanceBetweenCells(),
                        (i) * getLENGTH() + (i + 1) * getDistanceBetweenCells(), getLENGTH(), root);
            }
        }

        Text text = new Text();
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(35));
        text.relocate(730, 100);

        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(730, 170);
        scoreText.setFont(Font.font(33));
        scoreText.setText("0");

        RandomNum.randomFillNumber(root, textMaker);
        RandomNum.randomFillNumber(root, textMaker);

        MoveDirection direction = new MoveDirection();

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key -> Platform.runLater(() -> {
            if (key.getCode() == KeyCode.DOWN) {
                direction.moveDown();
                checkEmptyCells(root, primaryStage, endGameScene, endGameRoot);
            } else if (key.getCode() == KeyCode.UP) {
                direction.moveUp();
                checkEmptyCells(root, primaryStage, endGameScene, endGameRoot);
            } else if (key.getCode() == KeyCode.LEFT) {
                direction.moveLeft();
                checkEmptyCells(root, primaryStage, endGameScene, endGameRoot);
            } else if (key.getCode() == KeyCode.RIGHT) {
                direction.moveRight();
                checkEmptyCells(root, primaryStage, endGameScene, endGameRoot);
            }
            scoreText.setText(score + "");
        }));
    }
}