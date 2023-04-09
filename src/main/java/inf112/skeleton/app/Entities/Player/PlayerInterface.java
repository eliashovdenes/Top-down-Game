package inf112.skeleton.app.Entities.Player;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
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
    public Integer getHP();
    public MapInterface returnMap();
    
    void upgradeLightning();
    void upgradeArrow();

    public void setLives(int newLives);

    public Integer getLives();

    public void takeDamage(int damage);
    
    public Integer getCurrentHitpoints();
    
    public void setCurrentHitPoints(int newHitpoints);

    public Integer getMaxHitpoints();

    public void setMaxhitpoints(Integer newMaxHitpoints);

}