package inf112.skeleton.app.Mapfolder;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Maps;

public class Cave extends TiledMap implements MapInterface{
    
    private int enemies = 10;
    private float PlayerSpawnX = 23;
    private float PlayerSpawnY = 28;
    private int EnemyBoundsfromX = 19;
    private int EnemyBoundsToX = 20;
    private int EnemyBoundsFromY = 21;
    private int EnemyBoundsToY = 28;

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;

    public Cave(){
        tiledMap = new TmxMapLoader().load(Maps.Cave.source);
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
    

