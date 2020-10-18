package toby.challenge.mazeanalysation.locators;

import toby.challenge.mazecreation.coordinate.TwoDimensionCoordinates;
import toby.challenge.mazecreation.mazegeneration.Maze;

public abstract class MazeElementLocator {

    protected Maze maze;
    protected TwoDimensionCoordinates coordinate;

    public MazeElementLocator(Maze maze) {
        this.maze = maze;
        setCoordinate();
    }

    public abstract void setCoordinate();

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public TwoDimensionCoordinates getCoordinate(){
        return coordinate;
    }

}
