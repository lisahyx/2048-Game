package com.endgame;

import com.player.Score;
import com.startgame.colortheme.ChangeColor;
import com.startgame.gamemode.GameScene;
import com.startgame.gamemode.ButtonInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * Loads game over screen.
 *
 * @author  Lisa Ho Yen Xin - modified
 * @version 2022-12-03
 * @since   2022-11-01
 */
public class EndGame implements ButtonInterface {
    private static EndGame singleInstance = null;
    private EndGame(){

    }

    /**
     * Returns an active instance of the class if it exists.
     * Otherwise, creates a new instance of the {@link EndGame} class.
     *
     * @return instance of class
     */
    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    Score userScore = new Score();

    /**
     * Formats and displays elements for the game over scene.
     *
     * @param endGameScene scene
     * @param root root
     * @param primaryStage stage
     * @param score user's score
     */
    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage, long score){
        Text text = new Text("GAME OVER");
        text.setFont(Font.font(80));
        root.getChildren().add(text);

        // user's score
        Text scoreText = new Text(score+"");
        scoreText.setFill(Color.BLACK);
        scoreText.setFont(Font.font(80));
        root.getChildren().add(scoreText);

        // retry button
        Button retryButton = new Button("RETRY");
        retryButton.setPrefSize(88,39);
        retryButton.setTextFill(Color.BLACK);
        root.getChildren().add(retryButton);

        // high score button
        Button highScoreButton = new Button("HIGH SCORE");
        highScoreButton.setPrefSize(120,39);
        highScoreButton.setTextFill(Color.BLACK);
        root.getChildren().add(highScoreButton);

        // quit button
        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(88,39);
        quitButton.setTextFill(Color.BLACK);
        root.getChildren().add(quitButton);

        // organize all the elements
        StackPane mainPane;

        VBox vBox = new VBox(5);
        VBox.setMargin(text, new Insets(-80, 0, 0, 0));
        VBox.setMargin(scoreText, new Insets(0, 0, 100, 0));
        VBox.setMargin(highScoreButton, new Insets(20, 0, 0, 0));
        vBox.setAlignment(Pos. CENTER);
        vBox.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.90));
        vBox.prefHeightProperty().bind(primaryStage.heightProperty());

        HBox hBox = new HBox();
        hBox.getChildren().addAll(retryButton, highScoreButton, quitButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(45);

        vBox.getChildren().addAll(text, scoreText, hBox);

        mainPane = new StackPane(vBox);
        mainPane.setPadding(new Insets(30));
        root.getChildren().add(mainPane);

        //retry button listener
        retryButton.setOnAction(actionEvent -> {
            GameScene game = new GameScene();
            try {
                if(score > Score.getOldScore()) {
                    Score.setOldScore(score);
                }
                primaryStage.close();
                game.gameStart();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // quit button listener
        quitButton.setOnAction(actionEvent -> quitButtonListener(actionEvent, primaryStage, root, score));

        // save score to file when close window
        primaryStage.setOnCloseRequest(event -> {
            try {
                userScore.compareScore(score);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // high score button listener
        highScoreButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Parent root;
                try {
                    userScore.compareScore(score);
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/game/high_score_list.fxml")));
                    ChangeColor.fxmlColor(root);
                    primaryStage.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage primaryStage = new Stage();
                Scene highScore = new Scene(root);
                primaryStage.setScene(highScore);
                primaryStage.getIcons().add(new Image("https://logodix.com/logo/1649438.jpg"));
                primaryStage.setTitle("2048 Game");
                primaryStage.centerOnScreen();
                primaryStage.show();
            }
        });
    }

    /**
     * Saves user's score when quit button is selected.
     *
     * @param event action event
     * @param primaryStage stage
     * @param root root
     * @param score user score
     */
    @Override
    public void quitButtonListener(ActionEvent event, Stage primaryStage, Group root, long score) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit Dialog");
        alert.setHeaderText("Quit from this page");
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(null) == ButtonType.OK){
            try {
                userScore.compareScore(score);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            root.getChildren().clear();
            primaryStage.close();
        }
    }
}
