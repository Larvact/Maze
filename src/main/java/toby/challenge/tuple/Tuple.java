package toby.challenge.tuple;

import java.util.Arrays;
import java.util.List;

public class Tuple<T> implements Cloneable {
    private T[] contents;

    public Tuple (List<T> contents) {
        if (contents.size() < 2){
            throw new IllegalArgumentException();
        }
        this.contents = (T[]) contents.toArray();
    }

    public Tuple(T[] contents) {
        if (contents.length < 2){
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
        T[] clonedArray = Arrays.copyOf(this.contents, this.contents.length);
        deepClone.setContents(clonedArray);
        return deepClone;
    }

    public T[] getContents () {
        return this.contents.clone();
    }

    private void setContents(T[] contents) {
        this.contents = contents;
    }

    public int size(){
        return this.contents.length;
    }

    public T get(int tupleIndex){
        return this.contents[tupleIndex];
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
        return Arrays.equals(this.contents, otherTuple.getContents());
    }

    @Override
    public String toString () {
        return contents.toString();
    }
}

