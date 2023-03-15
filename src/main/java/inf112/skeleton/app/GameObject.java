package inf112.skeleton.app;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;

public abstract class GameObject extends Sprite {
    
    protected float x, y;
    protected float velX, velY;
    protected ID id;
    protected TiledMap map;
    protected float speed = 1;
    protected Collision collision;
    protected View view;
    protected float oldX, oldY;
    protected int maxHitPoints;
    protected int currentHitPoints;

    public GameObject(float x, float y, ID id, Sprite sprite, TiledMap map, View view) {
        super(sprite);
        this.map = map;
        this.x = x;
        this.y = y;
        this.id = id;
        this.view = view;
        setPosition(x, y);
    }

    public abstract void setOldXNdY(float oldX, float oldY);
    public abstract float getOldX();
    public abstract float getOldY();



    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getCurrentHitPoints() {
        return this.currentHitPoints;
    }

    public void setCurrentHitPoints(int newHitPoints) {
        if (newHitPoints > this.maxHitPoints) {
            this.currentHitPoints = maxHitPoints;
        }
        else if (newHitPoints < 0) {
            this.currentHitPoints = 0;
        }
        else {
            this.currentHitPoints = newHitPoints;
        }
    }
    
    public void takeDamage(int damage) {
        this.setCurrentHitPoints(this.currentHitPoints - damage);
    }

    public boolean isDead() {
        return getCurrentHitPoints() <= 0;
    } 

    public void heal(int healing) {
        this.setCurrentHitPoints(this.currentHitPoints + healing);
    }

    

    public int getMaxHitPoints() {
        return this.maxHitPoints;
    }
    
    
}
