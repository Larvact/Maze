package toby.challenge.staticmethods;

import java.util.HashMap;
import java.util.Map;

public class CollectionMethods {

    public static Map<Character, Integer> dictionaryMerge(Map<Character, Integer> firstMap, Map<Character, Integer> secondMap){
        Map<Character, Integer> mergedMap = new HashMap<>(firstMap);
        for (Map.Entry<Character, Integer> keyValuePair : secondMap.entrySet()){
            Character currentKey = keyValuePair.getKey();
            Integer currentValue = keyValuePair.getValue();
            if(mergedMap.containsKey(currentKey)){
                mergedMap.put(currentKey, firstMap.get(currentKey) + currentValue);
            }
            else {
                mergedMap.put(currentKey, currentValue);
            }
        }
        return mergedMap;
    }
}
