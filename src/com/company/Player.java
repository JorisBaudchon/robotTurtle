package com.company;

public class Player {
    private int playerTurn;
    private String pseudo;
    private char orientation;


    public Player(String pseudo, int playerTurn) {
        this.pseudo = pseudo;
        this.playerTurn = playerTurn;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }
}
