package inf112.skeleton.app.Entities.EnumsTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import inf112.skeleton.app.Entities.Enums.ID;

public class IDTest {

    @Test
    public void testPlayer() {
        assertEquals(ID.Player, ID.valueOf("Player"));
    }

    @Test
    public void testEnemy() {
        assertEquals(ID.Enemy, ID.valueOf("Enemy"));
    }

    @Test
    public void testThing() {
        assertEquals(ID.Thing, ID.valueOf("Thing"));
    }
}