package inf112.skeleton.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.GraphicsType;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;

import com.badlogic.gdx.graphics.GL20;


public class MainTest {
    
    
    private HeadlessApplication app;
    private Main main;
    
    

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
        Southgame game = mock(Southgame.class);

        app = new HeadlessApplication(game, config);
        main = new Main();
        
        

	}

    /**
     * Tests that the tests are running headless
    */
    @Test
    void testRunningHeadless() {
        assertTrue(Gdx.graphics.getType() == GraphicsType.Mock);
    }

    @Test
    public void testDefaultHeight() {
        assertEquals(main.getDefaultHeight(), 1080);
    }

    @Test
    public void testDefaultWidth() {
        assertEquals(main.getDefaultWidth(), 1920);
    }

}