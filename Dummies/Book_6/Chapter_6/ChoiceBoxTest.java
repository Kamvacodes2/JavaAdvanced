package Book_6.Chapter_6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private ChoiceBox<String> dwarves, biomes;
    private ChoiceBox<Astronaut> apollo13;
    Label lbl;

    @Override
    public void start(Stage primaryStage) {
        lbl = new Label("");

        dwarves = new ChoiceBox<>();
        // The getItems() returns an object of type Observable Interface.
        dwarves.getItems().addAll("Bashful", "Doc", "Dopey", "Grumpy", "Happy", "Sleepy", "Sneezy");
//        dwarves.setOnAction(e -> cbDwarves3_OnChange());
        dwarves.setValue("Sleepy");
        lbl.setText(dwarves.getValue());

        dwarves.getSelectionModel().selectedItemProperty().addListener(
                (v, oldValue, newValue) -> lbl.setText("Today is " + newValue + "'s turn to clean")
        );

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(dwarves, lbl);

        Astronaut lovell = new Astronaut("Jim", "Lovell");
        Astronaut swigert = new Astronaut("John", "Swigert");
        Astronaut haise = new Astronaut("Fred", "Haise");

        apollo13 = new ChoiceBox<>();
        apollo13.getItems().addAll(lovell, swigert, haise);
        apollo13.setValue(lovell);
        apollo13.setOnAction(e -> cbApollo13_OnChange());

        VBox vbox2 = new VBox(10);

        vbox2.getChildren().addAll(apollo13);

        VBox vbox3 = new VBox(10);

        biomes = new ChoiceBox<>();
        // The getItems() returns an object of type Observable Interface.
        biomes.getItems().addAll("Jungle", "Taiga", "Savanna", "Forest", "Desert", "Mesa", "Rainforest", "Tundra");
        vbox3.getChildren().addAll(biomes);
        biomes.setValue("Rainforest");
        biomes.setOnAction(e -> cbBiomes_OnChange());

        HBox hbox = new HBox(10, vbox, vbox2, vbox3);

        Scene scene = new Scene(hbox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void cbApollo13_OnChange() {
        String message = "You chose ";
        message += apollo13.getValue();
        Alert a = new Alert(Alert.AlertType.INFORMATION, message);
        a.setTitle("Your Favourite Astronaut");
        a.showAndWait();
    }

    public void cbDwarves3_OnChange() {
        String message = "You chose ";
        message += dwarves.getValue();
        Alert a = new Alert(Alert.AlertType.INFORMATION, message);
        a.setTitle("Your Favourite Dwarf");
        a.showAndWait();
    }

    public void cbBiomes_OnChange() {
        String message = "You chose ";
        message += biomes.getValue();
        Alert a = new Alert(Alert.AlertType.INFORMATION, message);
        a.setTitle("Your Favourite Biome");
        a.showAndWait();
    }
}

class Astronaut {
    private String firstName;
    private String lastName;

    public Astronaut(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString()
    {
        return firstName + " " + lastName;
    }

}
