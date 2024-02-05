package ed_recurso_8210126.API.Exceptions;

public class EmptyCollectionException extends RuntimeException{
    public EmptyCollectionException() {
        super();
    }

    public EmptyCollectionException(String text) {
        super(text);
    }
}
