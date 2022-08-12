package items.containers;

import exceptions.ItemAlreadyPlacedException;
import items.Item;
import items.Shape;
import exceptions.ItemStoreException;
import svg.SVGWriter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.OptionalInt;

public class Stack extends Container {

    private static final Shape DEFAULT_SHAPE = Shape.NON;
    private static final String DEFAULT_COLOR = " ";
    private static final int MAX_ITEMS = 10;
    private int countItems;
    private int W, H;

    public Stack(String name, double weight, int size) {
        super(name, weight, size, DEFAULT_SHAPE, DEFAULT_COLOR);
        itemCollection = new LinkedList<>();
        countItems = 0;
    }

    @Override
    public boolean addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        if (item.getShape() != Shape.FLAT ) throw new ItemStoreException("Wrong shape for stack: allow only flat");

        if (Container.itemContainerMap.containsKey(item))
            throw new ItemAlreadyPlacedException(String.format(
                    "Can't add item \"%s\", because it is already placed in container \"%s\"",
                    item.getName(),
                    Container.itemContainerMap.get(item)));

        if (countItems <= MAX_ITEMS) {
            itemCollection.add(0, item);
            countItems++;
            Container.itemContainerMap.put(item, this);
            return true;
        } else throw new ItemStoreException("Stack is full");
    }

    @Override
    public Item getItem() throws ItemStoreException {
        if (itemCollection.size() == 0) throw new ItemStoreException("Container is empty");

        Item item = itemCollection.get(0);
        itemCollection.remove(0);
        Container.itemContainerMap.remove(item);

        return item;
    }

    @Override
    public void clearContainer() {
        super.clearContainer();
    }

    @Override
    public int getW() {
        return W;
    }

    @Override
    public int getH() {
        return H;
    }

    @Override
    public void write(int x, int y, SVGWriter svgWriter) throws IOException {
        int stackCenterX;
        OptionalInt optionalMaxInt = itemCollection.stream().mapToInt(Item::getW).max();
        if (optionalMaxInt.isPresent()) {
            this.W = optionalMaxInt.getAsInt();
            stackCenterX = (this.W / 2) + PADDING;
        } else stackCenterX = x;

        int stackY = y + PADDING;

        for (Item item : itemCollection) {
            item.write(stackCenterX - (item.getW() / 2), stackY, svgWriter);
            stackY += item.getH() + PADDING;
        }

        this.H = stackY;
    }
}
