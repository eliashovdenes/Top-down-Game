package inf112.skeleton.app.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Entities.AbstractGameObject;
import inf112.skeleton.app.Entities.AbstractProjectile;
import inf112.skeleton.app.Entities.MonsterInterface;
import inf112.skeleton.app.Entities.Player;
import inf112.skeleton.app.Entities.PlayerInterface;
import inf112.skeleton.app.Entities.Enemies.BlueEnemy;
import inf112.skeleton.app.Mapfolder.Level1;
import inf112.skeleton.app.Mapfolder.MapInterface;
import inf112.skeleton.app.Zelda;
import inf112.skeleton.app.Controller.Controller;

import com.badlogic.gdx.graphics.Color;

import java.util.HashMap;


public class View implements Screen {

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private PlayerInterface playerI;
    public RectangleMapObject playerRect;
    public RectangleMapObject enemyRect;
    public boolean enemyexists;
    private BitmapFont pointText = new BitmapFont();
    private BitmapFont lifeText = new BitmapFont();
    private Zelda game;
    private MonsterInterface monsterI;
    private Controller controller;
    public HashMap<AbstractGameObject, Rectangle> enemies = new HashMap<>();
    
    MapInterface mapI = new Level1();
    OrthogonalTiledMapRenderer nyRend;
    TiledMap nyMap;
    SpriteBatch batch;
    
    public View(Zelda game, Controller controller) {
        this.game = game;
        this.controller = controller;    
    }   

    @Override
    public void show() {
        
        map = mapI.getMap();
        renderer = mapI.getRenderer();
        playerI = new Player(new Vector2(0,0),mapI, controller);
        monsterI = new BlueEnemy(mapI);
        playerI.spawn(mapI.getPlayerSpawnX()*16,mapI.getPlayerSpawnY()*16);
        
        camera = new OrthographicCamera();
        
        batch = new SpriteBatch();

        
        lifeText.getData().setScale(1);
        lifeText.setColor(Color.RED);

    }

    @Override
    public void render(float delta) {
        
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
    
        
        camera.position.set(playerI.getPosition().x+playerI.getWidth() / 2, playerI.getPosition().y+playerI.getHeight()/2,0);
        
        
        //Update   
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        
        playerI.update(delta);

        if (playerI.onPortal()){
            this.mapI=playerI.nextMap();
            
            renderer.setMap(mapI.getMap());
            playerI.setOffPortal();
        }
        
        

        //render map
        renderer.setView(camera);
        renderer.render();
   
        
        //render player / enemies / projectiles
        batch.begin();

        //draw player
        playerI.getSprite().draw(batch);

        //draw arrows
        for (AbstractProjectile projectile : playerI.getArrows()){
            projectile.getSprite().draw(batch);
        }
        //draw monsters
        for (MonsterInterface monsterI : mapI.getMonsters()){
            monsterI.getSprite().draw(batch);      
        }

        lifeText.draw(batch, "Lives: " + 10, playerI.getPosition().x - 12, playerI.getPosition().y + playerI.getHeight() + 30);
        lifeText.draw(batch, "HP: " + 100, playerI.getPosition().x - 12, playerI.getPosition().y + playerI.getHeight() + 15);
        lifeText.draw(batch,".",playerI.getPosition().x+11,playerI.getPosition().y+18);
        
        batch.end();

    }

        
    




    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width/3f;
        camera.viewportHeight = height/3f;
        
    }


    @Override
    public void pause() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pause'");
    }


    @Override
    public void resume() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resume'");
    }


    @Override
    public void hide() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hide'");
    }


    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
       
    }
}
