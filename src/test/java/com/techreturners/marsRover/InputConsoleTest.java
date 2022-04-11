package com.techreturners.marsRover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


public class InputConsoleTest {

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream stdout = System.out;
    private final InputStream stdin = System.in;

    private final static int MIN_PLATEAU_SIZE =0;
    private final static int MAX_PLATEAU_SIZE =25;

    @BeforeEach
    public void setUp() {
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
    }

    @Test
    public void checkcreatePlateau() throws Exception {
        System.setIn(new ByteArrayInputStream("4 4\n".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Plateau Created", outputLines[1]);
    }

    @Test
    public void checkcreatePlateauWithOnlyX() throws Exception {
        System.setIn(new ByteArrayInputStream("4\n".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Please enter both the values of the x and y.", outputLines[1]);
    }

    @Test
    public void checkcreatePlateauWithXaboveRange() throws Exception {
        System.setIn(new ByteArrayInputStream("26 4\n".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Please enter valid both the values of the x and y.(greater than " + MIN_PLATEAU_SIZE + " and below " + MAX_PLATEAU_SIZE + " )", outputLines[1]);
    }

    @Test
    public void checkcreatePlateauWithYaboveRange() throws Exception {
        System.setIn(new ByteArrayInputStream("2 45\n".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Please enter valid both the values of the x and y.(greater than " + MIN_PLATEAU_SIZE + " and below " + MAX_PLATEAU_SIZE + " )", outputLines[1]);
    }
}
