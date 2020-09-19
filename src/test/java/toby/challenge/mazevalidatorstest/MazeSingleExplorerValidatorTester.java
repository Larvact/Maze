package toby.challenge.mazevalidatorstest;

import org.junit.Test;
import toby.challenge.mazegeneration.Maze;
import toby.challenge.mazevalidators.MazeSingleExplorerValidator;
import toby.challenge.mazevalidators.MazeValidator;

public class MazeSingleExplorerValidatorTester {
    private final String validMazeInput = "WWWPP;EPPPW;PWWWW;PP*WW;PWPWP";
    private final String multipleExplorersMazeInput = "WWWPP;EPPPW;PWWWW;PP*EW;PWPWP";
    private final String noExplorerMazeInput = "WWWPP;WPPPW;PWWWW;PP*WW;PWPWP";
    private Maze maze;
    private MazeValidator singleExplorerValidator;

    @Test(expected = IllegalArgumentException.class)
    public void ensureExceptionIsThrownWhenTwoExitsAreAvailableInTheMaze(){
        setupMaze(this.multipleExplorersMazeInput);
        this.singleExplorerValidator.validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureExceptionIsThrownWhenNoExitsAreAvailableInTheMaze(){
        setupMaze(this.noExplorerMazeInput);
        this.singleExplorerValidator.validate();
    }

    @Test
    public void ensureNoExceptionOnEntryOfAValidMaze(){
        setupMaze(this.validMazeInput);
        this.singleExplorerValidator.validate();
    }

    private void setupMaze(String mazeInputString){
        this.maze = new Maze(mazeInputString);
        this.singleExplorerValidator = new MazeSingleExplorerValidator(this.maze);
    }
}
