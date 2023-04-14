package inf112.skeleton.app.Mapfolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Entities.Enemies.BlueEnemy;
import inf112.skeleton.app.Entities.Enemies.MonsterFactory;
import inf112.skeleton.app.Entities.Enemies.MonsterInterface;

public class Level2 extends TiledMap implements MapInterface {

    private float playerSpawnX = 114;
    private float playerSpawnY = 73;
    private int EnemyBoundsfromX = 121;
    private int EnemyBoundsToX = 122;
    private int EnemyBoundsFromY = 69;
    private int EnemyBoundsToY = 70;

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;
    private LinkedList<MonsterInterface> monsterList = new LinkedList<>();
    private Map<String, MonsterFactory> monsterFactories = new HashMap<>();
    private ArrayList<String> enemyList;
    
    public Level2(float  playerSpawnX, float playerSpawnY){

        this.playerSpawnX = playerSpawnX;
        this.playerSpawnY = playerSpawnY;
        tiledMap = new TmxMapLoader().load(Maps.Level2.source);
        renderer = new OrthogonalTiledMapRenderer(tiledMap);
        setup();
        this.spawn(enemyList);
    }

    @Override
    public void setup() {
        MonsterFactory blueEnemyFactory = BlueEnemy.getFactory();
        monsterFactories.put(blueEnemyFactory.name(), blueEnemyFactory);
        enemyList = new ArrayList<>(Arrays.asList("BlueEnemy", "BlueEnemy", "BlueEnemy"));
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
        return playerSpawnX;
    }

    @Override
    public float getPlayerSpawnY() {
        return playerSpawnY;
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
    public LinkedList<MonsterInterface> getMonsters() {
        return monsterList;
    }

    @Override
    public LinkedList<MonsterInterface> getMonsterList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMonsterList'");
    }

    @Override
    public void removeMonster(MonsterInterface monster) {
        monsterList.remove(monster);
    }
    
}