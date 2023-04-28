package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import inf112.skeleton.app.Zelda;
import inf112.skeleton.app.Controller.Controller;



public class CreditScreen extends ScreenAdapter {
    
    private SpriteBatch batch;
    private Zelda game;
    private Controller controller;
    OrthographicCamera camera;
    Texture background = new Texture(Gdx.files.internal("src/main/resources/assets/credits.png"));
    Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
    private DisplayMode disp = cfg.getDisplayMode(); 

    Rectangle EliasRect,BjornRect,CasperRect,MagnusRect,HansCRect;

    public CreditScreen(Zelda southGame, Controller controller) {
        this.game = southGame;
        this.controller = controller;
        batch = new SpriteBatch();
        //TODO legg til behagelig credits musikk
        //SM.mainMenuMusic.play();

            //creating rectangles based on app graphics

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();


        // Create the camera and set its position to the center of the screen
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f, 0);
        camera.update();
    }


    @Override
    public void render(float delta) {
        // Clear the screen with a solid color
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //draw boxes
        // Draw the title
        batch.begin();
        batch.draw(background, 0, 0, disp.width, disp.height);
        batch.end();
        if (controller.getJustTouched()){
            game.setScreen(new MainMenuScreen(game, controller));
        }
    }

    @Override
    public void dispose() {
        
        batch.dispose();
    }
}