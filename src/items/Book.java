package items;

import svg.SVGWriter;

import java.io.IOException;
import java.util.Random;

public class Book extends SimpleItem {
    private static final Shape DEFAULT_SHAPE = Shape.FLAT;
    private static final String DEFAULT_COLOR = "oldlace";

    public Book(String name, double weight, int size) {
        super(name, weight, size, DEFAULT_SHAPE, DEFAULT_COLOR);
    }


    public static Book createRandomWeightBook(String name) {
        double randWeight = new Random().nextDouble() * 10;
        int randSize = new Random().nextInt(4) + 1;
        return new Book(name, randWeight, randSize);
    }

    // For test
    public static Book createRandomWeightBook(String name, int seed) {
        double randWeight = new Random(seed).nextDouble() * 10;
        int randSize = new Random(100).nextInt(4)+1;
        return new Book(name, randWeight, randSize);
    }

    @Override
    public void write(int x, int y, SVGWriter svgWriter) throws IOException {
        svgWriter.write("\t\t");
        svgWriter.writeReact(x, y, this.getW(), this.getH(), this.getColor(), "black", 1);
        int centerX = (int) Math.round(x + this.getW() * 0.5);
        int centerY = (int) Math.round(y + this.getH() * 0.5) + 4;
        svgWriter.write("\t\t");
        svgWriter.writeText(centerX, centerY, this.getName());
    }
}
