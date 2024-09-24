package com.ziddi.model;

import com.ziddi.enums.GameStatus;
import com.ziddi.exceptions.InvalidGameDimension;
import com.ziddi.exceptions.InvalidNumberOfPlayersException;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
   private Board board;
    private List<Move> moves;
    private List<Player> players;

    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private Player winner;

    public static Builder getBuilder() {
        return new Builder();
    }

    public void displayBoard() {
        this.board.displayBoard();
    }




    private Game(){}

    public static class Builder {
        int dimension;
        List<Player> players;

        public Builder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }

        public Game build() {
            try {
                isValid();
            } catch (InvalidGameDimension | InvalidNumberOfPlayersException e){
                System.out.println(e.getMessage());

            }
            Game game = new Game();
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setPlayers(players);
            game.setBoard(new Board(dimension));
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            return game;


        }

        private void isValid() throws InvalidNumberOfPlayersException, InvalidGameDimension {
            if(players.size() != dimension - 1){
                throw new InvalidNumberOfPlayersException("Number of players should be 1 less than the dimension");

            }

            if(dimension < 3){
                throw new InvalidGameDimension("Dimension can't be less than 3");
            }
        }


    }


}
