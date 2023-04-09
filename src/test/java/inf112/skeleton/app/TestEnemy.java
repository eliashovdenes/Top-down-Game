package inf112.skeleton.app;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import inf112.skeleton.app.Entities.Enemies.BlueEnemy;
import inf112.skeleton.app.Entities.Enemies.RedEnemy;

public class TestEnemy {
    
    @Test 
    void testEnemyHitpoints(){
        // Mock Enemy
        RedEnemy redEnemy = mock(RedEnemy.class, Mockito.CALLS_REAL_METHODS);
        BlueEnemy blueEnemy = mock(BlueEnemy.class, Mockito.CALLS_REAL_METHODS);
        
        // Set hitpoints
        redEnemy.setMaxhitpoints(75);
        redEnemy.setCurrentHitPoints(redEnemy.getMaxHitpoints());
        blueEnemy.setMaxhitpoints(50);
        blueEnemy.setCurrentHitPoints(blueEnemy.getMaxHitpoints());
    
        // Check that enemy hitpoints are correct
        Assertions.assertEquals(75, redEnemy.getMaxHitpoints());
        Assertions.assertEquals(50, blueEnemy.getCurrentHitpoints());
        
        // Simulate damage and check that hit points updates correctly
        redEnemy.takeDamage(25);
        Assertions.assertEquals(50, redEnemy.getCurrentHitpoints());
        redEnemy.takeDamage(49);
        Assertions.assertEquals(1, redEnemy.getCurrentHitpoints());

        blueEnemy.takeDamage(10);
        Assertions.assertEquals(40, blueEnemy.getCurrentHitpoints());
        blueEnemy.takeDamage(22);
        Assertions.assertEquals(18, blueEnemy.getCurrentHitpoints());
        
    }   

}
