module com {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.Game to javafx.fxml;
    exports com.Game;
    exports com.EndGame;
    opens com.EndGame to javafx.fxml;
    exports com.User;
    opens com.User to javafx.fxml;
    exports com.StartGame;
    opens com.StartGame to javafx.fxml;
}