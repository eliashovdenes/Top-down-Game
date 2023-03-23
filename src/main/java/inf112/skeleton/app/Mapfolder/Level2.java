package inf112.skeleton.app.Mapfolder;

import java.util.ArrayList;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Entities.MonsterInterface;

public class Level2 extends TiledMap implements MapInterface {

    private float PlayerSpawnX = 114;
    private float PlayerSpawnY = 73;
    private int EnemyBoundsfromX = 200;
    private int EnemyBoundsToX = 800;
    private int EnemyBoundsFromY = 200;
    private int EnemyBoundsToY = 800;

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;
    private ArrayList<MonsterInterface> monsterList = new ArrayList<>();

    public Level2(){
        tiledMap = new TmxMapLoader().load(Maps.Level2.source);
        renderer = new OrthogonalTiledMapRenderer(tiledMap);
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
    
    @Override
    public ArrayList<MonsterInterface> getMonsters() {
        return monsterList;
    }
    
}
