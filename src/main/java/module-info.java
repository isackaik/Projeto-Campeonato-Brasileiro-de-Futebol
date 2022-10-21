module com.example.campeonatobrasileiro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.campeonatobrasileiro to javafx.fxml;
    exports com.example.campeonatobrasileiro;
}