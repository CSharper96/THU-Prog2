package HornyMerk.prog2.exercises.set09;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Counter extends Application
{
    private static final double WINDOW_WIDTH = 230;
    private static final double WINDOW_HEIGHT = 165;
    private static int _Counter = 0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        VBox vBox = new VBox();
        StackPane stackPane = new StackPane();
        TextField txtField = new TextField();
        Scene scene = new Scene(vBox, WINDOW_WIDTH, WINDOW_HEIGHT);
        Button[] buttons = new Button[]
                {
                        new Button("Count"),       //0
                        new Button("Reset"),       //1
                        new Button("Exit")        //2
                };
        /**
         * Define Control properties
         */
        {
            txtField.setText(String.valueOf(_Counter));
            txtField.setEditable(false);
            txtField.setPrefSize(260, 80);
            txtField.setAlignment(Pos.CENTER);
            txtField.setFont(Font.font("Arial", 50));

            for(Button btn : buttons)
                btn.setPrefSize(50, 25);
        }
        /**
         * Assign and define containers
         */
        {
            primaryStage.setResizable(false);

            vBox.getChildren().add(txtField);
            vBox.getChildren().add(stackPane);
        }
        /**
         *  Assign controls to containers
         */
        {
            stackPane.getChildren().addAll(buttons);
            stackPane.setAlignment(buttons[0], Pos.CENTER_LEFT);
            stackPane.setAlignment(buttons[1], Pos.CENTER);
            stackPane.setAlignment(buttons[2], Pos.CENTER_RIGHT);

            vBox.setMargin(txtField, new Insets(20,20,20,20));
            vBox.setMargin(stackPane, new Insets(0,20,20,20));
        }
        /**
         * Define EventHandler
         */
        {
            buttons[0].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                _Counter++;
                txtField.setText(String.valueOf(_Counter));
                }
            });
            buttons[1].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    _Counter = 0;
                    txtField.setText(String.valueOf(_Counter));
                }
            });
            buttons[2].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.exit(0);
                }
            });
        }

        primaryStage.setTitle("Testing JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
