package com.StartGame;

import com.Game.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MainMenu {
    @FXML
    private Button startGame;

    public void initialize() {
        startGame.setOnAction(displayMainMenu);
    }

    @FXML
    EventHandler<ActionEvent> displayMainMenu = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage stage;
            Parent root;

            stage = (Stage) startGame.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("/com/Game/gameModes.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    };
};


