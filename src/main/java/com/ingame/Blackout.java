package com.ingame;

import com.cell.TextMaker;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Random;

/**
 * Formats cells for blackout game mode.
 *
 * @author  Lisa Ho Yen Xin - modified
 * @version 2022-12-03
 * @since   2022-11-01
 */
public class Blackout {
    Group root;
    Text textClass;

    /**
     * A constructor that defines a rectangular game board for the cells with specified position, size, and fill.
     * Uses the X and Y coordinates to define the position
     * and the scaling factor to define the height and width of the rectangle.
     * Randomly sets the fill of the rectangles to black.
     *
     * @param x     the X coordinate
     * @param y     the Y coordinate
     * @param scale the scaling factor
     * @param root  the root
     */
    public Blackout(double x, double y, double scale, Group root) {
        Rectangle rectangle = null;
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        this.root = root;

        Random rand = new Random();
        int n = rand.nextInt(2);
        if(n == 1) {
            rectangle.setFill(Color.BLACK);
        } else {
            rectangle.setFill(Color.WHITE);
        }

        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        root.getChildren().add(rectangle);
    }
}
