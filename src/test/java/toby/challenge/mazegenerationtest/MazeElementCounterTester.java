package toby.challenge.mazegenerationtest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import toby.challenge.mazeelement.MazeCharElementConverter;
import toby.challenge.mazegeneration.MazeElementCounter;
import toby.challenge.mazegeneration.MazeGenerator;

public class MazeElementCounterTester {

    private static String mazeInputString;
    private static MazeGenerator mazeGenerator;
    private static MazeCharElementConverter mazeCharElementConverter;
    private static MazeElementCounter mazeElementCounter;

    @BeforeClass
    public static void setupMazeGeneratortest(){
        mazeInputString = "WWWPP;EPPPW;PWWWW;PP*WW;PWPWP";
        mazeGenerator = new MazeGenerator(mazeInputString);
        mazeCharElementConverter = MazeCharElementConverter.getMazeCharacterConverter();
    }

    @Test
    public void ensureTheMazeElementCounterHasBeenPopulatedCorrectly(){
        mazeElementCounter = new MazeElementCounter(mazeGenerator);
        Assert.assertEquals(1, mazeElementCounter.getMazeElementCount().get(mazeCharElementConverter.getMazeElementDict().get('*')).intValue());
        Assert.assertEquals(1, mazeElementCounter.getMazeElementCount().get(mazeCharElementConverter.getMazeElementDict().get('E')).intValue());
        Assert.assertEquals(11, mazeElementCounter.getMazeElementCount().get(mazeCharElementConverter.getMazeElementDict().get('P')).intValue());
        Assert.assertEquals(12, mazeElementCounter.getMazeElementCount().get(mazeCharElementConverter.getMazeElementDict().get('W')).intValue());
    }
}
