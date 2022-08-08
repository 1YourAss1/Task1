package items.containers;

import items.Item;
import items.Shape;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;

public class Bag extends WideContainer {
    private static final Shape defShape = Shape.CIRCLE;

    public Bag(String name, double weight, int size) {
        super(name, weight, size, defShape);
    }

    public Bag(String name, double maxWeight, double weight, int size) {
        super(name, maxWeight, weight, size, defShape);
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
