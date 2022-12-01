package com.cell;

import com.ingame.GameStatus;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Formats the font, position, and color for the text for cell numbers.
 *
 * @author  Lisa Ho Yen Xin - modified
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class TextMaker {
    private static TextMaker singleInstance = null;

    private TextMaker() {

    }

    /**
     * Returns an active instance of the class if it exists.
     * Otherwise, creates a new instance of the {@link TextMaker} class.
     *
     * @return instance of class
     */
    public static TextMaker getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new TextMaker();
        return singleInstance;
    }

    /**
     * Formats the font, position, and color for the text for cell numbers.
     *
     * @param input the cell number
     * @param xCell the X coordinate
     * @param yCell the Y coordinate
     * @param root the root
     * @return text for cell number
     */
    public Text madeText(String input, double xCell, double yCell, Group root) {
        double length = GameStatus.getLENGTH();
        double fontSize = (3 * length) / 7.0;
        Text text = new Text(input);
        text.setFont(Font.font(fontSize));
        text.relocate((xCell + (1.2)* length / 7.0), (yCell + 2 * length / 7.0));
        text.setFill(Color.WHITE);
        return text;
    }

    /**
     * Swaps the cell numbers and positions of two cells.
     *
     * @param first the first cell
     * @param second the second cell
     */
    static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        double tempNumber;
        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);
    }

}
