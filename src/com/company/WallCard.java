package com.company;

public class WallCard {
    private char wallCardType;

    public char getWallCardType() {
        return this.wallCardType;
    }

    public void setWallCardType(char wallCardType) {
        this.wallCardType = wallCardType;
    }

    public WallCard(char wallCardType) {
        this.wallCardType = wallCardType;
    }
}
