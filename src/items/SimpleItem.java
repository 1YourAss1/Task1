package items;

import svg.SVGWriter;

import java.io.IOException;

public abstract class SimpleItem extends Item {
    private static final int LIMIT_SIZE = 5;

    protected SimpleItem(String name, double weight, int size, Shape shape, String color) {
        super(name, weight, size, shape, color);

        if (size >= 1 && size <= LIMIT_SIZE) {
            this.size = size;
        } else {
            throw new IllegalArgumentException(String.format("Size must be in range 1-%d, not %d", LIMIT_SIZE, size));
        }
    }

}

