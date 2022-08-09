package items;

import java.util.Random;

public class Book extends SimpleItem {
    private static final Shape defShape = Shape.FLAT;
    private static final String defColor = "White";

    public Book(String name, double weight, int size) {
        super(name, weight, size, defShape, defColor);
    }


    public static Book createRandomWeightBook(String name) {
        double randWeight = new Random().nextDouble() * 10;
        int randSize = new Random().nextInt(5);
        return new Book(name, randWeight, randSize);
    }

    // For test
    public static Book createRandomWeightBook(String name, int seed) {
        double randWeight = new Random(seed).nextDouble() * 10;
        int randSize = new Random(100).nextInt(4)+1;
        return new Book(name, randWeight, randSize);
    }
}
