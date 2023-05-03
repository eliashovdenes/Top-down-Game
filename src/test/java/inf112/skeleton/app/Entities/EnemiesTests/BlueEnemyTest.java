package inf112.skeleton.app.Entities.EnemiesTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import inf112.skeleton.app.Entities.Enemies.BlueEnemy;
import inf112.skeleton.app.Entities.Enemies.MonsterInterface;
import inf112.skeleton.app.Entities.Enemies.RedEnemy;

public class BlueEnemyTest {

    MonsterInterface redEnemy;
    MonsterInterface blueEnemy;


    @BeforeEach 
    void setup(){
        redEnemy = new RedEnemy();
        blueEnemy = new BlueEnemy();
    }
    @Test
    void UpdateTest(){
        redEnemy.update(1);
    }

    @Test
    void setSpriteTest(){
        fail();
    }

    @Test
    void getSpriteTest(){
        fail();
    }
    @Test
    void setMovementSpeedTest(){
        fail();
    }
    @Test
    void getWidthTest(){
        fail();
    }
    @Test
    void getHeightTest(){
        fail();
    }
    @Test
    void setDirectionTest(){
        fail();
    }
    @Test
    void getDirectionTest(){
        fail();
    }
    @Test 
    void setXYFromSpawnBoundsTest(){
        fail();
    }
    @Test 
    void followPlayerTest(){
        fail();
    }

    @Test 
    void getPositionTest(){
        fail();
    }
    @Test
    void getRectTest(){
        fail();
    }
    
    @Test
    void getNameTest(){
        fail();
    }
    
    @Test
    void getDamageTest(){
        fail();
    }
    
    @Test
    void takeDamageTest(){
        fail();
    }

    @Test
    void getCurrentHitpointsTest(){
        fail();
    }
   
    
    @Test
    void isDeadTest(){
        fail();
    }

    @Test 
    void HealthPotionTest(){
        blueEnemy.setHealthPotionDropChance(0.3f);
        blueEnemy.getHealthPotionDropChance();
        fail();
    }


    @Test
    void geteProjectileListTest(){
        fail();
    }
}
