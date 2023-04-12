package inf112.skeleton.app.Entities.Player;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Projectiles.ProjectileInterface;
import inf112.skeleton.app.Mapfolder.MapInterface;

public interface PlayerInterface  {

    /**
     * Update changes to player. Call before draw.
     * @param delta Time elapsed since last frame was rendered.
     */
    void update(float delta);

    /**Set new sprite for player. 
     * 
     * @param string is a path to an image in resources. Intended for use with enum PlayerPics.
     */
    void setSprite(String string);

    /**
     * Get the sprite currently set on player-object
     * @return Player sprite
     */
    Sprite getSprite();

    /**
     * Set base movement speed of player 
     * @param speed (float) 
     */
    void setMovementSpeed(float speed);

    /**
     * 
     * @return player width (normally based on sprite size)
     */
    float getWidth();

    /**
     * 
     * @return Player height (normally based on sprite size)
     */
    float getHeight();

    /** Get list of projectile arrows to be drawn
     * 
     * @return List of arrows
     */
    ArrayList<ProjectileInterface> getArrows();

    /**
     * Set the direction the player should face
     * @param direction 
     */
    void setPlayerDirection(DirectionEnum direction);

    /**
     * 
     * @return direction the player is facing.
     */
    DirectionEnum getPlayerDirection();

    /** Check collision in y-direction.
     * @return true or false depending on if collision was detected
     */
    boolean yCollision();

    /**Set spawn location of player. 
     * @param x coordinate of player
     * @param y coordinate of player
     */
    void spawn(float x, float y);

    /**
     * 
     * @return a boolean that indicates wether player is on a portal tile or not.
     */
    boolean onPortal();

    /**
     * When a player moves onto portal to an other level, the collision sets the variable nextMap 
     * to the map the player moves 'in' to. This method returns that map.
     * @return map object. used to iniate map change in view
     */
    MapInterface nextMap();

    /**
     * @return a vector2 object that holds position x and y of player.
     */
    Vector2 getPosition();

    /**
     * set Boolean for player to FALSE to indicate that player is not on portal anymore.
     */
    void setOffPortal();
    
    //TODO write javadoc
    
    public MapInterface returnMap();
    
    void upgradeLightning();
    void upgradeArrow();

    /**
     * Sets the number of lives the player has
     * 
     * @param newLives
     */
    public void setLives(int newLives);

    /**
     * Gets the current amount of lives the player has
     * 
     * @return Integer - number of lives
     */
    public Integer getLives();

    /**
     * Reduces the Player's hitpoints by a given amount
     * Also checks if the Player is dead and reduce the amount of
     * lives if True. 
     * 
     * @param damage
     */
    public void takeDamage(int damage);
    
    /**
     * Get the currentHitpoints of the player
     * 
     * @return Integer - currentHitpoints
     */
    public Integer getCurrentHitpoints();
    
    /**
     * Set the Player's currentHitpoints to a new value
     * Also makes sure currentHitpoints cannot be set higher then maxHitpoints
     * or below zero.
     * 
     * @param newHitpoints
     */
    public void setCurrentHitPoints(int newHitpoints);

    /**
     * Get the maxHitpoints of the Player
     * 
     * @return Integer - maxHitpoints
     */
    public Integer getMaxHitpoints();

    /**
     * Set a new value for the Player's maxHitpoints
     * 
     * @param newMaxHitpoints
     */
    public void setMaxhitpoints(Integer newMaxHitpoints);

    /**
     * Checks if the Player is dead
     * True - if Player is dead
     * False - otherwise
     * 
     * @return boolean
     */
    public boolean isDead();

    Rectangle getRect();

}