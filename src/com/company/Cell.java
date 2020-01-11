package com.company;

import java.util.List;

public class Cell {
    char state;
    String jewel;
    String turtle;

    public Cell() {
        this.state = 'E';
        this.jewel = "";
        this.turtle = "";
    }

    public String getTurtle() {
        return this.turtle;
    }

    public String getJewel() {
        return this.jewel;
    }


    public void setJewel(String jewelColor) {
        this.state = 'J';
        this.jewel = jewelColor;
    }

    public void setTurtle(String turtle) {
        this.turtle = turtle;
        this.state = 'T';
    }

    public char getState() {
        return this.state;
    }

    public void setState(char state) {
        this.state = state;
    }
}



