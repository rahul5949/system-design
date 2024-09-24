package com.ziddi.model;

import com.ziddi.enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    String name;
    char symbol;
    PlayerType playerType;

}
