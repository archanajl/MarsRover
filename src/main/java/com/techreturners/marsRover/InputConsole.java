package com.techreturners.marsRover;

import java.io.PrintStream;
import java.util.*;


public class InputConsole {

    private final static int MIN_PLATEAU_SIZE =0;
    private final static int MAX_PLATEAU_SIZE =25;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream(System.out) ;
        GameController gController = new GameController();

        printStream.println("Enter the size of the plateau(x,y) you wanted to created: (Example: 4 4)");
        boolean validEntry = false;
        String errorMessage = "";
        Boolean plateau;
        int plateauX = 0;
        int plateauY = 0;
        while (!validEntry && scanner.hasNextLine() ) {
            String line = scanner.nextLine().trim();
            String[] plateauSizeArr = line.split(" ");
            if (line.isBlank())
                validEntry = false;
            else
                if (plateauSizeArr.length < 2) {
                    validEntry = false;
                    errorMessage = "Please enter both the values of the x and y.";
                } else if (Integer.parseInt(plateauSizeArr[0]) < MIN_PLATEAU_SIZE || Integer.parseInt(plateauSizeArr[0]) > MAX_PLATEAU_SIZE
                        || Integer.parseInt(plateauSizeArr[1]) < MIN_PLATEAU_SIZE || Integer.parseInt(plateauSizeArr[1]) > MAX_PLATEAU_SIZE) {
                    errorMessage = "Please enter valid both the values of the x and y.(greater than " + MIN_PLATEAU_SIZE + " and below " + MAX_PLATEAU_SIZE + " )";
                }else {
                    plateau = gController.createPlateau(Integer.parseInt(plateauSizeArr[0]), Integer.parseInt(plateauSizeArr[1]));
                    if (plateau) {
                        plateauX = Integer.parseInt(plateauSizeArr[0]);
                        plateauY = Integer.parseInt(plateauSizeArr[1]);
                        printStream.println("Plateau Created");
                        break;
                    }else{
                        errorMessage = "Plateau not created. Please try again or quit by Ctrl C";
                    }
                }
                if (!validEntry)
                    printStream.println(errorMessage);
        }
        printStream.println("Enter the initial position of Rover");
        String[] Directions = {"N","S","W","E"};
        List <String> DirectionsList = Arrays.asList(Directions);
        Rover rover = new Rover();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine().trim();
            String[] roverInitialArr = line.split(" ");
            if (line.isBlank())
                validEntry = false;
            else if (roverInitialArr.length < 3) {
                validEntry = false;
                errorMessage = "Please enter the values of the x , y and direction.";
            } else if (Integer.parseInt(roverInitialArr[0]) > plateauX || Integer.parseInt(roverInitialArr[0]) < MIN_PLATEAU_SIZE
                    || Integer.parseInt(roverInitialArr[1]) > plateauY || Integer.parseInt(roverInitialArr[1]) < MIN_PLATEAU_SIZE
                    || !Direction.contains(roverInitialArr[2].trim()))
                {
                errorMessage = "Please enter valid values of the x , y and direction.";
            }else {
                 rover = gController.createRover(Integer.parseInt(roverInitialArr[0]), Integer.parseInt(roverInitialArr[1]),roverInitialArr[2] );
                if (rover.getPosition() != null) {
                    printStream.println("Rover Created");
                    break;
                }else{
                    errorMessage = "Rover not created. Please try again or quit by Ctrl C";
                }
            }
            if (!validEntry)
                printStream.println(errorMessage);
        }
        printStream.println("Enter the command for moving the  Rover");
        while(scanner.hasNextLine()){
            boolean isValidRoverMove;
            Position newPosition, currentPosition;
            String line = scanner.nextLine().trim();
            currentPosition = rover.getPosition();
            if (line.isBlank())
                validEntry = false;
            else if (!line.matches("[LRM]*")){
                errorMessage = "Please enter only valid commands. Only L,R,M allowed.";
            }else {
                isValidRoverMove = gController.moveRover(rover, line);
                if (isValidRoverMove) {
                    printStream.println("Rover moved successfully");
                    printStream.println("Rover position is : " + rover.getPosition().getX()
                            + " " + rover.getPosition().getY() + " " + rover.getPosition().getDirection() );
                    break;
                }else{
                    errorMessage = "Rover can not be moved to this position, Try another position";
                }
            }
            if (!validEntry)
                printStream.println(errorMessage);
        }

        printStream.println("End");
    }


}
