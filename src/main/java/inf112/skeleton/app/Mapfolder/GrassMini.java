package inf112.skeleton.app.Mapfolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Entities.Enemies.BlueEnemy;
import inf112.skeleton.app.Entities.Enemies.MonsterFactory;
import inf112.skeleton.app.Entities.Enemies.MonsterInterface;
import inf112.skeleton.app.Entities.Enemies.RedEnemy;

public class GrassMini extends TiledMap implements MapInterface {

    private float PlayerSpawnX = 123;
    private float PlayerSpawnY = 87;

    private int EnemyBoundsfromX = 104;
    private int EnemyBoundsToX = 133;
    private int EnemyBoundsFromY = 56;
    private int EnemyBoundsToY = 85;

    

    

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;
    private ArrayList<MonsterInterface> monsterList = new ArrayList<>();
    private Map<String, MonsterFactory> monsterFactories = new HashMap<>();
    private ArrayList<String> enemyList;


    public GrassMini(float playerSpawnX, float playerSpawnY) {
        PlayerSpawnX = playerSpawnX;
        PlayerSpawnY = playerSpawnY;
        tiledMap = new TmxMapLoader().load(Maps.GrassMini.source);
        renderer = new OrthogonalTiledMapRenderer(tiledMap);
        setup();
        this.spawn(enemyList);
    }

    @Override
    public void setup() {
        MonsterFactory blueEnemyFactory = BlueEnemy.getFactory();
        MonsterFactory redEnemyFactory = RedEnemy.getFactory();
        monsterFactories.put(blueEnemyFactory.name(), blueEnemyFactory);
        monsterFactories.put(redEnemyFactory.name(), redEnemyFactory);
        enemyList = new ArrayList<>(Arrays.asList("BlueEnemy", "RedEnemy", "RedEnemy", "BlueEnemy", "BlueEnemy", "RedEnemy", "RedEnemy", 
        "BlueEnemy", "BlueEnemy", "RedEnemy", "RedEnemy", "BlueEnemy" , "BlueEnemy", "RedEnemy", "RedEnemy", "BlueEnemy" , "BlueEnemy", "RedEnemy", "RedEnemy", "BlueEnemy"));
    }
    
    @Override
    public void spawn(ArrayList<String> enemyList) {

        for (int i=0; i < enemyList.size(); i++){
            MonsterFactory monsterFactory = monsterFactories.get(enemyList.get(i));
            MonsterInterface monster = monsterFactory.create(this);
            monsterList.add(monster);
        }
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
    public ArrayList<MonsterInterface> getMonsterList() {
        return this.monsterList;
    }

    @Override
    public void removeMonster(MonsterInterface monster) {
        monsterList.remove(monster);
    }
    
}
