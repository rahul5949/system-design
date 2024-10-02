package com.ziddi.model;

import com.ziddi.enums.CellState;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Board {
    List<List<Cell>> board;


    public Board(int dimension) {
        this.board = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            this.board.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++) {
                this.board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < this.board.size(); i++) {
            for (int j = 0; j < this.board.size(); j++) {
                if (CellState.EMPTY.equals(board.get(i).get(j).getCellState())) {
                    System.out.print("| |");
                } else {
                    System.out.print("| " + board.get(i).get(j).getPlayer().getSymbol() + " |");
                }

            }
            System.out.println();
        }
    }


    public void applyMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        this.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        this.getBoard().get(row).get(col).setPlayer(move.getPlayer());
    }
}
