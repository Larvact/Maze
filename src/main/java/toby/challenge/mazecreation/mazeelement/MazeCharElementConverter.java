package toby.challenge.mazecreation.mazeelement;

import java.util.HashMap;
import java.util.Map;

public class MazeCharElementConverter {

    private static MazeCharElementConverter mazeCharElementConverter;
    private final Map<Character, MazeElement> mazeCharacterConverter;

    private MazeCharElementConverter() {
        mazeCharacterConverter = new HashMap<>();
        mazeCharacterConverter.put('E', MazeElement.EXPLORER);
        mazeCharacterConverter.put('*', MazeElement.EXIT);
        mazeCharacterConverter.put('W', MazeElement.WALL);
        mazeCharacterConverter.put('P', MazeElement.PATHWAY);
    }

    public static MazeCharElementConverter getMazeCharacterConverter() {
        if(mazeCharElementConverter == null){
            mazeCharElementConverter = new MazeCharElementConverter();
        }
        return mazeCharElementConverter;
    }

    public Map<Character, MazeElement> getMazeElementDict() {
        return this.mazeCharacterConverter;
    }
}
