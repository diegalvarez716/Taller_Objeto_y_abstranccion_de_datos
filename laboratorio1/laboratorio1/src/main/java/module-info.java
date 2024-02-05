module com.example.laboratorio1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laboratorio1 to javafx.fxml;
    exports com.example.laboratorio1;
}