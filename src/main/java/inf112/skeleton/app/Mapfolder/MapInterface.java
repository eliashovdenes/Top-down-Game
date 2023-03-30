package inf112.skeleton.app.Mapfolder;

import java.util.ArrayList;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Entities.Enemies.MonsterInterface;


public interface MapInterface {
    
    /**
     * Setup creates a MonsterFactory for each enemy class used in the map.
     * The MonsterFactories are stored in a HashMap - monsterFactories, where
     * the key (String) is the name of the monster class.
     * In setup we also create an ArrayList containing the string representation
     * of each monster we want to spawn on the map
     */
    public void setup();

    /**
     * Uses the MonsterFactories to create the monsters in the given list
     * 
     * @param enemyList - List of monster we want to create
     */
    public void spawn(ArrayList<String> enemyList);

    /**
     * 
     * @return ArrayList containing the monster objects for the map
     */
    public ArrayList<MonsterInterface> getMonsters();
    
    /**
     * 
     * @return an integer that represent amount of enemies to be spawned at map
     */
    // public int getEnemies();

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

    /**
     * 
     * @return ArrayList containing the monster objects for the map
     */
    public ArrayList<MonsterInterface> getMonsterList();
}
