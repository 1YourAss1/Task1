package items;

import java.util.Random;

public class Book extends SimpleItem {
    private static final Shape defShape = Shape.FLAT;
    private static final String defColor = "white";

    public Book(String name, double weight, int size) {
        super(name, weight, size, defShape, defColor);
    }

    public static Brick createRandomWeightBook(String name) {
        double randId = new Random().nextDouble() * 10;
        return new Brick(name, randId);
    }

    // For test
    public static Brick createRandomWeightBook(String name, int seed) {
        double randId = new Random(seed).nextDouble() * 10;
        return new Brick(name, randId);
    }
}
