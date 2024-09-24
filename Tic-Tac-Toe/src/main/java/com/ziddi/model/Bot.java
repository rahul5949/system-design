package com.ziddi.model;

import com.ziddi.enums.BotDifficultyLevel;
import com.ziddi.enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Setter;


@Setter
public class Bot extends Player {
    BotDifficultyLevel difficultyLevel;

    public  Bot(String name, char symbol, BotDifficultyLevel botDifficultyLevel){
        super(name,symbol, PlayerType.BOT);
        this.difficultyLevel = botDifficultyLevel;

    }


}
