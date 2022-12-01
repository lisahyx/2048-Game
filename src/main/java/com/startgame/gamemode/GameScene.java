package com.startgame.gamemode;

import com.ingame.Game;
import com.ingame.GameMovement;
import com.ingame.GameStatus;
import com.player.Score;
import com.startgame.colortheme.ColorThemeController;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * Formats game elements.
 *
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class GameScene implements ButtonListener {
    static final int WIDTH = 900;
    static final int HEIGHT = 650;
    private final Score userScore = new Score();
    private Group gameRoot = new Group();
    private Scene gameScene;

    long score = GameMovement.getScore();

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
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));

        setGameRoot(gameRoot);

        // change background color according to user choice
        if(Objects.equals(ColorThemeController.getMyColor(), "black")) {
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.BLACK);
        } else if(Objects.equals(ColorThemeController.getMyColor(), "white")) {
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.WHITE);
        } else if (Objects.equals(ColorThemeController.getMyColor(), "green")) {
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.GREEN);
        } else {
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
        }

        setGameScene(gameScene);

        Stage primaryStage = new Stage();
        primaryStage.setScene(gameScene);

        Game game = new Game();
        game.gamePlay(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);

        // display the Stage
        primaryStage.show();
        gameRoot.requestFocus(); // take away focus from quit button

        // quit button
        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(85,35);
        quitButton.setLayoutX(762);
        quitButton.setLayoutY(572);
        quitButton.setTextFill(Color.BLACK);
        gameRoot.getChildren().add(quitButton);

        // quit button listener
        quitButton.setOnAction(actionEvent -> {
            quitButtonListener (actionEvent, primaryStage, gameRoot, score);
        });
    }

    /**
     * Saves user's score when quit button is selected.
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
