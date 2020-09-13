package toby.challenge.mazevalidators;

import toby.challenge.mazegeneration.Maze;

public class MazeSingleExitValidator extends MazeValidator{

    public MazeSingleExitValidator(Maze maze) {
        super(maze);
    }

    @Override
    public void validate() {
        if(!maze.getMazeElementCountDict().containsKey('*')){
            throw new IllegalArgumentException("There is no exit inside the maze, redefine the maze with a single exit");
        }
        else if(maze.getMazeElementCountDict().get('*') > 1){
            throw new IllegalArgumentException("There are more than one exits inside the maze, redefine the maze with a single exit");
        }
    }
}
