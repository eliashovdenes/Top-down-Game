package inf112.skeleton.app.Mapfolder;

import java.util.Map;

import com.badlogic.gdx.maps.tiled.TiledMap;

public interface MapInterface {

    /**
     * Adds the base amount of enemies to the enemies HashMap
     */
    public void setup();

    /**
     * 
     * @return TiledMap object associated with the map.
     */
    public TiledMap getMap();

    /**
     * @return x-coordinate spawn point
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

    /**
     * Parameter decides if player can leave arena.
     * 
     * @param allEnemiesDead true: player can leave arena, false: player can't leave
     *                       arena.s
     */

    public void setAllEnemiesDead(boolean allEnemiesDead);

    /**
     * 
     * @return if enemy can leave arena map.
     */
    public boolean getAllEnemiesDead();

    /**
     * 
     * @return string of map name.
     */
    public String getMapName();

}
