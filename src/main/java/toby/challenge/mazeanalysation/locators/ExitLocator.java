package toby.challenge.mazeanalysation.locators;

import toby.challenge.mazecreation.coordinate.TwoDimensionCoordinates;
import toby.challenge.mazecreation.mazeelement.MazeElement;
import toby.challenge.mazecreation.mazegeneration.Maze;

public class ExitLocator extends MazeElementLocator {

    public ExitLocator(Maze maze) {
        super(maze);
    }

    @Override
    public void setCoordinate() {
        for(TwoDimensionCoordinates coordinate : this.maze.getMazeComponents().keySet()){
            if(this.maze.getMazeComponents().get(coordinate).equals(MazeElement.EXIT)){
                this.coordinate = coordinate;
                break;
            }
        }
    }
}
