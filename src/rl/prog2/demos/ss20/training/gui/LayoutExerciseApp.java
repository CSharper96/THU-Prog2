package rl.prog2.ss20.training.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LayoutExerciseApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button topBtn1 = new Button("< top");
        Button topBtn2 = new Button("top >>>");
        HBox topBox = new HBox();
        topBox.getChildren().addAll(topBtn1, topBtn2);
        topBox.setAlignment(Pos.CENTER);

        Button centerBtn = new Button("center");
        centerBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //centerBtn.setOnAction(ev -> System.out.println("Hallo!"));

        BorderPane rightPane = new BorderPane();
        rightPane.setTop(topBox);
        rightPane.setCenter(centerBtn);
        rightPane.setPadding(new Insets(20, 20, 20, 20));

        Button leftBtn = new Button("left");
        leftBtn.setMaxHeight(Double.MAX_VALUE);
        BorderPane rootPane = new BorderPane();
        rootPane.setLeft(leftBtn);
        rootPane.setCenter(rightPane);
        primaryStage.setScene(new Scene(rootPane));
        primaryStage.setTitle("LayoutExerciseApp");
        primaryStage.show();
    }
}
