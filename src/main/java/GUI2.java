package main.java;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUI2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        Scene scene = new Scene(group, 600, 300);
        scene.setFill(Color.BEIGE);
        primaryStage.setTitle("Testing");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
