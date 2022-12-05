import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.util.ArrayList;

public class ToDoList extends Application {
    private final Alert alert1 = new Alert(AlertType.ERROR, "Please enter a task.");
    private final Alert alert2 = new Alert(AlertType.ERROR, "Please select a task type.");
    private final Alert alert3 = new Alert(AlertType.ERROR, "Please select number of hours.");
    private final Alert alert4 = new Alert(AlertType.ERROR, "Exact task already exists.");
    private final Alert alert5 = new Alert(AlertType.ERROR, "Task name already exists.");
    @Override
    public void start(Stage primaryStage) {
        int numTasksCompleted = 0;
        int numTasksRemaining = 0;
        //ObservableList for ListView object...
        ObservableList<String> tasks = FXCollections.observableArrayList();
        //Title
        Text title = new Text("To-Do List");
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        title.setTextAlignment(TextAlignment.CENTER);
        // numtaskscompleted and numtasksremaining text
        Text ntc = new Text("Number of Tasks Completed:    " + numTasksCompleted);
        Text ntr = new Text("Number of Tasks Completed:    " + numTasksRemaining);
        //TextField
        TextField tf = new TextField("Add task here...");
        //ComboBoxes
        ComboBox<String> cbo1 = new ComboBox<String>();
        cbo1.getItems().addAll("Study", "Shop", "Cook", "Sleep");
        ComboBox<String> cbo2 = new ComboBox<String>();
        cbo2.getItems().addAll("1", "2", "3", "4", "5");
        //Buttons
        Button enq = new Button("Enqueue Task");
        Button deq = new Button("Dequeue Task");
        //Hbox TOP
        HBox hbTop = new HBox(ntc, ntr);
        hbTop.setAlignment(Pos.CENTER);
        hbTop.setSpacing(30);
        //Hbox BOTTOM
        HBox hbBottom = new HBox(tf, cbo1, cbo2, enq, deq);
        hbBottom.setAlignment(Pos.CENTER);
        hbBottom.setSpacing(20);
        //Vbox
        VBox vbox = new VBox();
        vbox.getChildren().addAll(title, hbTop);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        //ListView declaration;
        ListView<String> lv = new ListView<String>(tasks);
        //Enqueue button setOnAction
        enq.setOnAction(e -> {
            if (tf.getText().equals("") 
                || tf.getText().equals("Add task here...")) {
                alert1.showAndWait();
            } else if (cbo1.getValue() == null) {
                alert2.showAndWait();
            } else if (cbo2.getValue() == null) {
                alert3.showAndWait();
            }
            for (int i = 0; i < tasks.size(); i++) {
                if (tf.getText().equals(tasks.get(i).split(" ")[0])
                    && cbo1.getValue().equals(tasks.get(i).split(" ")[7])
                    && cbo2.getValue().equals(tasks.get(i).split(" ")[])) {

                }
            }
        });
        BorderPane root = new BorderPane();
        root.setCenter(lv);
        root.setTop(vbox);
        root.setBottom(hbBottom);
        primaryStage.setTitle("To Do List");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    private String getDateTime(String hours) {
        int h = Integer.parseInt(hours);
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}