package com.cell;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Handles cell modifications.
 *
 * @author  Lisa Ho Yen Xin
 * @version 2022-12-03
 * @since   2022-11-01
 */
public abstract class ModifyCell implements CellInterface{
    Rectangle rectangle = null;
    Group root = null;
    Text textClass;
    private boolean modify = false;

    /**
     * Sets a boolean variable to indicate if a cell is modified.
     *
     * @param modify the boolean variable
     */
    public void setModify(boolean modify) {
        this.modify = modify;
    }

    /**
     * Returns a boolean value that indicates if a cell is modified.
     *
     * @return the boolean value
     */
    public boolean getModify() {
        return !modify;
    }

    /**
     * @return X coordinate of game board
     */
    public double getX() {
        return rectangle.getX();
    }

    /**
     * @return Y coordinate of game board
     */
    public double getY() {
        return rectangle.getY();
    }

    /**
     * @return text that indicates a cell number
     */
    public int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    /**
     * Sets a text to a cell to be its cell number.
     *
     * @param textClass the text
     */
    public void setTextClass(Text textClass) {
        this.textClass = textClass;
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
    public void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.textClass);
        root.getChildren().remove(cell.textClass);
        root.getChildren().remove(textClass);

        if (!cell.textClass.getText().equals("0")) {
            root.getChildren().add(cell.textClass);
        }
        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }

    /**
     * Adds two cell numbers to get its total and sets the cell color for the new totaled up cell.
     *
     * @param cell the new cell to be added
     */
    public void adder(Cell cell) {
        cell.textClass.setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
    }
}
