package inf112.skeleton.app;


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

    
    
}
