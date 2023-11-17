package TicTacToe.models;

import TicTacToe.exceptions.BotCountException;
import TicTacToe.exceptions.PlayerCountDimensionMismatchException;
import TicTacToe.exceptions.SymbolCountException;
import TicTacToe.strategies.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private int nextMovePlayerIndex;
    private Player winner;
    private List<WinningStrategy> winningStrategies;
    public Board getBoard() {
        return board;
    }

    private Game(int dimension,
                 List<Player> players,
                 List<WinningStrategy> winningStrategies){
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.moves = new ArrayList<>();
        this.nextMovePlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.board = new Board(dimension);
    }

    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder {
        private int dimension ;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;

        }

        public Builder addPlayer(Player player){
            this.players.add(player);
            return this;
        }

        public Builder addWinningStrategy(WinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
            return this;

        }
        private void validateBotCount() throws BotCountException {
            int botCount = 0;
            for(Player p : players){
                if(p.getPlayerType().equals(PlayerType.BOT)){
                    botCount += 1;
                }
            }
            if(botCount > 1){
                throw new BotCountException();
            }
        }

        private void validatePlayersCount() throws PlayerCountDimensionMismatchException {


            if(players.size() != dimension - 1){
                throw new PlayerCountDimensionMismatchException();
            }
        }

        private void validateSymbolsCount() throws SymbolCountException {
            Map<Character , Integer> symCount = new HashMap<>();

            for(Player p : players) {
                if (!symCount.containsKey(p.getSymbol().getaChar())) {
                    symCount.put(p.getSymbol().getaChar(), 0);
                }

                symCount.put(p.getSymbol().getaChar(),
                        symCount.get(p.getSymbol().getaChar()) + 1);

                if (symCount.get(p.getSymbol().getaChar()) > 1) {
                    throw new SymbolCountException();
                }
            }
        }
        private void validate() throws BotCountException, PlayerCountDimensionMismatchException, SymbolCountException {
            // validate single Bot players
            validateBotCount();
            // validate no of players == dimension - 1
            validatePlayersCount();
            // validate diff symbol for every player
            validateSymbolsCount();
        }
        public Game build() throws BotCountException, SymbolCountException, PlayerCountDimensionMismatchException {
            validate();
            return new Game(
                    this.dimension,
                    this.players,
                    this.winningStrategies
            );
        }
    }
    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }



}
