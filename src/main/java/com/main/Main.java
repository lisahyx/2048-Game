package com.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Loads an application for a 2048 game.
 *
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class Main extends Application {
    /**
     * Loads and sets the main menu scene to the stage. Displays the stage.
     *
     * @param primaryStage stage to be displayed
     * @throws IOException if fail to load file
     *
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/game/main_menu.fxml")));

        Scene mainMenu = new Scene(root);
        primaryStage.setScene(mainMenu);
        primaryStage.setTitle("2048 Game");
        primaryStage.centerOnScreen();
        primaryStage.show();

        GameMusic.playMusic(); // play music
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be launched through deployment artifacts, e.g., in IDEs with limited FX support.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
