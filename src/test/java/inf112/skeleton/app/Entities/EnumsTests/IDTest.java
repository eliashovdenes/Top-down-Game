package inf112.skeleton.app.Entities.EnumsTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import inf112.skeleton.app.Entities.Enums.ID;

public class IDTest {
    @Test
    public void testID() {
        assertEquals(ID.Player, ID.valueOf("Player"));
        assertEquals(ID.Enemy, ID.valueOf("Enemy"));
        assertEquals(ID.Thing, ID.valueOf("Thing"));

        assertEquals(ID.Player.toString(), "Player");
        assertEquals(ID.Enemy.toString(), "Enemy");
        assertEquals(ID.Thing.toString(), "Thing");

        assertEquals(ID.values().length, 3);
    }
}
