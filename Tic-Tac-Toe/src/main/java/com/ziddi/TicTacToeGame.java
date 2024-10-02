package com.ziddi;

import com.ziddi.controllers.GameController;
import com.ziddi.enums.BotDifficultyLevel;
import com.ziddi.enums.GameStatus;
import com.ziddi.enums.PlayerType;
import com.ziddi.model.Bot;
import com.ziddi.model.Game;
import com.ziddi.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class TicTacToeGame {
    public static void main(String[] args) {
        System.out.println("Game is Starting ...");
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the dimension of the game");
        int dimension = scanner.nextInt();
        List<Player> players = new ArrayList<>();

        // player information
        System.out.println("Will there be any bot ? y/n");
        String isBot = scanner.next();
        int noOfHumanPlayer = dimension - 1;
        if (isBot.equalsIgnoreCase("y")) {
            noOfHumanPlayer = dimension - 2;
            System.out.println("Enter the name of the bot");
            String name = scanner.next();
            System.out.println("Enter the symbol of the bot: ");
            String botSymbol = scanner.next();
            players.add(new Bot(name, botSymbol.charAt(0), BotDifficultyLevel.EASY));
        }

        for (int i = 0; i < noOfHumanPlayer; i++) {
            System.out.println("Enter the name of the Player : " + (i + 1));
            String playerName = scanner.next();
            System.out.println("Enter the symbol of the player: " + (i + 1));
            String playerSymbol = scanner.next();
            players.add(new Player(playerName, playerSymbol.charAt(0), PlayerType.HUMAN));
        }

        GameController gameController = new GameController();
        Game game = gameController.CreateGame(dimension, players);

        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            //Player will be playing
            System.out.println(" This is the current Board :");
            gameController.displayBoard(game);
            System.out.println(" Do you want to undo ? y/n ");
            String input = scanner.next();
            if(input.equals("y")){
                gameController.undo();
            } else {
                gameController.executeNextMove(game);
            }

        }
        // if the game has Ended or Draw
        if (gameController.getGameStatus(game).equals(GameStatus.DRAW)) {
            gameController.displayBoard(game);
            System.out.println("Game has Draw");
        } else if (gameController.getGameStatus(game).equals(GameStatus.ENDED)) {
            gameController.displayBoard(game);
            System.out.println("Game Ended");
            System.out.println("Winner is " + gameController.getWinner(game).getName());
        }


    }
}
