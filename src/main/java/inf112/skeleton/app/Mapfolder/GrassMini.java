package inf112.skeleton.app.Mapfolder;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Sound.SoundManager;

public class GrassMini extends TiledMap implements MapInterface {

    private float PlayerSpawnX = 123;
    private float PlayerSpawnY = 87;

    private int EnemyBoundsfromX = 108;
    private int EnemyBoundsToX = 131;
    private int EnemyBoundsFromY = 58;
    private int EnemyBoundsToY = 81;
    
    private SoundManager sm;
    private TiledMap tiledMap;

    private Map<String, Integer> enemies = new HashMap<>();
    private boolean allEnemiesDead = false;


    public GrassMini(float playerSpawnX, float playerSpawnY) {
        PlayerSpawnX = playerSpawnX;
        PlayerSpawnY = playerSpawnY;
        tiledMap = new TmxMapLoader().load(Maps.GrassMini.source);
        sm = new SoundManager();
        sm.arenaSound.play();
        setup();
    }

    @Override
    public void setup() {
        enemies.put("BlueEnemy", 2);
        enemies.put("RedEnemy", 3);   
        // enemies.put("RedBoss", 1);   
    }
    
    @Override
    public TiledMap getMap() {
        return tiledMap;
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
        sm.arenaSound.stop();
        sm.arenaSound.dispose();
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
        return "arena";
    }
    
}
