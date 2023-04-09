package inf112.skeleton.app;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Mapfolder.MapInterface;

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
    
    
    
}
