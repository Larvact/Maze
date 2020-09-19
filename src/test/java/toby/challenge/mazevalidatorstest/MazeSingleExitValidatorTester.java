package toby.challenge.mazevalidatorstest;

import org.junit.Test;
import toby.challenge.mazegeneration.Maze;
import toby.challenge.mazevalidators.MazeSingleExitValidator;
import toby.challenge.mazevalidators.MazeValidator;

public class MazeSingleExitValidatorTester {

    private final String validMazeInput = "WWWPP;EPPPW;PWWWW;PP*WW;PWPWP";
    private final String multipleExitsMazeInput = "WW*PP;EPPPW;PWWWW;PP*WW;PWPWP";
    private final String noExitsMazeInput = "WWWPP;EPPPW;PWWWW;PPWWW;PWPWP";
    private Maze maze;
    private MazeValidator singleExitValidator;

    @Test(expected = IllegalArgumentException.class)
    public void ensureExceptionIsThrownWhenTwoExitsAreAvailableInTheMaze(){
        setupMaze(this.multipleExitsMazeInput);
        this.singleExitValidator.validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureExceptionIsThrownWhenNoExitsAreAvailableInTheMaze(){
        setupMaze(this.noExitsMazeInput);
        this.singleExitValidator.validate();
    }

    @Test
    public void ensureNoExceptionOnEntryOfAValidMaze(){
        setupMaze(this.validMazeInput);
        this.singleExitValidator.validate();
    }

    private void setupMaze(String mazeInputString){
        this.maze = new Maze(mazeInputString);
        this.singleExitValidator = new MazeSingleExitValidator(this.maze);
    }
}
