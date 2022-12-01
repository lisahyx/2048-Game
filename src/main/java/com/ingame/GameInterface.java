package com.ingame;

import com.cell.Cell;

import static com.ingame.GameStatus.getN;

/**
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
interface GameInterface {
    int n = getN();
    Cell[][] cells = new Cell[n][n];
}
