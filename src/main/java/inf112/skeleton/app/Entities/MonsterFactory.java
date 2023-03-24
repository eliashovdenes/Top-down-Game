package inf112.skeleton.app.Entities;

import inf112.skeleton.app.Mapfolder.MapInterface;

public interface MonsterFactory {
    String name();
    MonsterInterface create(MapInterface map);
}
