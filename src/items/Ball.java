package items;

import svg.SVGWriter;

import java.io.IOException;
import java.util.Random;

public class Ball extends SimpleItem {
    private static final Shape defShape = Shape.CIRCLE;
    private static final int defSize = 3;
    private static final String defColor = "blue";

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

    @Override
    public void write(int x, int y, SVGWriter svgWriter) throws IOException {
        int excenterX = x + this.getV(), excenterY = y + this.getH();
        svgWriter.write("\t\t");
        svgWriter.writeEllipse(excenterX, excenterY, this.getV(), this.getH(), this.getColor(), "black", 1);
        svgWriter.write("\t\t");
        svgWriter.writeText(excenterX, excenterY + 4, this.getName());
    }

}
