package com.company;

import java.util.ArrayList;

public class Move {

    static void leftRotation(Player player, GraphicalUserInterface gui) {
        char orientation = player.getOrientation();
        String color = player.getColor();
        switch (orientation) {
            case 'N':
                orientation = 'E';
                switch (color) {
                    case "orange":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.orangeTurtleO);
                        break;
                    case "green":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.greenTurtleO);
                        break;
                    case "blue":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.blueTurtleO);
                        break;
                    case "yellow":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.yellowTurtleO);
                        break;
                }
                break;
            case 'W':
                orientation = 'N';
                switch (color) {
                    case "orange":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.orangeTurtleN);
                        break;
                    case "green":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.greenTurtleN);
                        break;
                    case "blue":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.blueTurtleN);
                        break;
                    case "yellow":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.yellowTurtleN);
                        break;
                }
                break;
            case 'S':
                orientation = 'W';
                switch (color) {
                    case "orange":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.orangeTurtleE);
                        break;
                    case "green":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.greenTurtleE);
                        break;
                    case "blue":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.blueTurtleE);
                        break;
                    case "yellow":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.yellowTurtleE);
                        break;
                }
                break;
            case 'E':
                orientation = 'S';
                switch (color) {
                    case "orange":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.orangeTurtleS);
                        break;
                    case "green":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.greenTurtleS);
                        break;
                    case "blue":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.blueTurtleS);
                        break;
                    case "yellow":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.yellowTurtleS);
                        break;
                }
                break;
        }
        player.setOrientation(orientation);
    }

    static void rightRotation(Player player, GraphicalUserInterface gui) {
        char orientation = player.getOrientation();
        String color = player.getColor();
        switch (orientation) {
            case 'N':
                orientation = 'W';
                switch (color) {
                    case "orange":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.orangeTurtleE);
                        break;
                    case "green":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.greenTurtleE);
                        break;
                    case "blue":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.blueTurtleE);
                        break;
                    case "yellow":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.yellowTurtleE);
                        break;
                }
                break;
            case 'W':
                orientation = 'S';
                switch (color) {
                    case "orange":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.orangeTurtleS);
                        break;
                    case "green":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.greenTurtleS);
                        break;
                    case "blue":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.blueTurtleS);
                        break;
                    case "yellow":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.yellowTurtleS);
                        break;
                }
                break;
            case 'S':
                orientation = 'E';
                switch (color) {
                    case "orange":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.orangeTurtleO);
                        break;
                    case "green":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.greenTurtleO);
                        break;
                    case "blue":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.blueTurtleO);
                        break;
                    case "yellow":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.yellowTurtleO);
                        break;
                }
                break;
            case 'E':
                orientation = 'N';
                switch (color) {
                    case "orange":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.orangeTurtleN);
                        break;
                    case "green":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.greenTurtleN);
                        break;
                    case "blue":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.blueTurtleN);
                        break;
                    case "yellow":
                        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(gui.yellowTurtleN);
                        break;
                }
                break;
        }
        player.setOrientation(orientation);
    }

    private void backToStart(Player player, int numberOfPlayers, Grid grid, GraphicalUserInterface gui) {
        String color = player.getColor();
        grid.grid[player.getPositionX()][player.getPositionY()].setState('E');
        gui.btnGrid[player.getPositionX()][player.getPositionY()].setIcon(null);
        switch (numberOfPlayers) {
            case 2:
                switch (color) {
                    case "orange":
                        grid.grid[0][1].setTurtle("orange");
                        player.setPositionX(0);
                        player.setPositionY(1);
                        player.setOrientation('S');
                        gui.btnGrid[0][1].setIcon(gui.orangeTurtleS);
                        break;
                    case "green":
                        grid.grid[0][5].setTurtle("green");
                        player.setPositionX(0);
                        player.setPositionY(5);
                        player.setOrientation('S');
                        gui.btnGrid[0][5].setIcon(gui.greenTurtleS);
                        break;
                }
                break;
            case 3:
                switch (color) {
                    case "orange":
                        grid.grid[0][1].setTurtle("orange");
                        player.setPositionX(0);
                        player.setPositionY(1);
                        player.setOrientation('S');
                        gui.btnGrid[0][1].setIcon(gui.orangeTurtleS);
                        break;
                    case "green":
                        grid.grid[0][3].setTurtle("green");
                        player.setPositionX(0);
                        player.setPositionY(3);
                        player.setOrientation('S');
                        gui.btnGrid[0][3].setIcon(gui.greenTurtleS);
                        break;
                    case "blue":
                        grid.grid[0][0].setTurtle("blue");
                        player.setPositionX(0);
                        player.setPositionY(6);
                        player.setOrientation('S');
                        gui.btnGrid[0][6].setIcon(gui.blueTurtleS);
                        break;
                }
                break;
            case 4:
                switch (color) {
                    case "orange":
                        grid.grid[0][6].setTurtle("orange");
                        player.setPositionX(0);
                        player.setPositionY(0);
                        player.setOrientation('S');
                        gui.btnGrid[0][0].setIcon(gui.orangeTurtleS);
                        break;
                    case "green":
                        grid.grid[0][2].setTurtle("green");
                        player.setPositionX(0);
                        player.setPositionY(2);
                        player.setOrientation('S');
                        gui.btnGrid[0][2].setIcon(gui.greenTurtleS);
                        break;
                    case "blue":
                        grid.grid[0][5].setTurtle("blue");
                        player.setPositionX(0);
                        player.setPositionY(5);
                        player.setOrientation('S');
                        gui.btnGrid[0][5].setIcon(gui.blueTurtleS);
                        break;
                    case "yellow":
                        grid.grid[0][7].setTurtle("yellow");
                        player.setPositionX(0);
                        player.setPositionY(7);
                        player.setOrientation('S');
                        gui.btnGrid[0][7].setIcon(gui.yellowTurtleS);
                        break;
                }
                break;
        }
    }

    void moveForward(Player player, Grid grid, int numberOfPlayers, ArrayList<Player> finishedPlayers, ArrayList<Player> orderedPlayers, GraphicalUserInterface gui) {
        char orientation = player.getOrientation();
        int positionY = player.getPositionY();
        int positionX = player.getPositionX();
        grid.grid[positionX][positionY].setState('E');
        String color = player.getColor();
        switch (orientation) {
            case 'N':
                if (positionX - 1 < 0 || positionX - 1 > 7) {
                    backToStart(player, numberOfPlayers, grid, gui);
                }
                switch (grid.grid[positionX - 1][positionY].getState()) {
                    case 'E':
                        positionX = positionX - 1;
                        grid.grid[positionX][positionY].setTurtle(color);
                        grid.grid[positionX][positionY].setState('T');
                        player.setPositionY(positionY);
                        player.setPositionX(positionX);
                        switch (color) {
                            case "orange":
                                switch (player.getOrientation()) {
                                    case 'S':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleS);
                                        break;
                                    case 'W':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleE);
                                        break;
                                    case 'E':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleO);
                                        break;
                                    case 'N':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleN);
                                        break;
                                }
                                break;
                            case "green":
                                switch (player.getOrientation()) {
                                    case 'S':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleS);
                                        break;
                                    case 'W':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleE);
                                        break;
                                    case 'E':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleO);
                                        break;
                                    case 'N':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleN);
                                        break;
                                }
                                break;
                            case "blue":
                                switch (player.getOrientation()) {
                                    case 'S':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleS);
                                        break;
                                    case 'W':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleE);
                                        break;
                                    case 'E':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleO);
                                        break;
                                    case 'N':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleN);
                                        break;
                                }
                                break;
                            case "yellow":
                                switch (player.getOrientation()) {
                                    case 'S':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleS);
                                        break;
                                    case 'W':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleE);
                                        break;
                                    case 'E':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleO);
                                        break;
                                    case 'N':
                                        gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleN);
                                        break;
                                }
                                break;
                        }
                        gui.btnGrid[positionX + 1][positionY].setIcon(null);
                        break;
                    case 'J':
                        player.setFinished(true);
                        finishedPlayers.add(player);
                        orderedPlayers.remove(player);
                        break;
                    case 'T':
                        backToStart(player, numberOfPlayers, grid, gui);
                        String secondTurtle = grid.grid[positionX - 1][positionY].getTurtle();
                        for (int i = 0; i <= orderedPlayers.size(); i++) {
                            if (secondTurtle.equals(orderedPlayers.get((i)).getColor())) {
                                backToStart(orderedPlayers.get(i), numberOfPlayers, grid, gui);
                            }
                        }
                        break;
                }
                break;
            case 'W':
                if (positionY - 1 < 0 || positionY - 1 > 7) {
                    backToStart(player, numberOfPlayers, grid, gui);
                } else {
                    switch (grid.grid[positionX][positionY - 1].getState()) {
                        case 'E':
                            positionY = positionY - 1;
                            grid.grid[positionX][positionY].setTurtle(color);
                            grid.grid[positionX][positionY].setState('T');
                            player.setPositionY(positionY);
                            player.setPositionX(positionX);
                            switch (color) {
                                case "orange":
                                    switch (player.getOrientation()) {
                                        case 'S':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleS);
                                            break;
                                        case 'W':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleE);
                                            break;
                                        case 'E':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleO);
                                            break;
                                        case 'N':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleN);
                                            break;
                                    }
                                    break;
                                case "green":
                                    switch (player.getOrientation()) {
                                        case 'S':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleS);
                                            break;
                                        case 'W':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleE);
                                            break;
                                        case 'E':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleO);
                                            break;
                                        case 'N':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleN);
                                            break;
                                    }
                                    break;
                                case "blue":
                                    switch (player.getOrientation()) {
                                        case 'S':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleS);
                                            break;
                                        case 'W':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleE);
                                            break;
                                        case 'E':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleO);
                                            break;
                                        case 'N':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleN);
                                            break;
                                    }
                                    break;
                                case "yellow":
                                    switch (player.getOrientation()) {
                                        case 'S':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleS);
                                            break;
                                        case 'W':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleE);
                                            break;
                                        case 'E':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleO);
                                            break;
                                        case 'N':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleN);
                                            break;
                                    }
                                    break;
                            }
                            gui.btnGrid[positionX][positionY + 1].setIcon(null);
                            break;
                        case 'J':
                            player.setFinished(true);
                            finishedPlayers.add(player);
                            orderedPlayers.remove(player);
                            break;
                        case 'T':
                            backToStart(player, numberOfPlayers, grid, gui);
                            String secondTurtle = grid.grid[positionX][positionY - 1].getTurtle();
                            for (int i = 0; i < orderedPlayers.size(); i++) {
                                if (secondTurtle.equals(orderedPlayers.get((i)).getColor())) {
                                    backToStart(orderedPlayers.get(i), numberOfPlayers, grid, gui);
                                }
                            }
                            break;
                    }
                }
                break;
            case 'E':
                if (positionY + 1 < 0 || positionY + 1 > 7) {
                    backToStart(player, numberOfPlayers, grid, gui);
                } else {
                    switch (grid.grid[positionX][positionY + 1].getState()) {
                        case 'E':
                            positionY = positionY + 1;
                            grid.grid[positionX][positionY].setTurtle(color);
                            grid.grid[positionX][positionY].setState('T');
                            player.setPositionY(positionY);
                            player.setPositionX(positionX);
                            switch (color) {
                                case "orange":
                                    switch (player.getOrientation()) {
                                        case 'S':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleS);
                                            break;
                                        case 'W':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleE);
                                            break;
                                        case 'E':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleO);
                                            break;
                                        case 'N':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleN);
                                            break;
                                    }
                                    break;
                                case "green":
                                    switch (player.getOrientation()) {
                                        case 'S':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleS);
                                            break;
                                        case 'W':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleE);
                                            break;
                                        case 'E':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleO);
                                            break;
                                        case 'N':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleN);
                                            break;
                                    }
                                    break;
                                case "blue":
                                    switch (player.getOrientation()) {
                                        case 'S':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleS);
                                            break;
                                        case 'W':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleE);
                                            break;
                                        case 'E':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleO);
                                            break;
                                        case 'N':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleN);
                                            break;
                                    }
                                    break;
                                case "yellow":
                                    switch (player.getOrientation()) {
                                        case 'S':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleS);
                                            break;
                                        case 'W':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleE);
                                            break;
                                        case 'E':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleO);
                                            break;
                                        case 'N':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleN);
                                            break;
                                    }
                                    break;
                            }
                            gui.btnGrid[positionX][positionY - 1].setIcon(null);
                            break;
                        case 'J':
                            player.setFinished(true);
                            finishedPlayers.add(player);
                            orderedPlayers.remove(player);
                            break;
                        case 'T':
                            backToStart(player, numberOfPlayers, grid, gui);
                            String secondTurtle = grid.grid[positionX][positionY + 1].getTurtle();
                            for (int i = 0; i <= orderedPlayers.size(); i++) {
                                if (secondTurtle.equals(orderedPlayers.get((i)).getColor())) {
                                    backToStart(orderedPlayers.get(i), numberOfPlayers, grid, gui);
                                }
                            }
                            break;
                    }
                    break;
                }
            case 'S':
                if (positionX + 1 < 0 || positionX + 1 > 7) {
                    backToStart(player, numberOfPlayers, grid, gui);
                } else {
                    switch (grid.grid[positionX + 1][positionY].getState()) {
                        case 'E':
                            positionX = positionX + 1;
                            grid.grid[positionX][positionY].setTurtle(color);
                            grid.grid[positionX][positionY].setState('T');
                            player.setPositionY(positionY);
                            player.setPositionX(positionX);
                            switch (color) {
                                case "orange":
                                    switch (player.getOrientation()) {
                                        case 'S':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleS);
                                            break;
                                        case 'W':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleE);
                                            break;
                                        case 'E':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleO);
                                            break;
                                        case 'N':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.orangeTurtleN);
                                            break;
                                    }
                                    break;
                                case "green":
                                    switch (player.getOrientation()) {
                                        case 'S':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleS);
                                            break;
                                        case 'W':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleE);
                                            break;
                                        case 'E':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleO);
                                            break;
                                        case 'N':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.greenTurtleN);
                                            break;
                                    }
                                    break;
                                case "blue":
                                    switch (player.getOrientation()) {
                                        case 'S':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleS);
                                            break;
                                        case 'W':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleE);
                                            break;
                                        case 'E':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleO);
                                            break;
                                        case 'N':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.blueTurtleN);
                                            break;
                                    }
                                    break;
                                case "yellow":
                                    switch (player.getOrientation()) {
                                        case 'S':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleS);
                                            break;
                                        case 'W':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleE);
                                            break;
                                        case 'E':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleO);
                                            break;
                                        case 'N':
                                            gui.btnGrid[positionX][positionY].setIcon(gui.yellowTurtleN);
                                            break;
                                    }
                                    break;
                            }
                            gui.btnGrid[positionX - 1][positionY].setIcon(null);
                            break;
                        case 'J':
                            player.setFinished(true);
                            finishedPlayers.add(player);
                            orderedPlayers.remove(player);
                            break;
                        case 'T':
                            backToStart(player, numberOfPlayers, grid, gui);
                            String secondTurtle = grid.grid[positionX + 1][positionY].getTurtle();
                            for (int i = 0; i <= orderedPlayers.size(); i++) {
                                if (secondTurtle.equals(orderedPlayers.get((i)))) {
                                    backToStart(orderedPlayers.get(i), numberOfPlayers, grid, gui);
                                }
                            }
                            break;
                    }
                    break;
                }
        }
    }

    void laserShot(Player player, ArrayList<Player> players, int numberOfPlayers, Grid grid, GraphicalUserInterface gui) {
        char orientation = player.getOrientation();
        int positionY = player.getPositionY();
        int positionX = player.getPositionX();
        int i = 0;
        int j = 0;
        switch (orientation) {
            case 'N':
                while ((positionX - i > 0 && positionX - i < 7)) {
                    switch (grid.grid[positionX - i][positionY].getState()) {
                        case 'T':
                            String color = grid.grid[positionX - i][positionY].getTurtle();
                            for (Player playerAttacked : players) {
                                if (playerAttacked.getColor().equals(color)) {
                                    backToStart(playerAttacked, numberOfPlayers, grid, gui);
                                }
                            }
                            i -= 1;
                            break;
                        case 'E':
                            i -= i;
                            break;
                        case 'I':
                            grid.grid[positionX - i][positionY].setState('E');
                            gui.btnGrid[positionX - i][positionY].setIcon(null);
                            i -= 1;
                            break;
                        case 'S':
                            i = -1;
                            break;
                        case 'J':
                            i = -1;
                            break;
                    }
                }
            case 'S':
                while ((positionX + i > 0 && positionX + i < 7)) {
                    switch (grid.grid[positionX + i][positionY].getState()) {
                        case 'T':
                            String color = grid.grid[positionX + i][positionY].getTurtle();
                            for (Player playerAttacked : players) {
                                if (playerAttacked.getColor().equals(color)) {
                                    backToStart(playerAttacked, numberOfPlayers, grid, gui);
                                }
                            }
                            i = i + 1;
                            break;
                        case 'E':
                            i = i + 1;
                            break;
                        case 'I':
                            grid.grid[positionX + i][positionY].setState('E');
                            gui.btnGrid[positionX + i][positionY].setIcon(null);
                            i += 1;
                            break;
                        case 'S':
                            i = -1;
                            break;
                        case 'J':
                            i = -1;
                            break;
                    }
                }
            case 'W':
                while ((positionY - i > 0 && positionY - i < 7)) {
                    switch (grid.grid[positionX][positionY - i].getState()) {
                        case 'T':
                            String color = grid.grid[positionX][positionY - i].getTurtle();
                            for (Player playerAttacked : players) {
                                if (playerAttacked.getColor().equals(color)) {
                                    backToStart(playerAttacked, numberOfPlayers, grid, gui);
                                }
                            }
                            i -= 1;
                            break;
                        case 'E':
                            i -= 1;
                            break;
                        case 'I':
                            grid.grid[positionX][positionY - i].setState('E');
                            gui.btnGrid[positionX][positionY - i].setIcon(null);
                            i -= 1;
                            break;
                        case 'S':
                            i = -1;
                            break;
                        case 'J':
                            i = -1;
                            break;
                    }
                }
            case 'E':
                while ((positionY + i > 0 && positionY + i < 7)) {
                    switch (grid.grid[positionX][positionY + i].getState()) {
                        case 'T':
                            String color = grid.grid[positionX][positionY + i].getTurtle();
                            for (Player playerAttacked : players) {
                                if (playerAttacked.getColor().equals(color)) {
                                    backToStart(playerAttacked, numberOfPlayers, grid, gui);
                                }
                            }
                            i += 1;
                            break;
                        case 'E':
                            i += 1;
                            break;
                        case 'I':
                            grid.grid[positionX][positionY + i].setState('E');
                            gui.btnGrid[positionX][positionY + i].setIcon(null);
                            i += 1;
                            break;
                        case 'S':
                            i = -1;
                            break;
                        case 'J':
                            i = -1;
                            break;
                    }
                }


        }
    }
}
