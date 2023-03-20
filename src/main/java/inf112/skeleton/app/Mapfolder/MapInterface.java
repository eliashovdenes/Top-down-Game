package inf112.skeleton.app.Mapfolder;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public interface MapInterface {
    public int getEnemies();
    public TiledMap getMap();
    public OrthogonalTiledMapRenderer getRenderer();
    public float getPlayerSpawnX();
    public float getPlayerSpawnY();
    public int getEnemyBoundsFromX();
    public int getEnemyBoundsToX();
    public int getEnemyBoundsFromY();
    public int getEnemyBoundsToY();    
}
