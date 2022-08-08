package items;

import java.util.Random;

public class Ball extends SimpleItem {
    private static final Shape defShape = Shape.CIRCLE;

    public Ball(String name, double weight, int size, String color) {
        super(name, weight, size, defShape, color);
    }

    public static Brick createRandomWeightBall(String name) {
        double randId = new Random().nextDouble() * 10;
        return new Brick(name, randId);
    }

    // For test
    public static Brick createRandomWeightBall(String name, int seed) {
        double randId = new Random(seed).nextDouble() * 10;
        return new Brick(name, randId);
    }
}
