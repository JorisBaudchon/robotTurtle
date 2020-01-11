package com.company;

public class Move extends Grid {

    public static void leftRotation(Player player) {
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

    public static void rightRotation(Player player) {
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

    public void backToStart(Player player, int numberOfPlayers) {
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

    public void moveForward(Player player){
        grid[player.getPositionX()][player.getPositionY()].setState('E');
        char orientation = player.getOrientation();
        int positionY=player.getPositionY();
        int positionX=player.getPositionX();
        String color = player.getColor();
        switch(orientation) {
            case 'N':
                positionY=positionY-1;
                break;
            case 'W':
                positionX=positionX-1;
                break;
            case 'E':
                positionX=positionX+1;
                break;
            case 'S':
                positionY = positionY+1;
                break;
        }
        grid[positionX][positionY].setTurtle(color);
        player.setPositionY(positionY);
        player.setPositionX(positionX);
    }

}
