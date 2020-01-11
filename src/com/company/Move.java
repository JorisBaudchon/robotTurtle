package com.company;

import java.util.ArrayList;

import com.company.Game.*;

public class Move extends Grid {

    public static void LeftRotation(Player player) {
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

    public static void RightRotation(Player player) {
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

    public void BackToStart(Player player, int numberOfPlayers) {
        String color = player.getColor();
        grid[player.getPositionX()][player.getPositionY()].setState('E');
        switch (numberOfPlayers) {
            case 2:
                switch (color) {
                    case "orange":
                        grid[0][1].setTurtle("orange");
                        player.setPositionX(0);
                        player.setPositionY(1);
                        player.setOrientation('S');
                        break;
                    case "green":
                        grid[0][5].setTurtle("green");
                        player.setPositionX(0);
                        player.setPositionY(5);
                        player.setOrientation('S');
                        break;
                }
            case 3:
                switch (color) {
                    case "orange":
                        grid[0][1].setTurtle("orange");
                        player.setPositionX(0);
                        player.setPositionY(1);
                        player.setOrientation('S');
                        break;
                    case "green":
                        grid[0][3].setTurtle("green");
                        player.setPositionX(0);
                        player.setPositionY(3);
                        player.setOrientation('S');
                        break;
                    case "blue":
                        grid[0][0].setTurtle("blue");
                        player.setPositionX(6);
                        player.setPositionY(0);
                        player.setOrientation('S');
                        break;
                }
            case 4:
                switch (color) {
                    case "orange":
                        grid[0][6].setTurtle("orange");
                        player.setPositionX(0);
                        player.setPositionY(6);
                        player.setOrientation('S');
                        break;
                    case "green":
                        grid[0][2].setTurtle("green");
                        player.setPositionX(0);
                        player.setPositionY(2);
                        player.setOrientation('S');
                        break;
                    case "blue":
                        grid[0][5].setTurtle("blue");
                        player.setPositionX(0);
                        player.setPositionY(5);
                        player.setOrientation('S');
                        break;
                    case "yellow":
                        grid[0][7].setTurtle("yellow");
                        player.setPositionX(0);
                        player.setPositionY(7);
                        player.setOrientation('S');
                        break;
                }
        }
    }

    public void MoveForward(Player player) {
        grid[player.getPositionX()][player.getPositionY()].setState('E');
        char orientation = player.getOrientation();
        int positionY = player.getPositionY();
        int positionX = player.getPositionX();
        String color = player.getColor();
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
        grid[positionX][positionY].setTurtle(color);
        player.setPositionY(positionY);
        player.setPositionX(positionX);
    }

    public void LazerShot(Player player, Grid grid[][], ArrayList<Player> players, int numberOfPlayers) {
        char orientation = player.getOrientation();
        int positionY = player.getPositionY();
        int positionX = player.getPositionX();
        int i = 0;
        int j = 0;

        switch (orientation) {
            case 'N':
                while (this.grid[positionX][positionY - i].getState() == 'E') {
                    i = i++;
                }
                if (this.grid[positionX][positionY - i].getState() == 'T') {
                    String color = this.grid[positionX][positionY - i].getTurtle();
                    for (Player playerAttacked : players) {
                        if (playerAttacked.getColor() == color) {
                            BackToStart(playerAttacked, numberOfPlayers);
                        }
                    }
                } else if (this.grid[positionX][positionY - i].getState() == 'W') {
                } else if (this.grid[positionX][positionY - i].getState()=='I'){
                    this.grid[positionX][positionY - i].setState('E');
                } else if (this.grid[positionX][positionY - i].getState()=='J') {
                    BackToStart(player, numberOfPlayers);
                } else if (positionY-i == 0) {}
                
                    case 'W':


        }
    }
}
