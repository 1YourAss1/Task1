package items;


public abstract class Item {
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

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }




    @Override
    public String toString() {
        return String.format("[Name:%s][Weight:%.3f][Size:%d][Shape:%s][Color:%s]\n", name, weight, size, shape.label, color);
    }

}
