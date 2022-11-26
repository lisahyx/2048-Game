package com.StartGame;

import com.Game.Game;
import com.Game.GameScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class GameModes {
    public void buttonListener (ActionEvent event) throws Exception {
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

    private static final Scanner input= new Scanner(System.in);

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    public void start () {
        Group menuRoot = new Group();
        Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
        Group accountRoot = new Group();
        Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
        Group getAccountRoot = new Group();
        Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
        Group rankRoot = new Group();
        Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
        BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);


        Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
        backgroundOfMenu.setX(WIDTH / 2 - 120);
        backgroundOfMenu.setY(180);
        menuRoot.getChildren().add(backgroundOfMenu);

        Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
        backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
        backgroundOfMenuForPlay.setY(180);
        accountRoot.getChildren().add(backgroundOfMenuForPlay);

        setGameRoot(gameRoot);

        // change bg color according to user choice
        if(Objects.equals(ColorTheme.myColor, "black")) {
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.BLACK);
        } else if(Objects.equals(ColorTheme.myColor, "white")) {
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.WHITE);
        } else if (Objects.equals(ColorTheme.myColor, "green")) {
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.GREEN);
        } else {
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
        }

        setGameScene(gameScene);

        Stage primaryStage = new Stage();

        primaryStage.setScene(gameScene);
        Game game = new Game();
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);

        // Display the Stage
        primaryStage.show();
        gameRoot.requestFocus(); // take away focus from quit button

        // quit button
        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(85,35);
        quitButton.setLayoutX(800);
        quitButton.setLayoutY(550);
        quitButton.setTextFill(Color.BLACK);
        gameRoot.getChildren().add(quitButton);

        quitButton.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Quit Dialog");
            alert.setHeaderText("Quit from this page");
            alert.setContentText("Are you sure?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                gameRoot.getChildren().clear();
                primaryStage.close();
            } else {
                gameRoot.requestFocus();
            }
        });
    }

}
