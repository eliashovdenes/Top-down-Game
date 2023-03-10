package inf112.skeleton.app;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameOverScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private BitmapFont font;
    private Zelda game;

    public GameOverScreen(Zelda game){
        this.game = game;
        batch = new SpriteBatch();
        font = new BitmapFont();

    }
    @Override
    public void render(float delta) {
        // Clear the screen with a solid color
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw the "Game Over" message
        batch.begin();
        font.draw(batch, "Game Over!", 350, 400);
        font.draw(batch, "press anything to move to main menu", 250, 250);
        batch.end();

        // Draw the "Restart" button
        if (Gdx.input.justTouched()) {
            game.setScreen(new MainMenuScreen(game));
        }
    }
    @Override
    public void dispose(){
        batch.dispose();
        font.dispose();
        
    }

}

