module javafx.campeonato {
    requires javafx.controls;
    requires javafx.fxml;


    opens javafx.campeonato to javafx.fxml;
    exports javafx.campeonato;
}