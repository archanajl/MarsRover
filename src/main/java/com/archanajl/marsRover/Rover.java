package com.archanajl.marsRover;

public class Rover {

    private Position position;

    public Rover (){

    }
    public Rover (Position position){
        this.position = position;
    }

    public void setPosition (Position position){
        this.position = position;
    }

    public Position getPosition(){
        return this.position;
    }

}
