package com.company;

public class Main {
    
    public static GraficalUserInterface gui;
    
    public static void main(String[] args) {
        
        gui = new GraficalUserInterface();
        Game Game = new Game();
        Game.initGame();
    }
}
