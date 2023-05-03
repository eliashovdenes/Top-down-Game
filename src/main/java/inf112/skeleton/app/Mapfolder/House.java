package inf112.skeleton.app.Mapfolder;

import java.util.HashMap;
import java.util.Map;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Sound.SoundManager;

public class House extends TiledMap implements MapInterface {
    private float PlayerSpawnX = 18;
    private float PlayerSpawnY = 18;
    private int EnemyBoundsfromX = 13;
    private int EnemyBoundsToX = 30;
    private int EnemyBoundsFromY = 32;
    private int EnemyBoundsToY = 34;

    private SoundManager sm;
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;
    private boolean allEnemiesDead = false;
    private Map<String, Integer> enemies = new HashMap<>();

    public House(){
        tiledMap = new TmxMapLoader().load(Maps.House.source);
        sm = new SoundManager();
        sm.house.play();
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
        sm.house.stop();
        sm.house.dispose();
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
        return "house";
    }
    
}
    

