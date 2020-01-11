package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Player {

    ArrayList<Card> hand;
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;
    ArrayList<Card> program;
    ArrayList<WallCard> wallCardHand;
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

    Player(String pseudo) {
        this.pseudo = pseudo;
        this.orientation = 'S';
        this.playerTurn = 0;
        this.finished = false;
    }

    int getPlayerTurn() {
        return this.playerTurn;
    }

    void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    char getOrientation() {
        return orientation;
    }

    void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    String getPseudo() {
        return this.pseudo;
    }

    String getColor() {
        return this.color;
    }

    int getPositionX() {
        return this.positionX;
    }

    void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    int getPositionY() {
        return this.positionY;
    }

    void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    void initDeck() {
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

    void drawUntilHandIsFull(int nbOfCardsInHand) {
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

    void discardCard(int deletedCard) {
        this.discard.add(this.deck.get(0));
        this.hand.remove(deletedCard);
    }

    void initHand() {
        this.hand = new ArrayList<>();
        drawUntilHandIsFull(0);
    }

    void initWallHand() {
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

    boolean isFinished() {
        return finished;
    }

    ArrayList<Card> getCardHand() {
        return this.hand;
    }

    ArrayList<WallCard> getWallCardHand() {
        return this.wallCardHand;
    }

    public ArrayList<Card> getProgram() {
        return this.program;
    }

    public void createProgram() {
        this.program = new ArrayList<>();
    }
}
