package com.startgame.colortheme;

import javafx.scene.Parent;

import java.util.Objects;

/**
 * @author  Lisa Ho Yen Xin
 * @version %I%, %G%
 * @since   2020-11-1
 */
public class ChangeColor {
    /**
     * Sets background color of fxml stages according to the value stored in {@link ColorThemeController#myColor}.
     * Sets background color as default color if no color is selected by the user.
     *
     * @param root the background
     */
    public static void fxmlColor(Parent root) {
        if(Objects.equals(ColorThemeController.myColor, "black")) {
            root.setStyle("-fx-background-color: black");
        } else if(Objects.equals(ColorThemeController.myColor, "white")) {
            root.setStyle("-fx-background-color: white");
        } else if (Objects.equals(ColorThemeController.myColor, "green")) {
            root.setStyle("-fx-background-color: green");
        } else {
            root.setStyle("-fx-background-color: rgb(189, 177, 92)");
        }
    }
}
