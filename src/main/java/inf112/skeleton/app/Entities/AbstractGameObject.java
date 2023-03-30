package inf112.skeleton.app.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Collision;
import inf112.skeleton.app.Mapfolder.MapInterface;

public abstract class AbstractGameObject {
    protected Vector2 recentPosition;
    protected Vector2 position;
    protected Vector2 velocity;
    protected Collision collision;
    protected Integer currentHPInteger;
    public boolean enteredLevel3 = false;
    
    
    public AbstractGameObject(Vector2 position, MapInterface map) {
        
        this.position = position;
        TiledMap tiledMap = map.getMap();
        this.collision = new Collision(map, this);
        this.velocity = new Vector2();
        this.recentPosition = new Vector2(position);
        
    }
    
    //** update is a method that updates the position of the object */
    public abstract void update(float delta);
    
    //**applymovement is a method that applies the velocity to the position of the object. */
    public void ApplyMovement() {
        recentPosition.set(position);
        handleCollision();
        position.x += velocity.x;     
        position.y += velocity.y;
    }   
    
    
    

    //**override to handle collision a different way for your class that extends abstractgameobject */
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

    //**checks if the object is colliding in x and y direction->>>> */
    public boolean xCollision(){
        return collision.checkXDirection(velocity.x);
    }
    public boolean yCollision(){
        return collision.checkYDirection(velocity.y);
    }

    //**getters for velocity in x and y direction */
    public float getVeloX(){
        return velocity.x;
    }
    public float getVeloY(){
        return velocity.y;
    }

    //**setter and getter for Currenthealth */
    public Integer getHP(){
        return currentHPInteger;
    }
    public void setHP(Integer hp){
            currentHPInteger = hp;

    }
   
    //**getters for position */
    public Vector2 getPosition() {
        return position;
    }

    //**getters and setters for Sprite */
    public abstract Sprite getSprite();
    public abstract void setSprite(String string);

    //**Setter for movement speed */
    public abstract void setMovementSpeed(float speed);

    //**getters for width and height */
    public abstract float getWidth();
    public abstract float getHeight();

    //**To check if entity has entered level 3 */
    public boolean isEnteredLevel3() {
        return enteredLevel3;
    }
    //**To set if entity has entered level 3 */
    public void setEnteredLevel3(boolean enteredLevel3) {
        this.enteredLevel3 = enteredLevel3;
    }
  
    

}