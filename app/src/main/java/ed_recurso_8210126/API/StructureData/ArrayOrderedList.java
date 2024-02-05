package ed_recurso_8210126.API.StructureData;

import ed_recurso_8210126.API.ADTs.OrderedListADT;

public class ArrayOrderedList<T extends Comparable<T>> extends ArrayList<T> implements OrderedListADT<T> {

    /******************************************************************
     * Creates an empty sorted list using the default capacity.
     ******************************************************************/
    public ArrayOrderedList() {
        super();
    }

    /******************************************************************
     * Creates an empty sorted list using the specified capacity.
     ******************************************************************/
    public ArrayOrderedList(int initialCapacity) {
        super(initialCapacity);
    }

    /******************************************************************
     * Adds the specified element to the list in a sorted manner.
     ******************************************************************/
    @Override
    public void add(T element) {
        if (rear == list.length) {
            expandCapacity();
        }

        int index = 0;

        // Find the correct position to insert the element
        while (index < rear && element.compareTo(list[index]) > 0) {
            index++;
        }

        // Shift elements to make space for the new element
        for (int i = rear; i > index; i--) {
            list[i] = list[i - 1];
        }

        // Insert the element at the correct position
        list[index] = element;
        rear++;
    }

    public void clear() {
        rear = 0;
    }
}
