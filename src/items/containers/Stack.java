package items.containers;

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
    public boolean addItem(Item item) throws ItemStoreException {
        if (item.getShape() != Shape.FLAT ) throw new ItemStoreException("Wrong shape for stack: allow only flat");

        if (countItems <= maxItems) {
            itemList.add(0, item);
            countItems++;
            return true;
        } else throw new ItemStoreException("Stack is full");
    }

    @Override
    public Item getItem() {
        return itemList.get(0);
    }

}
