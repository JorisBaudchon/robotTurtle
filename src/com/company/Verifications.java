package com.company;

import java.util.List;
import java.util.Scanner;

public class Verifications {
    public static Scanner scTxt = new Scanner(System.in);
    public static Scanner scNb = new Scanner(System.in);

    public static String CellStatut(Cell cell) {
        if (cell.isEmpty() == true) {
            return "empty";
        } else if (cell.isAJewel() == true) {
            return "jewel";
        } else if (cell.isAnIceWall() == true) {
            return "icewall";
        } else if (cell.isAWall() == true) {
            return "wall";
        } else if (cell.isATurtle() == true) {
            return "turtle";
<<<<<<< HEAD
        } else if (cell.isAJewel() == true) {
            return "jewel";
=======
        } else {
            return "error";
>>>>>>> e05b90ce79de20a434e8c646e9bf60134f43ef54
        }
        return "error";
    }

    public static

}

