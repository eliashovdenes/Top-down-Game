package inf112.skeleton.app;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class TestEnemy {
    
    private HeadlessApplication app;
    private Enemy enemy;
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

        enemy = new Enemy(12*16, 25*16, ID.Enemy, new Sprite(new Texture(PlayerPics.ENEMYDOWN.source)),map, view);
        
    }
    @Test 
    void testEnemyHitPoints(){
        
        // Check that starting hit points is 25
        Assertions.assertEquals(25, enemy.getCurrentHitPoints());
       
        // Simulate enemy damage and check that hit points updates correctly
        enemy.takeDamage(2);
        Assertions.assertEquals(23, enemy.getCurrentHitPoints());
        enemy.takeDamage(12);
        Assertions.assertEquals(11, enemy.getCurrentHitPoints());
        
        // Overkill should set the enemy hit points to 0
        enemy.takeDamage(50);
        Assertions.assertEquals(0, enemy.getCurrentHitPoints()); 
        Assertions.assertTrue(enemy.isDead());
    } 
}
