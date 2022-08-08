package items;

public class Book extends SimpleItem {
    private static final Shape defShape = Shape.FLAT;
    private static final String defColor = "white";

    public Book(String name, double weight, int size) {
        super(name, weight, size, defShape, defColor);
    }

    public static Book createRandomBook(String name) {
        return new Book(name, Math.random() * 10, (int) (Math.random() * 5) + 1);
    }
}
