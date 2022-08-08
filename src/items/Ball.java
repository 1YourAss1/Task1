package items;

import java.util.Random;

public class Ball extends SimpleItem {
    private static final Shape defShape = Shape.CIRCLE;
    private static final int defSize = 3;
    private static final String defColor = "Blue";

    public Ball(String name, double weight, int size, String color) {
        super(name, weight, size, defShape, color);
    }

    public Ball(String name, double weight, String color) {
        super(name, weight, defSize, defShape, color);
    }

    public Ball(String name, double weight) {
        super(name, weight, defSize, defShape, defColor);
    }


    public static Ball createRandomWeightBall(String name, int size, String color) {
        double randId = new Random().nextDouble() * 10;
        return new Ball(name, randId);
    }

    // For test
    public static Ball createRandomWeightBall(String name, int seed) {
        double randId = new Random(seed).nextDouble() * 10;
        return new Ball(name, randId);
    }
}
