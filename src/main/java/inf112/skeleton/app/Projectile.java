package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Projectile extends GameObject{

    
    Collision collision;
    public Texture projTexture;
    float velX;
    float velY;
/*
    public Projectile(Vector2 projectilePosition, Vector2 projectileDirection, float x, float y,float speed) {
        projectilePosition = new Vector2(x,y);
        velocity.set(projectileDirection).scl(speed);
    } */

    public Projectile(float x, float y, ID id, Sprite sprite, TiledMap map, View view) {
        super(x, y, id, sprite, map, view);
        //setTexture(sprite.getTexture());
        velX=0;
        velY=1;
        collision = new Collision(map, this, view);
        
    }
    public void update(float deltaTime) {
        x+=velX;
        y+=velY;
        setY(getY() +velY*deltaTime);
        setX(getX()+velX*deltaTime);
    }

   
    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    } 

    @Override
    public void setOldXNdY(float oldX, float oldY) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOldXNdY'");
    }

    @Override
    public float getOldX() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOldX'");
    }

    @Override
    public float getOldY() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOldY'");
    }
    

}
