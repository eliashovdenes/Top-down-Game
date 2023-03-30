package inf112.skeleton.app.Mapfolder;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import inf112.skeleton.app.Entities.Enemies.BlueEnemy;
import inf112.skeleton.app.Entities.Enemies.MonsterFactory;
import inf112.skeleton.app.Entities.Enemies.MonsterInterface;
import inf112.skeleton.app.Entities.Enemies.RedEnemy;

public class Grass extends TiledMap implements MapInterface {

    private int enemies = 3;
    private float PlayerSpawnX = 119;
    private float PlayerSpawnY = 52;
    private int EnemyBoundsfromX = 110;
    private int EnemyBoundsToX = 115;
    private int EnemyBoundsFromY = 52;
    private int EnemyBoundsToY = 100;

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;
    private ArrayList<MonsterInterface> monsterList = new ArrayList<>();
    private Map<String, MonsterFactory> monsterFactories = new HashMap<>();
    private ArrayList<String> enemyList;

    public Grass(){
        tiledMap = new TmxMapLoader().load(Maps.Grass.source);
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
        enemyList = new ArrayList<>(Arrays.asList("BlueEnemy", "RedEnemy", "RedEnemy"));
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
    public ArrayList<MonsterInterface> getMonsters() {
        return monsterList;
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
        return monsterList;
    }

    
    public void setMonsterList(ArrayList<MonsterInterface> monsterList) {
        this.monsterList = monsterList;
    }
    
}
