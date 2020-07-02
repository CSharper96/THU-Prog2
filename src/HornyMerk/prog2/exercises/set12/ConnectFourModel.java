package HornyMerk.prog2.exercises.set12;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ConnectFourModel
{
    private Circle[][] _Circles = new Circle[7][7];
    protected ObservableList<Player> _Players = FXCollections.observableArrayList();
    public int moveCount = 0;

    protected void setCircles(Circle[][] circles)
    {
        _Circles = circles;
    }
    public Circle getCircle(int row, int col)
    {
        if(_Circles.length != 0)
            return _Circles[row][col];
        else return null;
    }
}
