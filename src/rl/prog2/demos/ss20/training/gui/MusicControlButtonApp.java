package rl.prog2.ss20.training.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MusicControlButtonApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MusicControlButton btn1 =
                new MusicControlButton(MusicControlButton.Type.PLAY);
        MusicControlButton btn2 =
                new MusicControlButton(MusicControlButton.Type.STOP);

        HBox box = new HBox(10);
        box.setPadding(new Insets(10, 10, 10, 10));
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(btn1, btn2);
        primaryStage.setTitle("Music Control Button App");
        primaryStage.setScene(new Scene(box));
        primaryStage.show();
    }
}
