package com.ziddi.controllers;

import com.ziddi.enums.GameStatus;
import com.ziddi.model.Game;
import com.ziddi.model.Player;

import java.util.List;

public class GameController {

    public Game CreateGame(int dimension, List<Player> players) {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .build();

    }

    public void undo() {

    }

    public void executeNextMove(Game game) {
        game.makeNextMove();

    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }
}
