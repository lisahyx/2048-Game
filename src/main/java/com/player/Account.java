package com.player;

import java.io.*;
import java.util.Objects;

/**
 * Compares and writes user's username and score into a file.
 *
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class Account {
    private static long oldScore;

    /**
     * Sets a new value to {@link #oldScore} variable.
     *
     * @param newScore new value
     */
    public static void setOldScore(long newScore) {
        Account.oldScore = newScore;
    }

    /**
     * @return {@link #oldScore} variable
     */
    public static long getOldScore() {
        return oldScore;
    }

    /**
     * Gets user's username and score.
     * Assigns user's old score to {@link #oldScore} variable to be used as comparison.
     *
     * @param line username and score
     */
    public void getStrScore(String line) {
        oldScore = Long.parseLong(line.substring(Integer.parseInt(String.valueOf(line.lastIndexOf(" ") + 1))));
    }

    /**
     * Reads from old file to check if user is new user.
     * Saves user's old score in {@link #oldScore} variable if user is old user.
     * Writes everything except current user's score from old file to new file.
     * Delete old file and rename new file to the same as old file.
     *
     * @param username username
     * @throws IOException if fail to load file
     */
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

        // check if user is old user
        while (nextLine != null) {
            if (Objects.equals(username.toUpperCase(), nextLine.substring(0, nextLine.indexOf(" ")))) {
                getStrScore(nextLine); // get user's old score
            } else {
                buffered_Writer.write(nextLine + "\n");
            }
            nextLine = reader.readLine();
        }
        lastLine = username.toUpperCase() + " "; // only write username to file
        buffered_Writer.write(lastLine);
        buffered_Writer.flush();
        buffered_Writer.close();
        file_writer.close();
        reader.close();

        oldFile.delete();
        newFile.renameTo(oldFile);
    }

    /**
     * Compares user's old score with user's new score.
     * Writes user's highest score into file.
     *
     * @param newScore new score
     * @throws IOException if fail to load file
     */
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
