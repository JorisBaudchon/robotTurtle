package com.company;

import java.util.List;

public class Cell {
    private char state;
    private String jewel;
    private String turtle;

    Cell() {
        this.state = 'E';
        this.jewel = "";
        this.turtle = "";
    }

    String getTurtle() {
        return this.turtle;
    }

    public String getJewel() {
        return this.jewel;
    }


    void setJewel(String jewelColor) {
        this.state = 'J';
        this.jewel = jewelColor;
    }

    void setTurtle(String turtle) {
        this.turtle = turtle;
        this.state = 'T';
    }

    char getState() {
        return this.state;
    }

    void setState(char state) {
        this.state = state;
    }
}



