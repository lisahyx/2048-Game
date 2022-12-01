package com.ingame;

/**
 * Changes the position of cells based on direction on the game board.
 *
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class PassDestination implements GameInterface {
    static int coordinate;

    static int passLeft(int i, int j) {
        coordinate = j;
        for (int k = j - 1; k >= 0; k--) {
            if (cells[i][k].getNumber() != 0) {
                coordinate = k + 1;
                break;
            } else if (k == 0) {
                coordinate = 0;
            }
        }
        return coordinate;
    }

    static int passRight(int i, int j){
        coordinate = j;
        for (int k = j + 1; k <= n - 1; k++) {
            if (cells[i][k].getNumber() != 0) {
                coordinate = k - 1;
                break;
            } else if (k == n - 1) {
                coordinate = n - 1;
            }
        }
        return coordinate;
    }

    static int passDown(int i, int j) {
        coordinate = i;
        for (int k = i + 1; k <= n - 1; k++) {
            if (cells[k][j].getNumber() != 0) {
                coordinate = k - 1;
                break;

            } else if (k == n - 1) {
                coordinate = n - 1;
            }
        }
        return coordinate;
    }

    static int passUp(int i, int j){
        coordinate = i;
        for (int k = i - 1; k >= 0; k--) {
            if (cells[k][j].getNumber() != 0) {
                coordinate = k + 1;
                break;
            } else if (k == 0) {
                coordinate = 0;
            }
        }
        return coordinate;
    }
}
