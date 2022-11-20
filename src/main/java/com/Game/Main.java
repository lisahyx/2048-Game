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
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Scanner;

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

        // Create the Scene
        Scene mainMenu = new Scene(root);
        // Set the Scene to the Stage
        primaryStage.setScene(mainMenu);
        // Display the Stage
        primaryStage.setTitle("2048 Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
