package com.techreturners.marsRover;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;


public class InputConsole {

    private final static int MIN_PLATEAU_SIZE =0;
    private final static int MAX_PLATEAU_SIZE =25;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream(System.out) ;
        PlateauController controller = new PlateauController();
        printStream.println("Enter the size of the plateau(x,y) you wanted to created: (Example: 4 4)");
        boolean validEntry = false;
        String errorMessage = "";
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
                    Plateau plateau = controller.createPlateau(Integer.parseInt(plateauSizeArr[0]), Integer.parseInt(plateauSizeArr[1]));
                    if (plateau != null) {
                        printStream.println("Plateau Created");
                    }else{
                        errorMessage = "Plateau not created. Please try again or quit by Ctrl C";
                    }
                }
                if (!validEntry)
                    printStream.println(errorMessage);
        }


        printStream.println("End");
    }


}
