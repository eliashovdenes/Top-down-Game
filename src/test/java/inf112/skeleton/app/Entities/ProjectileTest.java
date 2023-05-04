package inf112.skeleton.app.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Southgame;
import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Entities.Projectiles.Arrow;
import inf112.skeleton.app.Entities.Projectiles.Lightning;
import inf112.skeleton.app.Mapfolder.Level1Mini;
import inf112.skeleton.app.Mapfolder.MapInterface;
import inf112.skeleton.app.Entities.Projectiles.RedProjectile;

public class ProjectileTest {
    Arrow arrow; 
    Lightning lightning; 
    RedProjectile redBall;
    Southgame game;
    HeadlessApplication app;
    Player player;
    MapInterface map;
    Vector2 vector;
    int damage;

    
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
        game = mock(Southgame.class);
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        app = new HeadlessApplication(game, config);
        map = new Level1Mini(0, 0);
        vector = new Vector2(0,0);
        player = new Player(vector, map, null);
        arrow = new Arrow(vector, map, vector, player);
        lightning = new Lightning(vector, map,vector);
        damage = 1;
        redBall = new RedProjectile(vector,map, vector,null,damage);
	}

    
  

    @Test
    void testArrowMovementSpeedGetSet(){

        
        arrow.setMovementSpeed(0);
        assertEquals(0, arrow.getMovementSpeed());

    }
    
    @Test
    void testLightningMovementSpeedGetSet(){

        
        lightning.setMovementSpeed(0);
        assertEquals(0, lightning.getMovementSpeed());

    }
    
    @Test
    void testRedProjectileMovementSpeedGetSet(){

        
        redBall.setMovementSpeed(0);
        assertEquals(0, redBall.getMovementSpeed());

    }
    
    @Test
    void testRedProjectileDamage(){
        //damage variable set in constructor of RedProjectile
        assertEquals(redBall.getDamage(), damage);
        
        
    }
}
