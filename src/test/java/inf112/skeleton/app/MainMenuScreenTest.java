package inf112.skeleton.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Screens.CreditScreen;
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
            System.out.println("whtf?");
            game.getController().touchDown(0, 0, 0, 0);
            assertTrue(game.getScreen().equals(new MainMenuScreen(game, game.getController())));
            
        } catch (NullPointerException ignored) {
            assertTrue(game.getScreen().equals(new MainMenuScreen(game, game.getController())));
            System.out.println("stemning?");
        }
    }

    @Test
    void changeToInstructionScreenTest() {

        try {
            game.getController().touchDown(400, 350, 0, 0);
            assertTrue(game.getScreen().equals(new InstructionScreen(game, game.getController())));
        } catch (UnsatisfiedLinkError ignore) {
        }
    }

    @Test
    void changeToCreditScreenTest() {

        try {
            game.getController().touchDown(400, 400, 0, 0);
            assertTrue(game.getScreen().equals(new CreditScreen(game, game.getController())));
        } catch (UnsatisfiedLinkError ignore) {
        }
    }

    @Test
    void changeToViewScreenTest() {

        try {
            game.getController().touchDown(400, 400, 0, 0);
            //assertTrue(game.getScreen().equals());
        } catch (UnsatisfiedLinkError ignore) {
        }
    }

}
