package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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



public class MainMenuScreen extends ScreenAdapter {
    
    private SpriteBatch batch;
    private Texture img;
    private Zelda game;
    private BitmapFont font;
    private Controller controller;
    private SoundManager SM;
    MapInterface mapI = new Level1Mini(123,76);
    ShapeRenderer shape;
    Rectangle newGameRect,instructionsRect,quitRect,creditsRect;
    OrthographicCamera camera;


    public MainMenuScreen(Zelda southGame, Controller controller) {
        this.game = southGame;
        this.img = new Texture("src/main/resources/assets/mainMeny.png");
        this.controller = controller;
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.SM = new SoundManager();
        SM.mainMenuMusic.play();
        this.shape = new ShapeRenderer();

        //creating rectangles based on app graphics

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float rectangleWidth = screenWidth*0.2f;
        float rectangleHeight = screenHeight*0.03f;
        float spaceBetweenRetangles = screenHeight*0.02f;
        float rectangleY = screenHeight * 0.7f;

        
        
        newGameRect = new Rectangle(screenWidth * 0.475f, rectangleY, rectangleWidth, rectangleHeight);
        instructionsRect = new Rectangle(screenWidth * 0.475f, rectangleY - rectangleHeight - spaceBetweenRetangles, rectangleWidth, rectangleHeight);
        creditsRect = new Rectangle(screenWidth * 0.475f, rectangleY - 2 * (rectangleHeight + spaceBetweenRetangles), rectangleWidth, rectangleHeight);
        quitRect = new Rectangle(screenWidth * 0.475f, rectangleY - 3 * (rectangleHeight + spaceBetweenRetangles), rectangleWidth, rectangleHeight);

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
        batch.draw(img, -320, -250);
        font.getData().setScale(2);
        font.draw(batch, "Welcome to SouthGame", 10, 850);
        
        //draw text on buttons
        font.getData().setScale(1);
        font.draw(batch, "New Game", newGameRect.x+newGameRect.width*0.05f, newGameRect.y+newGameRect.height*0.75f);
        font.draw(batch, "Instructions", instructionsRect.x+instructionsRect.width*0.05f,instructionsRect.y+instructionsRect.height*0.75f);
        font.draw(batch, "Credits", creditsRect.x+creditsRect.width*0.05f,creditsRect.y+creditsRect.height*0.75f);
        font.draw(batch, "Quit",quitRect.x+creditsRect.width*0.05f,quitRect.y+quitRect.height*0.75f);
        
        batch.end();




        
        if (controller.getJustTouched()){
            
            Vector3 menuClick = new Vector3(controller.getMenuClick(),0);
            camera.unproject(menuClick);
            SM.buttonClick.play();
            SM.mainMenuMusic.stop();


            if (newGameRect.contains(menuClick.x, menuClick.y)){
                game.setScreen(new View(game, controller, new Player(new Vector2(0,0),mapI, controller)));
                SM.mainMenuMusic.stop();
                SM.mainMenuMusic.dispose();
            }
            if (instructionsRect.contains(menuClick.x,menuClick.y)){
                game.setScreen(new InstructionScreen(game, controller));
            }

            if (creditsRect.contains(menuClick.x,menuClick.y)){
                game.setScreen(new CreditScreen(game, controller));
            }
            if (quitRect.contains(menuClick.x,menuClick.y)){
                Gdx.app.exit();
            }
            controller.setJustTouched(false);
            
        }
        /*System.out.println(controller.getMenuClick().x);
        System.out.println("  ,  ");
        System.out.println(controller.getMenuClick().y);
        System.out.println("...");
        */
    }

    @Override
    public void dispose() {
        
        batch.dispose();
    }
}