package items.containers;

import items.Item;
import items.Shape;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;

import java.util.List;


public abstract class Container extends Item {
    protected List<Item> itemList;

    protected Container(String name, double weight, int size, Shape shape, String color) {
        super(name, weight, size, shape, color);
    }

    abstract boolean addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException;

    abstract Item getItem();

    @Override
    public double getWeight() {
        double totalWeight = this.weight;
        for (Item item : itemList) {
            totalWeight += item.getWeight();
        }
        return totalWeight;

    }

}
