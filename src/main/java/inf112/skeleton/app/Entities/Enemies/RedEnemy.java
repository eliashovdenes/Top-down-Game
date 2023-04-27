package inf112.skeleton.app.Entities.Enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

import inf112.skeleton.app.Entities.AbstractGameObject;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Enums.RedEnemyPics;
import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Mapfolder.MapInterface;

public class RedEnemy extends AbstractGameObject implements MonsterInterface  {

    Sprite sprite;
    int attackDamage = 20;
    float fromX,fromY,toX,toY;
    float speed = 0.1f ;
    private DirectionEnum direction;
    MapInterface map;
    // Integer RedEnemyHP =75;

    public RedEnemy(MapInterface map) {
        super(new Vector2(0,0), map);
        this.map = map;
        setSprite(RedEnemyPics.ENEMYDOWN.source);
        rectangle = new Rectangle(position.x, position.y, getWidth(), getHeight());
        setXYFromSpawnBounds();  
        this.setMaxhitpoints(75);
        this.setCurrentHitPoints(this.getMaxHitpoints()); 
    }

    public RedEnemy() {
        super(new Vector2(0,0));
        this.velocity.x = speed;
        this.velocity.y = speed;
        this.setMaxhitpoints(50);
        this.setCurrentHitPoints(this.getMaxHitpoints());
    }

    public static MonsterFactory getFactory() {
		
		return new MonsterFactory() {

			@Override
			public String name() {
				return "RedEnemy";
			}

			@Override
			public MonsterInterface create(MapInterface map) {
				return new RedEnemy(map);
			}

            @Override
			public MonsterInterface create() {
				return new RedEnemy();
			}
		};
	}


    @Override
    public void handleCollision() {
            if (xCollision()){
                position.x = recentPosition.x;
                velocity.x = - velocity.x;
                
            }
            if (yCollision()){
                position.y=recentPosition.y;
                velocity.y = - velocity.y;
                
            }
            
        }

    public void followPlayer(float x, float y) {
        if (x > position.x) velocity.x = speed;
        else if (x < position.x) velocity.x =  -speed;
        if (y > position.y) velocity.y = speed;
        else if (y < position.y) velocity.y =  -speed;
    }

    public String getName() {
        return "RedEnemy";
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

    @Override
    public void setXYFromSpawnBounds(){
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

    @Override
    public int getDamage() {
        return attackDamage;
    }

    
}