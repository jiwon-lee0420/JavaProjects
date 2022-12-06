import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
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
import javafx.scene.control.Control;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class ToDoList extends Application {
    private final Alert alert1 = new Alert(AlertType.ERROR, "Please enter a task.");
    private final Alert alert2 = new Alert(AlertType.ERROR, "Please select a task type.");
    private final Alert alert3 = new Alert(AlertType.ERROR, "Please select number of hours.");
    private final Alert alert4 = new Alert(AlertType.ERROR, "Exact task already exists.");
    private final Alert alert5 = new Alert(AlertType.ERROR, "Task name already exists.");
    
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        //Text initialization
        Text title = new Text("To-Do List");
        title.setFont(new Font("Times New Roman", 20));
        //Label initialization
        Label ntr = new Label("Number of tasks remaining:    0");
        Label ntc = new Label("Number of tasks completed:    0");
        Label totalHours = new Label("Total hours to complete task:    0");
        //TextField initializations
        TextField tf = new TextField("Add task here...");
        tf.requestFocus();
        //ComboBox initializations
        ComboBox<String> cbo1 = new ComboBox<String>();
        cbo1.getItems().addAll("Study", "Shop", "Cook", "Sleep");
        ComboBox<String> cbo2 = new ComboBox<String>();
        cbo2.getItems().addAll("1", "2", "3", "4", "5");
        //Button initializations
        Button enq = new Button("Enqueue Task");
        Button deq = new Button("Dequeue Task");
        ObservableList<String> ol = FXCollections.observableArrayList();
        //enqueue button action
        enq.setOnAction(e -> {
            if (tf.getText().equals("") 
                || tf.getText().equals("Add task here...")) {
                alert1.showAndWait();
                return;
            } else if (cbo1.getValue() == null) {
                alert2.showAndWait();
                return;
            } else if (cbo2.getValue() == null) {
                alert3.showAndWait();
                return;
            }
            for (int i = 0; i < ol.size(); i++) {
                if (tf.getText().equals(ol.get(i).split(" - ")[0])
                    && cbo1.getValue().equals(ol.get(i).split(" - ")[1].split(" ")[3])
                    && cbo2.getValue().equals(ol.get(i).split(" - ")[2].split(" ")[3])) {
                    alert4.showAndWait();
                    return;
                } else if (tf.getText().equals(ol.get(i).split(" - ")[0])
                           && cbo2.getValue().equals(ol.get(i).split(" - ")[2].split(" ")[3])) {
                    alert5.showAndWait();
                    return;
                } else if (tf.getText().equals(ol.get(i).split(" - ")[0])
                           && cbo1.getValue().equals(ol.get(i).split(" - ")[1].split(" ")[3])) {
                    ol.set(i, tf.getText() + " - Type of task: " + cbo1.getValue() + " Complete by " + addHours(new java.util.Date(), Integer.parseInt(cbo2.getValue())));
                    return;
                }
            }
            ol.add(tf.getText() + " - Type of task: " + cbo1.getValue() + " - Complete by " + addHours(new java.util.Date(), Integer.parseInt(cbo2.getValue())));
            tf.setText("Add task here...");
            tf.selectAll();
            int th = Integer.parseInt(totalHours.getText().split(":")[1].split(" ")[4]) + Integer.parseInt(cbo2.getValue());
            cbo1.setValue(null);
            cbo2.setValue(null);
            int numTasksRemaining = ol.size();
            ntr.setText("Number of tasks remaining:    " + numTasksRemaining);
            totalHours.setText("Total hours to complete task:    " + th);
        });
        //dequeue button action
        deq.setOnAction(e -> {
            if (ol.size() == 0) {
                return;
            }
            String removed = ol.remove(0);
            int numTasksRemaining = ol.size();
            ntr.setText("Number of tasks remaining:    " + numTasksRemaining);
            int numTasksCompleted = Integer.parseInt(ntc.getText().split(":")[1].split(" ")[4]) + 1;
            ntc.setText("Number of tasks completed:    " + numTasksCompleted);
            //int th = Integer.parseInt(removed.split(" - "))
        });
        //ListView initialization
        ListView<String> lv = new ListView<String>(ol);
        lv.setPrefWidth(500);
        lv.setMaxWidth(Control.USE_PREF_SIZE);
        lv.setMinWidth(Control.USE_PREF_SIZE);
        lv.setPrefHeight(250);
        lv.setMaxHeight(Control.USE_PREF_SIZE);
        lv.setMinHeight(Control.USE_PREF_SIZE);
        //HBox TOP initialization
        HBox hbTop = new HBox(ntr, ntc);
        hbTop.setAlignment(Pos.CENTER);
        hbTop.setSpacing(20);
        //HBox BOTTOM initialization
        HBox hbBottom = new HBox(tf, cbo1, cbo2, enq, deq);
        hbBottom.setAlignment(Pos.CENTER);
        hbBottom.setSpacing(20);
        //VBox initializatoin
        VBox vb = new VBox(title, hbTop, totalHours);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        BorderPane root = new BorderPane();
        root.setCenter(lv);
        root.setTop(vb);
        root.setBottom(hbBottom);
        primaryStage.setTitle("To Do List");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    private Date addHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }
}