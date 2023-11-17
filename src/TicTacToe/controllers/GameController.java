package TicTacToe.controllers;

import TicTacToe.models.Game;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;
import TicTacToe.strategies.winningStrategies.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int dimension,
                          List<Player> players,
                          List<WinningStrategy> winningStrategies){
        // we will create the game
        // we need to validate
//        game.getbuilder().setplayers(...).setWinning(...);
//        game.addplayer().addplayer().addwinningstrategt();
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game){

    }

    public void displayBoard(Game game){

    }

    public void getWinner(Game game){

    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public void undo(Game game){

    }

}
