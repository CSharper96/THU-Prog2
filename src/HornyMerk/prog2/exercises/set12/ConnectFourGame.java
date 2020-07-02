package HornyMerk.prog2.exercises.set12;

import javafx.scene.layout.GridPane;
import rl.prog2.exercises.ss12set01.connectfour.Board;
import rl.prog2.exercises.ss12set01.connectfour.Disk;
import rl.prog2.exercises.ss12set01.connectfour.EqualDiskCounter;

import java.util.ArrayList;

public class ConnectFourGame extends ConnectFourModel
{
    private ConnectFourView _View;

    public ConnectFourGame(ConnectFourView view) {
        this._View = view;
        //initCircleArray();
    }
    public void move(int col)
    {
        System.out.println(col);
    }
    public void clear()
    {

    }
    public void proposeMove()
    {

    }

    public String getNextPlayerColor() {
        return _Players.get(moveCount % 2).getColor();
    }

    public boolean isGameOver() {
        return false;
    }

    public String getWinner() {
        return null;
    }

    public void makeMove(int col) {
    }

    private String checkForWinner() {
        return null;
    }
}
