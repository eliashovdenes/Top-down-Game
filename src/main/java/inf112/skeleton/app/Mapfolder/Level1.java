package inf112.skeleton.app.Mapfolder;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Level1 extends TiledMap implements MapInterface {
    private int enemies = 0;
    private float PlayerSpawnX = 122;
    private float PlayerSpawnY = 70;
    private int EnemyBoundsfromX = 121;
    private int EnemyBoundsToX = 122;
    private int EnemyBoundsFromY = 69;
    private int EnemyBoundsToY = 70;

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

