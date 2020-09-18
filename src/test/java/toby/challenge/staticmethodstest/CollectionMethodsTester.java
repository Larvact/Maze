package toby.challenge.staticmethodstest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import toby.challenge.staticmethods.CollectionMethods;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CollectionMethodsTester {

    private static Map<String, Integer> map1;
    private static Map<String, Integer> map2;
    private static final Random randomGenerator = new Random();

    private static final String first = "First";
    private static final String second = "Second";
    private static final String third = "Third";

    private static final int firstInt = randomGenerator.nextInt(1000) + 1;
    private static final int secondInt = randomGenerator.nextInt(1000) + 1;
    private static final int thirdInt = randomGenerator.nextInt(1000) + 1;

    @BeforeClass
    public static void setup(){
        setupMaps();
    }

    @Test
    public void testDictionaryMergeHasCorrectKeyValues(){
        Map<String, Integer> actualResultMap = CollectionMethods.dictionaryMerge(map1, map2);
        Assert.assertEquals(firstInt + firstInt, actualResultMap.get(first).intValue());
        Assert.assertEquals(secondInt, actualResultMap.get(second).intValue());
        Assert.assertEquals(thirdInt, actualResultMap.get(third).intValue());
    }

    //HELPER METHODS
    private static void setupMaps(){
        map1 = new HashMap<>();
        map1.put(first, firstInt);
        map1.put(second, secondInt);
        map2 = new HashMap<>();
        map2.put(first, firstInt);
        map2.put(third, thirdInt);

    }

}
