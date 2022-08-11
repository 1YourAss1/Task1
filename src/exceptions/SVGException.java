package exceptions;

public class SVGException extends  RuntimeException {
    public SVGException() {}

    public SVGException(String s) {
        super(s);
    }

    public SVGException(String message, Throwable cause) {
        super(message, cause);
    }

    public SVGException(Throwable cause) {
        super(cause);
    }
}
