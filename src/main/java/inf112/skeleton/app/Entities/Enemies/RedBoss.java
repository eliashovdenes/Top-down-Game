package inf112.skeleton.app.Entities.Enemies;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Entities.AbstractGameObject;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Enums.RedBossPics;
import inf112.skeleton.app.Entities.Projectiles.ProjectileInterface;
import inf112.skeleton.app.Entities.Projectiles.RedProjectile;
import inf112.skeleton.app.Mapfolder.MapInterface;

public class RedBoss extends AbstractGameObject implements MonsterInterface {

    private Sprite sprite;
    private float speed = 0.5f;
    private int attackDamage;
    private Random rand = new Random();
    float fromX,fromY,toX,toY;
    private DirectionEnum direction;
    private double healthPotionDropChance;
    public ArrayList<ProjectileInterface> projectileList;
    private boolean shootingAbility = false;
    private float shootTimer = 0;
    private int projectileDamage = 30;
    private final float shootCooldown = 3.0f;

    public RedBoss(MapInterface map, float scaler) {
        super(new Vector2(0,0), map);
        setSprite(RedBossPics.BOSSDOWN.source);
        rectangle = new Rectangle(position.x, position.y, getWidth(), getHeight());
        setXYFromSpawnBounds();
        this.velocity.x = speed;
        this.velocity.y = speed;
        this.setMaxhitpoints(Math.round(1000*scaler));
        this.setCurrentHitPoints(this.getMaxHitpoints());
        this.attackDamage = 100;
        projectileList = new ArrayList<ProjectileInterface>();
    }

    public static MonsterFactory getFactory() {
		
		return new MonsterFactory() {

			@Override
			public String name() {
				return "RedBoss";
			}

			@Override
			public MonsterInterface create(MapInterface map, float scaler) {
				return new RedBoss(map, scaler);
			}

		};
	}


    @Override
    public void update(float delta) {
        ApplyMovement();
        sprite.setPosition(position.x, position.y);
        if (shootingAbility) {
            shootRedProjectile(delta, this.projectileDamage);
            for (ProjectileInterface projectile : projectileList) {
                projectile.update(delta);
            }
        }
    }

    @Override
    public void setSprite(String string) {
        sprite = new Sprite(new Texture(string));
        sprite.scale(3);
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
    public void setXYFromSpawnBounds() {
        
        fromX = map.getEnemyBoundsFromX()*16;
        fromY = map.getEnemyBoundsFromY()*16;
        toX = map.getEnemyBoundsToX()*16;
        toY = map.getEnemyBoundsToY()*16;
        super.position.set(rand.nextFloat(toX-fromX)+fromX, rand.nextFloat(toY-fromY)+fromY);
        sprite.setPosition(position.x,position.y);
    }

    @Override
    public void followPlayer(float x, float y) {
        if (x > position.x) {
            velocity.x = speed; 
        }
        else if (x < position.x) {
            velocity.x =  - speed;
        }
        if (y > position.y) {
            velocity.y = speed;
        }
        else if (y < position.y) {
            velocity.y =  - speed;
        }
        if (Math.abs(x - position.x) > Math.abs(y - position.y)) {
            if (x > position.x) {sprite.setTexture(new Texture(RedBossPics.BOSSRIGHT.source)); this.direction = DirectionEnum.EAST;}
            else {sprite.setTexture(new Texture(RedBossPics.BOSSLEFT.source)); this.direction = DirectionEnum.WEST;}
        }
        else if (Math.abs(x - position.x) < Math.abs(y - position.y)) {
            if (y > position.y) {sprite.setTexture( new Texture(RedBossPics.BOSSUP.source)); this.direction = DirectionEnum.NORTH;}
            else {sprite.setTexture( new Texture(RedBossPics.BOSSDOWN.source)); this.direction = DirectionEnum.SOUTH;}
        }
        
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
    public Vector2 getPosition() {
        return this.position;
    }

    @Override
    public Rectangle getRect() {
        return this.rectangle;
    }

    @Override
    public String getName() {
        return "RedBoss";
    }

    @Override
    public int getDamage() {
        return attackDamage;
    }


    @Override
    public boolean dropHealthPotion() {
        double dropValue = this.rand.nextDouble();
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
        return projectileList;
    }

    public void giveShootingPermission() {
        shootingAbility = true;
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
    
}
