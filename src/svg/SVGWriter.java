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


    public void writeHeader(int w, int h) throws IOException {
        String header = new StringBuilder()
                .append("<?xml version=\"1.0\"?>\n\n")
                .append("<svg width=\"").append(w)
                .append("\" height=\"").append(h)
                .append("\" viewBox=\"0 0 ").append(w).append(" ").append(h)
                .append("\" xmlns=\"http://www.w3.org/2000/svg\">\n\n")
                .toString();

        super.write(header);
    }

    public void writeContainerHeader(int x, int y, int w, int h) throws IOException {
        String containerHeader = new StringBuilder("<svg ")
                .append("x=\"").append(x).append("\" ")
                .append("y=\"").append(y).append("\" ")
                .append("width=\"").append(w).append("\" ")
                .append("height=\"").append(h).append("\">\n").toString();
        super.write(containerHeader);
    }

    public void writeFooter() throws IOException {
        String footer = "</svg>\n\n";
        super.write(footer);
    }

    public void writeReact(int x, int y, int w, int h, String fill, String stroke, int strokeWidth) throws IOException {
        String react = String.format("<rect x=\"%1$d\" y=\"%2$d\" width=\"%3$d\" height=\"%4$d\" style=\"fill:%5$s;stroke:%6$s;" +
                        "stroke-width:%7$dpx\"/>\n",
                x, y, w, h, fill, stroke, strokeWidth);
        super.write(react);
    }

    public void writeRoundReact(int x, int y, int w, int h, int rx, int ry, String fill, String stroke, int strokeWidth) throws IOException {
        String reactRound = String.format("<rect x=\"%1$d\" y=\"%2$d\" width=\"%3$d\" height=\"%4$d\" rx=\"%5$d\" ry=\"%6$d\" " +
                        "style=\"fill:%7$s;stroke:%8$s;stroke-width:%9$dpx\"/>\n",
                x, y, w, h, rx, ry, fill, stroke, strokeWidth);
        super.write(reactRound);
    }

    public void writeEllipse(int cx, int cy, int rx, int ry, String fill, String stroke, int strokeWidth) throws IOException {
        String ellipse = String.format("<ellipse cx=\"%1$d\" cy=\"%2$d\" rx=\"%3$d\" ry=\"%4$d\" style=\"fill:%5$s;stroke:%6$s;" +
                        "stroke-width:%7$dpx\"/>\n",
                cx, cy, rx, ry, fill, stroke, strokeWidth);
        super.write(ellipse);
    }

    public void writeText(int x, int y, String text) throws IOException {
        text = String.format("<text x=\"%1$d\" y=\"%2$d\" dominant-baseline=\"central\" text-anchor=\"middle\">%3$s</text>\n",
                x, y, text);
        super.write(text);
    }

}
