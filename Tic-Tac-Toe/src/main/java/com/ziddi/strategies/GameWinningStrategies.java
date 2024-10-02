package com.ziddi.strategies;

import com.ziddi.model.Board;
import com.ziddi.model.Move;

public interface GameWinningStrategies {
    boolean checkWinner(Board board, Move move);
}
