package com.EndGame;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Save user's score.
 *
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class HighScore {
    private static HighScore singleInstance = null;

    public static HighScore getInstance() {
        if (singleInstance == null)
            singleInstance = new HighScore();
        return singleInstance;
    }

    @FXML
    private TextArea userScoreList;

    public void initialize() throws IOException {
        userScoreList.setText(sortLines());
    }

    private String sortLines() throws IOException {
        String allContent = new String(Files.readAllBytes(Paths.get("highScoreList.txt")));

        ArrayList<String> str = new ArrayList<>(Arrays.asList(allContent.split("\n")));
        // descending
        str.sort((o1, o2) -> Integer.compare(
                Integer.parseInt(o2.substring(o2.indexOf(" ") + 1)),
                Integer.parseInt(o1.substring(o1.indexOf(" ") + 1))));

        String sorted = str.stream().collect(Collectors.joining("\n")); //separate with new line
        return sorted;
    }
}
