package ed_recurso_8210126.API.StructureData;

public class LinearNodeQueue<T> {
    private T element;
    private LinearNodeQueue<T> next;
    
    public LinearNodeQueue(T element, LinearNodeQueue<T> next) {
        this.element = element;
        this.next = next;
    }

    public LinearNodeQueue(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public LinearNodeQueue<T> getNext() {
        return next;
    }

    public void setNext(LinearNodeQueue<T> next) {
        this.next = next;
    }

}
