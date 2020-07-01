package HornyMerk.prog2.exercises.set12;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ConnectFourApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Layout.fxml"));

        primaryStage.setTitle("Connect 4");
        primaryStage.setScene(new Scene(root, 600, 700));
        primaryStage.setResizable(false);

        primaryStage.show();
    }
}
