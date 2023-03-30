package inf112.skeleton.app.Entities.Enemies;

import inf112.skeleton.app.Mapfolder.MapInterface;

public interface MonsterFactory {
    String name();
    MonsterInterface create(MapInterface map);
}
