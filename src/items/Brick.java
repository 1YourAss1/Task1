package items;


import java.util.Random;

public class Brick extends SimpleItem {
    private static final Shape defShape = Shape.FLAT;
    private static final int defSize = 2;
    private static final String defColor = "Red";


    public Brick(String name, double weight, int size, Shape shape, String color) {
        super(name, weight, size, shape, color);
    }

    public Brick(String name, double weight, int size, String color) {
        super(name, weight, size, defShape, color);
    }
    public Brick(String name, double weight, String color) {
        super(name, weight, defSize, defShape, color);
    }

    public Brick(String name, double weight) {
        super(name, weight, defSize, defShape, defColor);
    }


    public static Brick createRandomWeightBrick(String name) {
        double randId = new Random().nextDouble() * 10;
        return new Brick(name, randId);
    }

    // For test
    public static Brick createRandomWeightBrick(String name, int seed) {
        double randId = new Random(seed).nextDouble() * 10;
        return new Brick(name, randId);
    }
}
