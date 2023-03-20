package inf112.skeleton.app.Mapfolder;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Maps;

public class House extends TiledMap implements MapInterface {
    private int enemies = 10;
    private float PlayerSpawnX = 18;
    private float PlayerSpawnY = 18;
    private int EnemyBoundsfromX = 13;
    private int EnemyBoundsToX = 30;
    private int EnemyBoundsFromY = 32;
    private int EnemyBoundsToY = 34;

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;

    public House(){
        tiledMap = new TmxMapLoader().load(Maps.House.source);
        renderer = new OrthogonalTiledMapRenderer(tiledMap);
    }
    @Override
    public int getEnemies() {
        return enemies;
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
    
}
    

