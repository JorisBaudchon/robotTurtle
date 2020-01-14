package com.company;

public class Card {

    char cardType;

    char getCardType() {
        return this.cardType;
    }

    public void setCardType(char cardType) {
        this.cardType = cardType;
    }

    public Card(char cardType) {
        this.cardType = cardType;
    }
}

