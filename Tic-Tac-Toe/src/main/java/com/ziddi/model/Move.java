package com.ziddi.model;

import com.ziddi.enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Move {
    Cell cell;
    Player player;
}
