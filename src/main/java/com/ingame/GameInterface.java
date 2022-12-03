package com.ingame;

import com.cell.Cell;

import static com.ingame.GameStatus.getN;

/**
 * @author  Lisa Ho Yen Xin
 * @version 2022-12-03
 * @since   2022-11-01
 */
interface GameInterface {
    int n = getN();
    Cell[][] cells = new Cell[n][n];
}
