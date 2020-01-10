package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Player {
    
    private String couleur;
    public ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayDeque<Card> deck;
    private int playerTurn;
    private String pseudo;
<<<<<<< HEAD
    private String color;
=======
    private char orientation;

>>>>>>> af874700d0812bf932e9a9bc4831f1526f7bac2c

    public Player(String pseudo) {
        this.pseudo = pseudo;
        this.playerTurn = 4;
    }

    public int getPlayerTurn() {
        return this.playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }
<<<<<<< HEAD

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    
    public String getPseudo() {
		return this.pseudo;
	}
    
    public String colorPlayer() {
		return this.color;
	}
    
    public void setMain(ArrayList<Card> main) {
		this.hand = hand;
	}
    
	public ArrayList<Card> getMain(){
		return this.hand;
	}
    

}
