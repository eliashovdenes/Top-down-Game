package inf112.skeleton.app.MapfolderTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import com.badlogic.gdx.backends.headless.HeadlessApplication;

import static org.mockito.Mockito.mock;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.GraphicsType;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;

import inf112.skeleton.app.Southgame;
// import inf112.skeleton.app.Mapfolder.GrassMini;
import inf112.skeleton.app.Mapfolder.House;

public class HouseTest {
    
    private HeadlessApplication app;
    private House map; 

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
        map = new House();
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
        House map = new House();
        assertNotNull(map);
        assertEquals(18, map.getPlayerSpawnX(), 0.1);
    }

    @Test
    void testGetPlayerSpawnY() {
        House map = new House();
        assertNotNull(map);
        assertEquals(18, map.getPlayerSpawnY(), 0.1);
    }

    @Test
    void testGetEnemyBoundsFromX() {
        House map = new House();
        assertNotNull(map);
        assertEquals(13, map.getEnemyBoundsFromX());
    }

    @Test
    void testGetEnemyBoundsToX() {
        House map = new House();
        assertNotNull(map);
        assertEquals(30, map.getEnemyBoundsToX());
    }

    @Test
    void testGetEnemyBoundsFromY() {
        House map = new House();
        assertNotNull(map);
        assertEquals(32, map.getEnemyBoundsFromY());
    }

    @Test
    void testGetEnemyBoundsToY() {
        House map = new House();
        assertNotNull(map);
        assertEquals(34, map.getEnemyBoundsToY());
    }

    @Test
    void testSetup(){
        assertNotNull(map);
        map.setup();
        assertEquals(map.getEnemies().get("BlueEnemy"), 0);
        assertEquals(map.getEnemies().get("RedEnemy"), 0);
    }

    @Test
    void testGetMap(){
        assertNotNull(map);
        assertNotNull(map.getMap());
    }

    
}
