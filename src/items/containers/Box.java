package items.containers;

import items.Item;
import items.Shape;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import svg.SVGWriter;

import java.io.IOException;
import java.util.Random;

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


}
