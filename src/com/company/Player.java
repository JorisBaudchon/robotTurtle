package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

public class Player {

    public ArrayList<Card> hand = new ArrayList<Card>();
    private Card[] deck;
    private int playerTurn;
    private String pseudo;
    private String color;
    private char orientation;
    private int positionX;
    private int positionY;
    private int numberOfCardsInTheDeck;
    private int numberOfBlueCardsInTheDeck;
    private int numberOfYellowCardsInTheDeck;
    private int numberOfPurpleCardsInTheDeck;
    private int numberOfLaserCardsInTheDeck;

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

    public ArrayList<Card> getHand() {
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

    public void initDeck(Player player) {
        player.deck = new Card[numberOfCardsInTheDeck];
        Random rand = new Random();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < numberOfCardsInTheDeck; i++) {
            index.add(i);
        }
        for (int i = 0; i < numberOfBlueCardsInTheDeck; i++) {
            int randomIndex = rand.nextInt(index.size());
            deck[i] = new Card('B');
            deck[i].(index.get(randomIndex));
            index.remove(randomIndex);
        }
        for (int i = 0; i < numberOfYellowCardsInTheDeck; i++) {
            int randomIndex = rand.nextInt(index.size());
            deck.addYellowCard(index.get(randomIndex));
            index.remove(randomIndex);
        }
        for (int i = 0; i < numberOfPurpleCardsInTheDeck; i++) {
            int randomIndex = rand.nextInt(index.size());
            deck.addPurpleCard(index.get(randomIndex));
            index.remove(randomIndex);
        }
        for (int i = 0; i < numberOfLaserCardsInTheDeck; i++) {
            int randomIndex = rand.nextInt(index.size());
            deck.addLaserCard(index.get(randomIndex));
            index.remove(randomIndex);
        }
    }

    public void addBlueCard(Card[] deck){
        this.deck
    }
}
