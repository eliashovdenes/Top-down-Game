package inf112.skeleton.app.Mapfolder;

import java.util.Map;

import com.badlogic.gdx.maps.tiled.TiledMap;


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
     * 
     * @return TiledMap object associated with the map.
     */
    public TiledMap getMap();

    

    /**
     * @return  x-coordinate spawn point
     */
    public float getPlayerSpawnX();


    /**
     * stops the music.
     */
    public void stopMusic();

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
     * @return Map - key: String monster, value: Integer number of monsters
     */
    public Map<String, Integer> getEnemies();

    public void setAllEnemiesDead(boolean allEnemiesDead);

    public boolean getAllEnemiesDead();

    public String getMapName();

}
