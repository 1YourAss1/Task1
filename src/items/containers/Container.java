package items.containers;

import items.Item;
import items.Shape;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;


public abstract class Container extends Item {
    public static final int PADDING = 15;
    protected List<Item> itemList;
//    protected Collection<Item> itemCollection; // getWeight whit stream
    // protected static Map<Item, Container> itemContainerMap; // immutable setPlaced

    protected Container(String name, double weight, int size, Shape shape, String color) {
        super(name, weight, size, shape, color);
    }

    abstract boolean addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException;

    abstract Item getItem() throws ItemStoreException;

    protected void clearContainer() {
        for (Item item : itemList) {
            item.setPlaced(false);
        }
        itemList.clear();
    }

    @Override
    public double getWeight() {
//        double totalWeight = this.weight + itemCollection.stream()
//                .mapToDouble(Item::getWeight)
//                .sum();

        double totalWeight = this.weight;
        for (Item item : itemList) {
            totalWeight += item.getWeight();
        }

        return totalWeight;
    }

    @Override
    public String toString() {
        return String.format("%s[Contains:%d items]", super.toString(), itemList.size());
    }
}
