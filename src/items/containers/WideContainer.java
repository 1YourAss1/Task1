package items.containers;

import items.Item;
import items.Shape;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;

import java.util.ArrayList;

public class WideContainer extends Container {
    private static final String defColor = "grey";
    private static final double maxWeight = 50.0;

    protected WideContainer(String name, double weight, int size, Shape shape) {
        super(name, weight, size, shape, defColor);
        itemList = new ArrayList<>();
    }

    @Override
    protected boolean addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
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
    protected Item getItem() {
        int randomIndex = (int) (Math.random() * itemList.size()-1);
        Item item = itemList.get(randomIndex);
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

}
