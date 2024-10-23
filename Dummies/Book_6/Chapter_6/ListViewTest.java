package Book_6.Chapter_6;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    ListView list;

    @Override
    public void start(Stage primaryStage) {
        Label lbl = new Label("Pizza Toppings");
        list = new ListView();
        list.getItems().addAll("Sausage", "Pepperoni", "Linguica", "Salame", "Olives", "Mushrooms",
                "Onions", "Peppers", "Pineapple", "Spinach", "Canadian Bacon", "Tomatoes", "Kiwi", "Anchovies", "Gummy Bears");

        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        list.setOnMouseClicked(e -> displayToppings());

        VBox vbox = new VBox(10, lbl, list);
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void displayToppings() {
        String tops = "";
        ObservableList<String> toppings;
        toppings = list.getSelectionModel().getSelectedItems();

        for (String topping: toppings)
        {
            tops += topping + "\n";
        }

        System.out.println("These are the toppings you chose: " + tops);
    }
}
