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

public class MainMenu {
    @FXML
    private Button startGame;

    @FXML
    private Button colorTheme;

    @FXML
    private Button quit;

    @FXML
    private Pane startPane;

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

        Platform.runLater( () -> vbox.requestFocus() ); // remove focus from textfield
        colorTheme.setOnAction(displayThemeChooser);
        quit.setOnAction(quitGame);

        // disable start button if user input is empty
        int minLength = 1;

        startGame.disableProperty().bind(
                username.textProperty().length().lessThan(minLength));
    }

    public void displayGameModes () {
        Stage stage;
        Parent root;

        stage = (Stage) startGame.getScene().getWindow();
        try {
            startPane.setVisible(false);
            root = FXMLLoader.load(getClass().getResource("/com/Game/gameModes.fxml"));
            ColorTheme.fxmlColor(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    EventHandler<ActionEvent> displayThemeChooser = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage;
            Parent root;

            stage = (Stage) startGame.getScene().getWindow();
            try {
                startPane.setVisible(false);
                root = FXMLLoader.load(getClass().getResource("/com/Game/colorTheme.fxml"));
                ColorTheme.fxmlColor(root); // set bg color
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    };

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

