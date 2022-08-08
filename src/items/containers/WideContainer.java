package items.containers;

import items.Item;
import items.Shape;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;

import java.util.ArrayList;
import java.util.Random;

public class WideContainer extends Container {
    private static final String defColor = "Grey";
    private final double maxWeight;

    protected WideContainer(String name, double maxWeight, double weight, int size, Shape shape) {
        super(name, weight, size, shape, defColor);
        this.maxWeight = maxWeight;
        itemList = new ArrayList<>();
    }

    protected WideContainer(String name, double weight, int size, Shape shape) {
        super(name, weight, size, shape, defColor);
        this.maxWeight = 50;
        itemList = new ArrayList<>();
    }


    @Override
    protected boolean addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        if (item == this) throw new ItemStoreException("Container cannot be placed inside itself");

        if (item.isPlaced()) throw new ItemAlreadyPlacedException("Can't add item, because it is already placed somewhere");

        if ((weight + item.getWeight()) < maxWeight) {
            itemList.add(item);
            item.setPlaced(true);
            return true;
        } else {
            throw new ItemStoreException(String.format("Out of max weight (%.2f)", maxWeight));
        }
    }

    @Override
    protected Item getItem() throws ItemStoreException {
        if (itemList.size() == 0) throw new ItemStoreException("Container is empty");

        int randomIndex = new Random().nextInt(itemList.size());
        Item item = itemList.get(randomIndex);
        itemList.remove(randomIndex);
        item.setPlaced(false);

        return item;
    }

    protected int findItemByName(String itemNameToFind) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getName().equals(itemNameToFind)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void clearContainer() {
        super.clearContainer();
    }
}
