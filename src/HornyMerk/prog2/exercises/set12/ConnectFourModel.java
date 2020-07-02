package HornyMerk.prog2.exercises.set12;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ConnectFourModel
{
    private Circle[][] _Circles = new Circle[6][7];
    protected ObservableList<Player> _Players = FXCollections.observableArrayList();
    protected final String _DEFAULT_COLOR = "#90B0B9";
    protected final int _ROWS = 6;
    protected final int _COLS = 7;
    protected boolean IsOver;
    public int moveCount = 0;
    public Player activePlayer;

    protected void setCircles(Circle[][] circles)
    {
        _Circles = circles;
    }
    public Circle getCircle(int row, int col)
    {
        if(_Circles.length != 0)
            return _Circles[row ][col];
        else return null;
    }
    public Circle[][] getCircles()
    {
        return _Circles;
    }
    protected void nextPlayer()
    {
        activePlayer = _Players.get(moveCount % 2);
    }
}
