package com.main;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;

/**
 * Plays music when the application opens.
 *
 * @author  Lisa Ho Yen Xin
 * @version 2022-12-03
 * @since   2022-11-01
 */
public class GameMusic {
    private static MediaPlayer music;

    /**
     * Plays music on infinite loop.
     */
    public static void playMusic() {
        URL resource = GameMusic.class.getResource("/com/media/music.mp3");
        assert resource != null;
        music = new MediaPlayer(new Media(resource.toString()));
        music.setOnEndOfMedia(() -> music.seek(Duration.ZERO));
        music.play();
    }
}
