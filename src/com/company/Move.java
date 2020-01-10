package com.company;

public class Move {

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


    public static void BackToStart(Player player, int numberOfPlayers) {
        switch (numberOfPlayers) {
            case 3:
                switch(color){
                    case "orange":

                        grid[1][0].setTurtle("orange");
                        break;
                    case "green":
                        grid[3][0].setTurtle("green");
                        break;
                    case "blue";
                        grid[6][0].setTurtle("blue");
                        break;
                }
                break;
            case 3:


    }
}
