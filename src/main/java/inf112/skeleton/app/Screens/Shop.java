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
import com.badlogic.gdx.math.Vector3;

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
    private ShapeRenderer shape;
    Rectangle upgradeArrowRect,upgradeLightningRect,upgradePlayerHealthRect,upgradeMovementSpeed;
    OrthographicCamera camera;
  
    private float upgradeCooldown = 0.5f;
    private float timeSinceUpgrade = 0;

    public Shop(Zelda southGame, Controller controller,PlayerInterface playerI) {
        this.game = southGame;
        this.controller = controller;
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.SM = new SoundManager();
        this.playerI = playerI;
        
        this.shape = new ShapeRenderer();
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float rectangleWidth = screenWidth*0.2f;
        float rectangleHeight = screenHeight*0.03f;
        float spaceBetweenRetangles = screenHeight*0.02f;
        float rectangleY = screenHeight * 0.7f;

        
        upgradeArrowRect = new Rectangle(screenWidth * 0.05f, rectangleY, rectangleWidth, rectangleHeight);
        upgradeLightningRect = new Rectangle(screenWidth * 0.05f, rectangleY - rectangleHeight - spaceBetweenRetangles, rectangleWidth, rectangleHeight);
        upgradePlayerHealthRect = new Rectangle(screenWidth * 0.05f, rectangleY - 2 * (rectangleHeight + spaceBetweenRetangles), rectangleWidth, rectangleHeight);
        upgradeMovementSpeed = new Rectangle(screenWidth * 0.05f, rectangleY - 3 * (rectangleHeight + spaceBetweenRetangles), rectangleWidth, rectangleHeight);
        
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

        shape.rect(upgradeArrowRect.x,upgradeArrowRect.y,upgradeArrowRect.width,upgradeArrowRect.height);
        shape.rect(upgradeLightningRect.x,upgradeLightningRect.y,upgradeLightningRect.width,upgradeLightningRect.height);
        shape.rect(upgradePlayerHealthRect.x,upgradePlayerHealthRect.y,upgradePlayerHealthRect.width,upgradePlayerHealthRect.height);
        shape.rect(upgradeMovementSpeed.x,upgradeMovementSpeed.y,upgradeMovementSpeed.width,upgradeMovementSpeed.height);

        
        shape.end(); 

        // Draw the title
        batch.begin();
        font.getData().setScale(2);
        font.draw(batch, "You have "+playerI.getAbilityPoints()+" ability points", 10, 850);
        
        //draw text on buttons
        font.getData().setScale(1);
        font.draw(batch, "Upgrade Arrow (Currently level"+playerI.getArrowAbilityLevel()+")", upgradeArrowRect.x+upgradeArrowRect.width*0.05f, upgradeArrowRect.y+upgradeArrowRect.height*0.75f);
        font.draw(batch, "Upgrade Lightning (Currently level"+playerI.getLightningAbilityLevel()+")", upgradeLightningRect.x+upgradeLightningRect.width*0.05f,upgradeLightningRect.y+upgradeLightningRect.height*0.75f);
        font.draw(batch, "Upgrade Health (Currently level"+playerI.getHealthAbilityLevel()+")", upgradePlayerHealthRect.x+upgradePlayerHealthRect.width*0.05f,upgradePlayerHealthRect.y+upgradePlayerHealthRect.height*0.75f);
        font.draw(batch, "Upgrade Movementspeed (Currently level"+playerI.getMovementAbilityLevel()+")",upgradeMovementSpeed.x+upgradeMovementSpeed.width*0.05f,upgradeMovementSpeed.y+upgradeMovementSpeed.height*0.75f);
        batch.end();
        
        timeSinceUpgrade+= delta;

        if (!controller.isShop()){
            game.setScreen(new View(game, controller, playerI,0,0));
        }
        if (controller.getJustTouched()){
            
            Vector3 hei = new Vector3(controller.getMenuClick(),0);
            camera.unproject(hei);


            if (upgradeArrowRect.contains(hei.x, hei.y) && playerI.getAbilityPoints()>0 && timeSinceUpgrade >=upgradeCooldown){
                playerI.upgradeArrow();
                playerI.removeAbilityPoints();
                timeSinceUpgrade = 0;
            }
            if (upgradeLightningRect.contains(hei.x,hei.y)&& playerI.getAbilityPoints()>=3 && timeSinceUpgrade >=upgradeCooldown){
                playerI.upgradeLightning();
                for (int i = 0; i<3;i++){
                    playerI.removeAbilityPoints();
                }
                timeSinceUpgrade = 0;
            }
            if (upgradePlayerHealthRect.contains(hei.x,hei.y)&& playerI.getAbilityPoints()>=5 && timeSinceUpgrade >=upgradeCooldown){
                playerI.upgradeHealth();
                for (int i = 0; i<5;i++){
                    playerI.removeAbilityPoints();
                }
                timeSinceUpgrade = 0;
            }
            if (upgradeMovementSpeed.contains(hei.x,hei.y)&& playerI.getAbilityPoints()>=10 && timeSinceUpgrade >=upgradeCooldown){
                playerI.upgradeMovement();
                for (int i = 0; i<10;i++){
                    playerI.removeAbilityPoints();
                }
                timeSinceUpgrade = 0;
            }
            
        
            
        }
    }
    @Override
    public void dispose() {
        
        batch.dispose();
    }
}

