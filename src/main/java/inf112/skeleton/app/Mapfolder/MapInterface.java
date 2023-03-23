package inf112.skeleton.app.Mapfolder;

import java.util.ArrayList;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Entities.MonsterInterface;


public interface MapInterface {

    public void setup();

    public void spawn(ArrayList<String> enemyList);

    public TiledMap getMap();

    public OrthogonalTiledMapRenderer getRenderer();
    
    public float getPlayerSpawnX();
    
    public float getPlayerSpawnY();
    
    public int getEnemyBoundsFromX();
    
    public int getEnemyBoundsToX();
    
    public int getEnemyBoundsFromY();
    
    public int getEnemyBoundsToY();
    
    public ArrayList<MonsterInterface> getMonsters();
}
