package Book_6.Chapter_6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private ComboBox dwarves;

    @Override
    public void start(Stage primaryStage) {

        dwarves = new ComboBox();
        dwarves.getItems().addAll("Bashful", "Doc", "Dopey", "Grumpy", "Happy", "Sleepy", "Sneezy");

        dwarves.setEditable(true);
        dwarves.setVisibleRowCount(10);
        dwarves.setPromptText("Hello Test");
        dwarves.setOnAction(e -> Choice_Click());

        VBox vbox = new VBox(10, dwarves);

        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void Choice_Click() {

        if (dwarves.getValue() != null) {
            if (!dwarves.getItems().contains(dwarves.getValue()) && !dwarves.getValue().toString().trim().equals("")) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "You chose outside the box");
                a.setTitle("Good Thinking!");
                a.showAndWait();
            } else if (!dwarves.getValue().toString().trim().equals("")) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "You chose inside the box");
                a.setTitle("Your Choice:");
                a.showAndWait();
            }
        }

    }

}

