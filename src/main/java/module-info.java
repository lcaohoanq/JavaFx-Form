module com.lcaohoanq.formhandling {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.j;
    requires dotenv.java;

    opens com.lcaohoanq.formhandling to javafx.fxml;
    exports com.lcaohoanq.formhandling;
}