package Book_6.Chapter_6;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    TreeView tree;

    @Override
    public void start(Stage primaryStage) {
        TreeItem andy,archie,happy,maude, george;
        TreeItem root = new TreeItem("The Spin Offs");


        root.setExpanded(true);

        andy = makeShow("The Andy Griffith Show", root);
        makeShow("Gomer Pyle, U.S.M.C.", andy);
        makeShow("Mayberry R.F.D.", andy);

        archie = makeShow("All in the Family", root);
        george = makeShow("The Jeffersons", archie);
        makeShow("Checking In", george);

        maude = makeShow("Maude", archie);
        makeShow("Good Times", maude);
        makeShow("Gloria", archie);
        makeShow("Archie Bunker's Place", archie);

        happy = makeShow("Happy Days", root);
        makeShow("Mork and Mindy", happy);
        makeShow("Laverne and Shirley", happy);
        makeShow("Joanie Loves Chachi", happy);

        tree = new TreeView(root);

        tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//
////         Alternative
//         tree.getSelectionModel().selectedItemProperty()
//              .addListener( (v, oldValue, newValue) -> tree_SelectionChanged(newValue) )

//        tree.setOnMouseClicked(e -> treeDisplay());

        VBox vbox = new VBox(10, tree);
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public TreeItem<String> makeShow(String title, TreeItem<String> parent)
    {
        TreeItem<String> show = new TreeItem<String>(title);
        show.setExpanded(true);
        parent.getChildren().add(show);
        return show;
    }

    public void treeDisplay() {
        String message = "";
        ObservableList<TreeItem<String>> shows = tree.getSelectionModel().getSelectedItems();
        for (TreeItem show: shows) {
            message += show.getValue() + "\n";
        }

        System.out.println("You selected these shows:\n" + message);
    }

}
