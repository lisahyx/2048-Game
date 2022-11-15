package com.Game;

import com.EndGame.EndGame;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends MoveDirection{
    private long score = 0;

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
    void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * getLENGTH() + (j + 1) * getDistanceBetweenCells(),
                        (i) * getLENGTH() + (i + 1) * getDistanceBetweenCells(), getLENGTH(), root);
            }
        }

        Text text = new Text();
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.relocate(750, 100);
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(750, 150);
        scoreText.setFont(Font.font(20));
        scoreText.setText("0");

        randomFillNumber(1);
        randomFillNumber(1);

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key ->{
            Platform.runLater(() -> {
                int haveEmptyCell;
                if (key.getCode() == KeyCode.DOWN) {
                    Game.this.moveDown();
                } else if (key.getCode() == KeyCode.UP) {
                    Game.this.moveUp();
                } else if (key.getCode() == KeyCode.LEFT) {
                    Game.this.moveLeft();
                } else if (key.getCode() == KeyCode.RIGHT) {
                    Game.this.moveRight();
                }
                Game.this.sumCellNumbersToScore();
                scoreText.setText(score + "");
                haveEmptyCell = Game.this.haveEmptyCell();
                if (haveEmptyCell == -1) {
                    if (Game.this.canNotMove()) {
                        primaryStage.setScene(endGameScene);

                        EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
                        root.getChildren().clear();
                        score = 0;
                    }
                } else if(haveEmptyCell == 1)
                    Game.this.randomFillNumber(2);
            });
        });
    }

    void sumCellNumbersToScore() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                score += cells[i][j].getNumber();
            }
        }
    }
}
