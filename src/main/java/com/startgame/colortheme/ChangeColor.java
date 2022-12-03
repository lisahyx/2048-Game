package com.startgame.colortheme;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.util.Objects;

/**
 * Changes background color for all scenes according to user selection.
 *
 * @author  Lisa Ho Yen Xin
 * @version 2022-12-03
 * @since   2022-11-01
 */
public class ChangeColor {
    /**
     * Sets background color of fxml stages according to the value stored in {@link ColorThemeController#myColor}.
     * Sets background color as default color if no color is selected by the user.
     *
     * @param root background
     */
    public static void fxmlColor(Parent root) {
        if(Objects.equals(ColorThemeController.myColor, "blue")) {
            root.setStyle("-fx-background-color: rgb(141, 191, 247)");
        } else if(Objects.equals(ColorThemeController.myColor, "green")) {
            root.setStyle("-fx-background-color: rgb(114, 191, 59)");
        } else if (Objects.equals(ColorThemeController.myColor, "purple")) {
            root.setStyle("-fx-background-color: rgb(195, 182, 242)");
        } else {
            root.setStyle("-fx-background-color: rgb(189, 177, 92)");
        }
    }

    /**
     * Sets background color of javafx scenes according to the value stored in {@link ColorThemeController#myColor}.
     * Sets background color as default color if no color is selected by the user.
     *
     * @param root background
     * @param width width
     * @param height height
     * @return a scene with a background color that is chosen by the user
     */
    public static Scene bgColor(Group root, int width, int height) {
        Scene scene;
        if(Objects.equals(ColorThemeController.getMyColor(), "blue")) {
            scene = new Scene(root, width, height, Color.rgb(141, 191, 247));
        } else if(Objects.equals(ColorThemeController.getMyColor(), "green")) {
            scene = new Scene(root, width, height, Color.rgb(114, 191, 59));
        } else if (Objects.equals(ColorThemeController.getMyColor(), "purple")) {
            scene = new Scene(root, width, height, Color.rgb(195, 182, 242));
        } else {
            scene = new Scene(root, width, height, Color.rgb(189, 177, 92));
        }
        return scene;
    }
}
