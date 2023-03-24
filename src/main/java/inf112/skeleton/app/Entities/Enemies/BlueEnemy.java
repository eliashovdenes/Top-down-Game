package inf112.skeleton.app.Entities.Enemies;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Entities.AbstractGameObject;
import inf112.skeleton.app.Entities.MonsterFactory;
import inf112.skeleton.app.Entities.MonsterInterface;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Enums.PlayerPics;
import inf112.skeleton.app.Mapfolder.MapInterface;

public class BlueEnemy extends AbstractGameObject implements MonsterInterface  {

    Sprite sprite;
    float fromX,fromY,toX,toY;
    float speed = 1 ;
    private DirectionEnum direction;
    MapInterface map;

    public BlueEnemy(MapInterface map) {
        super(new Vector2(0,0), map);
        this.map = map;
        setSprite(PlayerPics.ENEMYDOWN.source);
        setXYFromSpawnBounds();
        this.velocity.x = speed;
        this.velocity.y = speed;
        
    }

    public static MonsterFactory getFactory() {
		
		return new MonsterFactory() {

			@Override
			public String name() {
				return "BlueEnemy";
			}

			@Override
			public MonsterInterface create(MapInterface map) {
				return new BlueEnemy(map);
			}
		};
	}

    @Override
    public void update(float delta) {
        ApplyMovement();
        sprite.setPosition(position.x, position.y);
    }

    @Override
    public void setSprite(String string) {
        sprite = new Sprite(new Texture(string));
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void setMovementSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public float getWidth() {
        return sprite.getWidth();
    }

    @Override
    public float getHeight() {
        return sprite.getHeight();
    }

    @Override
    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    @Override
    public DirectionEnum getDirection() {
        return direction;
    }

    // @Override
    // public void spawn() {

    //     for (int i=0; i<map.getEnemies();i++){
    //         monsterList.add(new BlueEnemy(map));

    //     }
    // }

    @Override
    public void setXYFromSpawnBounds(){

        System.out.println("hvor eller ");
        Random rand = new Random();
        fromX = map.getEnemyBoundsFromX()*16;
        fromY = map.getEnemyBoundsFromY()*16;
        toX = map.getEnemyBoundsToX()*16;
        toY = map.getEnemyBoundsToY()*16;
        super.position.set(rand.nextFloat(toX-fromX)+fromX, rand.nextFloat(toY-fromY)+fromY);
        sprite.setPosition(position.x,position.y);
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }
    
}
