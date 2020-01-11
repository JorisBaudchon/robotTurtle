package com.company;

public class Card {

    private char cardType;

    char getCardType() {
        return this.cardType;
    }

    public void setCardType(char cardType) {
        this.cardType = cardType;
    }

    Card(char cardType) {
        this.cardType = cardType;
    }
}

