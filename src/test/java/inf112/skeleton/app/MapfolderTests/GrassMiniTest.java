package inf112.skeleton.app.MapfolderTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.GraphicsType;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;

import inf112.skeleton.app.Southgame;
import inf112.skeleton.app.Mapfolder.GrassMini;

public class GrassMiniTest {
    
    private HeadlessApplication app;
    private GrassMini map; 
    

    @BeforeAll
	static void setUpBeforeAll() {
        Gdx.gl = mock(GL20.class);       
        Gdx.gl20 = mock(GL20.class);  
	}

	/**
	 * Setup method called before each of the test methods
	 */
	@BeforeEach
	void setUpBeforeEach() {
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        Southgame game = mock(Southgame.class);
        app = new HeadlessApplication(game, config);
        map = new GrassMini(0, 0);
	}

    /**
     * Tests that the tests are running headless
    */
    @Test
    void testRunningHeadless() {
        assertTrue(Gdx.graphics.getType() == GraphicsType.Mock);
    }

    @Test
    void testGetPlayerSpawnX() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        assertEquals(123, map.getPlayerSpawnX(), 0.1);
    }

    @Test
    void testGetPlayerSpawnY() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        assertEquals(87, map.getPlayerSpawnY(), 0.1);
    }

    @Test
    void testGetEnemyBoundsFromX() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        assertEquals(108, map.getEnemyBoundsFromX());
    }

    @Test
    void testGetEnemyBoundsToX() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        assertEquals(131, map.getEnemyBoundsToX());
    }

    @Test
    void testGetEnemyBoundsFromY() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        assertEquals(58, map.getEnemyBoundsFromY());
    }

    @Test
    void testGetEnemyBoundsToY() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        assertEquals(81, map.getEnemyBoundsToY());
    }
}
