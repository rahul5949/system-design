package com.ziddi.strategies;

import com.ziddi.enums.CellState;
import com.ziddi.model.Board;
import com.ziddi.model.Cell;
import com.ziddi.model.Move;
import com.ziddi.model.Player;

public class EasyBotPlayingStrategy implements BotPlayingStrategy  {
    @Override
    public Move decideMove(Player player, Board board) {
        for(int i = 0; i < board.getBoard().size(); i++){
            for(int j = 0; j < board.getBoard().size(); j++){
                if(CellState.EMPTY.equals(board.getBoard().get(i).get(j).getCellState())){
                    // Bot move
                    return new Move(new Cell(i, j), player);
                }
            }
        }
        return null;
    }
}
