package inf112.skeleton.app.Entities.Enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Random;

import inf112.skeleton.app.Entities.AbstractGameObject;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Enums.RedEnemyPics;
import inf112.skeleton.app.Entities.Projectiles.ProjectileInterface;
import inf112.skeleton.app.Entities.Projectiles.RedProjectile;
import inf112.skeleton.app.Mapfolder.MapInterface;

public class RedEnemy extends AbstractGameObject implements MonsterInterface  {

    private Sprite sprite;
    private int attackDamage = 20;
    private float fromX,fromY,toX,toY;
    private float speed;
    private DirectionEnum direction;
    private MapInterface map;
    private double healthPotionDropChance;
    private Random random;
    private ArrayList<ProjectileInterface> projectileList;
    private float shootTimer = 0.0f;
    private float shootCooldown;
    private int projectileDamage;

    public RedEnemy(MapInterface map, float scaler) {
        super(new Vector2(0,0), map);
        this.map = map;
        setSprite(RedEnemyPics.ENEMYDOWN.source);
        rectangle = new Rectangle(position.x, position.y, getWidth(), getHeight());
        setXYFromSpawnBounds();  
        this.setMaxhitpoints(Math.round(75*scaler));
        this.setCurrentHitPoints(this.getMaxHitpoints()); 
        this.random = new Random();
        this.setHealthPotionDropChance(0.5);
        projectileList = new ArrayList<ProjectileInterface>();
        this.projectileDamage = Math.round(10 * scaler);
        this.speed = scaler/20;
        this.shootCooldown = this.getRandomCooldown(3, 5);
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
			public MonsterInterface create(MapInterface map, float scaler) {
				return new RedEnemy(map, scaler);
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
        if (y > position.y) {
            velocity.y = speed;
            setSprite(RedEnemyPics.ENEMYUP.source);
            this.direction = DirectionEnum.NORTH;
        }
        else if (y < position.y) {
            velocity.y =  -speed;
            setSprite(RedEnemyPics.ENEMYDOWN.source);
            this.direction = DirectionEnum.SOUTH;
        }
    }

    public String getName() {
        return "RedEnemy";
    }

    @Override
    public void update(float delta) {
        ApplyMovement();
        sprite.setPosition(position.x, position.y);
        shootRedProjectile(delta, this.projectileDamage);
        for (ProjectileInterface projectile : projectileList) {
            projectile.update(delta);
        }
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

    private void shootRedProjectile(float delta, int damage) {      
        if (shootTimer <= 0) {
            Vector2 projectilePos = new Vector2(position.x, position.y);
            createProjectile(projectilePos, map, new Vector2(1, 0), this, damage);
            createProjectile(projectilePos, map, new Vector2(-1, 0), this, damage);
            createProjectile(projectilePos, map, new Vector2(0, 1), this, damage);
            createProjectile(projectilePos, map, new Vector2(0, -1), this, damage);
    
            shootTimer = shootCooldown; 
        }
        else {
            shootTimer -= delta;
        }
    }

    private void createProjectile(Vector2 position, MapInterface mapI, Vector2 velocity, MonsterInterface monster, int damage) {
        RedProjectile projectile = new RedProjectile(new Vector2(position), mapI, velocity, monster, damage);
        projectileList.add(projectile);           
    }

    @Override
    public ArrayList<ProjectileInterface> getProjectiles() {
        return this.projectileList;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    private float getRandomCooldown(int min, int max) {
        Random random = new Random();
        return min + random.nextFloat() * (max - min);
    }   
}