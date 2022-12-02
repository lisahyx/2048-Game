package com.ingame;

import com.endgame.EndGame;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Checks the status of the game.
 *
 * @author  Lisa Ho Yen Xin - modified
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class GameStatus extends MoveDirection implements GameInterface {
    private static final int HEIGHT = 620;
    private static int n = 4;
    private static final int DISTANCE_BETWEEN_CELLS = 10;
    private static double LENGTH = (HEIGHT - ((n + 1) * DISTANCE_BETWEEN_CELLS)) / (double) n;

    /**
     * Sets the number of cells on the game board and calculates the length of a cell.
     *
     * @param number number of cells on the game board
     */
    public void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * DISTANCE_BETWEEN_CELLS)) / (double) n;
    }

    /**
     * @return number of cells on the game board
     */
    public static int getN() {
        return n;
    }

    /**
     * @return distance between cells
     */
    public static int getDistanceBetweenCells() {
        return DISTANCE_BETWEEN_CELLS;
    }

    /**
     * @return length of a cell
     */
    public static double getLENGTH() {
        return LENGTH;
    }

    /**
     * Checks for empty cells on the game board.
     * Adds a random cell to the game board when there are still moves to be made.
     * Ends the game and displays the game over scene when no more moves can be made.
     *
     * @param root root
     * @param primaryStage stage
     * @param endGameScene game over scene
     * @param endGameRoot root for the game over scene
     */
    void checkEmptyCells(Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        int haveEmptyCell = haveEmptyCell();
        if (haveEmptyCell == -1) {
            if (canNotMove()) {
                primaryStage.setScene(endGameScene);

                EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
                root.getChildren().clear();
                score = 0;
            }
        } else if (haveEmptyCell == 1) {
            RandomNum.randomFillNumber(root, Game.textMaker);
        }
    }

    /**
     * Checks the cell number to determine if a cell is empty or is numbered 2048.
     *
     * @return indicator
     */
    private int haveEmptyCell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0) {
                    return 1;
                }
                if(cells[i][j].getNumber() == 2048) {
                    return 0;
                }
            }
        }
        return -1;
    }

    /**
     * @param i X coordinate
     * @param j Y coordinate
     * @return a boolean value that indicates whether two cells have the same cell number
     */
    private boolean haveSameNumber(int i, int j) {
        if (i < n - 1 && j < n - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            return cells[i][j + 1].getNumber() == cells[i][j].getNumber();
        }
        return false;
    }

    /**
     * @return a boolean value that indicates whether there are available moves on the game board
     */
    private boolean canNotMove() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (haveSameNumber(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
