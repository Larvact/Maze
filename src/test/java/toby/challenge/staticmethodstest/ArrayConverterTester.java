package toby.challenge.staticmethodstest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import toby.challenge.staticmethods.ArrayConverter;
import java.util.ArrayList;
import java.util.List;

public class ArrayConverterTester {

    private static Integer[] list;
    private static int currentNumber = 1;
    private static final int numberOfElementsInList = 4;

    @BeforeClass
    public static void setup(){
        setupArray();
    }

    @Before
    public void resetCurrentNumber(){
        currentNumber = 1;
    }

    @Test
    public void ensureArrayIsConvertedToListCorrectly(){
        List<Integer> expectedResult = getExpectedList();
        List<Integer> actualResult = ArrayConverter.toListFromArray(list);
        Assert.assertEquals(expectedResult, actualResult);
    }





    //HELPER METHODS
    private static void setupArray(){
        list = new Integer[numberOfElementsInList];
        for(int countIndex = 0; countIndex < numberOfElementsInList; countIndex++){
            list[countIndex] = currentNumber;
            currentNumber += 1;
        }
    }

    private List<Integer> getExpectedList(){
        List<Integer> expectedArrayListResult = new ArrayList<>();
        for(int countIndex = 0; countIndex < numberOfElementsInList; countIndex++){
            expectedArrayListResult.add(currentNumber);
            currentNumber += 1;
        }
        return expectedArrayListResult;
    }



}
