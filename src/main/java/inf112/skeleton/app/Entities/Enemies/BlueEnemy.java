package inf112.skeleton.app.Entities.Enemies;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Entities.AbstractGameObject;
import inf112.skeleton.app.Entities.Enums.BlueEnemyPics;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Projectiles.ProjectileInterface;
import inf112.skeleton.app.Mapfolder.MapInterface;

public class BlueEnemy extends AbstractGameObject implements MonsterInterface  {

    Sprite sprite;
    int attackDamage;
    float fromX,fromY,toX,toY;
    float speed;
    private DirectionEnum direction;
    MapInterface map;
    private double healthPotionDropChance;
    private Random random;
    public ArrayList<ProjectileInterface> projectileList;
    Random rand = new Random();
    float time = 0;


    public BlueEnemy(MapInterface map, float scaler) {
        super(new Vector2(0,0), map);
        this.map = map;
        setSprite(BlueEnemyPics.ENEMYDOWN.source);
        rectangle = new Rectangle(position.x, position.y, getWidth(), getHeight());
        setXYFromSpawnBounds();
        this.velocity.x = speed;
        this.velocity.y = speed;
        this.setMaxhitpoints(Math.round(75*scaler));
        this.setCurrentHitPoints(this.getMaxHitpoints());
        this.setHealthPotionDropChance(0.3);
        this.attackDamage = Math.round(10*scaler);
        this.speed = scaler/10;
        this.random = new Random();
        projectileList = new ArrayList<ProjectileInterface>();
    }

    // public BlueEnemy() {
    //     super(new Vector2(0,0));
    //     this.velocity.x = speed;
    //     this.velocity.y = speed;
    //     this.setMaxhitpoints(50);
    //     this.setCurrentHitPoints(this.getMaxHitpoints());
    // }

    public static MonsterFactory getFactory() {
		
		return new MonsterFactory() {

			@Override
			public String name() {
				return "BlueEnemy";
			}

			@Override
			public MonsterInterface create(MapInterface map, float scaler) {
				return new BlueEnemy(map, scaler);
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
        ApplyMovement();
        sprite.setPosition(position.x, position.y);
    }

    

    @Override
    public void setSprite(String string) {
        sprite = new Sprite(new Texture(string));
    }

    @Override
    public void followPlayer(float x, float y) {
        if (x > position.x) {
            velocity.x = speed; 
            // sprite.setTexture(new Texture(RedBossPics.BOSSRIGHT.source));
            this.direction = DirectionEnum.WEST;
        }
        else if (x < position.x) {
            velocity.x =  - speed;
            // sprite.setTexture(new Texture(RedBossPics.BOSSLEFT.source));
            this.direction = DirectionEnum.EAST;
        }
        if (y > position.y) {
            velocity.y = speed;
            // sprite.setTexture( new Texture(RedBossPics.BOSSUP.source));
            this.direction = DirectionEnum.NORTH;
        }
        else if (y < position.y) {
            velocity.y =  - speed;
            // sprite.setTexture(new Texture(RedBossPics.BOSSDOWN.source));
            this.direction = DirectionEnum.SOUTH;
        }
        if (Math.abs(x - position.x) > Math.abs(y - position.y)) {
            if (x > position.x) sprite.setTexture(new Texture(BlueEnemyPics.ENEMYRIGHT.source));
            else sprite.setTexture(new Texture(BlueEnemyPics.ENEMYLEFT.source));
        }
        else if (Math.abs(x - position.x) < Math.abs(y - position.y)) {
            if (y > position.y) sprite.setTexture( new Texture(BlueEnemyPics.ENEMYUP.source));
            else sprite.setTexture( new Texture(BlueEnemyPics.ENEMYDOWN.source));
        }
        
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

    @Override
    public void giveShootingPermission() {
        
    }
}
