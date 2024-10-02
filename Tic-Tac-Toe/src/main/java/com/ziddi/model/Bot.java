package com.ziddi.model;

import com.ziddi.enums.BotDifficultyLevel;
import com.ziddi.enums.PlayerType;
import com.ziddi.factories.BotPlayingStrategyFactory;
import com.ziddi.strategies.BotPlayingStrategy;
import lombok.Setter;


@Setter
public class Bot extends Player {

    private BotPlayingStrategy botPlayingStrategy;

    public  Bot(String name, char symbol, BotDifficultyLevel botDifficultyLevel){
        super(name,symbol, PlayerType.BOT);
        this.botPlayingStrategy  = BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(botDifficultyLevel);

    }

    @Override
    public Move decideMove(Board board){
            return botPlayingStrategy.decideMove(this, board);
    }


}
