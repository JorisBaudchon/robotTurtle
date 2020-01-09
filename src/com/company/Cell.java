package com.company;

public class Cell {
    boolean isAWall;
    boolean isAnIceWall;
    boolean isAJewel;
    boolean isEmpty;
    String jewel;
    String turtle;

    public boolean isAnIceWall() {
        return isAnIceWall;
    }

    public boolean isAWall() {
        return isAWall;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isJewel() {
        return isAJewel;
    }

    public String getTurtle() {
        return turtle;
    }

    public String getJewel() {
        return jewel;
    }

    public void setAnIceWall() {
        this.isAnIceWall = true;
    }

    public void setAWall() {
        this.isAWall = true;
    }

    public void setEmpty() {
        this.isEmpty = true;
    }

    public void setJewel(String jewelColor) {
        isAJewel = true;
        jewel=jewelColor;
    }

    public void setTurtle(String turtle) {
        turtle = turtle;
    }
}

