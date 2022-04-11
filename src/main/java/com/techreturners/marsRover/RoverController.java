package com.techreturners.marsRover;

public class RoverController {

    public Position moveRover(Rover rover, String command ){
        Position newPosition = new Position(0,0,Direction.N);
        rover.setPosition(newPosition);
        return newPosition;
    }

    public Rover createRover(int x, int y, String d){
        Direction dir;
        switch (d){
            case "S":
                dir = Direction.S;
                break;
            case "W":
                dir = Direction.W;
                break;
            case "E":
                dir = Direction.E;
                break;
            default:
                dir = Direction.N;
                break;
        }
        Position newPosition = new Position(0,0,dir);
        Rover rover = new Rover(newPosition);
        return rover;
    }
}
