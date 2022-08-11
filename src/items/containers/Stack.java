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

    private static final Shape DEFAULT_SHAPE = Shape.SQUARE;
    private static final String DEFAULT_COLOR = "Grey";
    private static final int maxItems = 10;
    private int countItems;
    private int W, H;

    public Stack(String name, double weight, int size) {
        super(name, weight, size, DEFAULT_SHAPE, DEFAULT_COLOR);
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
        OptionalInt optionalMaxInt = itemList.stream().mapToInt(Item::getW).max();
        if (optionalMaxInt.isPresent()) {
            W = optionalMaxInt.getAsInt();
            stackCenterX = (W / 2) + PADDING;
        } else stackCenterX = x;

        int stackY = y + PADDING;

        for (Item item : itemList) {
            item.write(stackCenterX - (item.getW() / 2), stackY, svgWriter);
            stackY += item.getH();
        }

        H = stackY;
    }
}
