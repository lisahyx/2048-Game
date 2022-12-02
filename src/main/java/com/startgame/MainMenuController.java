package com.startgame;

import com.player.Username;
import com.startgame.colortheme.ChangeColor;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

/**
 * A controller for <a href="file:C:\Users\lisah\IdeaProjects\COMP2042_CW_hfylh2\src\main\resources\com\Game\main_menu.fxml">main_menu.fxml</a>.
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

    /**
     * Disables start button if user input is less than the required character length.
     * Saves username by calling {@link Username#addUsername(String)}.
     */
    public void initialize() {
        startGame.setOnAction(e ->{
            displayGameModes();

            Username account = new Username();
            try {
                account.addUsername(username.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        colorTheme.setOnAction(displayThemeChooser);
        quit.setOnAction(quitGame);

        Platform.runLater( () -> vbox.requestFocus() ); // remove focus from textfield

        int minLength = 1; // minimum user input length
        username.addEventFilter(KeyEvent.KEY_TYPED, maxLength(5)); // maximum user input length

        // disable start button if user input is empty
        startGame.disableProperty().bind(username.textProperty().length().lessThan(minLength));
    }

    /**
     * @param i maximum user input length
     * @return event handler
     */
    public EventHandler<KeyEvent> maxLength(final Integer i) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                username = (TextField) arg0.getSource();
                if (username.getText().length() >= i) {
                    arg0.consume();
                }
            }
        };
    }

    /**
     * Loads and sets the game modes selection scene to the stage.
     * Sets stage background color according to user selection by calling
     * {@link ChangeColor#fxmlColor(Parent)} method.
     * Displays the stage.
     */
    public void displayGameModes () {
        Stage stage;
        Parent root;

        stage = (Stage) startGame.getScene().getWindow();
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/ingame/game_modes.fxml")));
            ChangeColor.fxmlColor(root);
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
     * {@link ChangeColor#fxmlColor(Parent)} method.
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
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/ingame/color_theme.fxml")));
                ChangeColor.fxmlColor(root);
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
        if (result.orElse(null) == ButtonType.OK){
            Platform.exit();
        }
    };
}
