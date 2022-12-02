package com.main;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;

public class GameMusic {
    private static MediaPlayer music;
    private static MediaPlayer bg;

    public static void playMusic() {
        URL resource = GameMusic.class.getResource("/com/media/music.mp3");
        assert resource != null;
        music = new MediaPlayer(new Media(resource.toString()));
        music.setOnEndOfMedia(new Runnable() {
            public void run() {
                music.seek(Duration.ZERO);
            }
        });
        music.play();
    }
}
