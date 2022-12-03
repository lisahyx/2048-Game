package com.ingame;

/**
 * Handles cells modification when a move is made on the game board.
 *
 * @author  Lisa Ho Yen Xin
 * @version 2022-12-03
 * @since   2022-11-01
 */
public class GameMovement extends PassDestination implements GameInterface{
    static long score;

    /**
     * Checks if cells are merged and increases user score.
     *
     * @param i X coordinate
     * @param j Y coordinate
     * @param des new coordinate
     * @param sign direction
     * @return a boolean value that indicates a merged cell
     */
    private boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0) {
            if (cells[i][des + sign].getNumber() == cells[i][j].getNumber() && cells[i][des + sign].getModify()
                    && cells[i][des + sign].getNumber() != 0) {
                score += cells[i][j].getNumber()* 2L; // increase score
                return true;
            }
        }
        return false;
    }

    /**
     * Modifies cells when cells move horizontally.
     *
     * @param i X coordinate
     * @param j Y coordinate
     * @param des new coordinate
     * @param sign direction
     */
    void moveHorizontally(int i, int j, int des, int sign) {
        if (isValidDesH(i, j, des, sign)) {
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des].setModify(true);
        } else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
        }
    }

    /**
     * Checks if cells are merged and increases user score.
     *
     * @param i X coordinate
     * @param j Y coordinate
     * @param des new coordinate
     * @param sign direction
     * @return a boolean value that indicates a merged cell
     */
    private boolean isValidDesV(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0)
            if (cells[des + sign][j].getNumber() == cells[i][j].getNumber() && cells[des + sign][j].getModify()
                    && cells[des + sign][j].getNumber() != 0) {
                score += cells[i][j].getNumber()* 2L; // increase score
                return true;
            }
        return false;
    }

    /**
     * Modifies cells when cells move vertically.
     *
     * @param i X coordinate
     * @param j Y coordinate
     * @param des new coordinate
     * @param sign direction
     */
    public void moveVertically(int i, int j, int des, int sign) {
        if (isValidDesV(i, j, des, sign)) {
            cells[i][j].adder(cells[des + sign][j]);
            cells[des][j].setModify(true);
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
        }
    }
}
