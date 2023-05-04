package inf112.skeleton.app;

import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Controller.Controller;
import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Mapfolder.Level1Mini;
import inf112.skeleton.app.Mapfolder.MapInterface;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


public class CollisionTest {
    
    private HeadlessApplication app;

    MapInterface map;
    Collision collision;
    Player player;
    Controller controller;

    
	/**
	 * Setup method called before each of the test methods
	 */
	@BeforeEach
	void setUpBeforeEach() {
        Gdx.gl = mock(GL20.class);       
        Gdx.gl20 = mock(GL20.class);
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        app = new HeadlessApplication(new Southgame(), config);
        map = new Level1Mini(123,16);
        controller = new Controller();
        player = new Player(new Vector2(123*16, 76*16), map, controller);
        collision = new Collision(map, player);

	}
    
    @Test
    void testCollisionYdirection(){

        //HVORFOR DETECTER VI COLLISION HER??? NOE ER RART
        assertFalse(collision.checkYDirection(1f));
        
        controller.setUp(true);


        for (int i = 0; i<10000; i++){
            player.update(1f);
        }
        assertTrue(collision.checkYDirection(1f));
        controller.setUp(false);
        
        //Move other way
        controller.setDown(true);
        
        player.update(1f);

        assertFalse(collision.checkYDirection(-1f));
        for (int i = 0; i<10000; i++){
            player.update(1f);
        }
        assertTrue(collision.checkYDirection(-1f));
        
    }

    @Test
    void testCollisionXdirection(){

        assertFalse(collision.checkXDirection(1f));

        
        controller.setRight(true);

        for (int i = 0; i<10000; i++){
            player.update(1f);
        }
        assertTrue(collision.checkXDirection(1f));

        controller.setRight(false);
        //Move other way
        controller.setLeft(true);
        player.update(1f);
        

        assertFalse(collision.checkXDirection(-1f));
        for (int i = 0; i<10000; i++){
            player.update(1f);
        }
        assertTrue(collision.checkXDirection(-1f));

        
    }
    
    @Test
    void testIsPlayerOnPortal(){
        //TODO: wtwfd
        collision.isCellAPortal();


    
    }

    @Test
    void setGetMap(){
        TiledMap mapTobeSet = new Level1Mini(0, 0).getMap();
        
        collision.setMap(mapTobeSet);
        assertEquals(collision.getMap(),mapTobeSet);
        
    }
}


