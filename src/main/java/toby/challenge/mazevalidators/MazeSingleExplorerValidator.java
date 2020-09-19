package toby.challenge.mazevalidators;

import toby.challenge.mazeelement.MazeElement;
import toby.challenge.mazegeneration.Maze;

public class MazeSingleExplorerValidator extends MazeValidator{

    public MazeSingleExplorerValidator(Maze maze) {
        super(maze);
    }

    @Override
    public void validate() {
        MazeElement explorer = MazeElement.EXPLORER;
        if(!maze.getMazeElementCountDict().containsKey(explorer)){
            throw new IllegalArgumentException("There is no explorer inside the maze, redefine the maze with a single explorer");
        }
        else if(maze.getMazeElementCountDict().get(explorer) > 1){
            throw new IllegalArgumentException("There are more than one explorers inside the maze, redefine the maze with a single explorer");
        }

    }
}
