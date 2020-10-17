package toby.challenge.mazecreationtest.mazegenerationtest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import toby.challenge.mazecreation.coordinate.TwoDimensionCoordinates;
import toby.challenge.mazecreation.mazeelement.MazeCharElementConverter;
import toby.challenge.mazecreation.mazeelement.MazeElement;
import toby.challenge.mazecreation.mazegeneration.Maze;
import toby.challenge.staticmethods.MethodsForStrings;

import java.util.Map;

public class MazeTester {

    private static Maze maze;
    private static String mazeInputString;
    private final int exitXCoordinate = 4;
    private final int exitYCoordinate = 3;
    private final char exitChar = '*';
    private final int invalidXCoordinate = 0;
    private final int invalidYCoordinate = 0;

    @BeforeClass
    public static void setupMazeGeneratortest(){
        mazeInputString = "WWWPP;EPPPW;PWWWW;PP*WW;PWPWP";
        maze = new Maze(mazeInputString);
    }

    @Test
    public void ensureCorrectCountOfElementsInsideElementCounter(){
        Map<Character, Integer> letterCounter = MethodsForStrings.letterCounter(mazeInputString);
        //; IS NOT MAPPED TO A MAZE ELEMENT
        letterCounter.remove(';');
        for(Character character : letterCounter.keySet()){
            MazeElement element = MazeCharElementConverter.getMazeCharacterConverter().getMazeElementDict().get(character);
            Assert.assertEquals(MethodsForStrings.letterCounter(mazeInputString).get(character), maze.getMazeElementCounterDict().get(element));
        }
    }

    @Test
    public void ensureExitHasTheCorrectCoordinates(){
        TwoDimensionCoordinates exitCoordinate = maze.getCoordinateKey(exitXCoordinate,exitYCoordinate);
        MazeElement exitElement = MazeCharElementConverter.getMazeCharacterConverter().getMazeElementDict().get(exitChar);
        Assert.assertEquals(maze.getMazeComponents().get(exitCoordinate), exitElement);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAttemptingToRetrieveInvalidCoordinatesFromMappingRisesTheorrectError(){
        TwoDimensionCoordinates invalidCoordinate = maze.getCoordinateKey(invalidXCoordinate,invalidYCoordinate);
    }


}
