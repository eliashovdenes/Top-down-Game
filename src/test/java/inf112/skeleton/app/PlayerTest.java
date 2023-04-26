package inf112.skeleton.app;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Graphics.GraphicsType;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.nio.ByteBuffer;

import inf112.skeleton.app.Controller.Controller;
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
        // Gdx.graphics = mock(Graphics.class);   
	}

	/**
	 * Setup method called before each of the test methods
	 */
	@BeforeEach
	void setUpBeforeEach() {
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        app = new HeadlessApplication(new Zelda(), config);

	}

    /**
     * Tests that the tests are running headless
    */
    @Test
    void testRunningHeadless() {
        assertTrue(Gdx.graphics.getType() == GraphicsType.Mock);
    }

    @Test 
    void testPlayerHitPoints(){
        // Mock Player

        Level1 lvl1 = new Level1();
       

        assertNotNull(lvl1);
        

        //Player player = mock(Player.class, Mockito.CALLS_REAL_METHODS);

        Player player = new Player(new Vector2(0, 0), lvl1, new Controller());

        // Set lives and hitpoints
        player.setMaxhitpoints(100);
        player.setCurrentHitPoints(player.getMaxHitpoints());
        player.setLives(3);
    
        
        assertNotNull(player);
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
    public void testSetSprite() {
        Controller controller = mock(Controller.class, Mockito.CALLS_REAL_METHODS);
        Level1 lvl1 = new Level1();

        assertNotNull(lvl1);
        Player player = new Player(new Vector2(0, 0), lvl1, controller);

        // Set a new sprite for the player
        String newSpriteFilePath = "src/main/resources/assets/playerPics/playerUP.png";
        player.setSprite(newSpriteFilePath);

        // Get the current sprite after setting the new sprite
        Sprite currentSprite = player.getSprite();

        // Get the Pixmap data of the new sprite texture and the current sprite's texture
        Pixmap newSpritePixmap = new Pixmap(Gdx.files.internal(newSpriteFilePath));
        Pixmap currentSpritePixmap = new Pixmap(Gdx.files.internal(currentSprite.getTexture().toString()));

        // Compare the Pixmap data
        ByteBuffer newSpriteBuffer = newSpritePixmap.getPixels();
        ByteBuffer currentSpriteBuffer = currentSpritePixmap.getPixels();
        assertTrue(newSpriteBuffer.equals(currentSpriteBuffer));

        // Dispose of the textures and pixmaps to avoid memory leak
        newSpritePixmap.dispose();
        currentSpritePixmap.dispose();
        currentSprite.getTexture().dispose();
    }

    @Test
    void testPlayerPosition(){
        
        // Mock Player
        Player player = mock(Player.class, Mockito.CALLS_REAL_METHODS);

        player.setSprite("src/main/resources/assets/playerPics/playerUP.png");

        Sprite sprite = player.getSprite();

        System.out.println(sprite);


        // Test if player position is set correctly

        sprite.setPosition(0, 0);

        assertEquals(0, sprite.getX());

        assertEquals(0, sprite.getY());


        // Test if player position is set correctly

        sprite.setPosition(1, 1);

        assertEquals(1, sprite.getX());

        assertEquals(1, sprite.getY());

        // Test if player position is set correctly

        sprite.setPosition(2, 2);

        assertEquals(2, sprite.getX());

        assertEquals(2, sprite.getY());
    }


    @Test
    public void testPlayerMovementSpeedWhenControllerIsFast() {
        Controller controller = mock(Controller.class, Mockito.CALLS_REAL_METHODS);
        Level1 lvl1 = new Level1();

        assertNotNull(lvl1);
        Player player = new Player(new Vector2(0, 0), lvl1, controller);
        
        // Set up the mocked Controller behavior
        Mockito.when(controller.isFast()).thenReturn(true);

        // Capture the initial speed
        float initialSpeed = player.getMovementSpeed();

        // Update the player to simulate game loop behavior
        player.update(1f);

        // Get the new speed after the update
        float newSpeed = player.getMovementSpeed();

        // Verify the speed has changed to 'run'
        // assertNotEquals(initialSpeed, newSpeed, 0.001);
        assertNotEquals(newSpeed, initialSpeed, 0.001, "Speed should have changed when controller is fast");
        assertEquals(2, newSpeed);
    }
    
}
