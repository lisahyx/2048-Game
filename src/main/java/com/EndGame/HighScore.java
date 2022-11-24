package com.EndGame;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
        userScores.setText(readList());
    }

    private String readList() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("highScoreList.txt")))) {
            String line = null;
            String nextLine;
            while ((nextLine = reader.readLine()) != null) {
                line = nextLine;
            }
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
