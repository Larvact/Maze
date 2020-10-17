package toby.challenge.mazecreation.mazegeneration;

import toby.challenge.mazecreation.mazeelement.MazeElement;
import java.util.HashMap;
import java.util.Map;

public class MazeElementCounter {

    private MazeGenerator mazeGenerator;
    private Map<MazeElement, Integer> mazeElementCount;

    public MazeElementCounter(MazeGenerator mazeGenerator) {
        setMazeElementCount(mazeGenerator);
    }

    private void setmazeElementCount() {
        this.mazeElementCount = new HashMap<>();
        for (MazeElement mazeComponent : this.mazeGenerator.getMazeElementCoordinateMapping().values()) {
            if (mazeElementCount.containsKey(mazeComponent)) {
                int mazeElementCount = this.mazeElementCount.computeIfPresent(mazeComponent, (k, v)-> v + 1);
                this.mazeElementCount.put(mazeComponent, mazeElementCount);
            }
            else {
                this.mazeElementCount.put(mazeComponent, 1);
            }
        }
    }

    public Map<MazeElement, Integer> getMazeElementCount() {
        return this.mazeElementCount;
    }

    private void setMazeElementCount(MazeGenerator mazeGenerator) {
        this.mazeGenerator = mazeGenerator;
        setmazeElementCount();
    }
}
