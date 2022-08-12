import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import items.Ball;
import items.Book;
import items.Brick;
import items.Item;
import items.containers.Bag;
import items.containers.Box;
import items.containers.Stack;
import svg.SVGWriter;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        //ba

        Bag bag = new Bag("Bag", 1000.0, 1.0, 20);
        Box box = new Box("Box", 1000.0, 0.5, 7);
        Stack stack = new Stack("Stack", 0.5, 10);

        File svgFile = new File("items.svg");

        try (SVGWriter svgWriter = new SVGWriter(svgFile)) {
            svgWriter.writeHeader(5000, 2500);

            for (int i = 0; i < 20; i++) {
                box.addItem(Brick.createRandomWeightBrick(String.format("brick%d", i + 1)));
            }

            stack.addItem(Book.createRandomWeightBook("book1"));
            stack.addItem(Book.createRandomWeightBook("book2"));
            stack.addItem(Book.createRandomWeightBook("book3"));
            stack.addItem(box);

            bag.addItem(stack);

            bag.addItem(new Brick("bigBrick", 1.0, 5,"white"));
            for (int i = 0; i < 30; i++) {
                bag.addItem(Brick.createRandomWeightBrick(String.format("brick%d", i+1)));
            }
            for (int i = 0; i < 10; i++) {
                bag.addItem(Book.createRandomWeightBook(String.format("book%d", i+1)));
            }
            for (int i = 0; i < 10; i++) {
                bag.addItem(Ball.createRandomWeightBall(String.format("ball%d", i+1), 1, "cornflowerblue"));
            }


            bag.write(10, 10, svgWriter);

            svgWriter.writeFooter();
//            Desktop.getDesktop().open(svgFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ItemAlreadyPlacedException | ItemStoreException e) {
            throw new RuntimeException(e);
        }


    }
}
