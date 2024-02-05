package ed_recurso_8210126.API.StructureData;

import ed_recurso_8210126.API.ADTs.UnorderedListADT;

public class UnorderedArrayList<T> extends ArrayList<T> implements UnorderedListADT<T> {
    // construtor e método add() permanecem como estão

    @Override
    public void addToFront(T element) {
        if (size() == items.length) {
            expandCapacity();
        }

        // Shift todos os elementos para a direita para abrir espaço para o novo elemento
        for (int i = rear; i > 0; i--) {
            items[i] = items[i - 1];
        }

        // Insere o novo elemento no início da lista
        items[0] = element;
        rear++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        addToRear(element);
    }

    @Override
    public void addAfter(T element, T target) throws IllegalArgumentException {
        int targetIndex = find(target);

        if (targetIndex == ELEMENT_NOT_FOUND) {
            throw new IllegalArgumentException("Elemento alvo não encontrado na lista.");
        }

        if (size() == items.length) {
            expandCapacity();
        }

        // Shift todos os elementos após o alvo para a direita
        for (int i = rear; i > targetIndex + 1; i--) {
            items[i] = items[i - 1];
        }

        // Insere o novo elemento após o alvo
        items[targetIndex + 1] = element;
        rear++;
        modCount++;
    }
}

