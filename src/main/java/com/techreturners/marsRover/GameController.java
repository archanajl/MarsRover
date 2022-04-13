package com.techreturners.marsRover;

import java.io.InputStream;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;

public class GameController {

    private Plateau plateau ;
    private Rover rover;

    public GameController() throws Exception{

    }

    public boolean createPlateau(int x, int y){
        PlateauController pleateauControl = new PlateauController();
        plateau = pleateauControl.createPlateau(x, y);
        if (plateau != null) return true;
        else return false;
    }

    public Rover createRover(int x, int y, String d){
        RoverController roverControl = new RoverController();
        rover = roverControl.createRover(x, y,d);
        PlateauController plateauControl = new PlateauController();
        if (!plateauControl.checkRoverCollision(plateau,rover,rover.getPosition())){
            plateauControl.connectPlateauRover(plateau,rover);
        }
        else {
            rover = null;
        }
        return rover;
    }

    public boolean moveRover( Rover rover, String command ){
        Position newPosition, currentPosition;
        RoverController roverControl = new RoverController();
        currentPosition = rover.getPosition();
        newPosition = roverControl.moveRover(plateau,rover,command);
        PlateauController plateauControl = new PlateauController();
        if (plateauControl.checkRoverCollision(plateau,rover,newPosition)) {
            //rover.setPosition(currentPosition);
            return false;
        }
        /*rover.setPosition(newPosition);
        HashMap<Rover,Position> rovers = plateau.getRovers();
        rovers.remove(rover);
        rovers.put(rover,newPosition);
        plateau.setRovers(rovers);*/
        return true;
    }

}
