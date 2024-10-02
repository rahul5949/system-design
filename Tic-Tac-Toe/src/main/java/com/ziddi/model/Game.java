package com.ziddi.model;

import com.ziddi.enums.CellState;
import com.ziddi.enums.GameStatus;
import com.ziddi.exceptions.InvalidGameDimension;
import com.ziddi.exceptions.InvalidNumberOfPlayersException;
import com.ziddi.strategies.GameWinningStrategies;
import com.ziddi.strategies.OrderOneGameWinningStrategy;
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
    private GameWinningStrategies gameWinningStrategies;


    public static Builder getBuilder() {
        return new Builder();
    }

    public void displayBoard() {
        this.board.displayBoard();
    }




    private Game(){}

    public void makeNextMove() {
        // Steps:
        //1. player should be able to devide the move.
        //2. Check the validation of them move. if move is valid then make the move.

        Player playerToMove = players.get(nextPlayerIndex);
        System.out.println("It is " + playerToMove.getName() + "'s turn");
        Move move = playerToMove.decideMove(board);
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)){
            // move is valid
            board.applyMove(move);
            moves.add(move);

            // Check the winner
            if(gameWinningStrategies.checkWinner(board, move)){
                gameStatus = GameStatus.ENDED;
                winner = playerToMove;
            }
            nextPlayerIndex+=1;
            nextPlayerIndex%= (players.size());

        } else {
            System.out.println("Warning : Invalid move please provide valid move ");
        }

    }

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
            game.setGameWinningStrategies(new OrderOneGameWinningStrategy(dimension));
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
