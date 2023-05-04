package inf112.skeleton.app.ScreensTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Graphics.GraphicsType;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Southgame;
import inf112.skeleton.app.Controller.Controller;
import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Mapfolder.GrassMini;
import inf112.skeleton.app.Screens.View;
public class ViewTest {
    
    private HeadlessApplication app;
    private GrassMini map; 
    private View view;
    private Player player;
    private Controller controller;

    @BeforeAll
	static void setUpBeforeAll() {
        // Gdx.files = mock(Files.class);
        Gdx.gl = mock(GL20.class);       
        Gdx.gl20 = mock(GL20.class);
        Gdx.graphics = mock(Graphics.class);   
	}

	/**
	 * Setup method called before each of the test methods
	 */
	@BeforeEach
	void setUpBeforeEach() {
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        app = new HeadlessApplication(new Southgame(), config);
        controller = new Controller();
        GrassMini lvl1 = new GrassMini(0, 0);
        Player player = new Player(new Vector2(0, 0), lvl1, new Controller());
        view = new View(new Southgame(), new Controller(), player);
	}

    /**
     * Tests that the tests are running headless
    */
    @Test
    void testRunningHeadless() {
        assertTrue(Gdx.graphics.getType() == GraphicsType.Mock);
    }

    @Test
    void testSpawn() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        map.setup();
        assertNotNull(view.getMonsterList());

        // No monsters added yet
        assertEquals(0, view.getMonsterList().size());

        // Spawn the base amount of enemies (scaler=1)
        view.spawn(map.getEnemies(), 1, map);
        assertEquals(5, view.getMonsterList().size());
        
        // Spawn the base amount of monster x2 (pluss the 5 that are allready in the list)
        view.spawn(map.getEnemies(), 2, map);
        assertEquals(15, view.getMonsterList().size());
    }

    @Test
    void testMonsterDead() {
        GrassMini map = new GrassMini(123, 87);
        assertNotNull(map);
        map.setup();
        assertNotNull(view.getMonsterList());
        assertEquals(0, view.getMonsterList().size());
        view.spawn(map.getEnemies(), 1, map);
        assertEquals(5, view.getMonsterList().size());

        // Do leathal damage to the first and third monster in the list
        view.getMonsterList().get(0).takeDamage(100);
        view.getMonsterList().get(2).takeDamage(100);
        assertTrue(view.getMonsterList().get(0).isDead());
        assertFalse(view.getMonsterList().get(1).isDead());
        assertTrue(view.getMonsterList().get(2).isDead());        
    }
    
    @Test
    void testResize(){
        fail();
    }
}
