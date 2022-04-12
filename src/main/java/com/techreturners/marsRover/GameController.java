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
        if (!plateauControl.checkRoverCollision(plateau,rover)){
            plateauControl.connectPlateauRover(plateau,rover);
        }
        else {
            rover = null;
        }
        return rover;
    }

    public Position moveRover(Rover rover, String command ){
        Position newPosition;
        RoverController roverControl = new RoverController();
        newPosition = roverControl.moveRover(rover,command);
        return newPosition;
    }

}
