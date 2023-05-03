package inf112.skeleton.app.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Entities.AbstractGameObject;
import inf112.skeleton.app.Entities.Enemies.BlueEnemy;
import inf112.skeleton.app.Entities.Enemies.MonsterFactory;
import inf112.skeleton.app.Entities.Enemies.MonsterInterface;
import inf112.skeleton.app.Entities.Enemies.RedEnemy;
import inf112.skeleton.app.Entities.Items.HealthPotion;
import inf112.skeleton.app.Entities.Items.ItemImpl;
import inf112.skeleton.app.Entities.Player.PlayerInterface;
import inf112.skeleton.app.Entities.Projectiles.ProjectileInterface;
import inf112.skeleton.app.Mapfolder.MapInterface;
import inf112.skeleton.app.Zelda;
import inf112.skeleton.app.Controller.Controller;

import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;


public class View implements Screen {

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private PlayerInterface playerI;
    private BitmapFont lifeText = new BitmapFont();
    private BitmapFont hpText = new BitmapFont();
    private BitmapFont pauseText = new BitmapFont();
    private Zelda game;
    private MonsterInterface monsterI;
    private boolean paused = false;
    private Controller controller;
    public HashMap<AbstractGameObject, Rectangle> enemies = new HashMap<>();
    private ArrayList<ItemImpl> itemList = new ArrayList<>();
    private ArrayList<MonsterInterface> monsterList = new ArrayList<>();
    private Map<String, MonsterFactory> monsterFactories = new HashMap<>();
    private float scaler;
    
    
    //MapInterface mapI = new Level1Mini(123,76);
    MapInterface mapI;
    OrthogonalTiledMapRenderer nyRend;
    TiledMap nyMap;
    SpriteBatch batch;
    
    public View(Zelda game, Controller controller, PlayerInterface playerI) {
        this.game = game;
        this.controller = controller;    
        this.playerI = playerI;
        this.mapI=playerI.returnMap();
        playerI.spawn(mapI.getPlayerSpawnX()*16,mapI.getPlayerSpawnY()*16);
        this.scaler = 1;
        setup();
        
    }   
    public View(Zelda game, Controller controller, PlayerInterface playerI, float x,float y){
        this.game = game;
        this.controller = controller;    
        this.playerI = playerI;
        this.mapI=playerI.returnMap();
        this.scaler = 1;
        setup();

    }

    private void setup() {
        MonsterFactory blueEnemyFactory = BlueEnemy.getFactory();
        MonsterFactory redEnemyFactory = RedEnemy.getFactory();
        monsterFactories.put(blueEnemyFactory.name(), blueEnemyFactory);
        monsterFactories.put(redEnemyFactory.name(), redEnemyFactory);       
    }

    public void spawn(Map<String, Integer> enemies, float scaler, MapInterface mapI) {
        for (String enemy : enemies.keySet())
            for (int i=0; i < enemies.get(enemy) * Math.round(scaler); i++){
                MonsterFactory monsterFactory = monsterFactories.get(enemy);
                MonsterInterface monster = monsterFactory.create(mapI, scaler);
                monsterList.add(monster);
            }
    }

    @Override
    public void show() {        
        map = mapI.getMap();
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();        
        batch = new SpriteBatch();

        pauseText.getData().setScale(5,5);
        pauseText.setColor(Color.BLUE);
        hpText.getData().setScale(0.7f);
        hpText.setColor(Color.RED);
        lifeText.getData().setScale(1.0f);
        lifeText.setColor(Color.YELLOW);      
    }

    @Override
    public void render(float delta) {
        playerI.getRect().setSize(playerI.getWidth(), playerI.getHeight());
        if(controller.isPaused()){pause();}
        if(!controller.isPaused()){resume();}
        if (paused) {
            batch.begin();
            GlyphLayout layout = new GlyphLayout();
            layout.setText(pauseText, "PAUSED"); 
            pauseText.draw(batch, "PAUSED", playerI.getPosition().x - (layout.width/2), playerI.getPosition().y);
            batch.end();
            return;
        }
        
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
            this.scaler = playerI.getLevel();
            spawn(mapI.getEnemies(), this.scaler, mapI);
            mapI.setAllEnemiesDead(false);
            itemList.clear();
        }
        
        if (playerI.isDead()){
            game.setScreen(new GameOverScreen(game, controller));
        }

        //render map
        renderer.setView(camera);
        renderer.render();
   
        //render player / enemies / projectiles
        batch.begin();

        //draw player
        playerI.getSprite().draw(batch);

        CopyOnWriteArrayList<MonsterInterface> deadMonsterList = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<ItemImpl> itemsToRemove = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<ProjectileInterface> projectilesToRemove = new CopyOnWriteArrayList<>();

        //draw projectiles and check if they hit enemy.
        for (ProjectileInterface projectile : playerI.getProjectiles()){
            projectile.getSprite().draw(batch);
            if (projectile.getPosition().dst(playerI.getPosition())>200){
                projectilesToRemove.add(projectile);
            }
            for (MonsterInterface monsterI : this.monsterList) {
                if (projectile.getRect().overlaps(monsterI.getRect())) { 
                    monsterI.takeDamage(projectile.getDamage());
                    projectilesToRemove.add(projectile);
                }
            }
        }

        //draw monsters
        for (MonsterInterface monsterI : this.monsterList){       
            monsterI.update(delta);
            monsterI.getSprite().draw(batch);   
            hpText.draw(batch,"HP:"+monsterI.getCurrentHitpoints(),monsterI.getPosition().x,monsterI.getPosition().y);
            monsterI.followPlayer(playerI.getPosition().x, playerI.getPosition().y);
            
            //check if monsterhp is less than or equal to zero
            if (monsterI.isDead()){
                deadMonsterList.add(monsterI);
                playerI.getExp();
            }
            for (ProjectileInterface projectile : monsterI.getProjectiles()){
                projectile.getSprite().draw(batch);
                if (projectile.getRect().overlaps(playerI.getRect())) { 
                    playerI.takeDamage(projectile.getDamage());
                    projectilesToRemove.add(projectile);
                }
                
            }
                
            //check if monster and player is colliding. if so, player takes damage
            if (monsterI.getRect().overlaps(playerI.getRect())) {
                playerI.takeDamage(monsterI.getDamage());
                break;
            }
        }   
        
        for (MonsterInterface monsterI : deadMonsterList) {
            if(monsterI.dropHealthPotion()){
                addPotion(monsterI.getPosition());
            }
        }

        //draw items
        for (ItemImpl item : this.itemList){
            item.update(delta);
            item.getSprite().draw(batch);  

            //check if item and player is colliding. if so, player heals damage
            if (item.getRect().overlaps(playerI.getRect())) {
                playerI.healDamage(item.getHealAmount());
                itemsToRemove.add(item);
                break;
            }
        }   

        //remove dead monsters, projectiles that hit enemies and used items
        this.monsterList.removeAll(deadMonsterList);
        itemList.removeAll(itemsToRemove);
        playerI.getProjectiles().removeAll(projectilesToRemove);
        deadMonsterList.clear();
        itemsToRemove.clear();
        projectilesToRemove.clear();

        // Check if all enemies are dead
        if (this.monsterList.isEmpty()) {
            mapI.setAllEnemiesDead(true);
        }

        //open store (bound to K)
        if(controller.isShop()){
            game.setScreen(new Shop(game,controller,playerI));
             

        }
      
        lifeText.draw(batch, "Lives: " + playerI.getLives(), (camera.position.x - camera.viewportWidth/2) + 20, camera.position.y + 6*(camera.viewportHeight/16));
        lifeText.draw(batch, "Level: " + playerI.getLevel(), (camera.position.x - camera.viewportWidth/2) + 20, camera.position.y + 7*(camera.viewportHeight/16));
        hpText.draw(batch, "HP: " + playerI.getCurrentHitpoints(), playerI.getPosition().x - 12, playerI.getPosition().y + playerI.getHeight() + 15);
        
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width/3f;
        camera.viewportHeight = height/3f;       
    }

    @Override
    public void pause() {
        paused = true;
    }

    /* */
    @Override
    public void resume() {
        paused = false;
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();      
    }

    public ArrayList<MonsterInterface> getMonsterList() {
        return this.monsterList;
    }

    private void addPotion(Vector2 position) {
        if (this.itemList.size() <= 2) {
            HealthPotion potion = new HealthPotion(position, mapI);
            this.itemList.add(potion);
        }
    }
}
