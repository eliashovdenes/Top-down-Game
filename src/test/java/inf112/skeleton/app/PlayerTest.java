package inf112.skeleton.app;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Enums.PlayerPics;
import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Mapfolder.Level1;

public class PlayerTest {
    private HeadlessApplication app;

    /**
	 * Static method run before everything else
	 */
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
        app = new HeadlessApplication(new Zelda(), config);

	}

    @Test 
    void testPlayerHitPoints(){
        // Mock Player
        Level1 lvl1 = new Level1();
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



    @Test
    void testPLayerSpeed() {

        Player player = mock(Player.class, Mockito.CALLS_REAL_METHODS);

        //Test if player speed is set correctly
        player.setMovementSpeed(3);

        assertEquals(3, player.getMovementSpeed());

        player.setMovementSpeed(1);

        assertEquals(1, player.getMovementSpeed());

        player.setMovementSpeed(2);

        assertEquals(2, player.getMovementSpeed());

        player.setMovementSpeed(0);

        assertEquals(0, player.getMovementSpeed());
    }


    @Test
    void testPlayerAnimation() {
        // Mock Player
        Player player = mock(Player.class, Mockito.CALLS_REAL_METHODS);

        player.setPlayerDirection(DirectionEnum.NORTH);

        assertEquals(DirectionEnum.NORTH, player.getPlayerDirection());

        player.setPlayerDirection(DirectionEnum.SOUTH);

        assertEquals(DirectionEnum.SOUTH, player.getPlayerDirection());

        player.setPlayerDirection(DirectionEnum.EAST);

        assertEquals(DirectionEnum.EAST, player.getPlayerDirection());

        player.setPlayerDirection(DirectionEnum.WEST);

        assertEquals(DirectionEnum.WEST, player.getPlayerDirection());
    }

    @Test
    void testPlayerSprite(){
        
        //Does not work yet

        // Mock Player
        // Player player = mock(Player.class, Mockito.CALLS_REAL_METHODS);

        // // Test if player sprite is set correctly

        // player.setSprite(PlayerPics.UP.toString());

        // assertEquals(new Sprite(new Texture(PlayerPics.UP.toString())), player.getSprite());

        // // Test if player sprite is set correctly
        // player.setSprite("player2.png");

        // assertEquals("player2.png", player.getSprite());

        // // Test if player sprite is set correctly
        // player.setSprite("player3.png");

        // assertEquals("player3.png", player.getSprite());

        // // Test if player sprite is set correctly
        // player.setSprite("player4.png");

        // assertEquals("player4.png", player.getSprite());
    }

    @Test
    void testPlayerPosition(){
        
        //Does not work yet
        
        
        // Mock Player
        // Player player = mock(Player.class, Mockito.CALLS_REAL_METHODS);

        // player.setSprite(PlayerPics.UP.toString());

        // Sprite sprite = player.getSprite();

        // System.out.println(sprite);


        // // Test if player position is set correctly

        // sprite.setPosition(0, 0);

        // assertEquals(0, sprite.getX());

        // assertEquals(0, sprite.getY());

        // // Test if player position is set correctly

        // sprite.setPosition(1, 1);

        // assertEquals(1, sprite.getX());

        // assertEquals(1, sprite.getY());

        // // Test if player position is set correctly

        // sprite.setPosition(2, 2);

        // assertEquals(2, sprite.getX());

        // assertEquals(2, sprite.getY());
    }
    
}
