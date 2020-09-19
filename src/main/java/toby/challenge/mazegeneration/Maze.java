package toby.challenge.mazegeneration;

import toby.challenge.coordinate.TwoDimensionCoordinates;
import toby.challenge.mazeelement.MazeElement;

import java.util.Map;

public class Maze {

    private String mazeInputString;
    private Map<TwoDimensionCoordinates, MazeElement> mazeComponents; //LOOK TO REMOVE ONE OF THESE MEMBER VARIABLES
    private MazeGenerator mazeGenerator; //LOOK TO REMOVE ONE OF THESE MEMBER VARIABLES
    private MazeElementCounter mazeElementCount;

    public Maze(String mazeInputString) {
        setMaze(mazeInputString);
    }

    public void setMaze(String mazeInputString){
        this.mazeInputString = mazeInputString;
        setMazeComponents();
        setMazeElementCount(new MazeElementCounter(this.mazeGenerator));
    }

    public Map<TwoDimensionCoordinates, MazeElement> getMazeComponents() {
        return mazeComponents;
    }

    public Map<MazeElement, Integer> getMazeElementCountDict() {
        return mazeElementCount.getMazeElementCount();
    }

    private void setMazeComponents() {
        this.mazeGenerator = new MazeGenerator(this.mazeInputString);
        this.mazeComponents = this.mazeGenerator.getMazeElementCoordinateMapping();
    }

    private void setMazeElementCount(MazeElementCounter mazeElementCount) {
        this.mazeElementCount = mazeElementCount;
    }

}
