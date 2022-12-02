import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ToDoList extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        VBox vbox = new VBox();
        TextField tf = new TextField("Add task here...");
        vbox.getChildren().add(tf);

        StackPane root = new StackPane();
        root.getChildren().add(tf);
        primaryStage.setTitle("To Do List");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }
}