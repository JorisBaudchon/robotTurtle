package com.company;

public class Grid {

    private static Cell[][] grid;


    static void InitGrid(int numberOfPlayers) {
        grid = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new Cell();
            }
        }
        if (numberOfPlayers == 2 || numberOfPlayers == 3) {
            for (int i = 0; i < 8; i++) {
                //grid[7][i]=;
            }
        }
    }
    public static void placeJewel(int numberOfPlayers){
        switch (numberOfPlayers){
            case 2 :
                this.grid[0][1];
                break;
            case 3 :
                break;
            case 4 :
                break;
        }
    }
}


