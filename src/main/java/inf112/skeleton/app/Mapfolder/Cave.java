package inf112.skeleton.app.Mapfolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import inf112.skeleton.app.Entities.MonsterFactory;
import inf112.skeleton.app.Entities.MonsterInterface;
import inf112.skeleton.app.Entities.Enemies.BlueEnemy;

public class Cave extends TiledMap implements MapInterface{
    
    private ArrayList<String> enemyList;
    private float PlayerSpawnX = 120;
    private float PlayerSpawnY = 77;
    private int EnemyBoundsfromX = 122;
    private int EnemyBoundsToX = 123;
    private int EnemyBoundsFromY = 63;
    private int EnemyBoundsToY = 70;

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;
    private ArrayList<MonsterInterface> monsterList = new ArrayList<>();
    private Map<String, MonsterFactory> monsterFactories = new HashMap<>();

    public Cave(){
        tiledMap = new TmxMapLoader().load(Maps.Cave.source);
        renderer = new OrthogonalTiledMapRenderer(tiledMap);
        setup();
        this.spawn(enemyList);
    }
    
    public void setup() {
        MonsterFactory blueEnemyFactory = BlueEnemy.getFactory();
        monsterFactories.put(blueEnemyFactory.name(), blueEnemyFactory);
        enemyList =new ArrayList<>(Arrays.asList("BlueEnemy", "BlueEnemy"));
    }
    
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
    
}
    

