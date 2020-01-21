package com.company;

import java.util.ArrayList;

import com.company.Game.*;

public class Move {

    static void leftRotation(Player player) {
        char orientation = player.getOrientation();
        switch (orientation) {
            case 'N':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'N';
                break;
        }
        player.setOrientation(orientation);
    }

    static void rightRotation(Player player) {
        char orientation = player.getOrientation();
        switch (orientation) {
            case 'N':
                orientation = 'E';
                break;
            case 'W':
                orientation = 'N';
                break;
            case 'S':
                orientation = 'W';
                break;
            case 'E':
                orientation = 'S';
                break;
        }
        player.setOrientation(orientation);
    }

    private void backToStart(Player player, int numberOfPlayers, Grid grid) {
        String color = player.getColor();
        grid.grid[player.getPositionX()][player.getPositionY()].setState('E');
        switch (numberOfPlayers) {
            case 2:
                switch (color) {
                    case "orange":
                        grid.grid[0][1].setTurtle("orange");
                        player.setPositionX(0);
                        player.setPositionY(1);
                        player.setOrientation('S');
                        break;
                    case "green":
                        grid.grid[0][5].setTurtle("green");
                        player.setPositionX(0);
                        player.setPositionY(5);
                        player.setOrientation('S');
                        break;
                }
            case 3:
                switch (color) {
                    case "orange":
                        grid.grid[0][1].setTurtle("orange");
                        player.setPositionX(0);
                        player.setPositionY(1);
                        player.setOrientation('S');
                        break;
                    case "green":
                        grid.grid[0][3].setTurtle("green");
                        player.setPositionX(0);
                        player.setPositionY(3);
                        player.setOrientation('S');
                        break;
                    case "blue":
                        grid.grid[0][0].setTurtle("blue");
                        player.setPositionX(6);
                        player.setPositionY(0);
                        player.setOrientation('S');
                        break;
                }
            case 4:
                switch (color) {
                    case "orange":
                        grid.grid[0][6].setTurtle("orange");
                        player.setPositionX(0);
                        player.setPositionY(6);
                        player.setOrientation('S');
                        break;
                    case "green":
                        grid.grid[0][2].setTurtle("green");
                        player.setPositionX(0);
                        player.setPositionY(2);
                        player.setOrientation('S');
                        break;
                    case "blue":
                        grid.grid[0][5].setTurtle("blue");
                        player.setPositionX(0);
                        player.setPositionY(5);
                        player.setOrientation('S');
                        break;
                    case "yellow":
                        grid.grid[0][7].setTurtle("yellow");
                        player.setPositionX(0);
                        player.setPositionY(7);
                        player.setOrientation('S');
                        break;
                }
        }
    }


    void moveForward(Player player, Grid grid) {
        char orientation = player.getOrientation();
        int positionY = player.getPositionY();
        int positionX = player.getPositionX();
        grid.grid[positionX][positionY].setState('E');
        String color = player.getColor();
        System.out.println(positionX);
        System.out.println(positionY);
        switch (orientation) {
            case 'N':
                positionY = positionY - 1;
                break;
            case 'W':
                positionX = positionX - 1;
                break;
            case 'E':
                positionX = positionX + 1;
                break;
            case 'S':
                positionY = positionY + 1;
                break;
        }
        grid.grid[positionX][positionY].setTurtle(color);
        grid.grid[positionX][positionY].setState('T');
        player.setPositionY(positionY);
        player.setPositionX(positionX);
    }

    void laserShot(Player player, ArrayList<Player> players, int numberOfPlayers, Grid grid) {
        char orientation = player.getOrientation();
        int positionY = player.getPositionY();
        int positionX = player.getPositionX();
        int i = 0;
        int j = 0;
        switch (orientation) {
            case 'N':
                while (grid.grid[positionX][positionY - i].getState() == 'E') {
                    i = i++;
                }
                if (grid.grid[positionX][positionY - i].getState() == 'T') {
                    String color = grid.grid[positionX][positionY - i].getTurtle();
                    for (Player playerAttacked : players) {
                        if (playerAttacked.getColor() == color) {
                            backToStart(playerAttacked, numberOfPlayers, grid);
                        }
                    }
                } else if (grid.grid[positionX][positionY - i].getState() == 'S') {
                } else if (grid.grid[positionX][positionY - i].getState() == 'I') {
                    grid.grid[positionX][positionY - i].setState('E');
                } else if (grid.grid[positionX][positionY - i].getState() == 'J') {
                    backToStart(player, numberOfPlayers, grid);
                } else if (positionY - i == 0) {
                }
            case 'W':
                while (grid.grid[positionX - i][positionY].getState() == 'E') {
                    i = i++;
                }
                if (grid.grid[positionX - i][positionY].getState() == 'T') {
                    String color = grid.grid[positionX - i][positionY].getTurtle();
                    for (Player playerAttacked : players) {
                        if (playerAttacked.getColor() == color) {
                            backToStart(playerAttacked, numberOfPlayers, grid);
                        }
                    }
                } else if (grid.grid[positionX - i][positionY].getState() == 'S') {
                } else if (grid.grid[positionX - i][positionY].getState() == 'I') {
                    grid.grid[positionX - i][positionY].setState('E');
                } else if (grid.grid[positionX - i][positionY].getState() == 'J') {
                    backToStart(player, numberOfPlayers, grid);
                } else if (positionX - i == 0) {
                }
            case 'S':
                while (grid.grid[positionX][positionY + i].getState() == 'E') {
                    i = i++;
                }
                if (grid.grid[positionX][positionY + i].getState() == 'T') {
                    String color = grid.grid[positionX - i][positionY].getTurtle();
                    for (Player playerAttacked : players) {
                        if (playerAttacked.getColor() == color) {
                            backToStart(playerAttacked, numberOfPlayers, grid);
                        }
                    }
                } else if (grid.grid[positionX][positionY + i].getState() == 'S') {
                } else if (grid.grid[positionX][positionY + i].getState() == 'I') {
                    grid.grid[positionX][positionY + i].setState('E');
                } else if (grid.grid[positionX][positionY + i].getState() == 'J') {
                    backToStart(player, numberOfPlayers, grid);
                } else if (positionY + i == 0) {
                }
            case 'E':
                while (grid.grid[positionX + i][positionY].getState() == 'E') {
                    i = i++;
                }
                if (grid.grid[positionX + i][positionY].getState() == 'T') {
                    String color = grid.grid[positionX + i][positionY].getTurtle();
                    for (Player playerAttacked : players) {
                        if (playerAttacked.getColor() == color) {
                            backToStart(playerAttacked, numberOfPlayers, grid);
                        }
                    }
                } else if (grid.grid[positionX + i][positionY].getState() == 'S') {
                } else if (grid.grid[positionX + i][positionY].getState() == 'I') {
                    grid.grid[positionX + i][positionY].setState('E');
                } else if (grid.grid[positionX + i][positionY].getState() == 'J') {
                    backToStart(player, numberOfPlayers, grid);
                } else if (positionX + i == 0) {
                }
        }
    }
}
