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
                grid[7][i].setAWall();
            }
        }
    }

    static void PlaceJewel(int numberOfPlayers) {
        switch (numberOfPlayers) {
            case 2:
                grid[3][7].setJewel("green");
                break;
            case 3:
                grid[0][7].setJewel("purple");
                grid[3][7].setJewel("green");
                grid[6][7].setJewel("blue");
                break;
            case 4:
                grid[1][7].setJewel("purple");
                grid[7][7].setJewel("blue");
                break;
        }
    }

    static void PlaceTurtle(int numberOfPlayers) {
        switch (numberOfPlayers) {
            case 2:
                grid[1][0].setTurtle("orange");
                grid[5][0].setTurtle("green");
                break;
            case 3:
                grid[1][0].setTurtle("orange");
                grid[3][0].setTurtle("green");
                grid[6][0].setTurtle("blue");
                break;
            case 4:
                grid[0][0].setTurtle("orange");
                grid[2][0].setTurtle("green");
                grid[5][0].setTurtle("blue");
                grid[7][0].setTurtle("yellow");
                break;
        }
    }


    static void DisplayGrid(){
        for
    }
}


