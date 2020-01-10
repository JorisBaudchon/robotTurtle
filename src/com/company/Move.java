package com.company;

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
        switch (numberOfPlayers) {

            case 3:
                switch (color) {
                    case "orange":
                        grid[player.getPositionX()][player.getPositionY()].setState('E');
                        grid[1][0].setTurtle("orange");
                        break;
                    case "green":
                        grid[player.getPositionX()][player.getPositionY()].setState('E');
                        grid[3][0].setTurtle("green");
                        break;
                    case "blue":
                        grid[player.getPositionX()][player.getPositionY()].setState('E');
                        grid[6][0].setTurtle("blue");
                        break;
                }
            case 4:
                switch(color) {
                    case "orange":
                        grid[player.getPositionX()][player.getPositionY()].setState('E');
                        grid[0][0].setTurtle("orange");
                        break;
                    case "green":
                        grid[player.getPositionX()][player.getPositionY()].setState('E');
                        grid[2][0].setTurtle("green");
                        break;
                    case "blue":
                        grid[player.getPositionX()][player.getPositionY()].setState('E');
                        grid[5][0].setTurtle("blue");
                        break;
                    case "yellow":
                        grid[player.getPositionX()][player.getPositionY()].setState('E');
                        grid[7][0].setTurtle("yellow");
                }
        }
    }
}
