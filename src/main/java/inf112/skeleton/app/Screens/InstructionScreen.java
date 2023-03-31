package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import inf112.skeleton.app.Zelda;
import inf112.skeleton.app.Controller.Controller;
import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Mapfolder.Level1Mini;
import inf112.skeleton.app.Mapfolder.MapInterface;
import inf112.skeleton.app.Sound.SoundManager;
import inf112.skeleton.app.Sound.aSound;



public class InstructionScreen extends ScreenAdapter {
    
    private SpriteBatch batch;
    private Zelda game;
    private BitmapFont font;
    private Controller controller;
    private SoundManager SM;
    MapInterface mapI = new Level1Mini(123,76);
    ShapeRenderer shape;
    Rectangle rect;
    OrthographicCamera camera;


    public InstructionScreen(Zelda southGame, Controller controller) {
        this.game = southGame;
        this.controller = controller;
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.SM = new SoundManager();
        //SM.mainMenuMusic.play();
        this.shape = new ShapeRenderer();

        rect = new Rectangle(8,730,80, 25);

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
        shape.setColor(Color.RED);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        
        shape.rect(8,730,80,25);
        
        shape.rect(8, 680, 80,25);
        shape.rect(8, 630, 80,25);
        shape.rect(8, 580, 80,25);
        shape.end();

        // Draw the title
        batch.begin();
        font.getData().setScale(2);
        font.draw(batch, "Welcome to Instructions", 10, 850);
        

        font.getData().setScale(1);
        font.draw(batch, "Kill Monsters", 10, 750);
        font.draw(batch, "Get EXP", 10,  700);
        font.draw(batch, "Get sick", 10, 650);
        font.draw(batch, "hei",10,600);
        batch.end();

        System.out.println(controller.getMenuClick().x);



        
        if (controller.getJustTouched()){
            
            game.setScreen(new MainMenuScreen(game, controller));
            }
            
        
    }

    @Override
    public void dispose() {
        
        batch.dispose();
    }
}