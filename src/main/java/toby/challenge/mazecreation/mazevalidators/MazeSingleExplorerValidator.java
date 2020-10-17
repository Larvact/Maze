package toby.challenge.mazecreation.mazevalidators;

import toby.challenge.mazecreation.mazeelement.MazeElement;
import toby.challenge.mazecreation.mazegeneration.Maze;

public class MazeSingleExplorerValidator extends MazeValidator{

    public MazeSingleExplorerValidator(Maze maze) {
        super(maze);
    }

    @Override
    public void validate() {
        MazeElement explorer = MazeElement.EXPLORER;
        if(!maze.getMazeElementCounterDict().containsKey(explorer)){
            throw new IllegalArgumentException("There is no explorer inside the maze, redefine the maze with a single explorer");
        }
        else if(maze.getMazeElementCounterDict().get(explorer) > 1){
            throw new IllegalArgumentException("There are more than one explorers inside the maze, redefine the maze with a single explorer");
        }

    }
}
