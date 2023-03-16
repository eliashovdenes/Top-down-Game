package inf112.skeleton.app;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class View implements Screen {

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Player player;
    private Controller controller;
    public RectangleMapObject playerRect;
    public RectangleMapObject enemyRect;
    public boolean enemyexists;
    private Random random = new Random();
    private int points = 0;
    private BitmapFont pointText = new BitmapFont();
    private BitmapFont lifeText = new BitmapFont();
    private Zelda game;
    public HashMap<GameObject, Rectangle> enemies = new HashMap<>();
    private float startX = 122;
    private float startY = 70;
    private int fromX = 23, toX = 1500, fromY = 200, toY = (800);
    private float timer;
    
    public ArrayList<Projectile> projectileList = new ArrayList<Projectile>();
    
    SpriteBatch batch;
    

   
    public View(Zelda game, Controller controller) {
        this.game = game;
        this.controller = controller;
    }   

    


    @Override
    public void show() {
        //map = new Map(Maps.Level1.source);
        map = new TmxMapLoader().load(Maps.Level1.source);
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        player = new Player(new Sprite(new Texture(PlayerPics.DOWN.source)), startX*16, startY*16, ID.Player, controller, map, this, PlayerPics.DOWN.source );
        playerRect = new RectangleMapObject(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        
        batch = new SpriteBatch();


       

        generateEnemies(10, map);
        


        enemyexists = true;
        pointText.getData().setScale(2);
        lifeText.getData().setScale(1);
        lifeText.setColor(Color.YELLOW);
    }

    @Override
    public void render(float delta) {
        
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
    
        //setter kamera position på spiller;
        camera.position.set(player.getX() + player.getWidth() / 2, player.getY() + player.getHeight() / 2, 0);
        camera.update();
        
        batch.setProjectionMatrix(camera.combined);


        //render map
        renderer.setView(camera);
        renderer.render();
   
        //render player / enemies / evt projectiles
        batch.begin();

        //for hver fiende, tegne fiende, tegne health points og sjekke kollisjon
        for (GameObject enemi : enemies.keySet()) {
            enemi.draw(batch);

            //setter riktig rektangel for hver enemy8
            enemies.get(enemi).setPosition(enemi.x, enemi.y);
            
            lifeText.draw(batch, "HP: " + enemi.getCurrentHitPoints(), enemi.x - 12, enemi.y + enemi.getHeight() + 15);
            checkSpriteCollision(enemi, enemies.get(enemi), delta);
        }

        if (player.isVisible() == false) {
            timer -= delta;
            if (timer <= 0) player.setVisible(true);
        }
        
        //tegne prosjektiler
        for(Projectile projectile : projectileList){
            ArrayList<GameObject> listToBeRemoved = new ArrayList<>();
            projectile.draw(batch);  
            Rectangle rect = new Rectangle(projectile.getX(), projectile.getY(), projectile.getWidth(), projectile.getHeight());
            
            //sjekker overlap mellom prosjektil og enemy. hvis overlap mister enemy liv og evt. dør
            for (GameObject enemy : enemies.keySet()){
                Rectangle recta = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
                if (didYouHitMonster(recta, rect)){
                    enemy.takeDamage(1);
                    if(enemy.isDead()){
                        points ++;
                        listToBeRemoved.add(enemy);
                    }
                    
                } 
            }
            //fjerne enemy fra enemyliste hvis en er 'dø'
            for (GameObject enemy : listToBeRemoved){
                enemies.remove(enemy);
            }
            
        }
        //fjerne fra list hvis når langt utenfor skjerm
        projectileList.removeIf(projectile -> projectile.getX() > 2000);
        projectileList.removeIf(projectile -> projectile.getY() > 2000);
        
        
        
        //spilleren med score, liv og health points.
        player.draw(batch);
        pointText.draw(batch, "score: " + points, 19*16, 33*16);
        lifeText.draw(batch, "Lives: " + player.getLives(), player.x - 12, player.y + player.getHeight() + 30);
        lifeText.draw(batch, "HP: " + player.getCurrentHitPoints(), player.x - 12, player.y + player.getHeight() + 15);

        //henter rectangle SHAPE fra rectangle OBJECT? og setter posisjon til player
        playerRect.getRectangle().setPosition(player.x, player.y);
        

        // renderer.getBatch().setProjectionMatrix(camera.combined);
        
        batch.end();

        System.out.println();
    }



    private boolean didYouHitMonster(Rectangle recta, Rectangle rect) {
        
        
        if (recta.overlaps(rect)) {
            return true;
        }
        else return false;
    }




    public void generateEnemies(int amountOfEnemies, TiledMap enemyMap) {
        Random rand = new Random();

        for (int i = 0; i < amountOfEnemies; i++) {
            Enemy entity = new Enemy((rand.nextInt(fromX, toX))*16, (rand.nextInt(fromY, toY))*16, ID.Enemy, new Sprite(new Texture(PlayerPics.ENEMYDOWN.source)), enemyMap, this);
            Rectangle rect = new Rectangle(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
            entity.newDeirection();
            enemies.put(entity, rect);
        }

    }

    

    public void changeMap(String mapFilename, int playerX, int playerY, int fromX, int toX, int fromY, int toY, int amountOfEnemies) {

        // Sets bounds for where enemies can spawn
        this.toX = toX;
        this.fromX = fromX;
        this.toY = toY;
        this.fromY = fromY;

        startX = playerX;
        startY = playerY;

        // Load the new map from file
        TmxMapLoader mapLoader = new TmxMapLoader();
        TiledMap newMap = mapLoader.load(mapFilename);
        player.setX(playerX*16);
        player.setY(playerY*16);
        // generates new enemies according to the new map rules.
        enemies.clear();
        generateEnemies(amountOfEnemies, newMap);
    
        // Create a new instance of Player with the new map
        player.setmap(newMap);
        
        // Player newPlayer = new Player(new Sprite(new Texture(PlayerPics.DOWN.source)), playerX*16, playerY*16, ID.Player, this.controller, newMap,this, PlayerPics.DOWN.source);

        // Dispose of the old instance of Player
        // player.getTexture().dispose();
        map.dispose();
    
        //Change the local values of map and player to the new ones
        this.map = newMap;
        // this.player = newPlayer;


        //render the new map 
        renderer.setMap(map);
    }

    /**
     * sjekker kollisjon mellom sprites
     * avslutter foreløpig programmet.
     * instansierer en gameoverscreen.
     */
    public void checkSpriteCollision(GameObject entity, Rectangle rect, float dt) {
        
        if (playerRect.getRectangle().overlaps(rect)) {
            if (player.isVisible()) {

            if (controller.isAttack()) {
                
                int x = random.nextInt(fromX*16, toX*16), y = random.nextInt(fromY*16, toY*16);
                entity.takeDamage(1);
                if (entity.isDead()) {
                    points ++;
                    entity.x = x;
                    entity.y = y;
                    entity.setCurrentHitPoints(entity.getMaxHitPoints());
                }    
            }
            else {
                player.takeDamage(25);
                if (player.getLives() <= 0) game.setScreen(new GameOverScreen(game, controller));
                player.setVisible(false);
                timer = 0.5f;
                // player.x = startX*16;
                // player.y = startY*16;
                
            }
        }
        }
            
        }
    

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width / 3f;
        camera.viewportHeight = height / 3f;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
  
    }

    @Override
    public void hide() {
        
    }

    @Override
    public void dispose() {;
       map.dispose();
       renderer.dispose();
       player.getTexture().dispose();
    }
    
}
