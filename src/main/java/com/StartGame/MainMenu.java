package com.StartGame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class MainMenu {
    @FXML
    private ChoiceBox gameMode;
    ObservableList<String> modes = FXCollections.observableArrayList("4x4","5x5","6x6","Blackout");

    public void initialize() {
        gameMode.setValue("4x4"); // this statement shows default value
        gameMode.setItems(modes);
    }
}
