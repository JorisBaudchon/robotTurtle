package com.company;

class Grid {

    Cell[][] grid = new Cell[8][8];

    void initGrid(int numberOfPlayers) {
        grid = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new Cell();
            }
        }
        if (numberOfPlayers == 2 || numberOfPlayers == 3) {
            for (int i = 0; i < 8; i++) {
                grid[i][7].setState('S');
            }
        }
    }

    void placeJewel(int numberOfPlayers) {
        switch (numberOfPlayers) {
            case 2:
                grid[7][3].setJewel("green");
                break;
            case 3:
                grid[7][0].setJewel("purple");
                grid[7][3].setJewel("green");
                grid[7][6].setJewel("blue");
                break;
            case 4:
                grid[7][1].setJewel("purple");
                grid[7][6].setJewel("blue");
                break;
        }
    }

    void placeTurtle(int numberOfPlayers) {
        switch (numberOfPlayers) {
            case 2:
                grid[0][1].setTurtle("orange");
                grid[0][5].setTurtle("green");
                break;
            case 3:
                grid[0][0].setTurtle("orange");
                grid[0][3].setTurtle("green");
                grid[0][6].setTurtle("blue");
                break;
            case 4:
                grid[0][0].setTurtle("orange");
                grid[0][2].setTurtle("green");
                grid[0][5].setTurtle("blue");
                grid[0][7].setTurtle("yellow");
                break;
        }
    }

    void displayGridConsole() {
        System.out.println("    0 1 2 3 4 5 6 7 \n  +-----------------+");
        String total = "";
        for (int i = 0; i <= 7; i++) {
            String ligne = i + " | ";
            for (int j = 0; j <= 7; j++) {
                char state = grid[i][j].getState();
                switch (state) {
                    case ('E'):
                        ligne = ligne + 'E' + " ";
                        break;
                    case ('S'):
                        ligne = ligne + 'S' + " ";
                        break;
                    case ('I'):
                        ligne = ligne + 'I' + " ";
                        break;
                    case ('T'):
                        ligne = ligne + 'T' + " ";
                        break;
                    case ('J'):
                        ligne = ligne + 'J' + " ";
                        break;
                }
            }
            total = total + ligne + "| \n";
        }
        System.out.println(total + "  +-----------------+");
    }
}


