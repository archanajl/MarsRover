package com.techreturners.marsRover;

public class RoverController {

    public Position moveRover(Rover rover, String command ){
        Position newPosition = new Position(0,0,Direction.NORTH);
        rover.setPosition(newPosition);
        return newPosition;
    }
}
