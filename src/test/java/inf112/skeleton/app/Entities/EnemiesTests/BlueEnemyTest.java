package inf112.skeleton.app.Entities.EnemiesTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.GraphicsType;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Southgame;
import inf112.skeleton.app.Entities.Enemies.BlueEnemy;
import inf112.skeleton.app.Entities.Enemies.MonsterFactory;
import inf112.skeleton.app.Entities.Enemies.MonsterInterface;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Projectiles.ProjectileInterface;
import inf112.skeleton.app.Mapfolder.Level1Mini;


public class BlueEnemyTest {
    
    
    private HeadlessApplication app;
    private BlueEnemy blueEnemy;
    private Level1Mini map; 
    

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
        app = new HeadlessApplication(new Southgame(), config);
        map = new Level1Mini(0, 0);
        blueEnemy = new BlueEnemy(map, 1);
        

	}

    /**
     * Tests that the tests are running headless
    */
    @Test
    void testRunningHeadless() {
        assertTrue(Gdx.graphics.getType() == GraphicsType.Mock);
    }

    @Test
    public void testSetMovementSpeed() {
        blueEnemy.setMovementSpeed(1.0f);
        assertEquals(1.0f, blueEnemy.getSpeed(), 0.01f);
    }

    @Test
    public void testGetWidth() {
        float width = blueEnemy.getSprite().getWidth();
        assertEquals(width, blueEnemy.getWidth(), 0.01f);
    }

    @Test
    public void testGetHeight() {
        float height = blueEnemy.getSprite().getHeight();
        assertEquals(height, blueEnemy.getHeight(), 0.01f);
    }

    @Test
    public void testSetDirection() {
        blueEnemy.setDirection(DirectionEnum.NORTH);
        assertEquals(DirectionEnum.NORTH, blueEnemy.getDirection());
    }

    @Test
    public void testGetPosition() {
        Vector2 position = blueEnemy.getPosition();
        assertNotNull(position);
    }

    @Test
    public void testGetDamage() {
        assertEquals(10, blueEnemy.getDamage());
    }

    @Test
    public void testSetHealthPotionDropChance() {
        blueEnemy.setHealthPotionDropChance(0.5);
        assertEquals(0.5, blueEnemy.getHealthPotionDropChance(), 0.01);
    }

    @Test
    public void testGetProjectiles() {
        ArrayList<ProjectileInterface> projectiles = blueEnemy.getProjectiles();
        assertNotNull(projectiles);
    }

    @Test
    public void testGetFactory() {
        MonsterFactory factory = BlueEnemy.getFactory();
        
        // Test name
        assertEquals("BlueEnemy", factory.name());

        // Test create with MapInterface
        MonsterInterface createdWithMap = factory.create(map,1);
        assertTrue(createdWithMap instanceof BlueEnemy);

    }

    @Test
    public void testHandleCollision_noCollision() {
        blueEnemy.update(0.5f);
        blueEnemy.handleCollision();
        assertEquals(0.1f, blueEnemy.getSpeed(), 0.01f);
        assertEquals(0.1f, blueEnemy.getSpeed(), 0.01f);
    }

    

    
}
