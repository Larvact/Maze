package toby.challenge.tupletest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import toby.challenge.tuple.Tuple;

import java.util.ArrayList;
import java.util.List;

public class TupleTester {

    private static Tuple<Integer> tuple;
    private static List<Integer> list;

    @BeforeClass
    public static void setup(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        tuple = new Tuple<>(list);
    }

    @Test
    public void cloneTupleObjectReferenceTest(){
        Tuple<Integer> clonedTuple = tuple.clone();
        Assert.assertTrue(clonedTuple != tuple);
    }

    @Test
    public void cloneTupleListObjectReferenceTest(){
        List<Integer> clonedTupleList = tuple.clone().getContents();
        Assert.assertTrue(clonedTupleList != tuple.getContents());
    }

    @Test
    public void ensureDifferentCorrectValuesBetweenTupleObjectAndClonedTupleObjectAfterDatsaInsertionTest(){
        Tuple<Integer> clonedTuple = tuple.clone();
        clonedTuple.getContents().add(5);
        Assert.assertNotEquals(clonedTuple.getContents(), tuple.getContents());
    }

    @Test
    public void ensureListOfOriginalTupleIsTheSameAsListOfCloneTupleAferCloning(){
        Tuple<Integer> clonedTuple = tuple.clone();
        Assert.assertEquals(clonedTuple.getContents(), tuple.getContents());
    }


}
