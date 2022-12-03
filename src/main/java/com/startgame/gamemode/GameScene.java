package com.startgame.gamemode;

import com.ingame.Game;
import com.player.Score;
import com.startgame.colortheme.ChangeColor;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * Formats game elements.
 *
 * @author  Lisa Ho Yen Xin - modified
 * @version 2022-12-03
 * @since   2022-11-01
 */
public class GameScene implements ButtonListener {
    static final int WIDTH = 900;
    static final int HEIGHT = 650;
    private final Score userScore = new Score();
    private Group gameRoot = new Group();
    private Scene gameScene;
    long score = 0;

    /**
     * @param gameScene game scene
     */
    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    /**
     * @param gameRoot root of game
     */
    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    /**
     * Formats game elements.
     */
    public void gameStart() {
        Group endgameRoot = new Group();
        Scene endGameScene = ChangeColor.bgColor(endgameRoot, WIDTH, HEIGHT); // set background color according to user choice

        setGameRoot(gameRoot);

        // set background color according to user choice
        gameScene = ChangeColor.bgColor(gameRoot, WIDTH, HEIGHT);
        setGameScene(gameScene);

        Stage primaryStage = new Stage();
        primaryStage.setScene(gameScene);

        Game game = new Game();
        game.gamePlay(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);

        // display the Stage
        primaryStage.setTitle("2048 Game");
        primaryStage.centerOnScreen();
        primaryStage.show();
        gameRoot.requestFocus(); // take away focus from quit button

        // save score when close window
        primaryStage.setOnCloseRequest(event -> {
            try {
                userScore.compareScore(score);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // quit button
        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(88,39);
        quitButton.setLayoutX(762);
        quitButton.setLayoutY(572);
        quitButton.setTextFill(Color.BLACK);
        gameRoot.getChildren().add(quitButton);

        // quit button listener
        quitButton.setOnAction(actionEvent -> quitButtonListener (actionEvent, primaryStage, gameRoot, score));
    }

    /**
     * Saves new user's score as 0 or old user's old score when quit button is selected.
     *
     * @param event action event
     * @param primaryStage stage
     * @param root root
     * @param score user score
     */
    @Override
    public void quitButtonListener(ActionEvent event, Stage primaryStage, Group root, long score) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit Dialog");
        alert.setHeaderText("Quit from this page");
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(null)  == ButtonType.OK) {
            try {
                userScore.compareScore(score); // write score to file
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            root.getChildren().clear();
            primaryStage.close();
        } else {
            root.requestFocus();
        }
    }
}
