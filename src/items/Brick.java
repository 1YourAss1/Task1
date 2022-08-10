package items;


import svg.SVGWriter;

import java.io.IOException;
import java.util.Random;

public class Brick extends SimpleItem {
    private static final Shape DEFAULT_SHAPE = Shape.SQUARE;
    private static final int DEFAULT_SIZE = 2;
    private static final String DEFAULT_COLOR = "red";


    public Brick(String name, double weight, int size, Shape shape, String color) {
        super(name, weight, size, shape, color);
    }

    public Brick(String name, double weight, int size, String color) {
        super(name, weight, size, DEFAULT_SHAPE, color);
    }
    public Brick(String name, double weight, String color) {
        super(name, weight, DEFAULT_SIZE, DEFAULT_SHAPE, color);
    }

    public Brick(String name, double weight) {
        super(name, weight, DEFAULT_SIZE, DEFAULT_SHAPE, DEFAULT_COLOR);
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

    @Override
    public void write(int x, int y, SVGWriter svgWriter) throws IOException {
        svgWriter.writeReact(x, y, this.getV(), this.getH(), this.getColor(), "black", 1);
        int centerX = (int) Math.round(x + this.getV() * 0.5);
        int centerY = (int) Math.round(y + this.getH() * 0.5) + 4;
        svgWriter.writeText(centerX, centerY, this.getName());
    }
}
