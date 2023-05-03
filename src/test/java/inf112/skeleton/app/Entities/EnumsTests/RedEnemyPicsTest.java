package inf112.skeleton.app.Entities.EnumsTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import inf112.skeleton.app.Entities.Enums.RedEnemyPics;

public class RedEnemyPicsTest {

    @Test
    void testGetSource() {
        assertEquals(RedEnemyPics.ENEMYDOWN.source, "assets/enemyPics/RedEnemyDOWN.png");
        assertEquals(RedEnemyPics.ENEMYUP.source, "assets/enemyPics/RedEnemyUP.png");
        assertEquals(RedEnemyPics.ENEMYLEFT.source, "assets/enemyPics/RedEnemyLEFT.png");
        assertEquals(RedEnemyPics.ENEMYRIGHT.source, "assets/enemyPics/RedEnemyRIGHT.png");
        assertEquals(RedEnemyPics.REDPROJECTILE.source, "assets/projectilePics/RedProjectile.png");
    }
}