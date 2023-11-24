package TicTacToe;

import TicTacToe.controllers.GameController;
import TicTacToe.exceptions.BotCountException;
import TicTacToe.exceptions.PlayerCountDimensionMismatchException;
import TicTacToe.exceptions.SymbolCountException;
import TicTacToe.models.*;
import TicTacToe.strategies.winningStrategies.OrderOneWinningStrategy;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException {
        GameController gameController = new GameController();

        // TODO take input from user to get player details
        // If user enters 3 players, then create a board of size 4

        Player john = new Player("John", 1, new Symbol('X'), PlayerType.HUMAN);
//        Player jane = new Player("Jane", 2, new Symbol('O'), PlayerType.HUMAN);

        Player bot = new Bot("Bourvita", 3, new Symbol('Y'), PlayerType.BOT, BotDifficultyLevel.EASY);

        Game game = gameController.startGame(3 , Arrays.asList(john, bot), new OrderOneWinningStrategy(3));
        System.out.println("Game is Starting");
//        Game game = new Game();
        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
            // do undo
            gameController.undo(game);
        }

        if(gameController.checkState(game).equals(GameState.ENDED)){
            Player winner = gameController.getWinner(game);
            System.out.println("Winner is " + winner.getName());
        } else if (gameController.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game is Drawn");
        }

    }
}
