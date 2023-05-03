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

    Sprite sprite;
    int attackDamage = 20;
    float fromX,fromY,toX,toY;
    float speed;
    private DirectionEnum direction;
    MapInterface map;
    private double healthPotionDropChance;
    private Random random;
    public ArrayList<ProjectileInterface> projectileList;
    private float shootTimer = 0.0f;
    private final float shootCooldown = 3.0f;
    private int projectileDamage;
    private float time = 0;

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
        if (Math.abs(x - position.x) > Math.abs(y - position.y)) {
            if (x > position.x) {sprite.setTexture(new Texture(RedEnemyPics.ENEMYRIGHT.source)); this.direction = DirectionEnum.EAST;}
            else {sprite.setTexture(new Texture(RedEnemyPics.ENEMYLEFT.source)); this.direction = DirectionEnum.WEST;}
        }
        else if (Math.abs(x - position.x) < Math.abs(y - position.y)) {
            if (y > position.y) {sprite.setTexture( new Texture(RedEnemyPics.ENEMYUP.source)); this.direction = DirectionEnum.NORTH;}
            else {sprite.setTexture( new Texture(RedEnemyPics.ENEMYDOWN.source)); this.direction = DirectionEnum.SOUTH;}
        }
    }

    public String getName() {
        return "RedEnemy";
    }

    @Override
    public void update(float delta) {
        changeDirection(delta);
        ApplyMovement();
        sprite.setPosition(position.x, position.y);
        shootRedProjectile(delta, this.projectileDamage);
        for (ProjectileInterface projectile : projectileList) {
            projectile.update(delta);
        }
        
    }
    private boolean changeDirection(float dt) {
        time -= dt;
        if (time <= 0) {
            velocity.x = random.nextFloat(-0.7f,0.7f);
            velocity.y = random.nextFloat(-0.7f, 0.7f);
            time = random.nextFloat(2, 5);
            return true;
        }
        return false;
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

            // set velocity based on enemy direction.
            Vector2 velocity = new Vector2();
            if (this.direction == DirectionEnum.NORTH)
                velocity.set(0, 1);
            if (this.direction == DirectionEnum.EAST)
                velocity.set(1, 0);
            if (this.direction == DirectionEnum.WEST)
                velocity.set(-1, 0);
            if (this.direction == DirectionEnum.SOUTH)
                velocity.set(0, -1);

            // projectile created and added.
            Vector2 projectilePos = new Vector2(position.x, position.y);
            RedProjectile projectile = new RedProjectile(projectilePos, map, velocity, this, damage);
            projectileList.add(projectile);
            shootTimer = shootCooldown;  
        }
        else {
            shootTimer -= delta;
        }
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

    @Override
    public void giveShootingPermission() {
        
    }

    


    
}