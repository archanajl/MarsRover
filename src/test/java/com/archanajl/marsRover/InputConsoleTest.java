package com.archanajl.marsRover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
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

    @Test
    public void checkcreatePlateauRover() throws Exception {
        System.setIn(new ByteArrayInputStream("4 4\n1\n1 2 N\n".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Rover Created", outputLines[5]);
    }

    @Test
    public void checkcreatePlateauRoverWithDirectionWrong() throws Exception {
        System.setIn(new ByteArrayInputStream("4 4\n1\n1 2 P".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Please enter valid values of the x , y and direction.", outputLines[5]);
    }

    @Test
    public void checkcreatePlateauRoverWithOnlyXYForRover() throws Exception {
        System.setIn(new ByteArrayInputStream("4 4\n1\n1 2".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Please enter the values of the x , y and direction.", outputLines[5]);
    }

    @Test
    public void checkcreatePlateauRoverWithXYaboveRange() throws Exception {
        System.setIn(new ByteArrayInputStream("2 2\n1\n3 3 N".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Please enter valid values of the x , y and direction.", outputLines[5]);
    }

    @Test
    public void checkmoveRoverWithWrongCommand() throws Exception {
        System.setIn(new ByteArrayInputStream("4 4\n1\n1 2 N\nLMLMS".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Please enter only valid commands. Only L,R,M allowed.", outputLines[7]);
    }

    @Test
    public void checkmoveRoverWithValidCommandCharacters() throws Exception {
        System.setIn(new ByteArrayInputStream("4 4\n1\n1 2 N\nLMLM".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Rover moved successfully", outputLines[7]);
    }

    @Test
    public void checkmoveRoverWithValidCommandWithOneSet() throws Exception {
        System.setIn(new ByteArrayInputStream("4 4\n1\n1 2 N\nLM".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Rover position is : 0 2 W", outputLines[8]);
    }

    @Test
    public void checkmoveRoverWithValidCommandWithMoreLM() throws Exception {
        System.setIn(new ByteArrayInputStream("5 5\n1\n1 2 N\nLMLMLMLMM".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Rover position is : 1 3 N", outputLines[8]);
    }

    @Test
    public void checkmoveRoverWithValidCommandWithMoreRM() throws Exception {
        System.setIn(new ByteArrayInputStream("5 5\n1\n3 3 E\nMMRMMRMRRM".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Rover position is : 5 1 E", outputLines[8]);
    }

    @Test
    public void checkenterTwoValidRovers() throws Exception {
        System.setIn(new ByteArrayInputStream("5 5\n2\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Rovers positioned successfully!", outputLines[14]);
    }

    @Test
    public void checkenterTwoRoversAtCollision() throws Exception {
        System.setIn(new ByteArrayInputStream("5 5\n2\n1 2 N\nM\n1 1 N\nMM".getBytes()));
        InputConsole.main(new String[0]);
        String[] outputLines  = byteArrayOutputStream.toString().split("\n");
        Assertions.assertEquals("Rover can not be at this position as it encountered an obstacle.", outputLines[13]);
    }
}
