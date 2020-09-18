package toby.challenge.tupletest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import toby.challenge.tuple.Tuple;

public class TupleTester {

    private static Tuple<Integer> tuple;
    private static Integer[] list;
    private static Integer testIndex = 0;
    private static Integer testInteger = 1;

    @BeforeClass
    public static void setup(){
        list = new Integer[4];
        list[0] = 1;
        list[1] = 2;
        list[2] = 3;
        list[3] = 4;
        tuple = new Tuple<Integer>(list);
    }

    @Test
    public void cloneTupleObjectReferenceTest(){
        Tuple<Integer> clonedTuple = tuple.clone();
        Assert.assertTrue(clonedTuple != tuple);
    }

    @Test
    public void cloneTupleListObjectReferenceTest(){
        Integer[] clonedTupleList = tuple.clone().getContents();
        Assert.assertTrue(clonedTupleList != tuple.getContents());
    }

    @Test
    public void ensureDifferentCorrectValuesBetweenTupleObjectAndClonedTupleObjectAfterDatsaInsertionTest(){
        Tuple<Integer> clonedTuple = tuple.clone();
        Integer[] clonedArray = clonedTuple.getContents();
        clonedArray[0] = 100;
        Assert.assertNotEquals(clonedArray, clonedTuple.getContents());
    }

    @Test
    public void ensureListOfOriginalTupleIsTheSameAsListOfCloneTupleAferCloning(){
        Tuple<Integer> clonedTuple = tuple.clone();
        Assert.assertEquals(clonedTuple.getContents(), tuple.getContents());
    }

    @Test
    public void getMethodTest(){
        Assert.assertEquals(testInteger, tuple.get(testIndex));
    }

    @Test
    public void tupleIteratorTest(){
        int expectedIntegerResult = 1;
        for(int actualIntegerResult : tuple){
            Assert.assertEquals(expectedIntegerResult, actualIntegerResult);
            expectedIntegerResult++;
        }
    }


}
