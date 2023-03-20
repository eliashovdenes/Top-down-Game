package inf112.skeleton.app.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;


public abstract class AbstractProjectile extends AbstractGameObject{

    public AbstractProjectile(Vector2 position,TiledMap map) {
        super(position, map);
    }

    @Override
    abstract public void update(float delta);

    @Override
    public abstract Sprite getSprite();
    

    @Override
    public abstract void setSprite(String string);

    @Override
    public abstract void setMovementSpeed(float speed);

    @Override
    public abstract float getWidth();
    

    @Override
    public abstract float getHeight();

   
}
