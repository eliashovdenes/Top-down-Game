package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainMenuScreen extends ScreenAdapter {
    
    private SpriteBatch batch;
    private Zelda game;
    private BitmapFont font;

    public MainMenuScreen(Zelda southGame) {
        this.game = southGame;
        batch = new SpriteBatch();
        font = new BitmapFont();
    }


    @Override
    public void render(float delta) {
        // Clear the screen with a solid color
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw the title
        batch.begin();
        font.draw(batch, "SouthGame", Main.screenWidth / 3, Main.screenHeight / 2);
        font.draw(batch, "New Game", 300, 300);
        font.draw(batch, "Load Game", 300, 200);
        font.draw(batch, "Credits", 300, 100);
        batch.end();

        if (Gdx.input.justTouched()) {
            game.setScreen(new View(game));
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}