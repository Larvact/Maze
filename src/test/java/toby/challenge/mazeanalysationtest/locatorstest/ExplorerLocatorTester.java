package toby.challenge.mazeanalysationtest.locatorstest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import toby.challenge.mazeanalysation.locators.ExplorerLocator;
import toby.challenge.mazecreation.mazegeneration.Maze;

public class ExplorerLocatorTester {

    private static Maze maze;
    private static String mazeInputString;
    private static ExplorerLocator explorerLocator;
    private final int explorerXCoordinate = 2;
    private final int explorerYCoordinate = 1;

    @BeforeClass
    public static void setupMazeGeneratortest() {
        mazeInputString = "WWWPP;EPPPW;PWWWW;PP*WW;PWPWP";
        maze = new Maze(mazeInputString);
        explorerLocator = new ExplorerLocator(maze);
    }

    @Test
    public void checkThatTheExitXCoordinateIsCorrect(){
        Assert.assertEquals(explorerXCoordinate, explorerLocator.getCoordinate().getxCoordinate());
    }

    @Test
    public void checkThatTheExitYCoordinateIsCorrect(){
        Assert.assertEquals(explorerYCoordinate, explorerLocator.getCoordinate().getyCoordinate());
    }

}
