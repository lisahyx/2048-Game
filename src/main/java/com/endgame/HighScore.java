package com.endgame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static com.startgame.colortheme.ChangeColor.fxmlColor;

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

    @FXML
    private Button backButton;

    /**
     * Sets the text for the high score list when the contents of the fxml file have been completely loaded.
     *
     * @throws IOException if fail to load file
     */
    public void initialize() throws IOException {
        highScoreList.setText(sortLines());
        backButton.setOnAction(backToMenu);
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

        return justifyContent(String.join("\n", str));
    }

    public String justifyContent(String sorted) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(sorted));

        String line = bufferedReader.readLine();
        String username;
        String score;
        int nameLength;
        int counter = 0;

        ArrayList<String> justifyStr = new ArrayList<>();

        while(line != null) {
            username = line.substring(0, line.indexOf(" "));
            nameLength = username.length();
            score = line.substring(line.indexOf(" ") + 1);

            switch (nameLength) {
                case 1 -> justifyStr.add(username + String.format("%1$" + (24) + "s", score));
                case 2 -> justifyStr.add(username + String.format("%1$" + (22) + "s", score));
                case 3 -> justifyStr.add(username + String.format("%1$" + (20) + "s", score));
                case 4 -> justifyStr.add(username + String.format("%1$" + (18) + "s", score));
                case 5 -> justifyStr.add(username + String.format("%1$" + (15) + "s", score));
            }

            counter++;
            line = bufferedReader.readLine();

            if(counter==10){
                break;
            }
        }
        return String.join("\n", justifyStr);
    }

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
