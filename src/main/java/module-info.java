module com {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.ingame to javafx.fxml;
    exports com.ingame;
    exports com.endgame;
    opens com.endgame to javafx.fxml;
    exports com.player;
    opens com.player to javafx.fxml;
    exports com.cell;
    opens com.cell to javafx.fxml;
    exports com.startgame.colortheme;
    opens com.startgame.colortheme to javafx.fxml;
    exports com.startgame.gamemode;
    opens com.startgame.gamemode to javafx.fxml;
    exports com.main;
    opens com.main to javafx.fxml;
    exports com.startgame.mainmenu;
    opens com.startgame.mainmenu to javafx.fxml;
}