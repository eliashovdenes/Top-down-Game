package inf112.skeleton.app.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Collision;

public abstract class AbstractGameObject {
    protected Vector2 recentPosition;
    protected Vector2 position;
    protected Vector2 velocity;
    protected Collision collision;
    
    public AbstractGameObject(Vector2 position, TiledMap map) {
        
        this.position = position;
        this.collision = new Collision(map, this);
        this.velocity = new Vector2();
        this.recentPosition = new Vector2(position);
        
    }
    
    public abstract void update(float delta);
    
    public void ApplyMovement() {

        
        recentPosition.set(position);
        handleCollision();
        position.x += velocity.x;     
        position.y += velocity.y;

        

        
        
    }   
    
    
    

     //override to handle collision a different way for your class that extends abstractgameobject
     public void handleCollision(){
        if (xCollision()){
            position.x=recentPosition.x;
            velocity.x = 0;
            
        }
        if (yCollision()){
            position.y=recentPosition.y;
            velocity.y = 0;
            
        }
        
    }
    public boolean xCollision(){
        return collision.checkXDirection(velocity.x);
    }
    public boolean yCollision(){
        return collision.checkYDirection(velocity.y);
    }
    public float getVeloX(){
        return velocity.x;
    }
    public float getVeloY(){
        return velocity.y;
    }
   
    public Vector2 getPosition() {
        return position;
    }
    public abstract Sprite getSprite();
    public abstract void setSprite(String string);
    public abstract void setMovementSpeed(float speed);
    public abstract float getWidth();
    public abstract float getHeight();
  
    

}