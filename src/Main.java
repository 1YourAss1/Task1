import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import items.Ball;
import items.Book;
import items.Brick;
import items.containers.Bag;
import items.containers.Box;
import svg.SVGWriter;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Brick brick1 = new Brick("brick1",5.5, 1,"indianred");

        Book book1 = new Book("book1", 2.5, 1);

        Ball ball1 = new Ball("ball1", 3.0, 1, "cornflowerblue");

        Bag bag = new Bag("Bag", 20.0, 1.0, 20);
        Box box = new Box("Box", 20.0, 0.5, 5);

        File svgFile = new File("items.svg");

        try (SVGWriter svgWriter = new SVGWriter(svgFile)) {
            svgWriter.writeHeader(5000, 2500);

            box.addItem(brick1);
            box.addItem(book1);
            box.addItem(ball1);

            for (int i = 0; i < 10; i++) {
                bag.addItem(Brick.createRandomWeightBrick(String.format("brick%d", i+1)));
            }
            for (int i = 0; i < 10; i++) {
                bag.addItem(Book.createRandomWeightBook(String.format("brick%d", i+1)));
            }
            for (int i = 0; i < 10; i++) {
                bag.addItem(Ball.createRandomWeightBall(String.format("brick%d", i+1), 1, "cornflowerblue"));
            }

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
