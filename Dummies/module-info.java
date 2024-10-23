module Book_6 {
    requires java.sql;
    requires java.desktop;
    requires java.xml;
    requires javafx.controls;
    requires javafx.fxml;


    exports Book_6.Chapter_1;
    opens Book_6.Chapter_1 to javafx.fxml;
    exports Book_6.Chapter_2;
    opens Book_6.Chapter_2 to javafx.fxml;
    exports Book_6.Chapter_3 to javafx.fxml;
    opens Book_6.Chapter_3 to javafx.fxml;
    exports Book_6.Chapter_4 to javafx.fxml;
    opens Book_6.Chapter_4 to javafx.fxml;
    exports Book_6.Chapter_5 to javafx.fxml;
    opens Book_6.Chapter_5 to javafx.fxml;
    exports Book_6.Chapter_6 to javafx.fxml;
    opens Book_6.Chapter_6 to javafx.fxml;
}