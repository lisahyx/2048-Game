package com.StartGame;

import com.Game.Game;
import com.Game.GameScene;
import com.User.Account;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;
import java.util.Optional;

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
     * Gets ids of buttons and sets the number of
     *
     * @param event
     */
    public void buttonListener (ActionEvent event) {
        String id = ((Node) event.getSource()).getId();
        GameScene a = new GameScene();

        switch (id) {
            case "4x4" -> {
                a.setN(4);
                ((Node) event.getSource()).getScene().getWindow().hide();
                start();
            }
            case "5x5" -> {
                a.setN(5);
                ((Node) event.getSource()).getScene().getWindow().hide();
                start();
            }
            case "6x6" -> {
                a.setN(6);
                ((Node) event.getSource()).getScene().getWindow().hide();
                start();
            }
        }
    }

    static final int WIDTH = 900;
    static final int HEIGHT = 650;
    private Group gameRoot = new Group();
    private Scene gameScene;

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    Account userScore = new Account();

    public void start () {
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
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);

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
        quitButton.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Quit Dialog");
            alert.setHeaderText("Quit from this page");
            alert.setContentText("Are you sure?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.orElse(null)  == ButtonType.OK) {
                try {
                    userScore.compareScore(GameScene.getScore()); // write score to file
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                gameRoot.getChildren().clear();
                primaryStage.close();
            } else {
                gameRoot.requestFocus();
            }
        });
    }
}
