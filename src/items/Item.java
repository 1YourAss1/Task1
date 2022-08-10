package items;


import items.containers.Container;
import svg.SVGWriter;

import java.io.IOException;

public abstract class Item {
    private static final int SCALE = 50;

    private final String name;
    protected final double weight; // >0
    protected int size; // 1-5
    private final Shape shape;
    private final String color;
    private boolean placed;

    protected Item(String name, double weight, int size, Shape shape, String color) {
        this.size = size;

        if (weight > 0.0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Weight must be greater than 0.0");
        }

        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name can't be empty");
        }

        this.shape = shape;

        if (!color.isEmpty()) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("Color can't be empty");
        }

        this.placed = false;
    }

    public String getName() { return name; }

    public double getWeight() { return weight; }

    public int getSize() { return size; }

    public Shape getShape() { return shape; }

    public String getColor() { return color; }

    public int getV() {
        switch (shape) {
            case SQUARE:
                return size * SCALE;
            case FLAT:
                return size * SCALE * 2;
            case CIRCLE:
                return (int) Math.round(size * SCALE / (Math.sqrt(Math.PI)));
            default:
                throw new IllegalArgumentException("This item has unknown shape, sorry");
        }
    }
    public int getH() {
        switch (shape) {
            case SQUARE:
                return size * SCALE;
            case FLAT:
                return (int) Math.round(size * SCALE * 0.5);
            case CIRCLE:
                return (int) Math.round(size * SCALE / (Math.sqrt(Math.PI)));
            default:
                throw new IllegalArgumentException("This item has unknown shape, sorry");
        }
    }

    public abstract void write(int x, int y, SVGWriter svgWriter) throws IOException;

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

    @Override
    public String toString() {
        return String.format("[Name:%s][Weight:%.3f][Size:%d][Shape:%s][Color:%s]", name, weight, size, shape.label, color);
    }

}
