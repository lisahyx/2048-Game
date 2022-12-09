package com.player;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Saves user's highest score to file.
 *
 * @author  Lisa Ho Yen Xin
 * @version 2022-12-03
 * @since   2022-11-01
 */
public class Score {
    static long oldScore;

    /**
     * Sets a new value to {@link #oldScore} variable.
     *
     * @param newScore new value
     */
    public static void setOldScore(long newScore) {
        oldScore = newScore;
    }

    /**
     * @return {@link #oldScore} variable
     */
    public static long getOldScore() {
        return oldScore;
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
        file_writer = new FileWriter("src/main/resources/com/textfile/highScoreList.txt", true);
        BufferedWriter buffered_Writer = new BufferedWriter(file_writer);

        if(newScore > getOldScore()) {
            buffered_Writer.write(newScore + "\n");
        } else {
            buffered_Writer.write(getOldScore() + "\n");
        }
        buffered_Writer.flush();
        buffered_Writer.close();
        file_writer.close();
    }
}
