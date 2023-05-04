package inf112.skeleton.app.MapfolderTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.mock;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.GraphicsType;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;

import inf112.skeleton.app.Southgame;
import inf112.skeleton.app.Mapfolder.Level1Mini;


public class Level1MapTest {
    
    private HeadlessApplication app;
    private Level1Mini map; 

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
        app = new HeadlessApplication(new Southgame(), config);
        map = new Level1Mini(0, 0);
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
        Level1Mini map = new Level1Mini(123, 87);
        assertNotNull(map);
        assertEquals(123, map.getPlayerSpawnX(), 0.1);
    }

    @Test
    void testGetPlayerSpawnY() {
        Level1Mini map = new Level1Mini(123, 87);
        assertNotNull(map);
        assertEquals(87, map.getPlayerSpawnY(), 0.1);
    }

    @Test
    void testGetEnemyBoundsFromX() {
        Level1Mini map = new Level1Mini(123, 87);
        assertNotNull(map);
        assertEquals(200, map.getEnemyBoundsFromX());
    }

    @Test
    void testGetEnemyBoundsToX() {
        Level1Mini map = new Level1Mini(123, 87);
        assertNotNull(map);
        assertEquals(800, map.getEnemyBoundsToX());
    }

    @Test
    void testGetEnemyBoundsFromY() {
        Level1Mini map = new Level1Mini(123, 87);
        assertNotNull(map);
        assertEquals(200, map.getEnemyBoundsFromY());
    }

    @Test
    void testGetEnemyBoundsToY() {
        Level1Mini map = new Level1Mini(123, 87);
        assertNotNull(map);
        assertEquals(800, map.getEnemyBoundsToY());
    }
}
