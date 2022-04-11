package com.techreturners.marsRover;

import java.io.InputStream;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;

public class GameController {


    public GameController() throws Exception{

    }

    public boolean createPlateau(int x, int y){
        PlateauController pleateauControl = new PlateauController();
        return pleateauControl.createPlateau(x, y);
    }


}
