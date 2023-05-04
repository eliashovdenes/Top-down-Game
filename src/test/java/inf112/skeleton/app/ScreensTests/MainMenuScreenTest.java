package inf112.skeleton.app.ScreensTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.*;
import org.mockito.Mock;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Southgame;
import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Mapfolder.MapInterface;
import inf112.skeleton.app.Screens.CreditScreen;
import inf112.skeleton.app.Screens.InstructionScreen;
import inf112.skeleton.app.Screens.MainMenuScreen;
import inf112.skeleton.app.Sound.SoundManager;

public class MainMenuScreenTest {
    Zelda game;
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
        game = mock(Zelda.class);

        screen = new MainMenuScreen(game, controller);
  
   
        
    }

    @Test
    void testWrongMouseClick() {


    }

    @Test
    void changeToInstructionScreenTest() {

    }
}
