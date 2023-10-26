package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        /*
        Group root = new Group();
        Scene scene = new Scene(root, Color.BLUEVIOLET);
        stage.setScene(scene);
        stage.setTitle("Stage demo program");
        stage.setWidth(200);
        stage.setHeight(200);

        Text text = new Text();
        text.setText("Sample Text");
        text.setX(50);
        text.setY(50);
        root.getChildren().add(text);

        stage.setFullScreen(true);

        stage.show();*
         */

        Parent root = FXMLLoader.load(getClass().getResource("Hotel.fxml"));
        stage.setScene(new Scene(root, 300,300));
        stage.show();
    }
}