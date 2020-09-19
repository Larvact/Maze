package toby.challenge.mazegeneration;

import toby.challenge.coordinate.TwoDimensionCoordinates;
import toby.challenge.mazeelement.MazeElement;

import java.util.Map;

public class Maze {

    private Map<TwoDimensionCoordinates, MazeElement> mazeComponents;
    private MazeElementCounter mazeElementCount;

    public Maze(MazeGenerator mazeGenerator, MazeElementCounter mazeElementCounter) {
        setMaze(mazeGenerator, mazeElementCounter);

    }

    private void setMazeComponents(MazeGenerator mazeGenerator) {
        this.mazeComponents = mazeGenerator.getMazeElementCoordinateMapping();
    }

    private void setMazeElementCount(MazeElementCounter mazeElementCount) {
        this.mazeElementCount = mazeElementCount;
    }

    public void setMaze(MazeGenerator mazeGenerator, MazeElementCounter mazeElementCount){
        setMazeComponents(mazeGenerator);
        setMazeElementCount(mazeElementCount);
    }

    public Map<TwoDimensionCoordinates, MazeElement> getMazeComponents() {
        return mazeComponents;
    }

    public Map<MazeElement, Integer> getMazeElementCountDict() {
        return mazeElementCount.getMazeElementCount();
    }
}
