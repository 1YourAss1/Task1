package exceptions;

public class ItemAlreadyPlacedException extends Exception{
    public ItemAlreadyPlacedException() {}

    public ItemAlreadyPlacedException(String s) {
        super(s);
    }

    public ItemAlreadyPlacedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemAlreadyPlacedException(Throwable cause) {
        super(cause);
    }
}
