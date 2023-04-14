package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import inf112.skeleton.app.Zelda;
import inf112.skeleton.app.Controller.Controller;



public class InstructionScreen extends ScreenAdapter {
    
    private SpriteBatch batch;
    private Zelda game;
    private BitmapFont font;
    private Controller controller;
    ShapeRenderer shape;
    Rectangle rect;
    OrthographicCamera camera;

    Rectangle movementKeysRect,attackKeysRect,miscKeysRect,purposeRect;

    public InstructionScreen(Zelda southGame, Controller controller) {
        this.game = southGame;
        this.controller = controller;
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.shape = new ShapeRenderer();

         //creating rectangles based on app graphics

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float rectangleWidth = screenWidth;
        float rectangleHeight = screenHeight*0.03f;
        float spaceBetweenRetangles = screenHeight*0.02f;
        float rectangleY = screenHeight * 0.7f;

    
        
        movementKeysRect = new Rectangle(screenWidth * 0.05f, rectangleY, rectangleWidth, rectangleHeight);
        attackKeysRect = new Rectangle(screenWidth * 0.05f, rectangleY - rectangleHeight - spaceBetweenRetangles, rectangleWidth, rectangleHeight);
        miscKeysRect = new Rectangle(screenWidth * 0.05f, rectangleY - 2 * (rectangleHeight + spaceBetweenRetangles), rectangleWidth, rectangleHeight);
        purposeRect = new Rectangle(screenWidth * 0.05f, rectangleY - 3 * (rectangleHeight + spaceBetweenRetangles), rectangleWidth, rectangleHeight);


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
        
        
        shape.rect(movementKeysRect.x,movementKeysRect.y,movementKeysRect.width,movementKeysRect.height);
        shape.rect(attackKeysRect.x,attackKeysRect.y,attackKeysRect.width,attackKeysRect.height);
        shape.rect(miscKeysRect.x,miscKeysRect.y,miscKeysRect.width,miscKeysRect.height);
        shape.rect(purposeRect.x,purposeRect.y,purposeRect.width,purposeRect.height);
        shape.end(); 

        // Draw the title
        batch.begin();
        font.getData().setScale(2);
        font.draw(batch, "Instructions", 10, 850);
        
        //draw text on buttons
        font.getData().setScale(1);
        font.draw(batch, "Move with 'A','W','S','D'", movementKeysRect.x+movementKeysRect.width*0.05f, movementKeysRect.y+movementKeysRect.height*0.75f);
        font.draw(batch, "Ranged attack with 'Enter' and 'Space'. Pause with 'Esc'", attackKeysRect.x+attackKeysRect.width*0.05f,attackKeysRect.y+attackKeysRect.height*0.75f);
        font.draw(batch, "shop for upgrades in the shop (bound to 'K')", miscKeysRect.x+miscKeysRect.width*0.05f,miscKeysRect.y+miscKeysRect.height*0.75f);
        font.draw(batch, "Your purpose is to kill monster, get currency to upgrade and then move to the next level",purposeRect.x+purposeRect.width*0.05f,purposeRect.y+purposeRect.height*0.75f);
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