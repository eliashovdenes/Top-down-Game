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
import inf112.skeleton.app.Entities.Enemies.RedEnemy;

public class Level1 extends TiledMap implements MapInterface {
    
    private float PlayerSpawnX = 122;
    private float PlayerSpawnY = 70;
    private int EnemyBoundsfromX = 120;
    private int EnemyBoundsToX = 125;
    private int EnemyBoundsFromY = 65;
    private int EnemyBoundsToY = 75;

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;
    private LinkedList<MonsterInterface> monsterList = new LinkedList<>();
    private Map<String, MonsterFactory> monsterFactories = new HashMap<>();
    private ArrayList<String> enemyList;

    public Level1(){
        tiledMap = new TmxMapLoader().load(Maps.Level1.source);
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
        enemyList = new ArrayList<>(Arrays.asList("BlueEnemy", "RedEnemy", "RedEnemy", "BlueEnemy"));
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

