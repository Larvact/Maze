package toby.challenge.tuple;

import java.util.Iterator;

public class TupleIterator<T> implements Iterator<T> {

    private Tuple<T> tuple;
    private int currentIndex;

    public TupleIterator(Tuple<T> tuple) {
        this.tuple = tuple;
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex < this.tuple.size();
    }

    @Override
    public T next() {
        this.currentIndex += 1;
        return this.tuple.getContents()[this.currentIndex - 1];
        }



}
