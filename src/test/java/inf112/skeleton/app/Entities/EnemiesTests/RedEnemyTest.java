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
import inf112.skeleton.app.Entities.Enemies.RedEnemy;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Mapfolder.Level1Mini;

public class RedEnemyTest {
    private HeadlessApplication app;
    private RedEnemy redEnemy;
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
        redEnemy = new RedEnemy(map);
        

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
        MonsterFactory factory = RedEnemy.getFactory();

        assertEquals("RedEnemy", factory.name());

        MonsterInterface createdMonster1 = factory.create(map);
        assertEquals(RedEnemy.class, createdMonster1.getClass());

        MonsterInterface createdMonster2 = factory.create();
        assertEquals(RedEnemy.class, createdMonster2.getClass());
    }

    @Test
    public void testHandleCollision_noCollision() {
        redEnemy.update(0.5f);
        redEnemy.handleCollision();
        assertEquals(0.1f, redEnemy.getSpeed(), 0.01f);
        assertEquals(0.1f, redEnemy.getSpeed(), 0.01f);
    }

    @Test
    public void testFollowPlayer() {
        redEnemy.setPosition(new Vector2(0, 0));
        redEnemy.setPosition(new Vector2(0, 0));

        redEnemy.followPlayer(10, 10);

        assertEquals(0.1f, redEnemy.getVeloX(), 0.01f);
        assertEquals(0.1f, redEnemy.getVeloY(), 0.01f);

        redEnemy.followPlayer(-10, -10);

        assertEquals(-0.1f, redEnemy.getVeloX(), 0.01f);
        assertEquals(-0.1f, redEnemy.getVeloY(), 0.01f);
    }

    @Test
    public void testSetAndGetSprite() {
        String newSpritePath = "src/main/resources/assets/enemyPics/enemyUp.png"; 
        redEnemy.setSprite(newSpritePath);

        assertEquals(newSpritePath, redEnemy.getSprite().getTexture().toString());
    }

    

    @Test
    public void testSetAndGetDirection() {
        redEnemy.setDirection(DirectionEnum.NORTH);
        assertEquals(DirectionEnum.NORTH, redEnemy.getDirection());
    }

    @Test
    public void testGetAndSetHealthPotionDropChance() {
        double newDropChance = 0.5;
        redEnemy.setHealthPotionDropChance(newDropChance);
        assertEquals(newDropChance, redEnemy.getHealthPotionDropChance(), 0.001);
    }

    @Test
    public void testGetWidthAndHeight() {
        assertEquals(redEnemy.getSprite().getWidth(), redEnemy.getWidth(), 0.001);
        assertEquals(redEnemy.getSprite().getHeight(), redEnemy.getHeight(), 0.001);
    }

    @Test
    public void testGetAndSetSpeed() {
        float newSpeed = 0.5f;
        redEnemy.setSpeed(newSpeed);
        assertEquals(newSpeed, redEnemy.getSpeed(), 0.001);
    }

    @Test
    public void testGetAndSetPosition() {
        Vector2 newPosition = new Vector2(10, 10);
        redEnemy.setPosition(newPosition);
        assertEquals(newPosition, redEnemy.getPosition());
    }

    @Test
    public void testGetDamage() {
        assertEquals(20, redEnemy.getDamage());
    }

    @Test
    public void testGetProjectiles() {
        assertNotNull(redEnemy.getProjectiles());
    }



}
