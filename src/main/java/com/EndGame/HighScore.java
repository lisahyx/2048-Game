package com.EndGame;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
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
    }

    // read last line of file
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

    private String sortLines() throws IOException {
        String sort = new String(Files.readAllBytes(Paths.get("highScoreList.txt")));
        String[] wordy = sort.split("\n");
        SortedSet<String> set = new TreeSet<String>();
        set.addAll(Arrays.asList(wordy));
        String sorted = set.stream().collect(Collectors.joining("\n"));
        return sorted;
    }
}
