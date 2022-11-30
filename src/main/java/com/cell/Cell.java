package com.cell;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Formats game board and cell color.
 *
 * @author  Lisa Ho Yen Xin - modified
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class Cell extends ModifyCell{
    /**
     * A constructor that defines a rectangular game board for the cells with specified position, size, and fill.
     * Uses the X and Y coordinates to define the position
     * and the scaling factor to define the height and width of the rectangle.
     * Sets the fill of the rectangle with the default color and adds the rectangle to root.
     *
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param scale the scaling factor
     * @param root the root
     */
    public Cell(double x, double y, double scale, Group root) {
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        this.root = root;
        rectangle.setFill(Color.rgb(255, 255, 255, 0.8));
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        root.getChildren().add(rectangle);
    }

    /**
     * Sets cell color according to cell number.
     *
     * @param number cell number
     */
    public void setColorByNumber(int number) {
        switch (number) {
            case 0:
                rectangle.setFill(Color.rgb(255, 255, 255, 0.8));
                break;
            case 2:
                rectangle.setFill(Color.rgb(255, 197, 197, 0.7));
                break;
            case 4:
                rectangle.setFill(Color.rgb(255, 108, 45, 0.7));
                break;
            case 8:
                rectangle.setFill(Color.rgb(255, 208, 108, 0.7));
                break;
            case 16:
                rectangle.setFill(Color.rgb(255, 204, 0, 0.7));
                break;
            case 32:
                rectangle.setFill(Color.rgb(77, 255, 106, 0.7));
                break;
            case 64:
                rectangle.setFill(Color.rgb(0, 197, 32, 0.7));
                break;
            case 128:
                rectangle.setFill(Color.rgb(37, 236, 212, 0.7));
                break;
            case 256:
                rectangle.setFill(Color.rgb(28, 157, 255, 0.7));
                break;
            case 512:
                rectangle.setFill(Color.rgb(57, 29, 250, 0.7));
                break;
            case 1024:
                rectangle.setFill(Color.rgb(172, 85, 255, 0.7));
                break;
            case 2048:
                rectangle.setFill(Color.rgb(129,0,250,0.7));
                break;
        }
    }
}
