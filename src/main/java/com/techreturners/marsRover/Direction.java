package com.techreturners.marsRover;

public enum Direction {
    N,
    S,
    W,
    E ;

    public static boolean contains(String s) {
        try {
            Direction.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
