package inf112.skeleton.app.Entities.EnumsTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import inf112.skeleton.app.Entities.Enums.BlueEnemyPics;

public class BlueEnemyPicsTest {
    
    @Test
    public void testBlueEnemyPics() {
        assertEquals(BlueEnemyPics.ENEMYDOWN.source, "assets/enemyPics/enemyDown.png");
        assertEquals(BlueEnemyPics.ENEMYUP.source, "assets/enemyPics/enemyUp.png");
        assertEquals(BlueEnemyPics.ENEMYLEFT.source, "assets/enemyPics/enemyLeft.png");
        assertEquals(BlueEnemyPics.ENEMYRIGHT.source, "assets/enemyPics/enemyRight.png");
    }
}
