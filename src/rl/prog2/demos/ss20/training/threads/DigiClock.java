package rl.prog2.ss20.training.threads;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.util.Date;

public class DigiClock extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private TextField textFld;

    @Override
    public void start(Stage primaryStage) {
        // TextField textFld;
        textFld = new TextField();
        textFld.setPrefColumnCount(10);
        textFld.setPadding(new Insets(10,10,10,10));
        textFld.setAlignment(Pos.CENTER);
        textFld.setFont(Font.font(40));
        textFld.setEditable(false);
        StackPane pane = new StackPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.getChildren().add(textFld);

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("DigiClock");
        primaryStage.show();
        Thread thread = new Thread(() -> startClock());
        thread.setDaemon(true);
        thread.start();
    }


    public void startClock() {
        while (true) {
            Platform.runLater(new Runnable() {
                public void run() {
                    //textFld.setText(new Date().toString());
                    textFld.setText(DateFormat.
                            getTimeInstance().format(new Date()));
                }
            });
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
