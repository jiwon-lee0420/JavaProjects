import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.ArrayList;

public class ToDoList extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        Text title = new Text("To-Do List");
        VBox vbox = new VBox();
        TextField tf = new TextField("Add task here...");
        ComboBox<String> cbo1 = new ComboBox<String>();
        cbo1.getItems().addAll("Study", "Shop", "Cook", "Sleep");
        ComboBox<String> cbo2 = new ComboBox<String>();
        cbo2.getItems().addAll("1", "2", "3", "4", "5");
        Button enq = new Button("Enqueue Task");
        Button deq = new Button("Dequeue Task");
        
        HBox hb = new HBox(tf, cbo1, cbo2, enq, deq);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(20);

        ArrayList<String> todo = new ArrayList<String>();
        tf.setOnAction(e -> {
            todo.add(tf.getText());
            System.out.println(todo.get(todo.size() - 1));
            tf.setText("Add task here...");
            tf.selectAll();
        });
        BorderPane root = new BorderPane();
        root.setTop(title);
        root.setBottom(hb);
        primaryStage.setTitle("To Do List");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}