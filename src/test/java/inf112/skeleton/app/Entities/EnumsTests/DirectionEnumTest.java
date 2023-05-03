package inf112.skeleton.app.Entities.EnumsTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import inf112.skeleton.app.Entities.Enums.DirectionEnum;

public class DirectionEnumTest {
    @Test
    public void testDirectionEnum() {
        assertEquals(DirectionEnum.WEST, DirectionEnum.valueOf("WEST"));
        assertEquals(DirectionEnum.EAST, DirectionEnum.valueOf("EAST"));
        assertEquals(DirectionEnum.NORTH, DirectionEnum.valueOf("NORTH"));
        assertEquals(DirectionEnum.SOUTH, DirectionEnum.valueOf("SOUTH"));

        assertEquals(DirectionEnum.WEST.toString(), "WEST");
        assertEquals(DirectionEnum.EAST.toString(), "EAST");
        assertEquals(DirectionEnum.NORTH.toString(), "NORTH");
        assertEquals(DirectionEnum.SOUTH.toString(), "SOUTH");

        assertEquals(DirectionEnum.values().length, 4);
    }
}
