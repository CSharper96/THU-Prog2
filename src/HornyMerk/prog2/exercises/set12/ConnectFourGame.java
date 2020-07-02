package HornyMerk.prog2.exercises.set12;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import rl.prog2.exercises.ss12set01.connectfour.Board;
import rl.prog2.exercises.ss12set01.connectfour.Disk;
import rl.prog2.exercises.ss12set01.connectfour.EqualDiskCounter;

import java.util.ArrayList;

public class ConnectFourGame extends ConnectFourModel
{
    private ConnectFourView _View;

    public ConnectFourGame(ConnectFourView view, Circle[][] circles) {
        this._View = view;
        setCircles(circles);
        _Players.addAll(Player.values());
        activePlayer = _Players.get(0);
        IsOver = false;
        _View.setLblTxt("Player " + activePlayer.Name + "s turn.");
    }
    public void move(int col)
    {
        if(IsOver) return;
        int row = _ROWS - 1;
        while(true) {
            if (circleUsed(row, col))
                row--;
            else {
                makeMove(row, col);
                break;
            }
            if (row < 0) {
                moveCount--;
                break;
            }
        }
        moveCount++;
        if(checkForWinner()) _View.setLblTxt("Player " + getWinner() + " won se game!");
        else if(isGameOver()) _View.setLblTxt("Game over! Please clear.");
        nextPlayer();
        if(!IsOver)
            _View.setLblTxt("Player " + activePlayer.Name + "s turn.");
    }
    public void clear()
    {
        for(Circle[] circles : getCircles())
            for(Circle circle : circles)
                circle.setFill(Paint.valueOf(_DEFAULT_COLOR));

        moveCount = 0;
        activePlayer = _Players.get(0);
        IsOver = false;
        _View.setLblTxt("Player " + activePlayer.Name + "s turn.");
    }
    public void proposeMove() throws InterruptedException {
        // Some mindblowing code
        _View.setLblTxt("YOU CAN DO THIS WITHOUT CHEATING!!! I BELIEVE IN YOU :) \t\t[" + activePlayer.Name + "s turn]");
    }

    public String getNextPlayerColor()
    {
        return activePlayer.getColor();
    }

    public boolean isGameOver() {
        for(Circle[] circles : getCircles())
            for(Circle circle : circles)
            {
                String color = _View.getCircleRGB(circle);
                if(color.equals(_DEFAULT_COLOR)) return IsOver = false;
            }
        return IsOver = true;
    }

    public String getWinner() {
        return activePlayer.Name;
    }

    public void makeMove(int row, int col)
    {
        Circle circle = getCircle(row, col);
        String color = getNextPlayerColor();
        _View.setCircleColor(circle, color);
    }

    private boolean checkForWinner()
    {
        if(checkHorizontal()) {
            IsOver = true;
            return true;
        }
        else if(checkVertical()) {
            IsOver = true;
            return true;
        }
        else if(checkDiagonal()) {
            IsOver = true;
            return true;
        }
        else return false;
    }
    private boolean checkHorizontal()
    {
        EqualDiskCounter counter = new EqualDiskCounter();

        for (int row = 0; row < _ROWS; row++) {
            counter.startLine();
            for (int col = 0; col < _COLS; col++) {
                if (counter.analyzeNext(getCircle(row, col)))
                    return true;
            }
        }
        return false;
    }
    private boolean checkVertical()
    {
        EqualDiskCounter counter = new EqualDiskCounter();

        for (int col = 0; col < _COLS; col++) {
            counter.startLine();
            for (int row = 0; row < _ROWS; row++) {
                if (counter.analyzeNext(getCircle(row, col)))
                    return true;
            }
        }
        return false;
    }
    private boolean checkDiagonal()
    {
        EqualDiskCounter dUpCounter = new EqualDiskCounter();
        EqualDiskCounter dDownCounter = new EqualDiskCounter();

        for (int col = 0; col < _COLS; col++) {
            dUpCounter.startLine();
            dDownCounter.startLine();
            for (int row = 0; row < _ROWS; row++) {
                int dCol = (col + row) % _COLS;
                if (dCol == 0) {
                    dDownCounter.startLine();
                    dUpCounter.startLine();
                }
                if (dDownCounter.analyzeNext(getCircle(row, dCol)))
                    return true;
                if (dUpCounter.analyzeNext(getCircle(_ROWS - 1
                        - row, dCol)))
                    return true;
            }
        }
        return false;
    }
    private boolean circleUsed(int row, int col)
    {
        Circle circle = getCircle(row, col);
        String color = _View.getCircleRGB(circle);
        if(color.equals(_DEFAULT_COLOR))
            return false;
        else return true;
    }
    public class EqualDiskCounter {
        int counter;
        Circle lastDisk;

        /**
         * Sets the counter to zero. Call this method before starting the analysis
         * of a new line.
         */
        public void startLine() {
            counter = 0;
        }

        /**
         * Updates the counter based on the next disk in line. Disk colors are
         * compared by == (fast), so never use different string representation for
         * the same color.
         *
         * @return true if 4 or more adjacent disks of the same color were found.
         */
        public boolean analyzeNext(Circle disk) {
            String diskColor = _View.getCircleRGB(disk);
            String lastDiskColor = "";
            if(lastDisk != null) lastDiskColor = _View.getCircleRGB(lastDisk);
            if (disk == null || diskColor.equals(_DEFAULT_COLOR))
                counter = 0;
            else if (counter == 0 || !lastDiskColor.equals(diskColor))
                counter = 1;
            else
                counter++;
            lastDisk = disk;
            return counter >= 4;
        }

        public Circle getLastAnalyzedDisk() {
            return lastDisk;
        }
    }
}

