package inf112.skeleton.app.Entities.PlayerTests;

import org.junit.jupiter.api.*;
import org.lwjgl.system.windows.INPUT;
import org.mockito.Mockito;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Graphics.GraphicsType;
import com.badlogic.gdx.Input.Keys;
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

import inf112.skeleton.app.Southgame;
import inf112.skeleton.app.Controller.Controller;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Enums.PlayerAnimation;
import inf112.skeleton.app.Entities.Enums.PlayerPics;
import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Entities.Projectiles.Arrow;
import inf112.skeleton.app.Entities.Projectiles.Lightning;
import inf112.skeleton.app.Mapfolder.Level1Mini;

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
        app = new HeadlessApplication(new Southgame(), config);

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

        Level1Mini lvl1 = new Level1Mini(0, 0);
       

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
        player.setInvincible(false);
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
        player.setInvincible(false);
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
        Level1Mini lvl1 = new Level1Mini(0, 0);

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
        Level1Mini lvl1 = new Level1Mini(0, 0);

        assertNotNull(lvl1);
        Player player = new Player(new Vector2(0, 0), lvl1, controller);

        // Capture the initial speed
        float initialSpeed = player.getMovementSpeed();

        controller.setFast(true);

        // Update the player to simulate game loop behavior
        player.update(1f);

        // Get the new speed after the update
        float newSpeed = player.getMovementSpeed();

        // Verify the speed has changed to 'run'
        // assertNotEquals(initialSpeed, newSpeed, 0.001);
        assertNotEquals(newSpeed, initialSpeed, 0.001, "Speed should have changed when controller is fast");
        assertEquals(2, newSpeed);
    }
    
    @Test
    public void testAnimateMethod() {
        Controller controller = mock(Controller.class, Mockito.CALLS_REAL_METHODS);
        Level1Mini lvl1 = new Level1Mini(0, 0);

        assertNotNull(lvl1);
        Player player = new Player(new Vector2(0, 0), lvl1, controller);

        // Test when player is walking in each direction
        for (DirectionEnum direction : DirectionEnum.values()) {
            player.setPlayerDirection(direction);
            player.update(1f);

            if (direction == DirectionEnum.NORTH){
                assertEquals(PlayerAnimation.UP.animation, player.getPlayerAnimation(),
                        "Player animation should match the direction when walking");
            } else if (direction == DirectionEnum.SOUTH){
                assertEquals(PlayerAnimation.DOWN.animation, player.getPlayerAnimation(),
                        "Player animation should match the direction when walking");
            } else if (direction == DirectionEnum.EAST){
                assertEquals(PlayerAnimation.RIGHT.animation, player.getPlayerAnimation(),
                        "Player animation should match the direction when walking");
            } else if (direction == DirectionEnum.WEST){
                assertEquals(PlayerAnimation.LEFT.animation, player.getPlayerAnimation(),
                        "Player animation should match the direction when walking");
            }
            
        }

        // Test when player is running in each direction
        controller.setFast(true);
        for (DirectionEnum direction : DirectionEnum.values()) {
            player.setPlayerDirection(direction);
            player.update(1f);


            if (direction == DirectionEnum.NORTH){
                assertEquals(PlayerAnimation.RUNUP.animation, player.getPlayerAnimation(),
                        "Player animation should match the direction when walking");
            } else if (direction == DirectionEnum.SOUTH){
                assertEquals(PlayerAnimation.RUNDOWN.animation, player.getPlayerAnimation(),
                        "Player animation should match the direction when walking");
            } else if (direction == DirectionEnum.EAST){
                assertEquals(PlayerAnimation.RUNRIGHT.animation, player.getPlayerAnimation(),
                        "Player animation should match the direction when walking");
            } else if (direction == DirectionEnum.WEST){
                assertEquals(PlayerAnimation.RUNLEFT.animation, player.getPlayerAnimation(),
                        "Player animation should match the direction when walking");
            }
        }
    }


    @Test
    public void testShootLightningMethod() {
        Controller controller = mock(Controller.class, Mockito.CALLS_REAL_METHODS);
        Level1Mini lvl1 = new Level1Mini(0, 0);

        assertNotNull(lvl1);
        Player player = new Player(new Vector2(0, 0), lvl1, controller);

        controller.keyDown(Keys.ENTER);

        player.setPlayerDirection(DirectionEnum.NORTH);

        player.update(1f);

        Lightning lightning = (Lightning) player.getProjectiles().get(0);

        assertEquals(1, player.getProjectiles().size());
    
        assertEquals(45, lightning.getDamage());

        assertEquals(lightning.getCurrentHitpoints(), lightning.getMaxHitpoints());

        assertEquals(-8, lightning.getPosition().x);

        assertEquals(-7, lightning.getPosition().y);

        assertEquals(lightning.getHeight(), 40);

        assertEquals(lightning.getWidth(), 40);
    }

    @Test
    public void testShootArrowMethod() {
        Controller controller = mock(Controller.class, Mockito.CALLS_REAL_METHODS);
        Level1Mini lvl1 = new Level1Mini(0, 0);

        assertNotNull(lvl1);
        Player player = new Player(new Vector2(0, 0), lvl1, controller);

        controller.keyDown(Keys.SPACE);

        player.setPlayerDirection(DirectionEnum.NORTH);

        player.update(1f);

        Arrow arrow = (Arrow) player.getProjectiles().get(0);

        assertEquals(1, player.getProjectiles().size());

        assertEquals(5, arrow.getDamage());

        assertEquals(arrow.getCurrentHitpoints(), arrow.getMaxHitpoints());

        assertEquals(0, arrow.getPosition().x);

        assertEquals(3, arrow.getPosition().y);

        assertEquals(arrow.getHeight(), 10);

        assertEquals(arrow.getWidth(), 10);
    }


    @Test
    public void testPlayerGettersAndSetters() {
        Controller controller = mock(Controller.class, Mockito.CALLS_REAL_METHODS);
        Level1Mini lvl1 = new Level1Mini(0, 0);
        assertNotNull(lvl1);
        Player player = new Player(new Vector2(0, 0), lvl1, controller);

        // Test setPlayerDirection and getPlayerDirection
        player.setPlayerDirection(DirectionEnum.NORTH);
        assertEquals(DirectionEnum.NORTH, player.getPlayerDirection());

        // Test spawn and getPosition
        player.spawn(16, 32);
        assertEquals(16, player.getPosition().x);
        assertEquals(32, player.getPosition().y);

        // Test setOffPortal and onPortal
        player.setOffPortal();
        assertFalse(player.onPortal());

        // Test returnMap
        assertEquals(lvl1, player.returnMap());

        // Test upgradeLightning and getLightningAbilityLevel
        int initialLightningAbilityLevel = player.getLightningAbilityLevel();
        player.upgradeLightning();
        assertEquals(initialLightningAbilityLevel + 1, player.getLightningAbilityLevel());

        // Test upgradeArrow and getArrowAbilityLevel
        int initialArrowAbilityLevel = player.getArrowAbilityLevel();
        player.upgradeArrow();
        assertEquals(initialArrowAbilityLevel + 1, player.getArrowAbilityLevel());

        // Test setLives and getLives
        player.setLives(3);
        assertEquals(3, player.getLives());

        // Test takeDamage
        int initialHitPoints = player.getCurrentHitpoints();
        int damage = 5;
        player.takeDamage(damage);
        assertEquals(initialHitPoints - damage, player.getCurrentHitpoints());

        // Test getExp, getLevel, getAbilityPoints
        int initialLevel = player.getLevel();
        int initialAbilityPoints = player.getAbilityPoints();
        player.getExp();
        assertEquals(initialLevel, player.getLevel());
        assertEquals(initialAbilityPoints, player.getAbilityPoints());

        // Test upgradeHealth and getHealthAbilityLevel
        int initialHealthAbilityLevel = player.getHealthAbilityLevel();
        player.upgradeHealth();
        assertEquals(initialHealthAbilityLevel + 1, player.getHealthAbilityLevel());

        // Test upgradeMovement and getMovementAbilityLevel
        int initialMovementAbilityLevel = player.getMovementAbilityLevel();
        player.upgradeMovement();
        player.upgradeMovement();

        // player.update(1f);
        assertEquals(initialMovementAbilityLevel+2, player.getMovementAbilityLevel());
        
        // Test removeAbilityPoints
        player.removeAbilityPoints();
        assertEquals(initialAbilityPoints - 1, player.getAbilityPoints());
    }











    


}
