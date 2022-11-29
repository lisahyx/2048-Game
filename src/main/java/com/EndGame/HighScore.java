package com.EndGame;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Reads all users' scores from a file and shows the sorted high score list.
 *
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class HighScore {
    private static HighScore singleInstance = null;

    /**
     * Returns an active instance of the class if it exists.
     * Otherwise, creates a new instance of the {@link HighScore} class.
     *
     * @return instance of class
     */
    public static HighScore getInstance() {
        if (singleInstance == null)
            singleInstance = new HighScore();
        return singleInstance;
    }

    @FXML
    private TextArea highScoreList;

    /**
     * Sets the text for the high score list when the contents of the fxml file have been completely loaded.
     *
     * @throws IOException if fail to load file
     */
    public void initialize() throws IOException {
        highScoreList.setText(sortLines());
    }

    /**
     * Reads all the content from a file,
     * <a href="file:C:\Users\lisah\IdeaProjects\COMP2042_CW_hfylh2\highScoreList.txt">
     *  * highScoreList.txt</a>, which includes usernames and scores.
     * Sorts the scores of all users in descending order and returns a sorted high score list.
     *
     * @return sorted high score list
     * @throws IOException if fail to load file
     */
    private String sortLines() throws IOException {
        String allContent = new String(Files.readAllBytes(Paths.get("highScoreList.txt")));
        ArrayList<String> str = new ArrayList<>(Arrays.asList(allContent.split("\n")));

        // sort in descending order
        str.sort((o1, o2) -> Integer.compare(
                Integer.parseInt(o2.substring(o2.indexOf(" ") + 1)),
                Integer.parseInt(o1.substring(o1.indexOf(" ") + 1))));

        return String.join("\n", str);
    }
}
