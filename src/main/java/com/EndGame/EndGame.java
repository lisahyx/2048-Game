package com.EndGame;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * A class for game over screen.
 */
public class EndGame {
    private static EndGame singleInstance = null;
    private EndGame(){

    }
    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage,long score){
        Text text = new Text("GAME OVER");
        text.setFont(Font.font(80));
        root.getChildren().add(text);

        Text scoreText = new Text(score+"");
        scoreText.setFill(Color.BLACK);
        scoreText.setFont(Font.font(80));
        root.getChildren().add(scoreText);

        // quit button
        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(85,35);
        quitButton.setTextFill(Color.BLACK);
        root.getChildren().add(quitButton);

        // main menu button
        Button mainMenuButton = new Button("BACK TO MAIN MENU");
        mainMenuButton.setPrefSize(150,35);
        mainMenuButton.setTextFill(Color.BLACK);
        root.getChildren().add(mainMenuButton);

        // retry button
        Button retryButton = new Button("RETRY");
        retryButton.setPrefSize(85,35);
        retryButton.setTextFill(Color.BLACK);
        root.getChildren().add(retryButton);

        StackPane mainPane;

        Stage window = primaryStage;

        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos. CENTER);
        vBox.setMargin(text, new Insets(-80, 0, 0, 0));
        vBox.setMargin(scoreText, new Insets(0, 0, 120, 0));
        vBox.prefWidthProperty().bind(window.widthProperty().multiply(0.90));
        vBox.prefHeightProperty().bind(window.heightProperty());

        HBox hBox = new HBox();
        hBox.getChildren().addAll(mainMenuButton, retryButton, quitButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(80);

        vBox.getChildren().addAll(text, scoreText, hBox);



        mainPane = new StackPane(vBox);
        mainPane.setPadding(new Insets(30));
        root.getChildren().add(mainPane);

        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    root.getChildren().clear();
                    primaryStage.close();
                }
            }
        });



    }
}
