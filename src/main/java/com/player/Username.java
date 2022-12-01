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
public class Username {
    /**
     * Gets and assigns user's old score to {@link Score#oldScore}
     * variable to be used as comparison when game ends.
     *
     * @param line user's old score
     */
    public void getStrScore(String line) {
        Score.oldScore = Long.parseLong(line.substring(Integer.parseInt(String.valueOf(line.lastIndexOf(" ") + 1))));
    }

    /**
     * Reads from old file to check if user is new user.
     * Saves user's old score in {@link Score#oldScore} variable if user is old user.
     * Writes everything except current user's score from old file to new file.
     * Delete old file and rename new file to the same as old file.
     *
     * @param username the username
     * @throws IOException if fail to load file
     */
    public void addUsername(String username) throws IOException {

        File oldFile = new File("highScoreList.txt");
        oldFile.createNewFile(); // create file if file does not exist
        File newFile = new File("newHighScoreList.txt");

        BufferedReader reader = new BufferedReader(new FileReader(oldFile));

        String nextLine = reader.readLine();
        String lastLine;

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
}
