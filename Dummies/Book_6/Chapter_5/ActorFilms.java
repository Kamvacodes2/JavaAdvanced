package Book_6.Chapter_5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ActorFilms extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    TextField txtNoFilms;
    TextField txtActor;

    @Override
    public void start(Stage primaryStage) {

        // Create the Character
        Label lblNoFilms = new Label("Number of Films:");
        lblNoFilms.setMinWidth(100);
        lblNoFilms.setAlignment(Pos.BOTTOM_RIGHT);

        // Create the Character text field
        txtNoFilms = new TextField();
        txtNoFilms.setMinWidth(200);
        txtNoFilms.setMaxWidth(200);
        txtNoFilms.setPromptText("Enter the number of films.");

        // Create the Actor label
        Label lblActor = new Label("Actor's Name:");
        lblActor.setMinWidth(100);
        lblActor.setAlignment(Pos.BOTTOM_RIGHT);

        // Create the Actor text field
        txtActor = new TextField();
        txtActor.setMinWidth(200);
        txtActor.setMaxWidth(200);
        txtActor.setPromptText("Enter the name of the actor here.");

        // Create the OK button
        Button btnOK = new Button("OK");
        btnOK.setMinWidth(75);
        btnOK.setOnAction(e -> btnOK_Click());

        // Create the Character pane
        HBox paneCharacter = new HBox(20, lblNoFilms, txtNoFilms);
        paneCharacter.setPadding(new Insets(10));

        // Create the Actor pane
        HBox paneActor = new HBox(20, lblActor, txtActor);
        paneActor.setPadding(new Insets(10));

        // Create the Button pane
        HBox paneButton = new HBox(20, btnOK);
        paneButton.setPadding(new Insets(10));
        paneButton.setAlignment(Pos.BOTTOM_RIGHT);

        // Add the Character, Actor, and Button panes to a VBox
        VBox pane = new VBox(10, paneCharacter, paneActor, paneButton);

        // Set the stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Role Player");
        primaryStage.show();
    }

    public void btnOK_Click() {
        String errorMessage = "";

        if (txtNoFilms.getText().isEmpty()) {
            errorMessage += "\nCharacter is a required field.";
        }
        if (txtActor.getText().isEmpty()) {
            errorMessage += "\nActor is a required field.";
        }

        if (!errorMessage.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, errorMessage);
            a.setTitle("Missing Data");
            a.showAndWait();
        } else if (isInt(txtNoFilms, "You must enter an integer.")) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, txtActor.getText() +" acted in " + Integer.parseInt(txtNoFilms.getText()) + " many films.");
            a.showAndWait();
            txtNoFilms.requestFocus();
        }

    }

    private boolean isInt(TextField f, String msg) {
        try {
            Integer.parseInt(f.getText());
            return true;
        } catch (NumberFormatException e) {
            Alert a = new Alert(Alert.AlertType.WARNING, msg);
            a.setTitle("Invalid data!");
            a.showAndWait();
            return false;
        }
    }
}
