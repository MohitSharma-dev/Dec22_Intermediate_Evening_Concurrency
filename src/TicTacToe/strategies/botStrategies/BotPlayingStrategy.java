package TicTacToe.strategies.botStrategies;

import TicTacToe.models.Board;
import TicTacToe.models.Bot;
import TicTacToe.models.Move;

public interface BotPlayingStrategy {

    public Move makeMove(Board board, Bot bot);
}
