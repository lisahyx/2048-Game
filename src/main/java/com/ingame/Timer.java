package com.ingame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Starts a timer upon starting the game.
 */
public class Timer {
    Timeline timeline;
    int mins = 0;
    int secs = 0;
    int millis = 0;

    /**
     * Changes the text for the timer.
     *
     * @param text text for timer
     */
    void change(Text text) {
        if(millis == 1000) {
            secs++;
            millis = 0;
        }
        if(secs == 60) {
            mins++;
            secs = 0;
        }
        text.setText((((mins/10) == 0) ? "0" : "") + mins + ":"
                + (((secs/10) == 0) ? "0" : "") + secs + ":"
                + (((millis/10) == 0) ? "00" : (((millis/100) == 0) ? "0" : "")) + millis++);
    }

    /**
     * Starts the timer.
     *
     * @param text text of timer
     * @return text for timer
     */
    Text startTimer(Text text) {
        timeline = new Timeline(new KeyFrame(Duration.millis(1), event -> change(text)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.play();
        return text;
    }
}
