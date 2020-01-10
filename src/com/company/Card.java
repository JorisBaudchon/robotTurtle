package com.company;

public class Card {

    private char cardType;

    public char getCardType() {
        return this.cardType;
    }

    public void setCardType(char cardType) {
        this.cardType = cardType;
    }

    public Card() {
        this.cardType = 'N';
    }
}
