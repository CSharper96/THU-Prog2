package HornyMerk.prog2.exercises.set12;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Circle;

public class ConnectFourView
{
    private Circle[][] Circles = new Circle[7][7];
    private GridPane _GameGrid;

    public ConnectFourView(GridPane gameGrid)
    {
        this._GameGrid = gameGrid;
    }
}
