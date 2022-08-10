package items.containers;

import items.Item;
import items.Shape;
import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import svg.SVGWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WideContainer extends Container {
    private final double maxWeight;
    public static final int PADDING = 15;

    protected WideContainer(String name, double maxWeight, double weight, int size, Shape shape, String color) {
        super(name, weight, size, shape, color);
        this.maxWeight = maxWeight;
        itemList = new ArrayList<>();
    }

    protected WideContainer(String name, double weight, int size, Shape shape, String color) {
        super(name, weight, size, shape, color);
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

    @Override
    public void write(int x, int y, SVGWriter svgWriter) throws IOException {
        // Write header for wide-container
//        svgWriter.write("\t");
//        svgWriter.writeContainerHeader(x, y, this.getV() + PADDING * 2, this.getH() + PADDING * 3);
        // Write wide-container
        svgWriter.write("\t\t");
//        int containerX = x + PADDING; int containerY = y + PADDING;
        switch (this.getShape()) {
            case SQUARE:
//                svgWriter.writeRoundReact(containerX, containerY, this.getV(), this.getH(), 50, 50, this.getColor(), "black", 5);
                svgWriter.writeRoundReact(x, y, this.getV(), this.getH(), 50, 50, this.getColor(), "black", 5);
                break;
            case FLAT:
                svgWriter.writeReact(x, y, this.getV(), this.getH(), this.getColor(), "black", 5);
                break;
            default:
                throw new RuntimeException("Can't write container with unknown shape to svg.");
        }
        // Write wide-container name
        svgWriter.write("\t\t");
//        int centerX = (int) Math.round(containerX + this.getV() * 0.5);
//        int centerY = Math.round(containerY + this.getH()) + 14;
        int centerX = (int) Math.round(x + this.getV() * 0.5);
        int centerY = Math.round(y + this.getH()) + 14;
        svgWriter.writeText(centerX, centerY, this.getName());
        // Write all items with random coordinates in wide-container
        for (Item item : itemList) {
            int randX = new Random().nextInt(this.getV() - item.getV()*2 - PADDING) + x + PADDING;
            int randY = new Random().nextInt(this.getH() - item.getH()* 2 - PADDING) + y + PADDING;
            svgWriter.write("\n");
            item.write(randX, randY, svgWriter);
            svgWriter.write("\n");
        }
        // Write footer for wide-container
//        svgWriter.write("\t");
//        svgWriter.writeFooter();
    }

}
