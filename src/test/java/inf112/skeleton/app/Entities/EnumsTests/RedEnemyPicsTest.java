package inf112.skeleton.app.Entities.EnumsTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import inf112.skeleton.app.Entities.Enums.RedEnemyPics;

public class RedEnemyPicsTest {

    @Test
    void testGetSource() {
        assertEquals(RedEnemyPics.ENEMYDOWN.source, "assets/enemyPics/redEnemyDown.png");
        assertEquals(RedEnemyPics.ENEMYUP.source, "assets/enemyPics/redEnemyUP.png");
        assertEquals(RedEnemyPics.ENEMYLEFT.source, "assets/enemyPics/redEnemyLEFT.png");
        assertEquals(RedEnemyPics.ENEMYRIGHT.source, "assets/enemyPics/redEnemyRIGHT.png");
        assertEquals(RedEnemyPics.REDPROJECTILE.source, "assets/projectilePics/RedProjectile.png");
    }
}