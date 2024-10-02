package com.ziddi.model;

import com.ziddi.enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

@AllArgsConstructor
@Data
public class Player {
    String name;
    char symbol;
    PlayerType playerType;

    public Move decideMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row to make a move : ");
        int row = scanner.nextInt();
        System.out.println("Enter the col to make a move : ");
        int col = scanner.nextInt();
        return new Move(new Cell(row, col), this);
    }

}
