package com.Game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.util.Scanner;

public class Main extends Application {
    static final int WIDTH = 900;
    static final int HEIGHT = 900;
    private Group gameRoot = new Group();
    private Scene gameScene;

    private static Scanner input= new Scanner(System.in);

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    @Override
    public void start(Stage primaryStage) {

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

        //gameScene
        gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
        setGameScene(gameScene);

        primaryStage.setScene(gameScene);
        Game game = new Game();
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);


        /*
        Parent root = FXMLLoader.load(getClass().getResource("/com/Game/main_menu.fxml"));

        // Create the Scene
        Scene mainMenu = new Scene(root);
        // Set the Scene to the Stage
        primaryStage.setScene(mainMenu);

         */
        // Display the Stage
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
