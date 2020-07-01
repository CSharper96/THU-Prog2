package HornyMerk.prog2.exercises.set12;

import rl.prog2.exercises.ss12set01.connectfour.Board;
import rl.prog2.exercises.ss12set01.connectfour.Disk;
import rl.prog2.exercises.ss12set01.connectfour.EqualDiskCounter;

import java.util.ArrayList;

public class ConnectFourGame
{
    private ArrayList<Player> players;
    private String winner;

    protected Board board;
    private int moveCount;

    public ConnectFourGame() {
        players = new ArrayList<>();
        board = new Board(6, 7);
    }

    public Player getNextPlayerColor() {
        return players.get(moveCount % 2);
    }

    public Board getBoard() {
        return board;
    }

    public boolean isGameOver() {
        return moveCount == board.getRows() * board.getCols() || winner != null;
    }

    public String getWinner() {
        return winner;
    }

    public void makeMove(int col) {
        //if (board.drop(new Disk(getNextPlayerColor()), col))
            moveCount++;
        winner = checkForWinner();
    }

    private String checkForWinner() {
        EqualDiskCounter counter = new EqualDiskCounter();
        EqualDiskCounter dUpCounter = new EqualDiskCounter();
        EqualDiskCounter dDownCounter = new EqualDiskCounter();
        // check horizontal lines
        for (int row = 0; row < board.getRows(); row++) {
            counter.startLine();
            for (int col = 0; col < board.getCols(); col++) {
                if (counter.analyzeNext(board.getDiskAt(row, col)))
                    return counter.getLastAnalyzedDisk().getColor();
            }
        }
        // check vertical lines
        for (int col = 0; col < board.getCols(); col++) {
            counter.startLine();
            for (int row = 0; row < board.getRows(); row++) {
                if (counter.analyzeNext(board.getDiskAt(row, col)))
                    return counter.getLastAnalyzedDisk().getColor();
            }
        }
        // check diagonal lines
        for (int col = 0; col < board.getCols(); col++) {
            dUpCounter.startLine();
            dDownCounter.startLine();
            for (int row = 0; row < board.getRows(); row++) {
                int dCol = (col + row) % board.getCols();
                if (dCol == 0) {
                    dDownCounter.startLine();
                    dUpCounter.startLine();
                }
                if (dDownCounter.analyzeNext(board.getDiskAt(row, dCol)))
                    return dDownCounter.getLastAnalyzedDisk().getColor();
                if (dUpCounter.analyzeNext(board.getDiskAt(board.getRows() - 1
                        - row, dCol)))
                    return dUpCounter.getLastAnalyzedDisk().getColor();
            }
        }
        return null;
    }
}
