package inf112.skeleton.app.Entities.ItemsTests;

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
import inf112.skeleton.app.Entities.Enums.Items;
import inf112.skeleton.app.Entities.Items.HealthPotion;
import inf112.skeleton.app.Mapfolder.Level1Mini;

public class HealthPotionTest {
    private HealthPotion healthPotion;
    private Vector2 position;
    

    private HeadlessApplication app;
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
        position = new Vector2(0, 0);
        healthPotion = new HealthPotion(position, map);
        
	}

    /**
     * Tests that the tests are running headless
    */
    @Test
    void testRunningHeadless() {
        assertTrue(Gdx.graphics.getType() == GraphicsType.Mock);
    }
    
    @Test
    public void testHealAmount() {
        assertEquals(50, healthPotion.getHealAmount());
        healthPotion.setHealAmount(100);
        assertEquals(100, healthPotion.getHealAmount());
    }
    
    @Test
    public void testSprite() {
        assertNotNull(healthPotion.getSprite());
        assertEquals(Items.HEALTHPOTION.source, healthPotion.getSprite().getTexture().toString());
    }
    
    @Test
    public void testPosition() {
        assertEquals(position, healthPotion.getPosition());
    }
    
    @Test
    public void testRectangle() {
        assertEquals(position.x, healthPotion.getRect().x, 0.001f);
        assertEquals(position.y, healthPotion.getRect().y, 0.001f);
        assertEquals(healthPotion.getWidth(), healthPotion.getRect().width, 0.001f);
        assertEquals(healthPotion.getHeight(), healthPotion.getRect().height, 0.001f);
    }
}
