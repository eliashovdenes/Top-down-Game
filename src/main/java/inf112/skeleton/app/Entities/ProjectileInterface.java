package inf112.skeleton.app.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Mapfolder.MapInterface;


public interface ProjectileInterface{

    

    abstract public void update(float delta);

    public abstract Sprite getSprite();
    

    public abstract void setSprite(String string);

    public abstract void setMovementSpeed(float speed);

    public abstract float getWidth();
    
    public abstract float getHeight();

   
}
