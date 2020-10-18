package toby.challenge.mazeanalysationtest.locatorstest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import toby.challenge.mazeanalysation.locators.ExitLocator;
import toby.challenge.mazecreation.mazegeneration.Maze;

public class ExitLocatorTester {

    private static Maze maze;
    private static String mazeInputString;
    private static ExitLocator exitLocator;
    private final int exitXCoordinate = 4;
    private final int exitYCoordinate = 3;

    @BeforeClass
    public static void setupMazeGeneratortest() {
        mazeInputString = "WWWPP;EPPPW;PWWWW;PP*WW;PWPWP";
        maze = new Maze(mazeInputString);
        exitLocator = new ExitLocator(maze);
    }

    @Test
    public void checkThatTheExitXCoordinateIsCorrect(){
        Assert.assertEquals(exitXCoordinate, exitLocator.getCoordinate().getxCoordinate());
    }

    @Test
    public void checkThatTheExitYCoordinateIsCorrect(){
        Assert.assertEquals(exitYCoordinate, exitLocator.getCoordinate().getyCoordinate());
    }

}
