# _Mars Rover Project_

### <ins>Goal of the application</ins>

As part of a team that explores Mars by sending remotely controlled vehicles to the surface of the planet. 
Develop an API that translates the commands sent from earth to instructions that are understood by the rover.
Refer to the [pdf](https://github.com/archanajl/MarsRover/tree/master/docs/MarsRoverMission.pdf) document for more information 
Click [here](https://kata-log.rocks/mars-rover-kata) to have more ideas/ suggestions.

### <ins>Rules of the game</ins>

Assumptions:

  - The inputs regarding the plateau and rover are given by the user along with the number of rovers he needs tp place.
  - The plateau is considered to be rectangular. But this should be easily extended to include more complications in future.
  - When initial position of Rover is specified, if there is a collision, the rover will not be considered.
  - If there is a collision while moving the rover, then the rover is placed back at its initial position.
  - When the rover reaches the edges of plateau, it just wraps around.

### <ins>Key Features of the application</ins>

  The console application takes care of all the validations of the instructions when the user enters them and keeps it very interactive.
  
  It checks for the following:
  
  - Size of the plateau falls within a specified range

  - The rover initial position is given as x, y , direction(N,W,S,E)

  - The command String is given by the following characters : L,R,M (Left, Right, Move)

  - The user will be allowed to enter as many rovers as he has specified in the start.

### <ins>Approach to the solution</ins>

  - Step One:

    As it is a TDD based application, I started off by writing a basic testcase of reading just one line of input : 
    the plateau size.
    Moved on to creating the plateau and getting a success message of plateau created.

  - Step Two:
  
    As a next step I also included first rover position and added different scenarios of valid values.
    Then I made sure the rovers are created.
    As a continuation, I connected the rovers to the plateau and checked whether the Rovers map was created.
  
  - Step Three:
  
    Now it was time to check the command string. After validating the string, I made sure the command works from single 
    movement to multiple movements. Made sure the rovers returned proper position.
  

  - Step Four:
  
    What happens when there's a collision. That was the next step. Check whether there is another rover existing in its
    destination. If so, then return false and rover will not be registered if it is start and not moved if it is an 
    existing rover.
  
  - Step Five:
    
    Instead of checking at destination, I changed it to check throughout the path of the movement and return to 
    original position if there is a collision.
  

  - Yet to be done:

    Display the plateau with rovers at the respective positions.
    
    On collision, I would like the rover to move till the last available location.
   
    While creating a plateau, I would like to randomly place some samples. If the rover moves over it, it will collect 
    them and report it back to the plateau.  At the end, these will be displayed as list against each rover.


### <ins> Testcases </ins>

Please click [here](https://htmlpreview.github.io/?https://github.com/archanajl/MarsRover/blob/master/docs/Test%20Results%20-%20InputConsoleTest.html) to see the test results.
### <ins>Technologies Used</ins>

    Java
    maven
    JUnit 5

### <ins>How to run the application and tests</ins>

To run the tests, use the following command:

    mvn test
    
