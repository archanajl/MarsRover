package com.techreturners.marsRover;

import java.util.HashMap;

public class Plateau {
    private final int width;
    private final int height;
    private HashMap<Position,Rover> rovers;

    public Plateau (int width, int height){
        this.width = width;
        this.height = height;
        this.rovers = new HashMap<>();
    }

    public void connectPlateauRover ( Rover r){
       this.rovers.put(r.getPosition(), r);
    }
}
