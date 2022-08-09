package tests;

import items.*;
import items.containers.Bag;
import items.containers.Box;
import items.containers.Stack;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {
    @Test
    public void createItemTest() {
        // Negative weight
        assertThrows(IllegalArgumentException.class, () -> new Brick("brick",-0.5, "Red"));
        // Empty color
        assertThrows(IllegalArgumentException.class, () -> new Brick("brick", 0.5, ""));
        // Out of size range
        assertThrows(IllegalArgumentException.class, () -> new Ball("ball", 0.5, 10, "Green"));
        // Empty name
        assertThrows(IllegalArgumentException.class, () -> new Book("", 0.5, 3));
        // Random brick via static method
        assertEquals(
                new Brick("random_brick", new Random(100).nextDouble() * 10).toString(),
                Brick.createRandomWeightBrick("random_brick",100).toString());
        // Random book via static method
        assertEquals(
                new Book("random_book", new Random(100).nextDouble() * 10, new Random(100).nextInt(4)+1).toString(),
                Book.createRandomWeightBook("random_book",100).toString());
        // Random ball via static method
        assertEquals(new Ball("random_ball", new Random(100).nextDouble() * 10, 3, "Blue").toString(),
                Ball.createRandomWeightBall("random_ball", 100).toString());

    }

    @Test
    public void createContainerTest() {
        // Negative weight
        assertThrows(IllegalArgumentException.class, () -> new Bag("bag", -1.0, 25));
        // Empty name
        assertThrows(IllegalArgumentException.class, () -> new Stack("", 0.5, 3));
    }

}
