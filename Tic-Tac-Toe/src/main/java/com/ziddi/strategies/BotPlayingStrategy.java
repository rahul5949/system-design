package com.ziddi.strategies;

import com.ziddi.model.Board;
import com.ziddi.model.Move;
import com.ziddi.model.Player;

public interface BotPlayingStrategy {
    Move decideMove(Player player, Board board);
}
