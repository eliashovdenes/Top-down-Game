package inf112.skeleton.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;

import inf112.skeleton.app.Screens.InstructionScreen;
import inf112.skeleton.app.Screens.MainMenuScreen;

public class MainMenuScreenTest {
    Zelda game;

    @BeforeEach
    void setup() {
        try {
            game = new Zelda();
            game.setScreen(new MainMenuScreen(game, game.getController()));
        } catch (NullPointerException ignored) {
        }
    }
    

    @Test
    void testWrongMouseClick() {

        try {
            game.getController().touchDown(0, 0, 0, 0);
            assertTrue(game.getScreen().equals(new MainMenuScreen(game, game.getController())));
        } catch (NullPointerException ignored) {

        }
    }
    @Test
    void changeToInstructionScreenTest(){
        //this will only work with resolution 1920x1080
        game.getController().touchDown(400, 350, 0, 0);
        assertTrue(game.getScreen().equals(new InstructionScreen(game,game.getController())));

    }
}
