package toby.challenge.mazegeneration;

import java.util.List;
import java.util.Map;

public class Maze {

    private List<String> mazeComponents;
    private MazeElementCounter mazeElementCount;

    public Maze(MazeGenerator mazeGenerator, MazeElementCounter mazeElementCounter) {
        this.mazeComponents = mazeGenerator.getMazeComponents();
        this.mazeElementCount = mazeElementCounter;

    }

    private void setMazeComponents(MazeGenerator mazeGenerator) {
        this.mazeComponents = mazeGenerator.getMazeComponents();
    }

    private void setMazeElementCount(MazeElementCounter mazeElementCount) {
        this.mazeElementCount = mazeElementCount;
    }

    public void setMaze(MazeGenerator mazeGenerator, MazeElementCounter mazeElementCount){
        setMazeComponents(mazeGenerator);
        setMazeElementCount(mazeElementCount);
    }

    public List<String> getMazeComponents() {
        return mazeComponents;
    }

    public Map<Character, Integer> getMazeElementCountDict() {
        return mazeElementCount.getMazeElementCount();
    }
}
