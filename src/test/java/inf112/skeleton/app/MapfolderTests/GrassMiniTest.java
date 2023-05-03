package inf112.skeleton.app.MapfolderTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.GraphicsType;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;

import inf112.skeleton.app.Zelda;
import inf112.skeleton.app.Mapfolder.GrassMini;

public class GrassMiniTest {
    
    private HeadlessApplication app;
    private GrassMini map; 

    @BeforeAll
	static void setUpBeforeAll() {
        // Gdx.files = mock(Files.class);
        Gdx.gl = mock(GL20.class);       
        Gdx.gl20 = mock(GL20.class);
        // Gdx.graphics = mock(Graphics.class);   
	}

	/**
	 * Setup method called before each of the test methods
	 */
	@BeforeEach
	void setUpBeforeEach() {
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        app = new HeadlessApplication(new Zelda(), config);
        map = new GrassMini(0, 0);
        
        

	}

    /**
     * Tests that the tests are running headless
    */
    @Test
    void testRunningHeadless() {
        assertTrue(Gdx.graphics.getType() == GraphicsType.Mock);
    }
/*
    @Test
    void testSpawn() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        map.setup();
        assertNotNull(map.getMonsterList());
        assertEquals(20, map.getMonsterList().size());
        ArrayList<String> enemyList = new ArrayList<>(Arrays.asList("BlueEnemy", "RedEnemy"));
        map.spawn(enemyList);
        assertEquals(22, map.getMonsterList().size());
    }
 */
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
        assertEquals(104, map.getEnemyBoundsFromX());
    }

    @Test
    void testGetEnemyBoundsToX() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        assertEquals(133, map.getEnemyBoundsToX());
    }

    @Test
    void testGetEnemyBoundsFromY() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        assertEquals(56, map.getEnemyBoundsFromY());
    }

    @Test
    void testGetEnemyBoundsToY() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        assertEquals(85, map.getEnemyBoundsToY());
    }
/* 
    @Test
    void testGetMonsterList() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        assertEquals(20, map.getMonsterList().size());
    }

    @Test
    void testRemoveMonster() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        map.setup();
        assertNotNull(map.getMonsterList());
        assertEquals(20, map.getMonsterList().size());
        ArrayList<String> enemyList = new ArrayList<>(Arrays.asList("BlueEnemy", "RedEnemy"));
        map.spawn(enemyList);
        assertEquals(22, map.getMonsterList().size());
        map.removeMonster(map.getMonsterList().get(0));
        assertEquals(21, map.getMonsterList().size());
    }
*/
}
