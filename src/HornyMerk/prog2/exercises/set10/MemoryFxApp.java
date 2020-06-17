package HornyMerk.prog2.exercises.set10;

import HornyMerk.prog2.exercises.set09.Counter;
import HornyMerk.prog2.exercises.set10.Utilities.IMemoryGame;
import HornyMerk.prog2.exercises.set10.Utilities.MemoryGame;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;


public class MemoryFxApp extends Application implements IMemoryGame {

    private static final double WINDOW_WIDTH = 600;
    private static final double WINDOW_HEIGHT = 400;
    private static final double GRID_WIDTH = 140;
    private static final double GRID_HEIGHT = 110;

    private static MemoryGame _MemoryGame = new MemoryGame();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();
        GridPane gameGrid = new GridPane();

        Label statusLbl = new Label("Next: Player x");

        ArrayList<Button> buttons = new ArrayList<>();

        // Define control properties
        {
            buttons = createButtons();

            // Defining MenuBar
            {
                Menu fileMenu = new Menu("File");

                MenuItem newItem = new MenuItem("New");
                MenuItem exitItem = new MenuItem("Exit?");

                fileMenu.getItems().addAll(newItem, exitItem);

                menuBar.getMenus().add(fileMenu);
            }
        }
        // Define and assign containers
        {
            mainPane.setTop(menuBar);
            mainPane.setCenter(gameGrid);
            mainPane.setBottom(statusLbl);
            mainPane.setAlignment(statusLbl, Pos.CENTER);

            gameGrid.addColumn(0);
            gameGrid.addColumn(1);
            gameGrid.addColumn(2);
            gameGrid.addColumn(3);
            gameGrid.addRow(0);
            gameGrid.addRow(1);
            gameGrid.addRow(2);
            {
                // Setting columns size in percent
                ColumnConstraints column = new ColumnConstraints();
                column.setPercentWidth(100.0/4.0);
                gameGrid.getColumnConstraints().add(column);

                column = new ColumnConstraints();
                column.setPercentWidth(100.0/4.0);
                gameGrid.getColumnConstraints().add(column);

                column = new ColumnConstraints();
                column.setPercentWidth(100.0/4.0);
                gameGrid.getColumnConstraints().add(column);

                column = new ColumnConstraints();
                column.setPercentWidth(100.0/4.0);
                gameGrid.getColumnConstraints().add(column);

                // Setting rows size in percent
                RowConstraints row = new RowConstraints();
                row.setPercentHeight(100.0/3.0);
                gameGrid.getRowConstraints().add(row);

                row = new RowConstraints();
                row.setPercentHeight(100.0/3.0);
                gameGrid.getRowConstraints().add(row);

                row = new RowConstraints();
                row.setPercentHeight(100.0/3.0);
                gameGrid.getRowConstraints().add(row);
            }
        }
        // Assign controls
        {
            assignButtons(buttons, gameGrid);
        }
        // EventHandler
        {

        }

        Scene scene = new Scene(mainPane, WINDOW_WIDTH, WINDOW_HEIGHT);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Testing JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private ArrayList<Button> createButtons()
    {
        ArrayList<Button> buttons = new ArrayList<>();

        for(int i = 0; i < 12; i++)
            buttons.add(new Button());

        return buttons;
    }
    private void assignButtons(ArrayList<Button> buttons, GridPane gameGrid)
    {
        int counter = 0;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 4; j++)
            {
                gameGrid.add(buttons.get(counter), j, i);
                gameGrid.setHalignment(buttons.get(counter), HPos.CENTER);
                buttons.get(counter).setPrefSize(GRID_WIDTH, GRID_HEIGHT);
                counter++;
            }
    }
}
