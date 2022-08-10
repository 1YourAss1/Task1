import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import items.Ball;
import items.Book;
import items.Brick;
import items.containers.Bag;
import items.containers.Box;
import svg.SVGWriter;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Brick brick1 = new Brick("brick1",5.5, 1,"indianred");
        Brick brick2 = new Brick("brick2",5.5, 1, "indianred");

        Book book1 = new Book("book1", 2.5, 1);
        Book book2 = new Book("book2", 1.5, 1);

        Ball ball1 = new Ball("ball1", 3.0, 1, "cornflowerblue");
        Ball ball2 = new Ball("ball2", 3.0, 1, "cornflowerblue");

        Bag bag = new Bag("Bag", 20.0, 1.0, 25);
        Box box = new Box("Box", 20.0, 0.5, 5);

        File svgFile = new File("items.svg");

        try (SVGWriter svgWriter = new SVGWriter(svgFile)) {
            svgWriter.writeHeader(5000, 2500);

            box.addItem(brick1);
            box.addItem(book1);
            box.addItem(ball1);

            bag.addItem(brick2);
            bag.addItem(book2);
            bag.addItem(ball2);
            bag.addItem(box);

            bag.write(10, 10, svgWriter);

            svgWriter.writeFooter();
//            Desktop.getDesktop().open(svgFile);
        } catch (ItemStoreException | ItemAlreadyPlacedException e) {
            throw new RuntimeException(e);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}
