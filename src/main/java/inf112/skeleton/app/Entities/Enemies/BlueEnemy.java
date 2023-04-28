package inf112.skeleton.app.Entities.Enemies;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Entities.AbstractGameObject;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Enums.PlayerPics;
import inf112.skeleton.app.Entities.Items.HealthPotion;
import inf112.skeleton.app.Entities.Projectiles.ProjectileInterface;
import inf112.skeleton.app.Mapfolder.MapInterface;

public class BlueEnemy extends AbstractGameObject implements MonsterInterface  {

    Sprite sprite;
    int attackDamage = 1;
    float fromX,fromY,toX,toY;
    float speed = 0.5f ;
    private DirectionEnum direction;
    MapInterface map;
    private double healthPotionDropChance;
    private Random random;
    public ArrayList<ProjectileInterface> projectileList;
    Random rand = new Random();
    float time = 0;


    public BlueEnemy(MapInterface map) {
        super(new Vector2(0,0), map);
        this.map = map;
        setSprite(PlayerPics.ENEMYDOWN.source);
        rectangle = new Rectangle(position.x, position.y, getWidth(), getHeight());
        setXYFromSpawnBounds();
        this.velocity.x = speed;
        this.velocity.y = speed;
        this.setMaxhitpoints(50);
        this.setCurrentHitPoints(this.getMaxHitpoints());
        this.setHealthPotionDropChance(0.3);
        this.random = new Random();
        projectileList = new ArrayList<ProjectileInterface>();
    }

    public BlueEnemy() {
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
				return "BlueEnemy";
			}

			@Override
			public MonsterInterface create(MapInterface map) {
				return new BlueEnemy(map);
			}

            @Override
			public MonsterInterface create() {
				return new BlueEnemy();
			}
		};
	}

    public String getName() {
        return "BlueEnemy";
    }

    @Override
    public void handleCollision() {
            if (xCollision()){
                position.x=recentPosition.x;
                velocity.x = - velocity.x;
                
            }
            if (yCollision()){
                position.y=recentPosition.y;
                velocity.y = - velocity.y;
                
            }
            
        }

    @Override
    public void update(float delta) {
        changeDirection(delta);
        ApplyMovement();
        sprite.setPosition(position.x, position.y);
    }

    private boolean changeDirection(float dt) {
        time -= dt;
        if (time <= 0) {
            velocity.x = rand.nextFloat(0,0.5f);
            velocity.y = rand.nextFloat(0, 0.5f);
            time = rand.nextFloat(2, 5);
            return true;
        }
        return false;
    }

    @Override
    public void setSprite(String string) {
        sprite = new Sprite(new Texture(string));
    }

    public void followPlayer(float x, float y) {
      
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

    

    @Override
    public boolean dropHealthPotion() {
        double dropValue = this.random.nextDouble();
        return (dropValue <= this.getHealthPotionDropChance());
    }

    @Override
    public double getHealthPotionDropChance() {
        return this.healthPotionDropChance;
    }

    @Override
    public void setHealthPotionDropChance(double chance) {
        this.healthPotionDropChance = chance;
    }

    @Override
    public ArrayList<ProjectileInterface> getProjectiles() {
        return this.projectileList;
    }
}
