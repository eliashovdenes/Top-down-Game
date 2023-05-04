package inf112.skeleton.app.Mapfolder;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Sound.SoundManager;

public class Level1Mini extends TiledMap implements MapInterface {

    private float PlayerSpawnX = 123;
    private float PlayerSpawnY = 76;

    private int EnemyBoundsfromX = 200;
    private int EnemyBoundsToX = 800;
    private int EnemyBoundsFromY = 200;
    private int EnemyBoundsToY = 800;
    private SoundManager sm;
    private boolean allEnemiesDead = false;
    

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;
    private Map<String, Integer> enemies = new HashMap<>();



    public Level1Mini(float playerSpawnX, float playerSpawnY) {
        PlayerSpawnX = playerSpawnX;
        PlayerSpawnY = playerSpawnY;
        tiledMap = new TmxMapLoader().load(Maps.Level1Mini.source);
        //renderer = new OrthogonalTiledMapRenderer(tiledMap);
        sm = new SoundManager();
        sm.safeZone.play();
        setup();
    }

    @Override
    public void setup() {
        enemies.put("BlueEnemy", 0);
        enemies.put("RedEnemy", 0);      
    }

    @Override
    public TiledMap getMap() {
        return tiledMap;
    }

    @Override
    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }

    @Override
    public float getPlayerSpawnX() {
        return PlayerSpawnX;
    }

    @Override
    public float getPlayerSpawnY() {
        return PlayerSpawnY;
    }

    @Override
    public int getEnemyBoundsFromX() {
        return EnemyBoundsfromX;
    }

    @Override
    public int getEnemyBoundsToX() {
        return EnemyBoundsToX;
    }

    @Override
    public int getEnemyBoundsFromY() {
        return EnemyBoundsFromY;
    }

    @Override
    public int getEnemyBoundsToY() {
        return EnemyBoundsToY;
    }

    @Override
    public Map<String, Integer> getEnemies() {
        return this.enemies;
    } 

    @Override
    public void stopMusic() {
        sm.safeZone.stop();
        sm.safeZone.dispose();
        }

    @Override
    public void setAllEnemiesDead(boolean allEnemiesDead) {
        this.allEnemiesDead = allEnemiesDead;
    }

    @Override
    public boolean getAllEnemiesDead() {
        return this.allEnemiesDead;
    }

    @Override
    public String getMapName() {
        return "safezone";
    }
}
