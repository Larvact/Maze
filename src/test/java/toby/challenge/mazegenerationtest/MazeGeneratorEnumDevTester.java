package toby.challenge.mazegenerationtest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import toby.challenge.coordinate.TwoDimensionCoordinates;
import toby.challenge.mazeelement.MazeCharElementConverter;
import toby.challenge.mazeelement.MazeElement;
import toby.challenge.mazegeneration.MazeGenerator;
import toby.challenge.staticmethods.ArrayConverter;

import java.util.List;

public class MazeGeneratorEnumDevTester {

    private static String mazeInputString;
    private static MazeGenerator mazeGenerator;
    private static MazeCharElementConverter mazeCharElementConverter;


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
        int rowCoordinate = 1;
        List<String> mazeStringByRows = ArrayConverter.toListFromArray(mazeInputString.split(";"));
        for(String mazeStringRow : mazeStringByRows){
            char [] charElementsOnRow = mazeStringRow.toCharArray();
            for(int charElementindex = 0; charElementindex < charElementsOnRow.length; charElementindex++){
                Character characterMazeElement = charElementsOnRow[charElementindex];
                //Gets Expected Element From Character Type
                MazeElement mazeElement = mazeCharElementConverter.getMazeElementDict().get(characterMazeElement);
                //Gets Coordinates of Element
                int columnCoordinate = charElementindex + 1;
                TwoDimensionCoordinates elementCoordinates = mazeGenerator.getCoordinateKey(rowCoordinate, columnCoordinate);
                //Ensures that the Expected Element Equals the Retrieved Element From the mazeGenerator Coordinate Element Mapping
                Assert.assertEquals(mazeElement, mazeGenerator.getMazeElementCoordinateMapping().get(elementCoordinates));
            }
            rowCoordinate++;
        }
    }
}
