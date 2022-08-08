package tests;

import items.*;
import items.containers.Bag;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {
    @Test
    public void createItemTest() {
        /* ---------- Items ---------- */
        // Negative weight
        assertThrows(IllegalArgumentException.class, () -> new Brick("brick1",-0.5, "Red"));
        // Empty color
        assertThrows(IllegalArgumentException.class, () -> new Brick("brick2", 0.5, ""));
        // Out of size range
        assertThrows(IllegalArgumentException.class, () -> new Ball("ball1", 0.5, 10, "Green"));
        // Empty name
        assertThrows(IllegalArgumentException.class, () -> new Book("", 0.5, 3));
        // Random item via static method
        assertEquals(
                new Brick("random_brick", new Random(100).nextDouble() * 10).toString(),
                Brick.createRandomWeightBrick("random_brick",100).toString());

        /* ---------- Containers ---------- */
        // Negative weight
        assertThrows(IllegalArgumentException.class, () -> new Bag("bag1", -1.0, 25));
    }

}
