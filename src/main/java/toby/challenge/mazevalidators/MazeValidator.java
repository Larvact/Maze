package toby.challenge.mazevalidators;

import toby.challenge.mazegeneration.Maze;

public abstract class MazeValidator {

    protected Maze maze;

    public MazeValidator(Maze maze) {
        this.maze = maze;
    }

    public abstract void validate();
}
