package ed_recurso_8210126.API.StructureData;

import ed_recurso_8210126.API.ADTs.OrderedListADT;

public class OrderedArrayList<T extends Comparable<T>> extends ArrayList<T> implements OrderedListADT<T> {
    public OrderedArrayList() {
        super();
    }

    @Override
    public void add(T element) {
        if (size() == items.length) {
            expandCapacity();
        }

        // Encontra a posição apropriada para inserir o elemento mantendo a ordem
        int scan = 0;
        // sou obrigado a fazer o cast, então faço fora do while para não repetir
        Comparable<T> comparableElement = (Comparable<T>) element; 
        while (scan < rear && comparableElement.compareTo(items[scan]) > 0) {
            scan++;
        }

        // faz shift de tudo uma posição para a direita para caber o novo elemento
        for (int shift = rear; shift > scan; shift--) {
            items[shift] = items[shift - 1];
        }

        // insere o novo elemento
        items[scan] = element;
        
        modCount++;
        rear++;
    }
}
