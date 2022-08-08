package tests;

import items.Brick;
import org.junit.jupiter.api.BeforeAll;

public class ComplexTest {
    Brick brick1, brick2, brick3;

    @BeforeAll
    public void setup() {
        brick1 = new Brick("brick1", 2.0, "Red");
    }

}
