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

    public boolean createRover(int x, int y, String d){
        RoverController roverControl = new RoverController();
        rover = roverControl.createRover(x, y,d);
        connectPlateauRover();
        if (rover != null) return true;
        else return false;
    }

    public void connectPlateauRover(){
        PlateauController pleateauControl = new PlateauController();
        pleateauControl.connectPlateauRover(plateau,rover);
    }
}
