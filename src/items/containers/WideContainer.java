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
        svgWriter.write("\t\t");

        switch (this.getShape()) {
            case SQUARE:
                svgWriter.writeRoundReact(x, y, this.getW(), this.getH(), 50, 50, this.getColor(), "black", 5);
                break;
            case FLAT:
                svgWriter.writeReact(x, y, this.getW(), this.getH(), this.getColor(), "black", 5);
                break;
            default:
                throw new RuntimeException("Can't write container with unknown shape to svg.");
        }
        // Write wide-container name
        svgWriter.write("\t\t");

        int centerX = (int) Math.round(x + this.getW() * 0.5);
        int centerY = Math.round(y + this.getH()) + 14;
        svgWriter.writeText(centerX, centerY, this.getName());
        // Write all items in wide-container
        int itemX = x + PADDING;
        int itemY = y + PADDING;
        int maxLineItemH = 0;

        for (Item item : itemList) {
            // Check right border
            if ((itemX + item.getW()) >= this.getW()) {
                itemX = x + PADDING;
                itemY += maxLineItemH + PADDING;
                maxLineItemH = 0;
            }
            // Check bottom border
            if ((itemY + item.getH()) >= this.getH()) {
                System.out.printf("%s does not fit", item.getName());
                continue;
            }
            // Write item
            svgWriter.write("\n");
            item.write(itemX, itemY, svgWriter);
            svgWriter.write("\n");
            // Edit aux variables
            maxLineItemH = Math.max(item.getH(), maxLineItemH);
            itemX += item.getW() + PADDING;
//            ----- RANDOM -----
//            int randX, randY;
//            if ((this.getV() - item.getV() - PADDING) >= 0 && (this.getH() - item.getH() - PADDING) >= 0) {
//                randX = new Random().nextInt(this.getV() - item.getV() - PADDING) + x + PADDING;
//                randY = new Random().nextInt(this.getH() - item.getH() - PADDING) + y + PADDING;
//            } else {
//                System.out.printf("Item %s size is too big for container %s\n", item.getName(), this.getName());
//                continue;
//            }
//            item.write(randX, randY, svgWriter);
//            ----- RANDOM -----
        }
    }

}
