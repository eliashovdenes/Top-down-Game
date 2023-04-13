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
import inf112.skeleton.app.Mapfolder.Level1Mini;
import inf112.skeleton.app.Mapfolder.MapInterface;
import inf112.skeleton.app.Sound.SoundManager;



public class CreditScreen extends ScreenAdapter {
    
    private SpriteBatch batch;
    private Zelda game;
    private BitmapFont font;
    private Controller controller;
    private SoundManager SM;
    ShapeRenderer shape;
    Rectangle rect;
    OrthographicCamera camera;

    Rectangle EliasRect,BjornRect,CasperRect,MagnusRect,HansCRect;

    public CreditScreen(Zelda southGame, Controller controller) {
        this.game = southGame;
        this.controller = controller;
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.SM = new SoundManager();
        //TODO legg til behagelig credits musikk
        //SM.mainMenuMusic.play();
        this.shape = new ShapeRenderer();

            //creating rectangles based on app graphics

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float rectangleWidth = screenWidth*0.2f;
        float rectangleHeight = screenHeight*0.03f;
        float spaceBetweenRetangles = screenHeight*0.02f;
        float rectangleY = screenHeight * 0.7f;

        
        MagnusRect = new Rectangle(screenWidth * 0.05f, rectangleY, rectangleWidth, rectangleHeight);
        EliasRect = new Rectangle(screenWidth * 0.05f, rectangleY - rectangleHeight - spaceBetweenRetangles, rectangleWidth, rectangleHeight);
        HansCRect = new Rectangle(screenWidth * 0.05f, rectangleY - 2 * (rectangleHeight + spaceBetweenRetangles), rectangleWidth, rectangleHeight);
        CasperRect = new Rectangle(screenWidth * 0.05f, rectangleY - 3 * (rectangleHeight + spaceBetweenRetangles), rectangleWidth, rectangleHeight);
        BjornRect = new Rectangle(screenWidth * 0.05f, rectangleY - 4 * (rectangleHeight + spaceBetweenRetangles), rectangleWidth, rectangleHeight);


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
        shape.setColor(Color.BLUE);
        shape.begin(ShapeRenderer.ShapeType.Filled);

        shape.rect(MagnusRect.x,MagnusRect.y,MagnusRect.width,MagnusRect.height);
        shape.rect(EliasRect.x,EliasRect.y,EliasRect.width,EliasRect.height);
        shape.rect(HansCRect.x,HansCRect.y,HansCRect.width,HansCRect.height);
        shape.rect(CasperRect.x,CasperRect.y,CasperRect.width,CasperRect.height);
        shape.rect(BjornRect.x,BjornRect.y,BjornRect.width,BjornRect.height);

        
        shape.end(); 

        // Draw the title
        batch.begin();
        font.getData().setScale(2);
        font.draw(batch, "Welcome to SouthGame", 10, 850);
        
        //draw text on buttons
        font.getData().setScale(1);
        font.draw(batch, "Magnus", MagnusRect.x+MagnusRect.width*0.05f, MagnusRect.y+MagnusRect.height*0.75f);
        font.draw(batch, "Elias", EliasRect.x+EliasRect.width*0.05f,EliasRect.y+EliasRect.height*0.75f);
        font.draw(batch, "Hans Christian", HansCRect.x+HansCRect.width*0.05f,HansCRect.y+HansCRect.height*0.75f);
        font.draw(batch, "Casper",CasperRect.x+CasperRect.width*0.05f,CasperRect.y+CasperRect.height*0.75f);
        font.draw(batch,"Bjørn",BjornRect.x+BjornRect.width*0.05f,BjornRect.y+BjornRect.height*0.75f);
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