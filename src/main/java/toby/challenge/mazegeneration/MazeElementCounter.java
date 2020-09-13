package toby.challenge.mazegeneration;

import toby.challenge.staticmethods.CollectionMethods;
import toby.challenge.staticmethods.MethodsForStrings;

import java.util.HashMap;
import java.util.Map;

public class MazeElementCounter {

    private MazeGenerator mazeGenerator;
    private Map<Character, Integer> mazeElementCount;

    public MazeElementCounter(MazeGenerator mazeGenerator) {
        setMazeElementCount(mazeGenerator);
    }

    private void setmazeElementCount() {
        this.mazeElementCount = new HashMap<>();
        for (String mazeComponent : this.mazeGenerator.getMazeComponents()) {
            Map<Character, Integer> mazeComponentElementCounter = MethodsForStrings.letterCounter(mazeComponent);
            this.mazeElementCount = CollectionMethods.dictionaryMerge(this.mazeElementCount, mazeComponentElementCounter);
        }
    }

    public Map<Character, Integer> getMazeElementCount() {
        return this.mazeElementCount;
    }

    private void setMazeElementCount(MazeGenerator mazeGenerator) {
        this.mazeGenerator = mazeGenerator;
        setmazeElementCount();
    }
}
