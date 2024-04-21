module org.example.hakmana {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens org.example.hakmana to javafx.fxml;
    exports org.example.hakmana;
    exports org.example.hakmana.model;
    opens org.example.hakmana.model to javafx.fxml;


}