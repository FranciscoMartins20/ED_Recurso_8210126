package ed_recurso_8210126.API.ADTs;

import java.util.Iterator;

public interface ListADT<T> extends Iterable<T> {

    T first();

    T last();

    boolean isEmpty();

    int size();

    boolean contains(T target);

    T removeFirst();

    T removeLast();

    T remove(T element);

    Iterator<T> iterator();
}
