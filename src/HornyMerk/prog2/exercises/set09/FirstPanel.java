package HornyMerk.prog2.exercises.set09;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class FirstPanel extends Application
{
    private static final double WINDOW_WIDTH = 300;
    private static final double WINDOW_HEIGHT = 200;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        BorderPane borderPane = new BorderPane();
        StackPane stackPane = new StackPane();
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(borderPane, WINDOW_WIDTH, WINDOW_HEIGHT);

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
        /**
         * Define button properties
         */
        {
            buttons[8].setPrefWidth(Double.MAX_VALUE);

            buttons[4].setPrefWidth(75);
            buttons[5].setPrefWidth(75);
            buttons[6].setPrefWidth(75);
            buttons[7].setPrefWidth(75);
        }
        /**
         * Assign and define containers
         */
        {
            borderPane.topProperty().set(stackPane);
            borderPane.centerProperty().set(gridPane);

            gridPane.addColumn(0);
            gridPane.addColumn(1);
            gridPane.addColumn(2);
            gridPane.addRow(0);
            gridPane.addRow(1);
            gridPane.addRow(2);
            gridPane.setGridLinesVisible(true);
            {
                // Setting columns size in percent
                ColumnConstraints column = new ColumnConstraints();
                column.setPercentWidth(100.0/3.0);
                gridPane.getColumnConstraints().add(column);

                column = new ColumnConstraints();
                column.setPercentWidth(100.0/3.0);
                gridPane.getColumnConstraints().add(column);

                column = new ColumnConstraints();
                column.setPercentWidth(100.0/3.0);
                gridPane.getColumnConstraints().add(column);

                // Setting rows size in percent
                RowConstraints row = new RowConstraints();
                row.setPercentHeight(100.0/3.0);
                gridPane.getRowConstraints().add(row);

                row = new RowConstraints();
                row.setPercentHeight(100.0/3.0);
                gridPane.getRowConstraints().add(row);

                row = new RowConstraints();
                row.setPercentHeight(100.0/3.0);
                gridPane.getRowConstraints().add(row);
            }
            //gridPane.getColumnConstraints().forEach(c->c.setPercentWidth(100.0/3.0)); GAD NED!!!!
            //gridPane.getRowConstraints().forEach(r->r.setPercentHeight(100.0/3.0));

            gridPane.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT); // Default width and height
            gridPane.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        }
        /**
         *  Assign buttons to containers
         */
        {
            stackPane.getChildren().add(buttons[0]);
            stackPane.getChildren().add(buttons[1]);
            stackPane.getChildren().add(buttons[2]);
            stackPane.getChildren().add(buttons[3]);
            stackPane.setMargin(buttons[0], new Insets(0,102,0,0));
            stackPane.setMargin(buttons[1], new Insets(0,34,0,0));
            stackPane.setMargin(buttons[2], new Insets(0,0,0,34));
            stackPane.setMargin(buttons[3], new Insets(0,0,0,102));

            borderPane.bottomProperty().set(buttons[8]);

            gridPane.add(buttons[4], 1, 0);
            gridPane.add(buttons[5], 0, 1);
            gridPane.add(buttons[6], 2, 1);
            gridPane.add(buttons[7], 1, 2);
            gridPane.setHalignment(buttons[4], HPos.CENTER);
            gridPane.setHalignment(buttons[5], HPos.CENTER);
            gridPane.setHalignment(buttons[6], HPos.CENTER);
            gridPane.setHalignment(buttons[7], HPos.CENTER);
        }
        primaryStage.setTitle("Testing JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
