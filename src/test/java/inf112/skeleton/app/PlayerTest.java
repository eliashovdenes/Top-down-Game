package inf112.skeleton.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.GraphicsType;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class PlayerTest {
    
    private HeadlessApplication app;
    private Player player;
    private Controller controller;
    private View view;
    TmxMapLoader mapLoader;
    TiledMap map; 
    
    @BeforeEach
    public void setup() {
        
        // Create a HeadlessApplication with the mock Application object
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        app = new HeadlessApplication(new Zelda(), config);
        Gdx.gl = mock(GL20.class);
        Gdx.gl20 = mock(GL20.class);
        //Gdx.graphics = mock(Graphics.class);
        
        controller = new Controller();
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("src/main/java/inf112/skeleton/app/assets/Level 1.tmx");

        player = new Player(new Sprite(new Texture(PlayerPics.DOWN.source)), 12*16, 25*16, ID.Player, this.controller, map, view, PlayerPics.DOWN.source);
        
    }

    /**
     * Tests that the tests are running headless
     */
    @Test
    void testRunningHeadless() {
        assertTrue(Gdx.graphics.getType() == GraphicsType.Mock);
    }

    /**
     * Tests that the right image is shown when the player changes direction
     */
    @Test
    void testPlayerImage(){
        
        Assertions.assertEquals("src/main/java/inf112/skeleton/app/assets/playerPics/playerUP.png", PlayerPics.UP.source);
        
        // Change the player's direction and check that the image was updated correctly
        controller.keyDown(Keys.A);
        Assertions.assertEquals("src/main/java/inf112/skeleton/app/assets/playerPics/playerL.png", PlayerPics.LEFT.source);
        controller.keyDown(Keys.S);
        Assertions.assertEquals("src/main/java/inf112/skeleton/app/assets/playerPics/playerDOWN.png", PlayerPics.DOWN.source);
        controller.keyDown(Keys.D);
        Assertions.assertEquals("src/main/java/inf112/skeleton/app/assets/playerPics/playerR.png", PlayerPics.RIGHT.source);
        controller.keyDown(Keys.W);
        Assertions.assertEquals("src/main/java/inf112/skeleton/app/assets/playerPics/playerUP.png", PlayerPics.UP.source);
    }

    @Test 
    void testPlayerHitPoints(){
        
        // Check that starting hit points is 100 and 3 lives
        Assertions.assertEquals(100, player.getCurrentHitPoints());
        Assertions.assertEquals(3, player.getLives());
        
        // Simulate player damage and check that hit points updates correctly
        player.takeDamage(25);
        Assertions.assertEquals(75, player.getCurrentHitPoints());
        player.takeDamage(50);
        Assertions.assertEquals(25, player.getCurrentHitPoints());
        
        // Overkill should set the player hit points to 0
        player.setLives(1);
        player.takeDamage(150);
        Assertions.assertEquals(player.maxHitPoints, player.getCurrentHitPoints()); 
        Assertions.assertTrue(player.isDead());
    }   
    

    
}
