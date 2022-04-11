package com.techreturners.marsRover;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputConsole {

    private final static int MIN_PLATEAU_SIZE =0;
    private final static int MAX_PLATEAU_SIZE =25;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        GameController controller = new GameController();
        System.out.println("Enter the size of the plateau(x,y) you wanted to created: (Example: 4 4)");
        boolean validEntry = false;
        String errorMessage = "";
        while (!validEntry) {
            String line = reader.readLine();
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
                    validEntry = controller.createPlateau(Integer.parseInt(plateauSizeArr[0]), Integer.parseInt(plateauSizeArr[1]));
                    if (validEntry) {
                        System.out.println("Plateau Created");
                    }else{
                        errorMessage = "Plateau not created";
                    }
                }
                if (!validEntry)
                System.out.println(errorMessage);
        }

        System.out.println("End");
    }


}
