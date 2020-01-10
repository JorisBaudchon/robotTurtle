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
        } else if (cell.isAJewel() == true) {
            return "jewel";
        } else {
            return "error";
        }
    }
<<<<<<< HEAD

    public static IsMovementPossible (){
        if (CellStatut(Cell cell)=="empty"){

        }

    }

}

=======
}
>>>>>>> 6c5e50073b58249e3ccebf6479256c00dbfe69dd
