package com.StartGame;

import com.User.Account;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

/**
 * A controller for <a href="file:C:\Users\lisah\IdeaProjects\COMP2042_CW_hfylh2\src\main\resources\com\Game\main_menu.fxml">main_menu.fxml</a>.
 * <p>
 * Defines an initialize() method which calls certain methods when certain buttons are selected by the user.
 * Calls the initialize() method when the contents of the fxml file have been completely loaded.
 * <p>
 * Disables start button if user input is less than the required character length.
 * Saves username by calling {@link Account#addUsername(String)}.
 *
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class MainMenuController {
    @FXML
    private Button startGame;

    @FXML
    private Button colorTheme;

    @FXML
    private Button quit;

    @FXML
    private VBox vbox;

    @FXML
    private TextField username;

    public void initialize() {
        startGame.setOnAction(e ->{
            displayGameModes();

            Account account = new Account();
            try {
                account.addUsername(username.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        colorTheme.setOnAction(displayThemeChooser);
        quit.setOnAction(quitGame);

        // remove focus from textfield
        Platform.runLater( () -> vbox.requestFocus() );
        
        // minimum user input length
        int minLength = 1;

        // disable start button if user input is empty
        startGame.disableProperty().bind(
                username.textProperty().length().lessThan(minLength));
    }

    /**
     * Loads and sets the game modes selection scene to the stage.
     * Sets stage background color according to user selection by calling
     * {@link ColorThemeController#fxmlColor(Parent)} method.
     * Displays the stage.
     */
    public void displayGameModes () {
        Stage stage;
        Parent root;

        stage = (Stage) startGame.getScene().getWindow();
        try {
            root = FXMLLoader.load(getClass().getResource("/com/Game/game_modes.fxml"));
            ColorThemeController.fxmlColor(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Loads and sets the color theme selection scene to the stage.
     * Sets stage background color according to user selection by calling
     * {@link ColorThemeController#fxmlColor(Parent)} method.
     * Displays the stage.
     */
    @FXML
    EventHandler<ActionEvent> displayThemeChooser = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage;
            Parent root;

            stage = (Stage) startGame.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("/com/Game/color_theme.fxml"));
                ColorThemeController.fxmlColor(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    };

    /**
     * Displays an alert message when the quit game button is clicked to prompt user for quit game confirmation.
     * Closes the program when user confirms on quitting the game.
     */
    @FXML
    EventHandler<ActionEvent> quitGame = actionEvent -> {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit Dialog");
        alert.setHeaderText("Quit from this page");
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Platform.exit();
        }
    };
};

