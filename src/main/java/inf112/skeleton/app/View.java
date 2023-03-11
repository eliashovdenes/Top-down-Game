package inf112.skeleton.app;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Color;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.random.*;

import javax.xml.catalog.Catalog;

public class View implements Screen {

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Player player;
    private Controller controller = new Controller();
    public RectangleMapObject playerRect;
    public RectangleMapObject enemyRect;
    public boolean enemyexists;
    private Random random = new Random();
    private int points = 0;
    private BitmapFont pointText = new BitmapFont();
    private BitmapFont lifeText = new BitmapFont();
    private Zelda game;
    private HashMap<GameObject, Rectangle> enemies = new HashMap<>();
    private float startX = 51*16;
    private float startY = 19*16;

   
    public View(Zelda game) {
        this.game = game;
    }   

    


    @Override
    public void show() {
        map = new TmxMapLoader().load(Maps.Level1.source);
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        player = new Player(new Sprite(new Texture(PlayerPics.DOWN.source)), startX, startY, ID.Player, controller, map, this, PlayerPics.DOWN.source );
        playerRect = new RectangleMapObject(player.getX(), player.getY(), player.getWidth(), player.getHeight());

        generateEnemies(10);
        // enemies.clear();


        Gdx.input.setInputProcessor(controller);
        enemyexists = true;
        pointText.getData().setScale(2);
        lifeText.getData().setScale(1);
        lifeText.setColor(Color.YELLOW);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // camera.position.set(320, 500, 0);
        renderer.getBatch().setProjectionMatrix(camera.combined);
        

        
        //setter position på spiller;
        camera.position.set(player.getX() + player.getWidth() / 2, player.getY() + player.getHeight() / 2, 0);
        camera.update();
        renderer.setView(camera);
        renderer.render();

        renderer.getBatch().begin();
        for (GameObject enemi : enemies.keySet()) {
            enemi.draw(renderer.getBatch());
            enemies.get(enemi).setPosition(enemi.x, enemi.y);
            checkSpriteCollision(enemi, enemies.get(enemi));
        }

        pointText.draw(renderer.getBatch(), "score: " + points, 19*16, 33*16);
        lifeText.draw(renderer.getBatch(), "Lives: " + (int) player.getLives(), player.x - 12, player.y + player.getHeight() + 15);

        playerRect.getRectangle().setPosition(player.x, player.y);
        player.draw(renderer.getBatch());
        

        renderer.getBatch().end();
    }



    public void generateEnemies(int amountOfEnemies) {
        Random rand = new Random();

        for (int i = 0; i < amountOfEnemies; i++) {
            GameObject entity = new Enemy((rand.nextInt(23, 41))*16, (rand.nextInt(14, 33))*16, ID.Enemy, new Sprite(new Texture(PlayerPics.ENEMYDOWN.source)), controller, map, this);
            Rectangle rect = new Rectangle(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
            enemies.put(entity, rect);
        }

    }

    

    public void changeMap(String mapFilename, int x, int y) {
        // Load the new map from file
        TmxMapLoader mapLoader = new TmxMapLoader();
        TiledMap newMap = mapLoader.load(mapFilename);
    
        // Create a new instance of Player with the new map
        Player newPlayer = new Player(new Sprite(new Texture(PlayerPics.DOWN.source)), x, y, ID.Player, this.controller, newMap,this, PlayerPics.DOWN.source);

        // Dispose of the old instance of Player
        player.getTexture().dispose();
        map.dispose();
    
        //Change the local values of map and player to the new ones
        this.map = newMap;
        this.player = newPlayer;


        //render the new map 
        renderer.setMap(map);
    }

    /**
     * sjekker kollisjon mellom sprites
     * avslutter foreløpig programmet.
     * instansierer en gameoverscreen.
     */
    public void checkSpriteCollision(GameObject entity, Rectangle rect) {
        
        if (playerRect.getRectangle().overlaps(rect)) {
            if (controller.isAttack()) {
                points ++;
                int x = random.nextInt(23*16, 41*16), y = random.nextInt(14*16, 33*16);
                entity.x = x;
                entity.y = y;
            }
            else {
                    player.x = startX;
                    player.y = startY;
                    player.takeDamage(1);

                if (player.getLives() <= 0) game.setScreen(new GameOverScreen(game));
            }
            
        }
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
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
    public void dispose() {
       map.dispose();
       renderer.dispose();
       player.getTexture().dispose();
    }
    
}
