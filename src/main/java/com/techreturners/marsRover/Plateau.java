package com.techreturners.marsRover;

import java.util.HashMap;

public class Plateau {
    private final int width;
    private final int height;
    private HashMap<Rover,Position> rovers;

    public Plateau (int width, int height){
        this.width = width;
        this.height = height;
        this.rovers = new HashMap<>();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void connectPlateauRover (Rover r){
       this.rovers.put(r,r.getPosition());
    }

    public HashMap<Rover,Position> getRovers(){
        return this.rovers;
    }
}
