package exceptions;

public class ItemStoreException extends Exception {
    public ItemStoreException() {}

    public ItemStoreException(String s) {
        super(s);
    }

    public ItemStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemStoreException(Throwable cause) {
        super(cause);
    }

}
