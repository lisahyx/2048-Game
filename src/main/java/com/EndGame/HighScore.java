package com.EndGame;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

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
        //userScoreList.setText(readList());
    }

    // read last line of file
    private String readList() {
        try (BufferedReader reader = new BufferedReader(new FileReader("highScoreList.txt"))) {
            String line = null;
            String nextLine;

            String sorted = null;
            while ((nextLine = reader.readLine()) != null) {
                line = nextLine;

                String[] tokens = line.split("\t");
                if (tokens.length != 2) {
                    throw new IllegalArgumentException();
                }
                String command = tokens[0];
                String person = tokens[1];

                SortedSet<String> set = new TreeSet<String>();
                set.addAll(Arrays.asList(person));
                sorted = set.stream().collect(Collectors.joining("\n"));
            }
            return sorted;
            //return line; //last line
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String sortLines() throws IOException {
        String allContent = new String(Files.readAllBytes(Paths.get("highScoreList.txt")));

        ArrayList<String> str = new ArrayList<>(Arrays.asList(allContent.split("\n")));
        // descending
        str.sort((o1, o2) -> Integer.compare(
                Integer.parseInt(o2.substring(o2.indexOf("\t") + 1)),
                Integer.parseInt(o1.substring(o1.indexOf("\t") + 1))));

        String sorted = str.stream().collect(Collectors.joining("\n")); //separate with new line
        return sorted;
    }
}
