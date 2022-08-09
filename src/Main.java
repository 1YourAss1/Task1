import svg.SVGWriter;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File svgFile = new File("test.svg");

        try (SVGWriter svgWriter = new SVGWriter(svgFile)) {
            svgWriter.write();
//            Desktop.getDesktop().open(svgFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
