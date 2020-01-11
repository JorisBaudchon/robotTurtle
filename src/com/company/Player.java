package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Player {

    private ArrayList<Card> hand;
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;
    private ArrayList<Card> program;
    private ArrayList<WallCard> wallCardHand;
    private int playerTurn;
    private String pseudo;
    private String color;
    private char orientation;
    private int positionX;
    private int positionY;
    private int nbOfCardsMaxInHand = 5;
    private int nbOfBlueCardsInDeck = 18;
    private int nbOfYellowCardsInDeck = 8;
    private int nbOfPurpleCardsInDeck = 8;
    private int nbOfLaserCardsInDeck = 3;
    private int nbOfStoneWallCards = 3;
    private int nbOfIceWallCards = 2;
    private boolean finished;

    private Player(String pseudo) {
        this.pseudo = pseudo;
        this.orientation = 'S';
        this.playerTurn = 0;
        this.finished = false;
    }

    private int getPlayerTurn() {
        return this.playerTurn;
    }

    private void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    private char getOrientation() {
        return orientation;
    }

    private void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    private String getPseudo() {
        return this.pseudo;
    }

    private String getColor() {
        return this.color;
    }

    private int getPositionX() {
        return this.positionX;
    }

    private void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    private int getPositionY() {
        return this.positionY;
    }

    private void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void initDeck() {
        this.deck = new ArrayList<>();
        this.discard = new ArrayList<>();
        for (int i = 0; i < nbOfBlueCardsInDeck; i++) {
            Card card = new Card('B');
            this.deck.add(card);
        }
        for (int i = 0; i < nbOfYellowCardsInDeck; i++) {
            Card card = new Card('Y');
            this.deck.add(card);
        }
        for (int i = 0; i < nbOfPurpleCardsInDeck; i++) {
            Card card = new Card('P');
            this.deck.add(card);
        }
        for (int i = 0; i < nbOfLaserCardsInDeck; i++) {
            Card card = new Card('L');
            this.deck.add(card);
        }
        Collections.shuffle(this.deck);
    }

    private void drawUntilHandIsFull(int nbOfCardsInHand) {
        for (int i = 0; i < (nbOfCardsMaxInHand - nbOfCardsInHand); i++) {
            this.hand.add(this.deck.get(0));
            this.deck.remove(0);
            if (this.deck.size() == 1) {
                for (int j = 0; j < this.discard.size(); j++) {
                    this.deck.add(this.discard.get(0));
                    this.deck.remove(0);
                }
                Collections.shuffle(this.deck);
            }
        }
    }

    private void discardCard(int deletedCard) {
        this.discard.add(this.deck.get(0));
        this.hand.remove(deletedCard);
    }

    private void initHand() {
        this.hand = new ArrayList<>();
        drawUntilHandIsFull(0);
    }

    private void initWallHand() {
        this.wallCardHand = new ArrayList<>();
        for (int i = 0; i < nbOfStoneWallCards; i++) {
            WallCard wallCard = new WallCard('S');
            this.wallCardHand.add(wallCard);
        }
        for (int i = 0; i < nbOfIceWallCards; i++) {
            WallCard wallCard = new WallCard('I');
            this.wallCardHand.add(wallCard);
        }
    }

    private boolean isFinished() {
        return finished;
    }

    private ArrayList<Card> getCardHand() {
        return this.hand;
    }

    private ArrayList<WallCard> getWallCardHand() {
        return this.wallCardHand;
    }

    public ArrayList<Card> getProgram() {
        return this.program;
    }

    private void createProgram() {
        this.program = new ArrayList<>();
    }

    public void setColor(String color) {
        this.color = color;
    }
}
