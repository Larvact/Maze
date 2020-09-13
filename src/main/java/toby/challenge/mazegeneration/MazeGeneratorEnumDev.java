package toby.challenge.mazegeneration;

import toby.challenge.mazeelement.MazeElement;
import toby.challenge.mazeelement.MazeCharElementConverter;
import toby.challenge.staticmethods.ArrayConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MazeGeneratorEnumDev {

    private String mazeInputString;
    private Map<List<Integer>,MazeElement> mazeElementCoordinateMapping; //FURTHER DEV - USE MAP.ENTRY<INTEGER, INTEGER> INTSEAD OF INTEGER TO MAP A ROW NO AND COL NO TO AN ELEMENT
    private final MazeCharElementConverter mazeCharElementConverter = MazeCharElementConverter.getMazeCharacterConverter();

    public MazeGeneratorEnumDev(String mazeInputString) {
        generateNewMaze(mazeInputString);
    }

    private void setMazeMapping() {
        List<String> mazeStringByRows = getMazeByRow();
        mazeElementCoordinateMapping = new HashMap<>();
        int currentMazeRowNumber = 1;
        for(String mazeStringRow : mazeStringByRows){
            char [] mazeCharsRow = mazeStringRow.toCharArray();
            setCoordinateMappingOfCurrentMazeElement(currentMazeRowNumber, mazeCharsRow);
            currentMazeRowNumber++;
        }
    }

    private List<String> getMazeByRow(){
        String [] mazeCharElementsByRowArray = mazeInputString.split(";");
        return ArrayConverter.toListFromArray(mazeCharElementsByRowArray);
    }

    private List<Integer> getCoordinatesAsList(int xCordinate, int yCoordinate){
        List<Integer> mazeElementCoordinates = new ArrayList<>();
        mazeElementCoordinates.add(xCordinate);
        mazeElementCoordinates.add(yCoordinate);
        return mazeElementCoordinates;
    }

    private void setCoordinateMappingOfCurrentMazeElement(int mazeRowNumber, char [] mazeCharsOnRow){
        for(int mazeColumnIndex = 0; mazeColumnIndex < mazeCharsOnRow.length; mazeColumnIndex++){
            Character mazeCurrentCharacter = mazeCharsOnRow[mazeColumnIndex];
            int currentMazeColNumber = mazeColumnIndex + 1;
            List<Integer> currentMazeElementCoordinates = getCoordinatesAsList(mazeRowNumber, currentMazeColNumber);
            MazeElement currentMazeElement = mazeCharElementConverter.getMazeElementDict().get(mazeCurrentCharacter);
            mazeElementCoordinateMapping.put(currentMazeElementCoordinates, currentMazeElement);
        }
    }

    public Map<List<Integer>,MazeElement> getMazeElementCoordinateMapping() {
        return mazeElementCoordinateMapping;
    }

    public void generateNewMaze(String mazeInputString) {
        this.mazeInputString = mazeInputString;
        this.setMazeMapping();
    }
}
