package com.company;

public class Grid {

    private static Cell[][] grid;


    static void InitGrid(int numberOfPlayers) {
        grid = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j]=new Cell();
            }
        }
        switch (numberOfPlayers) {
            case (2):
                for (int i = 0; i < 8; i++) {
                    //grid[7][i]=;
                }
                break;
            case (3):
                break;
        }
    }
}


