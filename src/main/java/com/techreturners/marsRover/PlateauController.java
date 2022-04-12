package com.techreturners.marsRover;

import java.util.HashMap;
import java.util.Map;

public class PlateauController {

    public Plateau createPlateau(int x, int y){
        Plateau plateau = new Plateau( x, y);
        return plateau;
    }

    public void connectPlateauRover(Plateau plateau, Rover rover){
        plateau.connectPlateauRover(rover);
    }

    public boolean checkRoverCollision(Plateau plateau, Rover rover, Position position){
        HashMap<Rover,Position> plateauRovers;
        plateauRovers = plateau.getRovers();
        boolean isCollision = false;
        for (Map.Entry<Rover,Position> set :
                plateauRovers.entrySet()) {
            if ((set.getValue().getX() == position.getX()) && (set.getValue().getY() == position.getY())){
                isCollision = true;
                System.out.println("Bang");
                break;
            }
        }
        return isCollision;
    }
}
