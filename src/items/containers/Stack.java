package items.containers;

import exceptions.ItemAlreadyPlacedException;
import items.Item;
import items.Shape;
import exceptions.ItemStoreException;

import java.util.LinkedList;

public class Stack extends Container {

    private static final Shape defShape = Shape.SQUARE;
    private static final String defColor = "Grey";
    private static final int maxItems = 10;
    private int countItems;

    public Stack(String name, double weight, int size) {
        super(name, weight, size, defShape, defColor);
        itemList = new LinkedList<>();
        countItems = 0;
    }

    @Override
    public boolean addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        if (item.getShape() != Shape.FLAT ) throw new ItemStoreException("Wrong shape for stack: allow only flat");

        if (item.isPlaced()) throw new ItemAlreadyPlacedException("Can't add item, because it is already placed somewhere");

        if (countItems <= maxItems) {
            itemList.add(0, item);
            countItems++;
            item.setPlaced(true);
            return true;
        } else throw new ItemStoreException("Stack is full");
    }

    @Override
    public Item getItem() throws ItemStoreException {
        if (itemList.size() == 0) throw new ItemStoreException("Container is empty");

        Item item = itemList.get(0);
        itemList.remove(0);
        item.setPlaced(false);

        return item;
    }

    @Override
    public void clearContainer() {
        super.clearContainer();
    }
}
