package inf112.skeleton.app.ScreensTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Zelda;
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
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void testWrongMouseClick() {

        fail();
    }

    @Test
    void changeToInstructionScreenTest() {

       fail();
    }
}