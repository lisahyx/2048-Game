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
 * A controller for <a href="file:C:\Users\lisah\IdeaProjects\COMP2042_CW_hfylh2\src\main\resources\com\Game\color_theme.fxml">color_theme.fxml</a>.
 * <p>
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
    private Button black;

    @FXML
    private Button white;

    @FXML
    private Button green;

    public void initialize() {
        backButton.setOnAction(backToMenu);
        black.setOnAction(e -> paneBlack());
        white.setOnAction(e -> paneWhite());
        green.setOnAction(e -> paneGreen());
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
        pane.setStyle("-fx-background-color: black"); // set background color

        //disable other buttons
        white.setDisable(true);
        green.setDisable(true);

        counter++; // increase when button is clicked once
        myColor = "black"; // indicate which background color is chosen

        // enable other buttons when button is clicked twice
        if(counter==2) {
            white.setDisable(false);
            green.setDisable(false);
            counter=0; // reset counter
            myColor=null; // reset variable
        }
    }

    private void paneWhite() {
        pane.setStyle("-fx-background-color: white");

        black.setDisable(true);
        green.setDisable(true);

        counter++;
        myColor = "white";

        if(counter==2) {
            black.setDisable(false);
            green.setDisable(false);
            counter=0;
            myColor = null;
        }
    }

    private void paneGreen() {
        pane.setStyle("-fx-background-color: green");

        black.setDisable(true);
        white.setDisable(true);

        counter++;
        myColor = "green";

        if(counter==2) {
            black.setDisable(false);
            white.setDisable(false);
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
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/ingame/main_menu.fxml")));
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
