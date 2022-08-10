package tests;

import exceptions.ItemAlreadyPlacedException;
import exceptions.ItemStoreException;
import items.Ball;
import items.Book;
import items.Brick;
import items.Item;
import items.containers.Bag;
import items.containers.Box;
import items.containers.Stack;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexTest {
    Brick brick; Ball ball; Book book;
    Bag bag; Box box; Stack stack;

    @BeforeEach
    public void setup() {
        brick = new Brick("brick", 2.0, "Red");
        ball = new Ball("ball", 2.1, "White");
        book = new Book("book", 1.2, 3);

        bag = new Bag("bag", 5.0, 0.1, 10);
        box = new Box("box", 10.0, 0.5, 20);
        stack = new Stack("stack", 0.5, 7);
    }

    @Test
    public void addItemTest() throws ItemAlreadyPlacedException, ItemStoreException {
        // Add item to bag
        assertTrue(bag.addItem(brick));
        // Add item to box
        assertTrue(box.addItem(ball));
        // Add item to stack
        assertTrue(stack.addItem(book));
        // Try to add the item to the container again
        assertThrows(ItemAlreadyPlacedException.class, () -> bag.addItem(brick));
        // Try to add container to itself
        assertThrows(ItemStoreException.class, () -> bag.addItem(bag));
        // Try to add non-flat item to stack
        assertThrows(ItemStoreException.class, () -> stack.addItem(ball));
        // Add one container to another
        assertTrue(stack.addItem(box));
        assertTrue(bag.addItem(stack));
    }

    @Test
    public void weightTest() throws ItemAlreadyPlacedException, ItemStoreException {
        // Unit weight
        assertEquals(2.0, brick.getWeight());
        assertEquals(2.1, ball.getWeight());
        assertEquals(1.2, book.getWeight());
//        assertEquals(0.1, bag.getWeight());
        // Summarized weight
        bag.addItem(brick);
        bag.addItem(ball);
        bag.addItem(book);
        assertEquals(5.4, bag.getWeight(), 0.00001);
    }

    @Test
    public void getItemTest() throws ItemAlreadyPlacedException, ItemStoreException {
        // Try to get item from empty container
        assertThrows(ItemStoreException.class, () -> bag.getItem());
        assertThrows(ItemStoreException.class, () -> box.getItem());
        assertThrows(ItemStoreException.class, () -> stack.getItem());
        // Get item from wide container
        bag.addItem(brick);
        bag.addItem(ball);
        bag.addItem(book);
        assertInstanceOf(Item.class, bag.getItem());
        bag.clearContainer();
        // Get item from box
        box.addItem(brick);
        box.addItem(ball);
        box.addItem(book);
        assertInstanceOf(Item.class, box.getItem());
        box.clearContainer();
        // Get item from stack
        stack.addItem(book);
        stack.addItem(box);
        assertSame(stack.getItem(), box);
    }

    @Test
    public void findItemByNameTest() throws ItemAlreadyPlacedException, ItemStoreException {
        bag.addItem(brick);
        bag.addItem(ball);
        bag.addItem(book);
        assertEquals(2, bag.findItemByName("book"));
    }

}
