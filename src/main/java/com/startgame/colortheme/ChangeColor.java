package com.startgame.colortheme;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

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
