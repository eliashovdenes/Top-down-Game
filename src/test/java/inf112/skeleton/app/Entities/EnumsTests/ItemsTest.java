package inf112.skeleton.app.Entities.EnumsTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import inf112.skeleton.app.Entities.Enums.Items;


public class ItemsTest {

    @Test
    public void testSource() {
        assertEquals("assets/Items/HealthPotion.png", Items.HEALTHPOTION.source);
    }
}