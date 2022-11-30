module com {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ingame to javafx.fxml;
    exports com.ingame;
    exports com.endgame;
    opens com.endgame to javafx.fxml;
    exports com.player;
    opens com.player to javafx.fxml;
    exports com.startgame;
    opens com.startgame to javafx.fxml;
    exports com.cell;
    opens com.cell to javafx.fxml;
}