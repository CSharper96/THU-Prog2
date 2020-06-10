package HornyMerk.prog2.exercises.set09;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class FirstPanel extends Application
{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        BorderPane borderPane = new BorderPane();
        StackPane stackPane = new StackPane();
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(borderPane, 300, 200);
        Button[] buttons = new Button[]
                {
                        new Button("F1"),       //0
                        new Button("F2"),       //1
                        new Button("F3"),       //2
                        new Button("F4"),       //3
                        new Button("Up"),       //4
                        new Button("Left"),     //5
                        new Button("Right"),    //6
                        new Button("Down"),     //7
                        new Button("Exit")      //8
                };

        borderPane.topProperty().set(stackPane);
        borderPane.centerProperty().set(gridPane);
        borderPane.bottomProperty().set(buttons[8]);
        buttons[8].setPrefWidth(borderPane.getMaxWidth()); //???

        stackPane.getChildren().add(buttons[0]);
        stackPane.getChildren().add(buttons[1]);
        stackPane.getChildren().add(buttons[2]);
        stackPane.getChildren().add(buttons[3]);
        stackPane.setMargin(buttons[0], new Insets(0,102,0,0));
        stackPane.setMargin(buttons[1], new Insets(0,34,0,0));
        stackPane.setMargin(buttons[2], new Insets(0,0,0,34));
        stackPane.setMargin(buttons[3], new Insets(0,0,0,102));

        gridPane.addColumn(0);
        gridPane.addColumn(1);
        gridPane.addColumn(2);
        gridPane.addRow(0);
        gridPane.addRow(1);
        gridPane.addRow(2);
        gridPane.add(buttons[4], 1, 0);
        gridPane.add(buttons[5], 0, 1);
        gridPane.add(buttons[6], 2, 1);
        gridPane.add(buttons[7], 1, 2);

        primaryStage.setTitle("Testing JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
