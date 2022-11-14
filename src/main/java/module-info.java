module com.example.comp2042_cw_hfylh2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.Game to javafx.fxml;
    exports com.Game;
    exports com.EndGame;
    opens com.EndGame to javafx.fxml;
    exports com.User;
    opens com.User to javafx.fxml;
}