package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import inf112.skeleton.app.Zelda;
import inf112.skeleton.app.Controller.Controller;
import inf112.skeleton.app.Entities.Player.PlayerInterface;
import inf112.skeleton.app.Sound.SoundManager;

public class Shop extends ScreenAdapter {
     
    private SpriteBatch batch;
    private Zelda game;
    private BitmapFont font;
    private Controller controller;
    private SoundManager SM;
    private PlayerInterface playerI;
  

    public Shop(Zelda southGame, Controller controller,PlayerInterface playerI) {
        this.game = southGame;
        this.controller = controller;
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.SM = new SoundManager();
        SM.mainMenuMusic.play();
        this.playerI = playerI;
    }


    @Override
    public void render(float delta) {
        // Clear the screen with a solid color
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw the title
        batch.begin();
        font.getData().setScale(2);
        font.draw(batch, "Welcome to the +shop", 10, 750);
        font.getData().setScale(1);
        font.draw(batch, "Upgrade Arrows", 10, 700);
        font.draw(batch, "Upgrade Lightning", 10, 650);
        font.draw(batch, "Upgrade healthpoints", 10, 600);
        font.draw(batch, "Let's get it.", 10, 550);
        batch.end();

        
        if (Gdx.input.isTouched()){
            game.setScreen(new View(game, controller, playerI));
            
            SM.mainMenuMusic.stop();
            SM.mainMenuMusic.dispose();
        }
    }

    @Override
    public void dispose() {
        
        batch.dispose();
    }
}

