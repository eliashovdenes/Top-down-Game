package inf112.skeleton.app.Entities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Zelda;
import inf112.skeleton.app.Controller.Controller;
import inf112.skeleton.app.Entities.Enemies.RedEnemy;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Enums.PlayerAnimation;
import inf112.skeleton.app.Entities.Enums.PlayerPics;
import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Entities.Projectiles.Lightning;
import inf112.skeleton.app.Mapfolder.GrassMini;
import inf112.skeleton.app.Mapfolder.Level1Mini;

public class GameObjectTest {

    Player player;
    RedEnemy enemy;
    Lightning lightning;
    
    private HeadlessApplication app;
    private static Zelda zelda;
    /**
	 * Static method run before everything else
	 */
	@BeforeAll
	static void setUpBeforeAll() {
        Gdx.gl = mock(GL20.class);       
        Gdx.gl20 = mock(GL20.class);
        zelda = mock(Zelda.class);
	}

	@BeforeEach
	void setUpBeforeEach() {
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        app = new HeadlessApplication(zelda, config);
        player = new Player(new Vector2(123*16,76*16), new Level1Mini(123,76),new Controller());
        enemy = new RedEnemy();
        lightning = new Lightning(new Vector2(0, 0), new Level1Mini(123,76), new Vector2(0, 0));
	}



       
        
    
    @Test 
    void testApplyMovement(){
        float before = player.getPosition().x;
        player.velocity.set(1, 0);
        player.ApplyMovement();
        player.update(1);
        float after = player.getPosition().x;
        assertNotEquals(before,after);
        
    }   
        
        
        
    @Test
    void testGetRect(){
        player.ApplyMovement();

        Rectangle playerRect = player.getRect();
        Rectangle compareRect = new Rectangle(player.getPosition().x,player.getPosition().y, player.getWidth(),player.getHeight());
        assertEquals(playerRect,compareRect);


    }
    
    @Test
    void testCurrentHitpoints(){
        

        assertEquals(player.getCurrentHitpoints(),100);
        assertEquals(enemy.getCurrentHitpoints(),50);
        player.setCurrentHitPoints(50);
        enemy.setCurrentHitPoints(3);

        assertEquals(player.getCurrentHitpoints(),50);
        assertEquals(enemy.getCurrentHitpoints(),3);

    }
        
     


        
    @Test
    void testGetMaxHitpoints(){


        assertEquals(player.getMaxHitpoints(),100);
        assertEquals(enemy.getMaxHitpoints(),50);
        
        player.setMaxhitpoints(100000);

        enemy.setMaxhitpoints(10000000);

        assertEquals(player.getMaxHitpoints(),100000);
        assertEquals(enemy.getMaxHitpoints(),10000000);
    }
   
    @Test   
    void testGetPosition() {
        assertEquals(player.getPosition(),new Vector2(123*16,76*16));
        assertNotEquals(player.getPosition(),new Vector2(1231,342));
    }


    @Test 
    void testSetGetSprite(){
        
        lightning.setSprite(PlayerPics.LIGHTNING.source);

        Sprite actualSprite = lightning.getSprite();
        Sprite expectedSprite = new Sprite(new Texture(PlayerPics.LIGHTNING.source));
    
        assertEquals(expectedSprite.getX(), actualSprite.getX(), 0.001);
        assertEquals(expectedSprite.getY(), actualSprite.getY(), 0.001);
        assertEquals(expectedSprite.getWidth(), actualSprite.getWidth(), 0.001);
        assertEquals(expectedSprite.getHeight(), actualSprite.getHeight(), 0.001);

       


    }
    @Test
    void testMovementSpeed(){
        player.setMovementSpeed(143);
        assertEquals(player.getMovementSpeed(),143);
    }
    
    @Test
    void testGetWidthandGetHeight(){
        
        player.getSprite().setSize(4310, 4310);
        assertEquals(player.getWidth(),4310);
        assertEquals(player.getHeight(),4310);
    }

    @Test
    void testEnteredLevel3(){
        player.setEnteredLevel3(false);
        assertFalse(player.isEnteredLevel3());
    }
     
}
