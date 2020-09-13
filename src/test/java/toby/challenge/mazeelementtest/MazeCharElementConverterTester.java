package toby.challenge.mazeelementtest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import toby.challenge.mazeelement.MazeCharElementConverter;
import toby.challenge.mazeelement.MazeElement;

public class MazeCharElementConverterTester {

    private static int numberOfMazeElements;
    private static MazeCharElementConverter converter;
    private static Character explorer;
    private static Character exit;
    private static Character pathWay;
    private static Character wall;

    @BeforeClass
    public static void elementConverterAndTestVariablesSetup(){
        numberOfMazeElements = 4;
        converter = MazeCharElementConverter.getMazeCharacterConverter();
        explorer = 'E';
        exit = '*';
        pathWay = 'P';
        wall = 'W';
    }

    @Test
    public void ensureOnlyFourElementsInsideTheMapConverter(){
        Assert.assertEquals(numberOfMazeElements, converter.getMazeElementDict().size());
    }

    @Test
    public void ensureAllMappingsInTheConverterAreCorrect(){
        Assert.assertEquals(MazeElement.EXPLORER, converter.getMazeElementDict().get(explorer));
        Assert.assertEquals(MazeElement.EXIT, converter.getMazeElementDict().get(exit));
        Assert.assertEquals(MazeElement.PATHWAY, converter.getMazeElementDict().get(pathWay));
        Assert.assertEquals(MazeElement.WALL, converter.getMazeElementDict().get(wall));
    }



}
