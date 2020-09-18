package toby.challenge.staticmethods;

import java.util.HashMap;
import java.util.Map;

public class CollectionMethods {

    public static <T> Map<T, Integer> dictionaryMerge(Map<T, Integer> firstMap, Map<T, Integer> secondMap){
        Map<T, Integer> mergedMap = new HashMap<>(firstMap);
        for (Map.Entry<T, Integer> keyValuePair : secondMap.entrySet()){
            T currentKey = keyValuePair.getKey();
            Integer currentValue = keyValuePair.getValue();
            if(mergedMap.containsKey(currentKey)){
                mergedMap.put(currentKey, Math.addExact(firstMap.get(currentKey), currentValue));
            }
            else {
                mergedMap.put(currentKey, currentValue);
            }
        }
        return mergedMap;
    }
}
