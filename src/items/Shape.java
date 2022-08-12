package items;

public enum Shape {
    SQUARE("Square"),
    CIRCLE("Circle"),
    FLAT("Flat"),
    NON("");

    public final String label;

    Shape(String label) {
        this.label = label;
    }
}
