package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Player {

    private ArrayList<Card> hand;
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;
    private ArrayList<Wall> wallHand;
    private int playerTurn;
    private String pseudo;
    private String color;
    private char orientation;
    private int positionX;
    private int positionY;
    private int nbOfCardsMaxInHand=5;
    private int nbOfCardsInHand;
    private int nbOfBlueCardsInDeck=18;
    private int nbOfYellowCardsInDeck=8;
    private int nbOfPurpleCardsInDeck=8;
    private int nbOfLaserCardsInDeck=3;

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

    public void initDeck() {
        this.deck = new ArrayList<>();
        this.discard = new ArrayList<>();
        for (int i = 0; i < nbOfBlueCardsInDeck; i++) {
            Card card= new Card('B');
            this.deck.add(card);
        }
        for (int i = 0; i < nbOfYellowCardsInDeck; i++) {
            Card card= new Card('Y');
            this.deck.add(card);
        }
        for (int i = 0; i < nbOfPurpleCardsInDeck; i++) {
            Card card= new Card('P');
            this.deck.add(card);
        }
        for (int i = 0; i < nbOfLaserCardsInDeck; i++) {
            Card card= new Card('L');
            this.deck.add(card);
        }
        Collections.shuffle(this.deck);
    }

    public void drawUntilHandIsFull(){
            for (int i = 0; i < nbOfCardsMaxInHand; i++){
                this.hand.add(this.deck.get(0));
                this.discard.add(this.deck.get(0));
                this.deck.remove(0);
            }
    }

    public void initHand(){
        ArrayList<Card> hand = new ArrayList<>();
        drawUntilHandIsFull();
    }

    public void initWallHand(){
        
    }
}
