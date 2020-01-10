package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Player {
    
    private String couleur;
    public ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayDeque<Card> deck;
    private int playerTurn;
    private String pseudo;
    private String color;

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
