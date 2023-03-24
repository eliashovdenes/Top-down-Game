package inf112.skeleton.app.Mapfolder;

import java.util.ArrayList;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Entities.MonsterInterface;


public interface MapInterface {
    /**
     * 
     * @return an integer that represent amount of enemies to be spawned at map
     */
    public int getEnemies();

    /**
     * 
     * @return TiledMap object associated with the map.
     */
    public TiledMap getMap();

    /**
     * 
     * @return OrthogonalTiledMapRenderer object associated with the map.
     */
    public OrthogonalTiledMapRenderer getRenderer();

    /**
     * @return  x-coordinate spawn point
     */
    public float getPlayerSpawnX();

    /**
     * @return y-coordinate spawn point
     */
    public float getPlayerSpawnY();

    /**
     * 
     * @return from X coordinate bounds for spawn location
     */
    public int getEnemyBoundsFromX();

    /**
     * 
     * @return to X coordinate bounds for spawn location
     */
    public int getEnemyBoundsToX();

    /**
     * 
     * @return from Y coordinate bounds for spawn location
     */
    public int getEnemyBoundsFromY();

    /**
     * 
     * @return to Y coordinate bounds for spawn location.
     */
    public int getEnemyBoundsToY();    
}
