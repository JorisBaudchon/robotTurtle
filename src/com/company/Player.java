package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

public class Player {

    private Card[] hand;
    private ArrayDeque<Card> deck;
    private int playerTurn;
    private String pseudo;
    private String color;
    private char orientation;
    private int positionX;
    private int positionY;
    private int nbOfCardMaxInHand=5;
    private int nbOfCardsInHand;
    private int nbOfCardsInDeck=37;
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
        this.deck = new ArrayDeque<>();
        Random rand = new Random();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < nbOfCardsInDeck; i++) {
            index.add(i);
            this.deck.add(Card('N'));
        }
        for (int i = 0; i < nbOfBlueCardsInDeck; i++) {
            int randomIndex = rand.nextInt(index.size());
            deck[randomIndex] = new Card('B');
            index.remove(randomIndex);
        }
        for (int i = 0; i < nbOfYellowCardsInDeck; i++) {
            int randomIndex = rand.nextInt(index.size());
            deck[randomIndex] = new Card('Y');
            index.remove(randomIndex);
        }
        for (int i = 0; i < nbOfPurpleCardsInDeck; i++) {
            int randomIndex = rand.nextInt(index.size());
            deck[randomIndex] = new Card('P');
            index.remove(randomIndex);
        }
        for (int i = 0; i < nbOfLaserCardsInDeck; i++) {
            int randomIndex = rand.nextInt(index.size());
            deck[randomIndex] = new Card('L');
            index.remove(randomIndex);
        }
    }
    public void initHand(){
            this.hand = new Card[nbOfCardMaxInHand];
            for (int i = 0; i < nbOfCardMaxInHand; i++){
                Card drawedCard = this.deck[0];
                char drawedCardType=drawedCard.getCardType();
                hand[i]=new Card(drawedCardType);
                this.deck
            }

    }
}
