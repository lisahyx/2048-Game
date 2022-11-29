package com.User;

import java.io.*;
import java.util.Objects;

public class Account {
    private static long oldScore;

    // get old score
    public void getOldScore(String line) {
        oldScore = Long.parseLong(line.substring(Integer.parseInt(String.valueOf(line.lastIndexOf(" ") + 1))));
    }

    public void addUsername(String username) throws IOException {
        File oldFile = new File("C:\\Users\\lisah\\IdeaProjects\\COMP2042_CW_hfylh2\\highScoreList.txt");
        oldFile.createNewFile(); // create file if file does not exist
        File newFile = new File("newHighScoreList.txt");

        BufferedReader reader = new BufferedReader(new FileReader(oldFile));

        String nextLine = reader.readLine();
        String lastLine = null;

        FileWriter file_writer;
        file_writer = new FileWriter(newFile, true);
        BufferedWriter buffered_Writer = new BufferedWriter(file_writer);

        while (nextLine != null) {
            if (Objects.equals(username.toUpperCase(), nextLine.substring(0, nextLine.indexOf(" ")))) {
            getOldScore(nextLine);
        } else {
            buffered_Writer.write(nextLine + "\n");
        }
            nextLine = reader.readLine();
        }
        lastLine = username.toUpperCase() + " ";
        buffered_Writer.write(lastLine);
        buffered_Writer.flush();
        buffered_Writer.close();
        file_writer.close();
        reader.close();

        oldFile.delete();
        newFile.renameTo(oldFile);
    }

    public void compareScore(long newScore) throws IOException {
        FileWriter file_writer;
        file_writer = new FileWriter("highScoreList.txt", true);
        BufferedWriter buffered_Writer = new BufferedWriter(file_writer);

        if(newScore > oldScore) {
            buffered_Writer.write(newScore + "\n");
        } else {
            buffered_Writer.write(oldScore + "\n");
        }
        buffered_Writer.flush();
        buffered_Writer.close();
        file_writer.close();
    }
}
