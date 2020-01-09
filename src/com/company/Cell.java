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


    public boolean isAnIceWall(int positionX, int positionY) {
        return this.isAnIceWall;
    }

    public boolean isAWall(int positionX, int positionY) {
        return this.isAWall;
    }

    public boolean isEmpty(int positionX, int positionY) {
        return this.isEmpty;
    }

    public boolean isAJewel(int positionX, int positionY) {
        return this.isAJewel;
    }

    public boolean isATurtle(int positionX, int positionY) {
        return this.isATurtle;
    }

    public String getTurtle(int positionX, int positionY) {
        return this.turtle;
    }

    public String getJewel(int positionX, int positionY) {
        return this.jewel;
    }

    public int getPositionX(int positionX, int positionY) {
        return this.positionX;
    }

    public int getPositionY(int positionX, int positionY) {
        return this.positionY;
    }

    public void setAnIceWall(int positionX, int positionY) {
        this.isAnIceWall = true;
    }

    public void setAWall(int positionX, int positionY) {
        this.isAWall = true;
    }

    public void setEmpty(int positionX, int positionY) {
        this.isEmpty = true;
    }

    public void setJewel(String jewelColor, int positionX, int positionY) {
        this.isAJewel = true;
        this.jewel=jewelColor;
    }

    public void setTurtle(String turtle, int positionX, int positionY) {
        turtle = turtle;
    }
}

