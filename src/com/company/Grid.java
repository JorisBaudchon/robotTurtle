package com.company;

public class Grid {

    private static Cell[][] grid;


    static void InitGrid(int numberOfPlayers) {
        grid = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j].setEmpty();
            }
        }
        if (numberOfPlayers == 2 || numberOfPlayers == 3) {
            for (int i = 0; i < 8; i++) {
                //grid[7][i]=;
            }
        }
    }

    void PlaceJewel(int numberOfPlayers) {
        switch (numberOfPlayers) {
            case 2:
                this.grid[3][7].setJewel("green");
                break;
            case 3:
                this.grid[0][7].setJewel("purple");
                this.grid[3][7].setJewel("green");
                this.grid[6][7].setJewel("blue");
                break;
            case 4:
                this.grid[1][7].setJewel("purple");
                this.grid[7][7].setJewel("blue");
                break;
        }
    }
}


