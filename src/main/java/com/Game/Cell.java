package com.Game;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Format cells.
 *
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class Cell {
    private final Rectangle rectangle;
    private final Group root;
    private Text textClass;
    private boolean modify = false;

    /**
     * Sets a boolean variable to indicate if a cell is modified.
     *
     * @param modify the boolean variable
     */
    void setModify(boolean modify) {
        this.modify = modify;
    }

    /**
     * Returns a boolean value that indicates if a cell is modified.
     *
     * @return the boolean value
     */
    boolean getModify() {
        return modify;
    }

    /**
     * @return X coordinate of game board
     */
    double getX() {
        return rectangle.getX();
    }

    /**
     * @return Y coordinate of game board
     */
    double getY() {
        return rectangle.getY();
    }

    /**
     * @return text that indicates a cell number
     */
    int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    /**
     * Sets a text to a cell to be its cell number.
     *
     * @param textClass the text
     */
    void setTextClass(Text textClass) {
        this.textClass = textClass;
    }

    /**
     * @return cell number
     */
    private Text getTextClass() {
        return textClass;
    }

    /**
     * Defines a rectangle, which is the board for the cells, with specified position, size, and fill.
     * Uses the X and Y coordinates of the upper-left corner of the rectangle to define the position
     * of the rectangle.
     * Uses the scaling factor to define the height and width of the rectangle.
     * Sets the fill of the rectangle with the default color.
     * Adds the rectangle to a container component.
     *
     * @param x X coordinate
     * @param y Y coordinate
     * @param scale scaling factor
     * @param root the container component
     */
    Cell(double x, double y, double scale, Group root) {
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
     * Swaps the cell numbers and positions of a new cell and an old cell by calling
     * {@link TextMaker#changeTwoText(Text, Text)}.
     * <p>
     * Adds the new cell to the game board if the new cell is non-empty.
     * Sets new color for the new cell according to the new cell number.
     *
     * @param cell the new cell
     */
    void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.getTextClass());
        root.getChildren().remove(cell.getTextClass());
        root.getChildren().remove(textClass);

        if (!cell.getTextClass().getText().equals("0")) {
            root.getChildren().add(cell.getTextClass());
        }
        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }

    /**
     * Adds two cell numbers to get its total.
     * Sets cell color for the new totaled up cell.
     *
     * @param cell the new cell to be added
     */
    void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
    }

    /**
     * Sets cell color according to cell number.
     *
     * @param number cell number
     */
    void setColorByNumber(int number) {
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
