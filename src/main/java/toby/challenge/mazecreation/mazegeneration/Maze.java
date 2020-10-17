package toby.challenge.mazecreation.mazegeneration;

import toby.challenge.mazecreation.coordinate.TwoDimensionCoordinates;
import toby.challenge.mazecreation.mazeelement.MazeElement;

import java.util.Map;

public class Maze {

    private String mazeInputString;
    private Map<TwoDimensionCoordinates, MazeElement> mazeComponents; //LOOK TO REMOVE ONE OF THESE MEMBER VARIABLES
    private MazeGenerator mazeGenerator; //LOOK TO REMOVE ONE OF THESE MEMBER VARIABLES
    private MazeElementCounter mazeElementCounter;

    public Maze(String mazeInputString) {
        setMaze(mazeInputString);
    }

    public void setMaze(String mazeInputString){
        this.mazeInputString = mazeInputString;
        setMazeComponents();
        setMazeElementCounter(new MazeElementCounter(this.mazeGenerator));
    }

    public Map<TwoDimensionCoordinates, MazeElement> getMazeComponents() {
        return mazeComponents;
    }

    public Map<MazeElement, Integer> getMazeElementCounterDict() {
        return mazeElementCounter.getMazeElementCount();
    }

    public TwoDimensionCoordinates getCoordinateKey(int xCoordinate, int yCoordinate){
        for(TwoDimensionCoordinates twoDCoordinate : mazeGenerator.getMazeElementCoordinateMapping().keySet()){
            if(twoDCoordinate.getxCoordinate() == xCoordinate && twoDCoordinate.getyCoordinate() == yCoordinate){
                return twoDCoordinate;
            }
        }
        throw new IllegalArgumentException("The co-ordinates entered do not exist for this maze (points to a position outside of the maze)");
    }


    private void setMazeComponents() {
        this.mazeGenerator = new MazeGenerator(this.mazeInputString);
        this.mazeComponents = this.mazeGenerator.getMazeElementCoordinateMapping();
    }

    private void setMazeElementCounter(MazeElementCounter mazeElementCounter) {
        this.mazeElementCounter = mazeElementCounter;
    }

}
