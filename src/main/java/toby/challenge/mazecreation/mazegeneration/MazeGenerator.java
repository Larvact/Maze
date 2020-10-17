package toby.challenge.mazecreation.mazegeneration;

import toby.challenge.mazecreation.coordinate.TwoDimensionCoordinates;
import toby.challenge.mazecreation.mazeelement.MazeElement;
import toby.challenge.mazecreation.mazeelement.MazeCharElementConverter;
import toby.challenge.staticmethods.ArrayConverter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MazeGenerator {

    private String mazeInputString;
    private Map<TwoDimensionCoordinates,MazeElement> mazeElementCoordinateMapping; //FURTHER DEV - USE MAP.ENTRY<INTEGER, INTEGER> INTSEAD OF INTEGER TO MAP A ROW NO AND COL NO TO AN ELEMENT
    private final MazeCharElementConverter mazeCharElementConverter = MazeCharElementConverter.getMazeCharacterConverter();

    public MazeGenerator(String mazeInputString) {
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

    private void setCoordinateMappingOfCurrentMazeElement(int mazeRowNumber, char [] mazeCharsOnRow){
        for(int mazeColumnIndex = 0; mazeColumnIndex < mazeCharsOnRow.length; mazeColumnIndex++){
            Character mazeCurrentCharacter = mazeCharsOnRow[mazeColumnIndex];
            int currentMazeColNumber = mazeColumnIndex + 1;
            TwoDimensionCoordinates currentMazeElementCoordinates = new TwoDimensionCoordinates(mazeRowNumber, currentMazeColNumber);
            MazeElement currentMazeElement = mazeCharElementConverter.getMazeElementDict().get(mazeCurrentCharacter);
            mazeElementCoordinateMapping.put(currentMazeElementCoordinates, currentMazeElement);
        }
    }

    public Map<TwoDimensionCoordinates,MazeElement> getMazeElementCoordinateMapping() {
        return mazeElementCoordinateMapping;
    }

    public void generateNewMaze(String mazeInputString) {
        this.mazeInputString = mazeInputString;
        this.setMazeMapping();
    }

    //LOOK TO DELETE LATER. IT IS ONLY HERE AT THE MOMENT FOR UNIT TESTING PURPOSE.
    //THIS METHOD IS AVAILABLE INSIDE THE MAZE CLASS ASWELL FOR ANALYSIS PURPOSE.
    public TwoDimensionCoordinates getCoordinateKey(int xCoordinate, int yCoordinate){
        for(TwoDimensionCoordinates twoDCoordinate : mazeElementCoordinateMapping.keySet()){
            if(twoDCoordinate.getxCoordinate() == xCoordinate && twoDCoordinate.getyCoordinate() == yCoordinate){
                return twoDCoordinate;
            }
        }
        throw new IllegalArgumentException("The co-ordinates entered do not exist for this maze (points to a position outside of the maze)");
    }
}
