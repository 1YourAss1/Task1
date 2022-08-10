package items.containers;

import items.Item;
import items.Shape;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import svg.SVGWriter;

import java.io.IOException;

public class Box extends WideContainer {
    private static final Shape DEFAULT_SHAPE = Shape.FLAT;
    private static final String DEFAULT_COLOR = "sienna";

    public Box(String name, double weight, int size) {
        super(name, weight, size, DEFAULT_SHAPE, DEFAULT_COLOR);
    }

    public Box(String name, double maxWeight, double weight, int size) {
        super(name, maxWeight, weight, size, DEFAULT_SHAPE, DEFAULT_COLOR);
    }

    @Override
    public boolean addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        return super.addItem(item);
    }

    @Override
    public Item getItem() throws ItemStoreException {
        return super.getItem();
    }

    @Override
    public int findItemByName(String itemNameToFind) {
        return super.findItemByName(itemNameToFind);
    }

    @Override
    public void clearContainer() {
        super.clearContainer();
    }

    @Override
    public void write(int x, int y, SVGWriter svgWriter) throws IOException {
        svgWriter.writeContainerHeader(x, y, this.getV() + PADDING * 2, this.getH() + PADDING * 3);

        svgWriter.write("\t");
        int containerX = x + PADDING; int containerY = y + PADDING;
        svgWriter.writeReact(containerX, containerY, this.getV(), this.getH(), this.getColor(), "black", 5);

        svgWriter.write("\t");
        int centerX = (int) Math.round(containerX + this.getV() * 0.5);
        int centerY = Math.round(containerY + this.getH()) + 14;
        svgWriter.writeText(centerX, centerY, this.getName());

        svgWriter.writeFooter();
    }
}
