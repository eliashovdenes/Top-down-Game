package inf112.skeleton.app.Entities.EnumsTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import inf112.skeleton.app.Entities.Enums.BlueEnemyPics;

public class BlueEnemyPicsTest {
    
    @Test
    public void testSources() {
        assertEquals("assets/enemyPics/enemyDown.png", BlueEnemyPics.ENEMYDOWN.source);
        assertEquals("assets/enemyPics/enemyUp.png", BlueEnemyPics.ENEMYUP.source);
        assertEquals("assets/enemyPics/enemyLeft.png", BlueEnemyPics.ENEMYLEFT.source);
        assertEquals("assets/enemyPics/enemyRight.png", BlueEnemyPics.ENEMYRIGHT.source);
    }
}
