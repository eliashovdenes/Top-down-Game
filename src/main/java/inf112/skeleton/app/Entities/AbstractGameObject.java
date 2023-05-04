package inf112.skeleton.app.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Collision;
import inf112.skeleton.app.Mapfolder.MapInterface;

public abstract class AbstractGameObject {
    protected Vector2 recentPosition;
    
    protected Vector2 position;

    protected Vector2 velocity;
    

    protected Collision collision;
    private Integer currentHitpoints;
    private Integer maxHitpoints;
    public boolean enteredLevel3 = false;
    protected Rectangle rectangle;
    protected MapInterface map;
    
    
    public AbstractGameObject(Vector2 position, MapInterface map) {
        this.map = map;
        this.position = position;
        this.collision = new Collision(map, this);
        this.velocity = new Vector2();
        this.recentPosition = new Vector2(position);
        
    }

    public AbstractGameObject(Vector2 position) {
        this.position = position;
        this.velocity = new Vector2();
        this.recentPosition = new Vector2(position);
        
    }
    

    //**applymovement is a method that applies the velocity to the position of the object. */
    public void ApplyMovement() {
        recentPosition.set(position);
        handleCollision();
        position.x += velocity.x;     
        position.y += velocity.y;
        rectangle.setPosition(position);
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

    //*getter for the rectangle object */
    public Rectangle getRect() {
        return rectangle;
    }

    /**
     * Checks collision in X-direction
     * velX velocity of object in X direction
     * @return false if not collision. True if collision.
     */
    public boolean xCollision(){
        return collision.checkXDirection(velocity.x);
    }
    public boolean yCollision(){
        return collision.checkYDirection(velocity.y);
    }


    /**
     * Checks if the Entity is dead
     * True - if Entity is dead
     * False - otherwise
     * @return boolean
     */
    public boolean isDead() {
        return getCurrentHitpoints() <= 0;
    } 

    /**
     * @return velocity in x direction
     */
    public float getVeloX(){
        return velocity.x;
    }
    /**
     * @return velocity in y-direction
     */
    public float getVeloY(){
        return velocity.y;
    }

    /**
     * Get the currentHitpoints of the Entity
     * 
     * @return Integer - currentHitpoints
     */
    public Integer getCurrentHitpoints(){
        return this.currentHitpoints;
    }
    
    /**
     * Set the Entity's currentHitpoints to a new value
     * Also makes sure currentHitpoints cannot be set higher then maxHitpoints
     * or below zero.
     * 
     * @param newHitpoints
     */
    public void setCurrentHitPoints(int newHitpoints) {
        if (newHitpoints > this.maxHitpoints) {
            this.currentHitpoints = maxHitpoints;
        }
        else if (newHitpoints < 0) {
            this.currentHitpoints = 0;
        }
        else {
            this.currentHitpoints = newHitpoints;
        }
    }
    
    /**
     * Reduces the Entity's hitpoints by a given amount 
     * @param damage
     */
    public void takeDamage(int damage) {
        this.setCurrentHitPoints(this.getCurrentHitpoints() - damage);
    }   
    /**
     * Get the maxHitpoints of the Entity
     * 
     * @return Integer - maxHitpoints
     */
    public Integer getMaxHitpoints(){
        return this.maxHitpoints;
    }

    /**
     * Get the maxHitpoints of the Entity
     * 
     * @return Integer - maxHitpoints
     */
    public void setMaxhitpoints(Integer newMaxHitpoints) {
        if (newMaxHitpoints > 0) {
            this.maxHitpoints = newMaxHitpoints;   
        }
    }

    

    
   
    /**
     * returns position of abstractGameObject
     * @return
     */
    public Vector2 getPosition() {
        return position;
    }
    /**
     * @returns sprite associated with gameobject
     */
    public abstract Sprite getSprite();

    /**
     * Sets sprite for the path inserted in string-parameter
     * @param string 
     */
    public abstract void setSprite(String string);

    /**
     * Sets movementspeeed for game object.
     * @param speed
     */
    public abstract void setMovementSpeed(float speed);

    /**
     * 
     * @return width of gameobject
     */
    public abstract float getWidth();

    /**
     * 
     * @return height of gameobject
     */
    public abstract float getHeight();

    /**
     * 
     * @return boolean. Has gameobject entered level 3.
     */
    public boolean isEnteredLevel3() {
        return enteredLevel3;
    }
    /**
     * set the boolean field variable that decides if the 
     * gameobject has entered level3.
     * @param enteredLevel3
     */
    public void setEnteredLevel3(boolean enteredLevel3) {
        this.enteredLevel3 = enteredLevel3;
    }

    
  
    

}