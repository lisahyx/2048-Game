package com.startgame.colortheme;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.startgame.colortheme.ChangeColor.fxmlColor;

/**
 * A controller for the color theme selection scene.
 * Sets background color and disables the other color buttons.
 * Assigns the background color chosen to a variable and increases counter
 * to indicate the number of button clicks.
 * Enables the other color buttons and resets all variables when button is
 * clicked twice to let user select other colors.
 */
public class ColorThemeController {
    @FXML
    private Pane pane;

    @FXML
    private Button backButton;

    @FXML
    private Button blue;

    @FXML
    private Button green;

    @FXML
    private Button purple;

    public void initialize() {
        backButton.setOnAction(backToMenu);
        blue.setOnAction(e -> paneBlack());
        green.setOnAction(e -> paneGreen());
        purple.setOnAction(e -> panePurple());
    }

    int counter; // to indicate button clicks
    static String myColor;

    /**
     * Returns a variable that indicates the background color selected by
     * the user that is to be used in other methods.
     *
     * @return background color
     */
    public static String getMyColor() {
        return myColor;
    }

    private void paneBlack() {
        pane.setStyle("-fx-background-color: rgb(141, 191, 247)"); // set background color

        //disable other buttons
        green.setDisable(true);
        purple.setDisable(true);

        counter++; // increase when button is clicked once
        myColor = "blue"; // indicate which background color is chosen

        // enable other buttons when button is clicked twice
        if(counter==2) {
            green.setDisable(false);
            purple.setDisable(false);
            counter=0; // reset counter
            myColor=null; // reset variable
        }
    }

    private void paneGreen() {
        pane.setStyle("-fx-background-color: rgb(114, 191, 59)");

        blue.setDisable(true);
        purple.setDisable(true);

        counter++;
        myColor = "green";

        if(counter==2) {
            blue.setDisable(false);
            purple.setDisable(false);
            counter=0;
            myColor = null;
        }
    }

    private void panePurple() {
        pane.setStyle("-fx-background-color: rgb(195, 182, 242)");

        blue.setDisable(true);
        green.setDisable(true);

        counter++;
        myColor = "purple";

        if(counter==2) {
            blue.setDisable(false);
            green.setDisable(false);
            counter=0;
            myColor = "null";
        }
    }

    /**
     * Loads and sets the main menu scene to the stage.
     * Sets stage background color according to user selection by calling
     * {@link ChangeColor#fxmlColor(Parent)} method and displays the stage.
     */
    @FXML
    EventHandler<ActionEvent> backToMenu = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage;
            Parent root;

            stage = (Stage) backButton.getScene().getWindow();
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/game/main_menu.fxml")));
                fxmlColor(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    };
}
