module com.example.comp2042_cw_hfylh2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.comp2042_cw_hfylh2 to javafx.fxml;
    exports com.example.comp2042_cw_hfylh2;
}