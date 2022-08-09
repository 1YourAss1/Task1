package svg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SVGWriter extends FileWriter {
    public SVGWriter(File file) throws IOException {
        super(file);
    }

    public SVGWriter(String fileName) throws IOException {
        super(fileName);
    }


    public void write() throws IOException {
        writeHeader();
        writeReact(10, 10, 100, 50, "yellow", "red");
        writeRoundReact(10, 70, 100, 50, 30, 30, "green", "red");
        writeEllipse(80, 200, 50, 50, "yellow", "green");
        writeText(80, 200, "ellipse");
        writeFooter();
    }

    private void writeHeader() throws IOException {
        String header = new StringBuilder()
                .append("<?xml version=\"1.0\"?>\n\n")
                .append("<svg width=\"300\" height=\"300\" viewBox=\"0 0 300 300\" xmlns=\"http://www.w3.org/2000/svg\">\n\n")
                .toString();

        super.write(header);
    }

    private void writeFooter() throws IOException {
        String footer = "</svg>";
        super.write(footer);
    }

    private void writeReact(int x, int y, int w, int h, String fill, String stroke) throws IOException {
        String react = String.format("<rect x=\"%1$d\" y=\"%2$d\" width=\"%3$d\" height=\"%4$d\" style=\"fill:%5$s;stroke:%6$s\"/>\n\n",
                x, y, w, h, fill, stroke);
        super.write(react);
    }

    private void writeRoundReact(int x, int y, int w, int h, int rx, int ry, String fill, String stroke) throws IOException {
        String reactRound = String.format("<rect x=\"%1$d\" y=\"%2$d\" width=\"%3$d\" height=\"%4$d\" rx=\"%5$d\" ry=\"%6$d\" " +
                        "style=\"fill:%7$s;stroke:%8$s\"/>\n\n",
                x, y, w, h, rx, ry, fill, stroke);
        super.write(reactRound);
    }

    private void writeEllipse(int cx, int cy, int rx, int ry, String fill, String stroke) throws IOException {
        String ellipse = String.format("<ellipse cx=\"%1$d\" cy=\"%2$d\" rx=\"%3$d\" ry=\"%4$d\" style=\"fill:%5$s;stroke:%6$s;" +
                        "stroke-width:5px\"/>\n\n",
                cx, cy, rx, ry, fill, stroke);
        super.write(ellipse);
    }

    private void writeText(int x, int y, String text) throws IOException {
        text = String.format("<text x=\"%1$d\" y=\"%2$d\">%3$s</text>",
                x, y, text);
        super.write(text);
    }

}
