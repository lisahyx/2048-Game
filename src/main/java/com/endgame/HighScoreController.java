package com.endgame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * A controller for the high score list display scene that reads all users' scores
 * from a file and shows the sorted high score list.
 *
 * @author  Lisa Ho Yen Xin
 * @version 2022-12-03
 * @since   2022-11-01
 */
public class HighScoreController {
    private static HighScoreController singleInstance = null;

    /**
     * Returns an active instance of the class if it exists.
     * Otherwise, creates a new instance of the {@link HighScoreController} class.
     *
     * @return instance of class
     */
    public static HighScoreController getInstance() {
        if (singleInstance == null)
            singleInstance = new HighScoreController();
        return singleInstance;
    }

    @FXML
    private TextArea usernameList;

    @FXML
    private TextArea scoreList;

    @FXML
    private Button quitButton;

    /**
     * Sets the text for the high score list when the contents of the fxml file have been completely loaded.
     *
     * @throws IOException if fail to load file
     */
    public void initialize() throws IOException {
        usernameList.setText(getNameList(sortLines()));
        scoreList.setText(getScoreList(sortLines()));
        quitButton.setOnAction(quitGame);
    }

    /**
     * Reads all the content from a file that includes usernames and scores.
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

    /**
     * Returns the top ten user's usernames from the sorted high score list.
     *
     * @param sorted sorted high score list
     * @return top ten usernames
     * @throws IOException if fail to read the sorted high score list
     */
    public String getNameList(String sorted) throws IOException {
        ArrayList<String> nameStr = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new StringReader(sorted));

        String line = bufferedReader.readLine();
        String username;
        int counter = 0;

        while(line != null) {
            username = line.substring(0, line.indexOf(" "));
            nameStr.add(username); // add username to list
            counter++;
            checkName(username, counter);
            line = bufferedReader.readLine();
            if(counter==10){
                break;
            }
        }
        return String.join("\n", nameStr);
    }

    /**
     * Checks if the current user is among the top 10 players
     * and shows a congratulations message.
     *
     * @param username username
     * @param rank ranking
     * @throws IOException if fail to load file
     */
    public void checkName(String username, int rank) throws IOException {
        String currentUser = getName();

        if (currentUser.equals(username)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Congratulations!");
            alert.setHeaderText("You are among the top 10!");
            alert.setContentText("Current ranking: " + rank);
            alert.showAndWait();
        }
    }

    /**
     * Returns the username of the current user.
     *
     * @return current user's name
     * @throws IOException if fail to load file
     */
    public String getName() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("highScoreList.txt"));
        String last = null, line;

        while ((line = input.readLine()) != null) {
            last = line;
        }
        return Objects.requireNonNull(last).substring(0, last.indexOf(" "));
    }

    /**
     * Returns the top ten user's scores from the sorted high score list.
     *
     * @param sorted sorted high score list
     * @return top ten users' scores
     * @throws IOException if fail to read the sorted high score list
     */
    public String getScoreList(String sorted) throws IOException {
        ArrayList<String> scoreStr = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new StringReader(sorted));

        String line = bufferedReader.readLine();
        String score;
        int counter = 0;

        while(line != null) {
            score = line.substring(line.indexOf(" ") + 1);
            scoreStr.add(score); // add score to list
            counter++;
            line = bufferedReader.readLine();
            if(counter==10){
                break;
            }
        }
        return String.join("\n", scoreStr);
    }

    @FXML
    EventHandler<ActionEvent> quitGame = actionEvent -> {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit Dialog");
        alert.setHeaderText("Quit from this page");
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(null)  == ButtonType.OK) {
            Platform.exit();
        }
    };
}
