package toby.challenge.tuple;

import java.util.ArrayList;
import java.util.List;

public class Tuple<T> implements Cloneable {
    private List<T> contents;

    public Tuple (List<T> contents) {
        if (contents.size() < 2){
            throw new IllegalArgumentException();
        }
        this.contents = contents;
    }

    @Override
    public Tuple<T> clone(){
        Tuple<T> deepClone = null;
        try {
            deepClone = (Tuple<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning of Tuple failed.");
        }
        List<T> clonedList = new ArrayList<>(this.contents);
        deepClone.setContents(clonedList);
        return deepClone;
    }

    public List<T> getContents () {
        return this.contents;
    }

    private void setContents(List<T> contents) {
        this.contents = contents;
    }

    public int size(){
        return this.contents.size();
    }

    @Override
    public int hashCode () {
        return this.contents.hashCode();
    }

    @Override
    public boolean equals (Object obj) {
        if(obj == null){
            return false;
        }
        if(!Tuple.class.equals(obj.getClass())){
            return false;
        }
        Tuple<T> otherTuple = (Tuple<T>) obj;
        return this.contents.equals(otherTuple.getContents());
    }

    @Override
    public String toString () {
        return contents.toString();
    }
}

