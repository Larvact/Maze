package toby.challenge.staticmethods;

import java.util.ArrayList;
import java.util.List;

public class ArrayConverter {

    public static <T> List<T> toListFromArray(T[] array){
        List<T> convertedListFromArray = new ArrayList<>();
        for(int arrayIndex = 0; arrayIndex < array.length; arrayIndex++){
            convertedListFromArray.add(array[arrayIndex]);
        }
        return convertedListFromArray;
    }
}
