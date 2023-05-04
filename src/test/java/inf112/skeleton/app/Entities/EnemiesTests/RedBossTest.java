package inf112.skeleton.app.Entities.EnemiesTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.GraphicsType;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Southgame;
import inf112.skeleton.app.Entities.Enemies.MonsterFactory;
import inf112.skeleton.app.Entities.Enemies.MonsterInterface;
import inf112.skeleton.app.Entities.Enemies.RedBoss;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Mapfolder.Level1Mini;

public class RedBossTest {
    private HeadlessApplication app;
    private RedBoss redBoss;
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
        Southgame game = mock(Southgame.class);
        app = new HeadlessApplication(game, config);
        map = new Level1Mini(0, 0);
        redBoss = new RedBoss(map,1);
        

	}

    /**
     * Tests that the tests are running headless
    */
    @Test
    void testRunningHeadless() {
        assertTrue(Gdx.graphics.getType() == GraphicsType.Mock);
    }


    @Test
    public void testGetFactory() {
        MonsterFactory factory = RedBoss.getFactory();

        assertEquals("RedBoss", factory.name());

        MonsterInterface createdMonster1 = factory.create(map,1);
        assertEquals(RedBoss.class, createdMonster1.getClass());

        
    }

    @Test
    public void testHandleCollision_noCollision() {
        redBoss.update(0.5f);
        redBoss.handleCollision();
        assertEquals(0.5f, redBoss.getSpeed(), 0.01f);
        assertEquals(0.5f, redBoss.getSpeed(), 0.01f);
    }



    @Test
    public void testSetAndGetSprite() {
        String newSpritePath = "src/main/resources/assets/enemyPics/enemyUp.png"; 
        redBoss.setSprite(newSpritePath);

        assertEquals(newSpritePath, redBoss.getSprite().getTexture().toString());
    }

    

    @Test
    public void testSetAndGetDirection() {
        redBoss.setDirection(DirectionEnum.NORTH);
        assertEquals(DirectionEnum.NORTH, redBoss.getDirection());
    }

    @Test
    public void testGetAndSetHealthPotionDropChance() {
        double newDropChance = 0.5;
        redBoss.setHealthPotionDropChance(newDropChance);
        assertEquals(newDropChance, redBoss.getHealthPotionDropChance(), 0.001);
    }

    @Test
    public void testGetWidthAndHeight() {
        assertEquals(redBoss.getSprite().getWidth(), redBoss.getWidth(), 0.001);
        assertEquals(redBoss.getSprite().getHeight(), redBoss.getHeight(), 0.001);
    }

    @Test
    public void testGetAndSetSpeed() {
        float newSpeed = 0.5f;
        redBoss.setMovementSpeed(newSpeed);
        assertEquals(newSpeed, redBoss.getSpeed(), 0.001);
    }

    @Test
    public void testGetAndSetPosition() {
        Vector2 newPosition = new Vector2(10, 10);
        redBoss.setPosition(newPosition);
        assertEquals(newPosition, redBoss.getPosition());
    }

    @Test
    public void testGetDamage() {
        assertEquals(100, redBoss.getDamage());
    }

    @Test
    public void testGetProjectiles() {
        assertNotNull(redBoss.getProjectiles());
    }

    @Test 
    public void testDropHealthPotion() {
        redBoss.setHealthPotionDropChance(1);
        assertTrue(redBoss.dropHealthPotion());
    }

    @Test 
    public void testGetName() {
        assertEquals("RedBoss", redBoss.getName());
    }
    
}
