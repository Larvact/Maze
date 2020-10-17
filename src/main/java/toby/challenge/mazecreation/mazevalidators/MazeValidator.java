package toby.challenge.mazecreation.mazevalidators;

import toby.challenge.mazecreation.mazegeneration.Maze;

public abstract class MazeValidator {

    protected Maze maze;

    public MazeValidator(Maze maze) {
        this.maze = maze;
    }

    public abstract void validate();
}
