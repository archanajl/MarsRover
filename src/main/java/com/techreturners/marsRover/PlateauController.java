package com.techreturners.marsRover;

public class PlateauController {

    public boolean createPlateau(int x, int y){

        if (x != y ) {
            return false;
        }
        Plateau plateau = new Plateau( x, y);
        return true;

    }
}
