package items.containers;

import items.Item;
import items.Shape;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;

public class Box extends WideContainer {
    private static final Shape defShape = Shape.FLAT;

    public Box(String name, double weight, int size) {
        super(name, weight, size, defShape);
    }

    @Override
    public boolean addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        return super.addItem(item);
    }

    @Override
    public Item getItem() {
        return super.getItem();
    }

    @Override
    public int findItemByName(String itemNameToFind) {
        return super.findItemByName(itemNameToFind);
    }
}