package inf112.skeleton.app.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;


public interface ProjectileInterface{

    

    public void update(float delta);

    public  Sprite getSprite();

    public  void setSprite(String string);

    public  void setMovementSpeed(float speed);

    public  float getWidth();
    
    public  float getHeight();

    public Vector2 setVelocity();
   
}
