package com.company;

import java.util.List;

public class Cell {
    boolean isAWall;
    boolean isAnIceWall;
    boolean isAJewel;
    boolean isEmpty;
    boolean isATurtle;
    String jewel;
    String turtle;
    int positionX;
    int positionY;


    public boolean isAnIceWall() {
        return isAnIceWall;
    }

    public boolean isAWall() {
        return isAWall;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isAJewel() {
        return isAJewel;
    }

    public boolean isATurtle() {
        return isATurtle;
    }

    public String getTurtle() {
        return turtle;
    }

    public String getJewel() {
        return jewel;
    }

    public List<Integer> getPosition() {
        return position;
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

