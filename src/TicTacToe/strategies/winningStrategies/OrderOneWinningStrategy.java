package TicTacToe.strategies.winningStrategies;

import TicTacToe.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneWinningStrategy implements WinningStrategy{

    private List<Map<Symbol, Integer>> rows;
    private List<Map<Symbol, Integer>> cols;

    private Map<Symbol, Integer> diagonal;
    private Map<Symbol, Integer> reverseDiagonal;

    public OrderOneWinningStrategy(int size) {
        rows = new ArrayList<>();
        cols = new ArrayList<>();
        diagonal = new HashMap<>();
        reverseDiagonal = new HashMap<>();
        for(int i=0; i<size; i++){
            rows.add(new HashMap<>());
            cols.add(new HashMap<>());
        }
    }


    @Override
    public boolean checkWinner(Move move, Board board) {
        Cell cell = move.getCell();
        Player player = move.getPlayer();
        int row = cell.getRow();
        int col = cell.getCol();

        Map<Symbol, Integer> rowMap = rows.get(row);
        rowMap.put(player.getSymbol(), rowMap.getOrDefault(player.getSymbol(), 0) + 1);

        Map<Symbol, Integer> colMap = cols.get(col);
        colMap.put(player.getSymbol(), colMap.getOrDefault(player.getSymbol(), 0) + 1);

        // Diagaonal
        if(row == col){
            diagonal.put(player.getSymbol(), diagonal.getOrDefault(player.getSymbol(), 0) + 1);
        }

        // Reverse Diagonal
        if(row + col == board.getSize() - 1){
            reverseDiagonal.put(player.getSymbol(), reverseDiagonal.getOrDefault(player.getSymbol(), 0) + 1);
        }

        // Check if the player is winning
        return rowMap.get(player.getSymbol()) == board.getSize() || colMap.get(player.getSymbol()) == board.getSize()
                || diagonal.getOrDefault(player.getSymbol(), 0) == board.getSize() || reverseDiagonal.getOrDefault(player.getSymbol(), 0) == board.getSize();

    }

    @Override
    public void handleUndo(Move move, Board board) {
        // Logic to update the maps
    }
}
