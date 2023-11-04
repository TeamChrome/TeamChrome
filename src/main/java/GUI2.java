package main.java;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Text text = new Text();
        text.setFont(Font.font("Century Gothic", 30));
        text.setX(225);
        text.setY(30);

        text.setText("Hotel CSUN");

        Group root = new Group();

        ObservableList list = root.getChildren();

        list.add(text);

        //Group group = new Group();
        Scene scene = new Scene(root, 600, 300);
        scene.setFill(Color.BEIGE);
        primaryStage.setTitle("Welcome to Hotel Sun");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
