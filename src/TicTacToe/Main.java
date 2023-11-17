package TicTacToe;

import TicTacToe.controllers.GameController;
import TicTacToe.models.Game;
import TicTacToe.models.GameState;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        System.out.println("Game is Starting");
        Game game = new Game();
        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }

        if(gameController.checkState(game).equals(GameState.SUCCESS)){
            System.out.println("Winner is some player");
        } else if (gameController.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game is Drawn");
        }

    }
}
