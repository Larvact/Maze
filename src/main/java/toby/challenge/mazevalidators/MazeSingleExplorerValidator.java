package toby.challenge.mazevalidators;

import toby.challenge.mazegeneration.Maze;

public class MazeSingleExplorerValidator extends MazeValidator{

    public MazeSingleExplorerValidator(Maze maze) {
        super(maze);
    }

    @Override
    public void validate() {
        if(!maze.getMazeElementCountDict().containsKey('E')){
            throw new IllegalArgumentException("There is no explorer inside the maze, redefine the maze with a single explorer");
        }
        else if(maze.getMazeElementCountDict().get('E') > 1){
            throw new IllegalArgumentException("There are more than one explorers inside the maze, redefine the maze with a single explorer");
        }

    }
}
