module com.mycompany.mathsnap {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.mathsnap to javafx.fxml;
    exports com.mycompany.mathsnap;
}
