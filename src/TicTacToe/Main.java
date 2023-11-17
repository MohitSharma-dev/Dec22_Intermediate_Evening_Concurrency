package TicTacToe;

import TicTacToe.controllers.GameController;
import TicTacToe.exceptions.BotCountException;
import TicTacToe.exceptions.PlayerCountDimensionMismatchException;
import TicTacToe.exceptions.SymbolCountException;
import TicTacToe.models.Game;
import TicTacToe.models.GameState;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException {
        GameController gameController = new GameController();
        Game game = gameController.startGame(3 , new ArrayList<>(), new ArrayList<>());
        System.out.println("Game is Starting");
//        Game game = new Game();
        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
            // do undo
        }

        if(gameController.checkState(game).equals(GameState.SUCCESS)){
            System.out.println("Winner is some player");
        } else if (gameController.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game is Drawn");
        }

    }
}
