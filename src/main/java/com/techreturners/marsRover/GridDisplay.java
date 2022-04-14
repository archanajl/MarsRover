package com.techreturners.marsRover;

import java.util.HashMap;
import java.util.Map;

public class GridDisplay {

    private static final int CELL_SIZE_X = 10;
    private static final int CELL_SIZE_Y = 4;
    private static final int CELL_X_START = 3;
    private static final int CELL_Y_START = 6;

    public StringBuilder displayGrid(int width, int height, HashMap<Rover,Position> rovers){
        StringBuilder gridDisplay = new StringBuilder();
        for (int i=0; i<=height;i++){
            gridDisplay.append("*".repeat(CELL_SIZE_X*(width + 1))+ "*" + System.lineSeparator());
                String str = ("|" + " ".repeat(CELL_SIZE_X-1)).repeat(width + 1) + "|";
                gridDisplay.append( str + System.lineSeparator()) ;
                gridDisplay.append( str + System.lineSeparator()) ;
                gridDisplay.append( str + System.lineSeparator()) ;
        }
        gridDisplay.append("*".repeat(CELL_SIZE_X*(width+1))+ "*" + System.lineSeparator());

        for (Map.Entry<Rover,Position> set :
                rovers.entrySet()) {
            int intX = set.getValue().getX();
            int intY = height - (set.getValue().getY());

            int yPosition = CELL_X_START +(CELL_SIZE_Y * intY);
            int xPosition = CELL_Y_START +(CELL_SIZE_X * intX);

            int finalPosition = ((yPosition-1) * ((CELL_SIZE_X*(width + 1)) + 2)) + xPosition;

            gridDisplay.replace(finalPosition-1,finalPosition,"R");
        }
        return gridDisplay;
    }


}
