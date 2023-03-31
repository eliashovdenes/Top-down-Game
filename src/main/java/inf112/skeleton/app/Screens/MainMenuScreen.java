package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Zelda;
import inf112.skeleton.app.Controller.Controller;
import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Mapfolder.Level1Mini;
import inf112.skeleton.app.Mapfolder.MapInterface;
import inf112.skeleton.app.Sound.SoundManager;
import inf112.skeleton.app.Sound.aSound;



public class MainMenuScreen extends ScreenAdapter {
    
    private SpriteBatch batch;
    private Zelda game;
    private BitmapFont font;
    private Controller controller;
    private SoundManager SM;
    MapInterface mapI = new Level1Mini(123,76);
  

    public MainMenuScreen(Zelda southGame, Controller controller) {
        this.game = southGame;
        this.controller = controller;
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.SM = new SoundManager();
        SM.mainMenuMusic.play();
        
    }


    @Override
    public void render(float delta) {
        // Clear the screen with a solid color
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw the title
        batch.begin();
        font.getData().setScale(2);
        font.draw(batch, "Press Enter to begin", 10, 750);
        font.getData().setScale(1);
        font.draw(batch, "SouthGame", 10, 700);
        font.draw(batch, "New Game", 10, 650);
        font.draw(batch, "Load Game", 10, 600);
        font.draw(batch, "Credits", 10, 550);
        batch.end();

        
        if (Gdx.input.isTouched()){
            game.setScreen(new View(game, controller, new Player(new Vector2(0,0),mapI, controller)));
            
            SM.mainMenuMusic.stop();
            SM.mainMenuMusic.dispose();
        }
    }

    @Override
    public void dispose() {
        
        batch.dispose();
    }
}