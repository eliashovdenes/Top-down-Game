package inf112.skeleton.app.Entities.Enemies;

import inf112.skeleton.app.Mapfolder.MapInterface;

public interface MonsterFactory {
    
    /**
     * Returns the name og the monster
     * 
     * @return String - name of the monster/enemy
     */
    String name();

    /**
     * Creates a new enemy
     * 
     * @param map - MapInterface: the map the enemy will be created on
     * @param scaler - float: How much the base stats of the enemy will be scaled
     * @return
     */
    MonsterInterface create(MapInterface map, float scaler);
}
