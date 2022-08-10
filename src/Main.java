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
        Brick brick = new Brick("brick",5.5, 1,"red");

        Book book = new Book("book", 0.5, 1);

        Ball ball = new Ball("ball", 3.0, 1, "blue");

        Box box = new Box("Box", 10.0, 0.5, 5);

        Bag bag = new Bag("Bag", 15.0, 1.0, 5);

        File svgFile = new File("items.svg");

        try (SVGWriter svgWriter = new SVGWriter(svgFile)) {
            svgWriter.writeHeader(2000, 1000);


            bag.write(10, 10, svgWriter);
            box.write(10, 200, svgWriter);

//            brick.write(0, 0, svgWriter);
//
//            book.write(50, 50, svgWriter);
//
//            ball.write(100, 100, svgWriter);

            svgWriter.writeFooter();
//            Desktop.getDesktop().open(svgFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}
