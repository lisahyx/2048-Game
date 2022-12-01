package com.player;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class Score extends AbstractScore {
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
