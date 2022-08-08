package items;

public class Ball extends SimpleItem {
    private static final Shape defShape = Shape.CIRCLE;

    public Ball(String name, double weight, int size, String color) {
        super(name, weight, size, defShape, color);
    }

    public static Ball createRandomBall(String name, String color) {
        return new Ball(name,Math.random() * 10, (int) (Math.random() * 5) + 1, color);
    }
}
