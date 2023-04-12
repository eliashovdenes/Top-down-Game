package inf112.skeleton.app;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import inf112.skeleton.app.Entities.Player.Player;

public class PlayerTest {

    /**
	 * Static method run before everything else
	 */
	@BeforeAll
	static void setUpBeforeAll() {
        // Gdx.files = mock(Files.class);
        // Gdx.gl = mock(GL20.class);       
        // Gdx.gl20 = mock(GL20.class);
        // Gdx.graphics = mock(Graphics.class);   
	}

	/**
	 * Setup method called before each of the test methods
	 */
	@BeforeEach
	void setUpBeforeEach() {
	}

    @Test 
    void testPlayerHitPoints(){
        // Mock Player
        Player player = mock(Player.class, Mockito.CALLS_REAL_METHODS);
        
        // Set lives and hitpoints
        player.setMaxhitpoints(100);
        player.setCurrentHitPoints(player.getMaxHitpoints());
        player.setLives(3);
    
        // Check that player has 100 current and maxHitpoints and 3 lives
        Assertions.assertEquals(100, player.getMaxHitpoints());
        Assertions.assertEquals(100, player.getCurrentHitpoints());
        Assertions.assertEquals(3, player.getLives());
        
        // Simulate player damage and check that hit points updates correctly
        player.takeDamage(25);
        Assertions.assertEquals(75, player.getCurrentHitpoints());
        player.takeDamage(50);
        Assertions.assertEquals(25, player.getCurrentHitpoints());
        
    }   
    
    @Test
    void testPlayerIsDead() {
        // Mock Player
        Player player = mock(Player.class, Mockito.CALLS_REAL_METHODS);
        
        // Set lives and hitpoints
        player.setMaxhitpoints(100);
        player.setCurrentHitPoints(player.getMaxHitpoints());
        player.setLives(2);

        // Test if player is dead
        assertFalse(player.isDead());

        // Player dies and respawn, life should be reduced by 1, HP should be equal to MaxHP
        player.takeDamage(100);
        assertFalse(player.isDead());
        assertEquals(100, player.getCurrentHitpoints());
        assertEquals(1, player.getLives());

        // Test player is dead when lives = 0
        player.takeDamage(200);
        assertTrue(player.isDead());
        assertEquals(0, player.getCurrentHitpoints());
        assertEquals(0, player.getLives());
    }
    
}
