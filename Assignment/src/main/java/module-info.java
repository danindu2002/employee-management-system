module com.example.assignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;


    opens com.example.assignment to javafx.fxml;
    exports com.example.assignment;
}