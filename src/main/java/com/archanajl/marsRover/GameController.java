package com.archanajl.marsRover;

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
        boolean isCreated = true;
        PlateauController plateauControl = new PlateauController();
        if (!plateauControl.checkRoverCollision(plateau,rover,rover.getPosition(),rover.getPosition(),isCreated)){
            plateauControl.connectPlateauRover(plateau,rover);
        }
        else {
            rover = null;
        }
        return rover;
    }

    public boolean moveRover( Rover rover, String command ){
        boolean isCreated = false;
        Position newPosition, currentPosition;
        RoverController roverControl = new RoverController();
        currentPosition = rover.getPosition();
        newPosition = roverControl.moveRover(plateau,rover,command);
        PlateauController plateauControl = new PlateauController();
        if (plateauControl.checkRoverCollision(plateau,rover,newPosition,currentPosition, isCreated)) {
            return false;
        }
        return true;
    }

    public StringBuilder displayGrid(){
        GridDisplay gd = new GridDisplay();
        StringBuilder gridDisplay
                = new StringBuilder();
        if (plateau != null) {
            gridDisplay = gd.displayGrid(plateau.getWidth(), plateau.getHeight(), plateau.getRovers());

        }
        return gridDisplay;
    }

}
