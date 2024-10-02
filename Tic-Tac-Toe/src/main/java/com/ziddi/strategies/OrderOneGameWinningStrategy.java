package com.ziddi.strategies;

import com.ziddi.model.Board;
import com.ziddi.model.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStrategy implements GameWinningStrategies {
    List<HashMap<Character, Integer>> rowSymbolCounts = new ArrayList<>();
    List<HashMap<Character, Integer>> colSymbolCounts = new ArrayList<>();

    HashMap<Character, Integer> topLeftDiagonalSymbolCounts = new HashMap<>();
    HashMap<Character, Integer> topRightDiagonalSymbolCounts = new HashMap<>();

    public OrderOneGameWinningStrategy(int dimension) {
        for (int i = 0; i < dimension; i++) {
            rowSymbolCounts.add(new HashMap<>());
            colSymbolCounts.add(new HashMap<>());
        }
    }

    private boolean isCellOnTopLeftDiagonal(int row, int col) {
        return row == col;
    }

    private boolean isCellOnTopRightDiagonal(int row, int col, int dimension) {
        return row + col == dimension - 1;
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        char symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        int dimension = board.getBoard().size();
        if (!rowSymbolCounts.get(row).containsKey(symbol)) {
            rowSymbolCounts.get(row).put(symbol, 0);
        }
        rowSymbolCounts.get(row).put(symbol, rowSymbolCounts.get(row).get(symbol) + 1);

        if (!colSymbolCounts.get(col).containsKey(symbol)) {
            colSymbolCounts.get(col).put(symbol, 0);
        }
        colSymbolCounts.get(col).put(symbol, colSymbolCounts.get(col).get(symbol) + 1);
        if (isCellOnTopLeftDiagonal(row, col)) {
            if (!topLeftDiagonalSymbolCounts.containsKey(symbol)) {
                topLeftDiagonalSymbolCounts.put(symbol, 0);
            }
            topLeftDiagonalSymbolCounts.put(symbol, topLeftDiagonalSymbolCounts.get(symbol) + 1);
        }

        if (isCellOnTopRightDiagonal(row, col, dimension)) {
            if (!topRightDiagonalSymbolCounts.containsKey(symbol)) {
                topRightDiagonalSymbolCounts.put(symbol, 0);
            }
            topRightDiagonalSymbolCounts.put(symbol, topRightDiagonalSymbolCounts.get(symbol) + 1);
        }

        //check the winner
        if (rowSymbolCounts.get(row).get(symbol) == dimension || colSymbolCounts.get(col).get(symbol) == dimension) {
            return true;
        }
        if (isCellOnTopRightDiagonal(row, col, dimension) && topRightDiagonalSymbolCounts.get(symbol) == dimension) {
            return true;
        }

        if (isCellOnTopLeftDiagonal(row, col) && topLeftDiagonalSymbolCounts.get(symbol) == dimension) {
            return true;
        }


        return false;
    }
}
