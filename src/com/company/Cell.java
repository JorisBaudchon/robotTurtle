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

    public Cell() {
        this.isAJewel = false;
        this.isAnIceWall = false;
        this.isATurtle = false;
        this.isAWall = false;
        this.jewel = "";
        this.isEmpty = true;
        this.turtle = "";
    }

    public boolean isAnIceWall() {
        return this.isAnIceWall;
    }

    public boolean isAWall() {
        return this.isAWall;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public boolean isAJewel() {
        return this.isAJewel;
    }

    public boolean isATurtle() {
        return this.isATurtle;
    }

    public String getTurtle() {
        return this.turtle;
    }

    public String getJewel() {
        return this.jewel;
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
        this.isAJewel = true;
        this.jewel = jewelColor;
    }

    public void setTurtle(String turtle) {
        this.turtle = turtle;
        this.isATurtle = true;
    }
}

