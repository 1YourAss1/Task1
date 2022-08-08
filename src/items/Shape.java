package items;

public enum Shape {
    SQUARE("Square"),
    CIRCLE("Circle"),
    FLAT("Flat");

    public final String label;

    Shape(String label) {
        this.label = label;
    }
}
