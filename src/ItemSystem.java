import items.Item;
import svg.SVGWriter;

import java.awt.*;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ItemSystem {
    private final TreeMap<String, Item> itemTreeMap = new TreeMap<>();
    private final TreeMap<String, Point> pointTreeMap = new TreeMap<>();

    public void addItemToSystem(Item item, int x, int y) {
        itemTreeMap.put(item.getName(), item);
        pointTreeMap.put(item.getName(), new Point(x, y));
    }

    public boolean writeToSVG(String filename) {
        try (SVGWriter svgWriter = new SVGWriter(filename)){
            svgWriter.writeHeader(5000, 2500);

            for (Map.Entry<String, Item> entry : itemTreeMap.entrySet()) {
                Item item = entry.getValue();
                String name = entry.getKey();
                Point point = pointTreeMap.get(name);
                item.write(point.x, point.y, svgWriter);
            }

            svgWriter.writeFooter();
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
