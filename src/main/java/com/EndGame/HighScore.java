package com.EndGame;

import com.Game.Game;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HighScore {
    private static HighScore singleInstance = null;
    public static HighScore getInstance() {
        if(singleInstance == null)
            singleInstance= new HighScore();
        return singleInstance;
    }

    @FXML
    private TextField userScores;

    public void initialize() {
        userScores.setText("username + score");
    }

}
