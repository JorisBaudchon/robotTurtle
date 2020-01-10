package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Player {

    public ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayDeque<Card> deck;
    private int playerTurn;
    private String pseudo;
    private String color;
    private char orientation;
    private int positionX;
    private int positionY;

    public Player(String pseudo) {
        this.pseudo = pseudo;
        this.playerTurn = 0;
    }

    public int getPlayerTurn() {
        return this.playerTurn;
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

    public String getPseudo() {
		return this.pseudo;
	}
    
    public String getColor() {
		return this.color;
	}
    
    public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
    
	public ArrayList<Card> getHand(){
		return this.hand;
	}

    public int getPositionX() {
        return this.positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
