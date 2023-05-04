package inf112.skeleton.app.Entities.Projectiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public interface ProjectileInterface{

    

    public void update(float delta);

    public  Sprite getSprite();

    public  void setSprite(String string);

    public  float getWidth();
    
    public  float getHeight();

    public float getMovementSpeed();

    public Rectangle getRect();

    public int getDamage();

    public Vector2 getPosition();
   
}
