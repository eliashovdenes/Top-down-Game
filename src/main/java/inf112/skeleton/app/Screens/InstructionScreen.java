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

    Rectangle newGameRect,instructionsRect,quitRect,creditsRect;

    public InstructionScreen(Zelda southGame, Controller controller) {
        this.game = southGame;
        this.controller = controller;
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.SM = new SoundManager();
        //SM.mainMenuMusic.play();
        this.shape = new ShapeRenderer();

         //creating rectangles based on app graphics

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float rectangleWidth = screenWidth*0.2f;
        float rectangleHeight = screenHeight*0.03f;
        float spaceBetweenRetangles = screenHeight*0.02f;
        float rectangleY = screenHeight * 0.7f;

    
        
        newGameRect = new Rectangle(screenWidth * 0.05f, rectangleY, rectangleWidth, rectangleHeight);
        instructionsRect = new Rectangle(screenWidth * 0.05f, rectangleY - rectangleHeight - spaceBetweenRetangles, rectangleWidth, rectangleHeight);
        creditsRect = new Rectangle(screenWidth * 0.05f, rectangleY - 2 * (rectangleHeight + spaceBetweenRetangles), rectangleWidth, rectangleHeight);
        quitRect = new Rectangle(screenWidth * 0.05f, rectangleY - 3 * (rectangleHeight + spaceBetweenRetangles), rectangleWidth, rectangleHeight);


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
        
        
        shape.rect(newGameRect.x,newGameRect.y,newGameRect.width,newGameRect.height);
        shape.rect(instructionsRect.x,instructionsRect.y,instructionsRect.width,instructionsRect.height);
        shape.rect(creditsRect.x,creditsRect.y,creditsRect.width,creditsRect.height);
        shape.rect(quitRect.x,quitRect.y,quitRect.width,quitRect.height);
        shape.end(); 

        // Draw the title
        batch.begin();
        font.getData().setScale(2);
        font.draw(batch, "Instructions", 10, 850);
        
        //draw text on buttons
        font.getData().setScale(1);
        font.draw(batch, "Move with awsd", newGameRect.x+newGameRect.width*0.05f, newGameRect.y+newGameRect.height*0.75f);
        font.draw(batch, "Attacj with bahllbab", instructionsRect.x+instructionsRect.width*0.05f,instructionsRect.y+instructionsRect.height*0.75f);
        font.draw(batch, "dont die", creditsRect.x+creditsRect.width*0.05f,creditsRect.y+creditsRect.height*0.75f);
        font.draw(batch, "shop for upgrades in the shop (press k)",quitRect.x+creditsRect.width*0.05f,quitRect.y+quitRect.height*0.75f);
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