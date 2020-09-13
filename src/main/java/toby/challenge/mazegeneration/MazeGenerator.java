package toby.challenge.mazegeneration;

import toby.challenge.staticmethods.ArrayConverter;

import java.util.List;

public class MazeGenerator {

    private List<String> mazeComponents;

    public MazeGenerator(String mazeComponentsString) {
        setMazeComponents(mazeComponentsString);
    }

    private void setMazeComponents(String mazeComponentsString) {
        String [] mazeComponentsArray = mazeComponentsString.split("|");
        this.mazeComponents = ArrayConverter.toListFromArray(mazeComponentsArray);
    }

    public List<String> getMazeComponents() {
        return mazeComponents;
    }
}
