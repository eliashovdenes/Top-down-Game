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
    private Controller controller;

    public GameOverScreen(Zelda game, Controller controller){
        this.game = game;
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.controller = controller;

    }
    @Override
    public void render(float delta) {
        // Clear the screen with a solid color
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw the "Game Over" message
        batch.begin();
        font.getData().setScale(2);
        font.draw(batch, "Game Over, you died!", 10, 750);
        font.getData().setScale(1);
        font.draw(batch, "Press space to move to main menu", 10, 700);
        batch.end();

        // Draw the "Restart" button
        if (controller.isSpace()) {
            game.setScreen(new MainMenuScreen(game, controller));
        }
    }
    @Override
    public void dispose(){
        batch.dispose();
        font.dispose();
        
    }

}

