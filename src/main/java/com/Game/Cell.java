package com.Game;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Cell {
    private Rectangle rectangle;
    private Group root;
    private Text textClass;
    private boolean modify = false;

    void setModify(boolean modify) {
        this.modify = modify;
    }

    boolean getModify() {
        return modify;
    }

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

    void setTextClass(Text textClass) {
        this.textClass = textClass;
    }

    void changeCell(Cell cell) {
        TextMaker.changeTwoText(textClass, cell.getTextClass());
        root.getChildren().remove(cell.getTextClass());
        root.getChildren().remove(textClass);

        if (!cell.getTextClass().getText().equals("0")) {
            root.getChildren().add(cell.getTextClass());
        }
        if (!textClass.getText().equals("0")) {
            root.getChildren().add(textClass);
        }
        setColorByNumber(getNumber());
        cell.setColorByNumber(cell.getNumber());
    }

    void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColorByNumber(cell.getNumber());
        setColorByNumber(getNumber());
    }

    void setColorByNumber(int number) {
        switch (number) {
            case 0:
                rectangle.setFill(Color.rgb(255, 244, 244, 0.5));
                break;
            case 2:
                rectangle.setFill(Color.rgb(255, 197, 197, 0.5));
                break;
            case 4:
                rectangle.setFill(Color.rgb(255, 108, 45, 0.5));
                break;
            case 8:
                rectangle.setFill(Color.rgb(255, 208, 108, 0.5));
                break;
            case 16:
                rectangle.setFill(Color.rgb(255, 204, 0, 0.5));
                break;
            case 32:
                rectangle.setFill(Color.rgb(77, 255, 106, 0.5));
                break;
            case 64:
                rectangle.setFill(Color.rgb(0, 197, 32, 0.5));
                break;
            case 128:
                rectangle.setFill(Color.rgb(37, 236, 212, 0.5));
                break;
            case 256:
                rectangle.setFill(Color.rgb(28, 157, 255, 0.5));
                break;
            case 512:
                rectangle.setFill(Color.rgb(57, 29, 250, 0.5));
                break;
            case 1024:
                rectangle.setFill(Color.rgb(172, 85, 255, 0.5));
                break;
            case 2048:
                rectangle.setFill(Color.rgb(129,0,250,0.5));
                break;
        }

    }

    double getX() {
        return rectangle.getX();
    }

    double getY() {
        return rectangle.getY();
    }

    int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    private Text getTextClass() {
        return textClass;
    }

}
