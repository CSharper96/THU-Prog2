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

    public Circle[][] initCircleArray()
    {
        ObservableList<Node> childrens = _GameGrid.getChildren();
        for(int col = 0; col < 8; col++)
        {
            for(int row = 1; row < 8; row++)
            {
                for (Node node : childrens) {
                    if (_GameGrid.getRowIndex(node) == row && _GameGrid.getColumnIndex(node) == col)
                        Circles[row - 1][col] = (Circle) node;
                }
            }
        }
        return Circles;
    }
}
