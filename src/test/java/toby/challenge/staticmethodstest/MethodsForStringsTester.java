package toby.challenge.staticmethodstest;

import org.junit.Assert;
import org.junit.Test;
import toby.challenge.staticmethods.MethodsForStrings;
import java.util.Map;

public class MethodsForStringsTester {

    private String testString = "nifwafvanivisfvnzj";

    @Test
    public void ensureMethodReturnsAMapWithTheCorrectCountFora(){
        Map<Character, Integer> resultMap = MethodsForStrings.letterCounter(testString);
        Assert.assertEquals(2, resultMap.get('a').intValue());
    }

    @Test
    public void ensureMethodReturnsAMapWithTheCorrectCountForz(){
        Map<Character, Integer> resultMap = MethodsForStrings.letterCounter(testString);
        Assert.assertEquals(1, resultMap.get('z').intValue());
    }

    @Test
    public void ensureMethodReturnsAMapWithTheCorrectCountFori(){
        Map<Character, Integer> resultMap = MethodsForStrings.letterCounter(testString);
        Assert.assertEquals(3, resultMap.get('i').intValue());
    }




}
