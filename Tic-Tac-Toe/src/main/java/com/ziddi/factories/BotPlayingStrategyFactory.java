package com.ziddi.factories;

import com.ziddi.enums.BotDifficultyLevel;
import com.ziddi.strategies.BotPlayingStrategy;
import com.ziddi.strategies.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel){
        if(BotDifficultyLevel.HARD.equals(difficultyLevel)){
            return null;
        } else if(BotDifficultyLevel.MEDIUM.equals(difficultyLevel)){
            return null;
        }

        return new EasyBotPlayingStrategy();

    }
}
