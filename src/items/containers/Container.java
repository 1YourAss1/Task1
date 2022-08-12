package items.containers;

import items.Item;
import items.Shape;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;

import java.util.*;


public abstract class Container extends Item {
    protected final static Map<Item, Container> itemContainerMap = new HashMap<>(); // immutable setPlaced
    public static final int PADDING = 15;
    protected List<Item> itemCollection;

    protected Container(String name, double weight, int size, Shape shape, String color) {
        super(name, weight, size, shape, color);
    }

    abstract boolean addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException;

    abstract Item getItem() throws ItemStoreException;

    protected void clearContainer() {
        for (Item item : itemCollection) {
            Container.itemContainerMap.remove(item);
        }
        itemCollection.clear();
    }

    @Override
    public double getWeight() {
        return itemCollection.stream()
                .mapToDouble(Item::getWeight)
                .reduce(this.weight, Double::sum);
    }

    @Override
    public String toString() {
        return String.format("%s[Contains:%d items]", super.toString(), itemCollection.size());
    }
}
