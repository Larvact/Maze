package toby.challenge.mazecreationtest.mazegenerationtest;

import org.junit.*;
import toby.challenge.mazecreation.coordinate.TwoDimensionCoordinates;
import toby.challenge.mazecreation.mazeelement.MazeCharElementConverter;
import toby.challenge.mazecreation.mazeelement.MazeElement;
import toby.challenge.mazecreation.mazegeneration.MazeGenerator;
import toby.challenge.staticmethods.ArrayConverter;
import java.util.List;

public class MazeGeneratorTester {

    private static String mazeInputString;
    private static MazeGenerator mazeGenerator;
    private static MazeCharElementConverter mazeCharElementConverter;
    private final int invalidXCoordinate = 0;
    private final int invalidYCoordinate = 0;

    @BeforeClass
    public static void setupMazeGeneratortest(){
        mazeInputString = "WWWPP;EPPPW;PWWWW;PP*WW;PWPWP";
        mazeGenerator = new MazeGenerator(mazeInputString);
        mazeCharElementConverter = MazeCharElementConverter.getMazeCharacterConverter();
    }

    @Test
    public void ensureMazeCoordinateMapHasCorrectNumberOfEntries(){
        String mazeInputStringWithOutDelimiter = mazeInputString.replaceAll(";", "");
        Assert.assertEquals(mazeInputStringWithOutDelimiter.length(), mazeGenerator.getMazeElementCoordinateMapping().size());
    }

    @Test
    public void ensureAllCoordinateMappingsAreCorrect(){
        int xCoordinate = 1;
        List<String> mazeStringByColumns = ArrayConverter.toListFromArray(mazeInputString.split(";"));
        for(String mazeStringColumn : mazeStringByColumns){
            char [] charElementsOnColumn = mazeStringColumn.toCharArray();
            for(int charElementindex = 0; charElementindex < charElementsOnColumn.length; charElementindex++){
                Character characterMazeElement = charElementsOnColumn[charElementindex];
                //Gets Expected Element From Character Type
                MazeElement mazeElement = mazeCharElementConverter.getMazeElementDict().get(characterMazeElement);
                //Gets Coordinates of Element
                int yCoordinate = charElementindex + 1;
                TwoDimensionCoordinates elementCoordinates = mazeGenerator.getCoordinateKey(xCoordinate, yCoordinate);
                //Ensures that the Expected Element Equals the Retrieved Element From the mazeGenerator Coordinate Element Mapping
                Assert.assertEquals(mazeElement, mazeGenerator.getMazeElementCoordinateMapping().get(elementCoordinates));
            }
            xCoordinate++;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAttemptingToRetrieveInvalidCoordinatesFromMappingRisesTheorrectError(){
        TwoDimensionCoordinates invalidCoordinate = mazeGenerator.getCoordinateKey(invalidXCoordinate,invalidYCoordinate);
    }
}
