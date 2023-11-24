package TicTacToe.strategies.winningStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

public interface WinningStrategy {

    public boolean checkWinner(Move move, Board board);

    public void handleUndo(Move move, Board board);
}
