package rl.prog2.ss20.training.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloWorldApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Hello World!");
        btn.setFont(Font.font(50));
        StackPane pane = new StackPane();
        pane.getChildren().add(btn);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("My first program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
