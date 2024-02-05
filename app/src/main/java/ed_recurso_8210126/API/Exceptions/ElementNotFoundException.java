package ed_recurso_8210126.API.Exceptions;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException() {
        super();
    }

    public ElementNotFoundException(String text) {
        super(text);
    }
}
