package com.player;

/**
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
public abstract class AbstractScore {
    private static long oldScore;

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
     * Gets user's username and score.
     * Assigns user's old score to {@link #oldScore} variable to be used as comparison.
     *
     * @param line username and score
     */
    public void getStrScore(String line) {
        oldScore = Long.parseLong(line.substring(Integer.parseInt(String.valueOf(line.lastIndexOf(" ") + 1))));
    }
}
