import items.Ball;
import items.Brick;
import svg.SVGWriter;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Brick brick = new Brick("brick",5.5, "Red");
        System.out.println(brick.getH());

        Ball ball = new Ball("ball", 0.5, 3, "Green");
        System.out.println(ball.getH());

        File svgFile = new File("test.svg");

        try (SVGWriter svgWriter = new SVGWriter(svgFile)) {
            svgWriter.write();
//            Desktop.getDesktop().open(svgFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
