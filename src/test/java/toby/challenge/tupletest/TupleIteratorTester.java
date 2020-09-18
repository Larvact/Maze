package toby.challenge.tupletest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import toby.challenge.tuple.Tuple;
import toby.challenge.tuple.TupleIterator;

public class TupleIteratorTester {

    private static Tuple<Integer> tuple;
    private static Integer[] list;
    private static TupleIterator<Integer> tupleIterator;


    @BeforeClass
    public static void setup(){
        list = new Integer[4];
        list[0] = 1;
        list[1] = 2;
        list[2] = 3;
        list[3] = 4;
        tuple = new Tuple<Integer>(list);
        tupleIterator = new TupleIterator<>(tuple);
    }

    @Test
    public void testIteratorProcess(){
        int expectedIntegerElement = 1;
        while(tupleIterator.hasNext()){
            Assert.assertEquals(expectedIntegerElement, tupleIterator.next().intValue());
            expectedIntegerElement++;
        }
    }



}
