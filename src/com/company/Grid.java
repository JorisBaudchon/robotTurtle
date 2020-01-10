package com.company;

public class Grid {

    private Cell[][] grid = new Cell[8][8];

    public void initGrid(int numberOfPlayers) {
        grid = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new Cell();
            }
        }
        if (numberOfPlayers == 2 || numberOfPlayers == 3) {
            for (int i = 0; i < 8; i++) {
                grid[7][i].setState('W');
            }
        }
    }

    public void placeJewel(int numberOfPlayers) {
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

    public void placeTurtle(int numberOfPlayers) {
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

    public void displayGridConsole() {
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
                    case ('W'):
                        ligne = ligne + 'W' + " ";
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

    public void BackToStart(Player player, int numberOfPlayers) {
        String color = player.getColor();
        switch (numberOfPlayers) {
            case 3:
                switch (color) {
                    case "orange":
                        grid[1][0].setTurtle("orange");
                        break;
                    case "green":
                        grid[3][0].setTurtle("green");
                        break;
                    case "blue":
                        grid[6][0].setTurtle("blue");
                        break;
                }
        }
    }
}


