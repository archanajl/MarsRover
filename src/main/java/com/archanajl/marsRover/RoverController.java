package com.archanajl.marsRover;

public class RoverController {

    public Position moveRover(Plateau plateau,Rover rover, String command ){
        Position currentPosition = rover.getPosition();
        int plateauX = plateau.getWidth() ;
        int plateauY = plateau.getHeight();
        int currentX = currentPosition.getX();
        int currentY = currentPosition.getY();
        Direction currentDir = currentPosition.getDirection();
        boolean isValidMove = false;
        for (int i=0; i<= command.length() - 1; i++) {
            if (command.charAt(i) == 'L') {
                currentDir = switch (currentDir) {
                    case N:
                        yield Direction.W;
                    case W:
                        yield Direction.S;
                    case S:
                        yield Direction.E;
                    case E:
                        yield Direction.N;
                };

            } else if (command.charAt(i) == 'R') {
                currentDir = switch (currentDir) {
                    case N:
                        yield Direction.E;
                    case E:
                        yield Direction.S;
                    case S:
                        yield Direction.W;
                    case W:
                        yield Direction.N;
                };

            }else if (command.charAt(i) == 'M') {

                switch (currentDir) {
                    case N:
                        currentY++;
                        if (currentY > plateauY) currentY =1;
                        break;

                    case E:
                        currentX++;
                        if (currentX > plateauX) currentX =1;
                        break;
                    case S:
                        currentY--;
                        if (currentY <0 ) currentY =plateauY;
                        break;
                    case W:
                        currentX--;
                        if (currentX < 0) currentX = plateauX;
                        break;

                };
            }
        }
        Position newPosition = new Position(currentX, currentY, currentDir);
        return newPosition;
    }

    public Rover createRover(int x, int y, String d){
        Direction dir = switch (d) {
                            case "N":
                                yield Direction.N;
                            case "S":
                                yield Direction.S;
                            case "W":
                                yield Direction.W;
                            case "E":
                                yield Direction.E;
                            default:
                                throw new IllegalStateException("Unexpected value: " + d);
                        };
        Position position = new Position(x,y,dir);
        Rover rover = new Rover(position);
        return rover;
    }
}
