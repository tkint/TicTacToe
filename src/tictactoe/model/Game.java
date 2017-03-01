/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.model;

/**
 *
 * @author tkint
 */
public class Game {

    private boolean turn;
    private boolean startTurn;
    private Board board;
    private Player playerOne;
    private Player playerTwo;

    public Game() {
        turn = true;
        startTurn = true;
        board = new Board();
        playerOne = new Player();
        playerTwo = new Player();
    }

    public Game(String playerOneName, String playerTwoName) {
        this();
        playerOne.setName(playerOneName);
        playerTwo.setName(playerTwoName);
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public void setPlayersName(String playerOneName, String playerTwoName) {
        playerOne.setName(playerOneName);
        playerTwo.setName(playerTwoName);
    }

    public void playerOneWin() {
        playerOne.getScore().addWin();
        playerTwo.getScore().addLoose();
    }

    public void playerTwoWin() {
        playerOne.getScore().addLoose();
        playerTwo.getScore().addWin();
    }

    public void equality() {
        playerOne.getScore().addEqualities();
        playerTwo.getScore().addEqualities();
    }

    public void newParty() {
        board = new Board();
        startTurn = !startTurn;
        turn = startTurn;
        int player = -1;
        if (turn) {
            player = 1;
        } else {
            player = 2;
        }
        System.out.println("Nouvelle partie, au tour du joueur " + player);
    }

    public void mark(int x, int y) {
        board.getCell(x, y).setMark(turn);
        turn = !turn;
        checkWin();
    }

    private Cell getCell(int x, int y) {
        return board.getCell(x, y);
    }

    private boolean isColumnFull(int x) {
        boolean full = false;
        Boolean value = getCell(x, 0).getMark();
        if (value != null) {
            if (getCell(x, 1).getMark() == value && getCell(x, 2).getMark() == value) {
                full = true;
            }
        }
        return full;
    }

    private boolean isRowFull(int y) {
        boolean full = false;
        Boolean value = getCell(0, y).getMark();
        if (value != null) {
            if (getCell(1, y).getMark() == value && getCell(2, y).getMark() == value) {
                full = true;
            }
        }
        return full;
    }

    private void checkWin() {
        Boolean win = whoWins();
        if (win != null) {
            if (win) {
                playerOneWin();
            } else {
                playerTwoWin();
            }
            newParty();
        } else {
            if (board.isFull()) {
                equality();
            }
        }
    }

    public Boolean whoWins() {
        Boolean win = null;
        for (int i = 0; i < 2; i++) {
            if (isColumnFull(i)) {
                win = getCell(i, 0).getMark();
            }
            if (isRowFull(i)) {
                win = getCell(0, i).getMark();
            }
        }
        return win;
    }
}
