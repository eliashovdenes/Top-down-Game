package inf112.skeleton.app.ScreensTests;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.*;


import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;


import inf112.skeleton.app.Southgame;
import inf112.skeleton.app.Controller.Controller;

import inf112.skeleton.app.Screens.MainMenuScreen;


public class MainMenuScreenTest {
    Southgame game;
    Controller controller;
    HeadlessApplication app;
  
    private MainMenuScreen screen;

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
        app = new HeadlessApplication(game, config);
        game = mock(Southgame.class);

        screen = new MainMenuScreen(game, controller);
  
   
        
    }

    // @Test
    // void testWrongMouseClick() {


    // }

    // @Test
    // void changeToInstructionScreenTest() {

    // }
}
