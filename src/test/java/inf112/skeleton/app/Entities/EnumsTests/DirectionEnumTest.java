package inf112.skeleton.app.Entities.EnumsTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import inf112.skeleton.app.Entities.Enums.DirectionEnum;



public class DirectionEnumTest {

    @Test
    public void testWest() {
        assertEquals(DirectionEnum.WEST, DirectionEnum.valueOf("WEST"));
    }

    @Test
    public void testEast() {
        assertEquals(DirectionEnum.EAST, DirectionEnum.valueOf("EAST"));
    }

    @Test
    public void testNorth() {
        assertEquals(DirectionEnum.NORTH, DirectionEnum.valueOf("NORTH"));
    }

    @Test
    public void testSouth() {
        assertEquals(DirectionEnum.SOUTH, DirectionEnum.valueOf("SOUTH"));
    }
}