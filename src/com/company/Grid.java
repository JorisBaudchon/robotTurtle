package com.company;

class Grid {

    Cell[][] grid = new Cell[8][8];

    void initGrid(int numberOfPlayers, GraphicalUserInterface graphicalUserInterface) {
        grid = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new Cell();
            }
        }
        if (numberOfPlayers == 2 || numberOfPlayers == 3) {
            for (int i = 0; i < 8; i++) {
                grid[i][7].setState('S');
                graphicalUserInterface.btnGrid[i][7].setIcon(graphicalUserInterface.Wall);
            }
        }
    }

    void placeJewel(int numberOfPlayers, GraphicalUserInterface graphicalUserInterface) {
        switch (numberOfPlayers) {
            case 2:
                grid[7][3].setJewel("green");
                graphicalUserInterface.btnGrid[7][3].setIcon(graphicalUserInterface.GreenJewel);
                break;
            case 3:
                grid[7][0].setJewel("purple");
                graphicalUserInterface.btnGrid[7][0].setIcon(graphicalUserInterface.PurpleJewel);
                grid[7][3].setJewel("green");
                graphicalUserInterface.btnGrid[7][3].setIcon(graphicalUserInterface.GreenJewel);
                grid[7][6].setJewel("blue");
                graphicalUserInterface.btnGrid[7][6].setIcon(graphicalUserInterface.BlueJewel);
                break;
            case 4:
                grid[7][1].setJewel("purple");
                graphicalUserInterface.btnGrid[7][1].setIcon(graphicalUserInterface.PurpleJewel);
                grid[7][6].setJewel("blue");
                graphicalUserInterface.btnGrid[7][6].setIcon(graphicalUserInterface.BlueJewel);
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
            StringBuilder ligne = new StringBuilder(i + " | ");
            for (int j = 0; j <= 7; j++) {
                char state = grid[i][j].getState();
                switch (state) {
                    case ('E'):
                        ligne.append('E').append(" ");
                        break;
                    case ('S'):
                        ligne.append('S').append(" ");
                        break;
                    case ('I'):
                        ligne.append('I').append(" ");
                        break;
                    case ('T'):
                        ligne.append('T').append(" ");
                        break;
                    case ('J'):
                        ligne.append('J').append(" ");
                        break;
                }
            }
            total = total + ligne + "| \n";
        }
        System.out.println(total + "  +-----------------+");
    }
}


