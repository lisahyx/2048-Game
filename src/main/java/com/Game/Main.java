package com.Game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This is a java program for a 2048 game.
 *
 * @author  Lisa Ho
 * @version 1.0
 * @since   2020-11-1
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        // display main menu
        Parent root = FXMLLoader.load(getClass().getResource("/com/Game/main_menu.fxml"));
        root.setStyle("-fx-background-color: rgb(189, 177, 92)");

        // Create the Scene
        Scene mainMenu = new Scene(root);
        // Set the Scene to the Stage
        primaryStage.setScene(mainMenu);
        // Display the Stage
        primaryStage.setTitle("2048 Game");
        // center on screen
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
