package ed_recurso_8210126.API.ADTs;


public interface UnorderedListADT<T> extends ListADT<T> {
    void addToFront(T element);

    void addToRear(T element);

    void addAfter(T element, T target) throws IllegalArgumentException;
}
