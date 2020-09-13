package toby.challenge.staticmethods;

import java.util.HashMap;
import java.util.Map;

public class MethodsForStrings {

    public static Map<Character, Integer> letterCounter(String string) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        char[] characterArrayFromString = string.toCharArray();
        for (char character : characterArrayFromString) {
            Character characterWrapped = character;
            if (characterCountMap.containsKey(characterWrapped)) {
                characterCountMap.put(characterWrapped, characterCountMap.get(characterWrapped) + 1);
            } else {
                characterCountMap.put(characterWrapped, 1);
            }
        }
        return characterCountMap;
    }
}
