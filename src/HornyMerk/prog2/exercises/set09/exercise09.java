package HornyMerk.prog2.exercises.set09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class exercise09 extends Application
{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button[] buttons = new Button[]
                {
                        new Button("F1"),
                        new Button("F2"),
                        new Button("F3"),
                        new Button("F4"),
                        new Button("Up"),
                        new Button("Left"),
                        new Button("Right"),
                        new Button("Down"),
                        new Button("Exit")
                };
        buttons = setUpButtons(buttons);

        Pane pane = new Pane();
        pane.getChildren().addAll(buttons);

        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Testing JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Button[] setUpButtons(Button[] buttons)
    {
        buttons[0].setPrefSize(20,20);
        buttons[0].relocate(0,0);

        buttons[1].setPrefSize(20,20);
        buttons[1].relocate(30,0);

        buttons[2].setPrefSize(20,20);
        buttons[2].relocate(60,0);

        buttons[3].setPrefSize(20,20);
        buttons[3].relocate(90,0);

        buttons[4].setPrefSize(40,20);
        buttons[4].relocate(100,100);

        buttons[5].setPrefSize(40,20);
        buttons[5].relocate(100,100);

        buttons[6].setPrefSize(40,20);
        buttons[6].relocate(100,100);

        buttons[7].setPrefSize(40,20);
        buttons[7].relocate(100,100);

        buttons[8].setPrefSize(40,20);
        buttons[8].relocate(100,100);
        return buttons;
    }
}
