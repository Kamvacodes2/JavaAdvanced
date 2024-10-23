package Book_6.Chapter_5;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PizzaOrder extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage stage;
    TextField txtName, txtPhone, txtAddress;
    RadioButton rdoSmall, rdoMedium, rdoLarge, rdoThin, rdoThick;
    CheckBox chkPepperoni,chkSausage, chkLinguica, chkOlives,chkTomatoes ,chkAnchovies, chkMushrooms;

    ToggleGroup groupSize, groupCrust;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        String cssLayout = "-fx-border-color: red;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-border-style: dashed;\n";

        // Create the top pane -----
        Text textHeading = new Text("Order Your Pizza Now!");
        textHeading.setFont(new Font(20));
        HBox paneTop = new HBox(textHeading);
        paneTop.setPadding(new Insets(20, 10, 20, 10));

        // Create the customer pane ----
        // Create the name label and text field
        Label lblName = new Label("Name:");
        lblName.setPrefWidth(100);
        txtName = new TextField();
        txtName.setPrefColumnCount(20);
        txtName.setPromptText("Enter the customer's name here");
        txtName.setMaxWidth(Double.MAX_VALUE);
        HBox paneName = new HBox(lblName, txtName);

        // Create the phone number label and text field
        Label lblPhone = new Label("Phone Number:");
        lblPhone.setPrefWidth(100);
        txtPhone = new TextField();
        txtPhone.setPrefColumnCount(20);
        txtPhone.setPromptText("Enter the customer's phone number here:");
        HBox panePhone = new HBox(lblPhone, txtPhone);

        // Create the address label and text field
        Label lblAddress = new Label("Address:");
        lblAddress.setPrefWidth(100);
        txtAddress = new TextField();
        txtAddress.setPrefColumnCount(20);
        txtAddress.setPromptText("Enter the customer's address here:");
        HBox paneAddress = new HBox(lblAddress, txtAddress);

        // Create the customer pane
        VBox paneCustomer = new VBox(10, paneName, panePhone, paneAddress);

        // ------ Create the order pane --------

        // Create the size pane
        Label lblSize = new Label("Size");
        rdoSmall = new RadioButton("Small");
        rdoMedium = new RadioButton("Medium");
        rdoLarge = new RadioButton("Large");
        rdoMedium.setSelected(true);
        groupSize = new ToggleGroup();
        rdoSmall.setToggleGroup(groupSize);
        rdoMedium.setToggleGroup(groupSize);
        rdoLarge.setToggleGroup(groupSize);

        VBox paneSize = new VBox(lblSize, rdoSmall, rdoMedium, rdoLarge);
        paneSize.setSpacing(10);

        // Create the crust pane
        Label lblCrust = new Label("Crust");
        rdoThin = new RadioButton("Thin");
        rdoThick = new RadioButton("Thick");
        rdoThin.setSelected(true);

        groupCrust = new ToggleGroup();
        rdoThin.setToggleGroup(groupCrust);
        rdoThick.setToggleGroup(groupCrust);

        VBox paneCrust = new VBox(lblCrust, rdoThin, rdoThick);
        paneCrust.setSpacing(10);

        // Create the toppings pane
        Label lblToppings = new Label("Toppings");
        chkPepperoni = new CheckBox("Pepperoni");
        chkMushrooms = new CheckBox("Mushrooms");
        chkAnchovies = new CheckBox("Anchovies");

        chkSausage = new CheckBox("Sausage");
        chkLinguica = new CheckBox("Linguica");
        chkOlives = new CheckBox("Olives");
        chkTomatoes = new CheckBox("Tomatoes");

        FlowPane paneToppings = new FlowPane(Orientation.VERTICAL, chkPepperoni, chkSausage, chkLinguica, chkOlives, chkMushrooms, chkTomatoes, chkAnchovies);
        paneToppings.setPadding(new Insets(10, 0, 10, 0));
        paneToppings.setHgap(20);
        paneToppings.setVgap(10);
        paneToppings.setPrefWrapLength(100);

        VBox paneTopping = new VBox(lblToppings, paneToppings);

        // Add the size, crust, and toppings pane to the order pane
        HBox paneOrder = new HBox(50, paneSize, paneCrust, paneTopping);

        // Create the center pane
        VBox paneCenter = new VBox(20, paneCustomer, paneOrder);
        paneCenter.setPadding(new Insets(0, 10, 0, 10));

        // ---- Create the bottom pane
        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(80);
        btnOK.setOnAction(e -> btnOK_Click());

        Button btnCancel = new Button("Cancel");
        btnCancel.setPrefWidth(80);
        btnCancel.setOnAction(e -> btnCancel_Click());

        Region spacer = new Region();

        HBox paneBottom = new HBox(10, spacer, btnOK, btnCancel);
        HBox.setHgrow(spacer, Priority.ALWAYS);
        paneBottom.setPadding(new Insets(20, 10, 20, 10));

        chkAnchovies.setOnAction(e -> chkAnchovies_Click());

        // Finish the scene
        BorderPane mainPane = new BorderPane();
        mainPane.setTop(paneTop);
        mainPane.setCenter(paneCenter);
        mainPane.setBottom(paneBottom);

        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza Order");
        primaryStage.show();
    }

    public void btnOK_Click()
    {
        // Create a message string with the customer information
        String msg = "Customer:\n\n";
        msg += "\t" + txtName.getText() + " \n";
        msg += "\t" + txtPhone.getText() + "\n\n";
        msg += "\t" + txtAddress.getText() + "\n\n";
        msg += "You have ordered a ";

        // Add the pizza size
        if (rdoSmall.isSelected()) {
            msg += "small ";
        } else if (rdoSmall.isSelected()) {
            msg += "medium ";
        } else if (rdoSmall.isSelected()) {
            msg += "large ";
        }

        // Add the crust style
        if (rdoThin.isSelected()) {
            msg += "thin crust pizza with ";
        } else if (rdoThick.isSelected()) {
            msg += "thick crust pizza with";
        }

        // Add the toppings
        String toppings = "";
        toppings = buildToppings(chkPepperoni, toppings);
        toppings = buildToppings(chkSausage, toppings);
        toppings = buildToppings(chkLinguica, toppings);
        toppings = buildToppings(chkOlives, toppings);
        toppings = buildToppings(chkTomatoes, toppings);
        toppings = buildToppings(chkMushrooms, toppings);
        toppings = buildToppings(chkAnchovies, toppings);

        if (toppings.equals(""))
            msg += "no toppings";
        else
            msg += " the following toppings:\n" + toppings;

        // Display the message
        Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
        a.setTitle("Order Details");
        a.showAndWait();

        rdoMedium.setSelected(true);
        rdoThin.setSelected(true);

        chkPepperoni.setSelected(false);
        chkSausage.setSelected(false);
        chkLinguica.setSelected(false);
        chkOlives.setSelected(false);
        chkTomatoes.setSelected(false);
        chkMushrooms.setSelected(false);
        chkAnchovies.setSelected(false);

        txtAddress.clear();
        txtPhone.clear();
        txtName.clear();
    }

    public String buildToppings(CheckBox chk, String msg) {
        // Helper method for displaying the list of toppings
        if (chk.isSelected()) {
            if (!msg.equals("")) {
                msg += ", ";
            }
            msg += chk.getText();
        }
        return msg;
    }

    public void btnCancel_Click() {
        stage.close();
    }

    public void chkAnchovies_Click() {
        Alert a = new Alert(Alert.AlertType.WARNING, "We don't do anchovies here.");
        a.setTitle("Yuck!");
        a.showAndWait();
        chkAnchovies.setSelected(false);
    }

}
