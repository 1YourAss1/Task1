package items;

import svg.SVGWriter;

import java.io.IOException;
import java.util.Random;

public class Ball extends SimpleItem {
    private static final Shape DEFAULT_SHAPE = Shape.CIRCLE;
    private static final int DEFAULT_SIZE = 1;
    private static final String DEFAULT_COLOR = "blue";

    public Ball(String name, double weight, int size, String color) {
        super(name, weight, size, DEFAULT_SHAPE, color);
    }

    public Ball(String name, double weight, String color) {
        super(name, weight, DEFAULT_SIZE, DEFAULT_SHAPE, color);
    }

    public Ball(String name, double weight, int size) {
        super(name, weight, size, DEFAULT_SHAPE, DEFAULT_COLOR);
    }

    public Ball(String name, double weight) {
        super(name, weight, DEFAULT_SIZE, DEFAULT_SHAPE, DEFAULT_COLOR);
    }


    public static Ball createRandomWeightBall(String name, int size, String color) {
        double randId = new Random().nextDouble() * 10;
        return new Ball(name, randId, size);
    }

    // For test
    public static Ball createRandomWeightBall(String name, int seed) {
        double randId = new Random(seed).nextDouble() * 10;
        return new Ball(name, randId);
    }

    @Override
    public void write(int x, int y, SVGWriter svgWriter) throws IOException {
        int radiusX = this.getW() / 2;
        int radiusY = this.getH() / 2;
        int excenterX = x + radiusX, excenterY = y + radiusY;

        svgWriter.write("\t\t");
        svgWriter.writeEllipse(excenterX, excenterY, radiusX, radiusY, this.getColor(), "black", 1);
        svgWriter.write("\t\t");
        svgWriter.writeText(excenterX, excenterY + 4, this.getName());
    }

}
