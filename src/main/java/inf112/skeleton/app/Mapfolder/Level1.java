package inf112.skeleton.app.Mapfolder;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Maps;

public class Level1 extends TiledMap implements MapInterface {
    private int enemies = 10;
    private float PlayerSpawnX = 18;
    private float PlayerSpawnY = 18;
    private int EnemyBoundsfromX = 0;
    private int EnemyBoundsToX = 10;
    private int EnemyBoundsFromY = 10;
    private int EnemyBoundsToY = 10;

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;


    public Level1(){
        tiledMap = new TmxMapLoader().load(Maps.Level1.source);
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

