package inf112.skeleton.app.Entities.Enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;

public interface MonsterInterface {

    /**
     * Update monster object. Call before draw.
     * @param delta time elapsed since last frame was rendered.
     */
    void update(float delta);

    /**
     * Set monster sprite.
     * @param string is a path to an image in resources. Intended for enum with png.
     */
    void setSprite(String string);
    
    /**
     * 
     * @return the sprite associated with the monster object.
     */
    Sprite getSprite();

    /**
     * Set base movement speed of monster.
     * @param speed
     */
    void setMovementSpeed(float speed);

    /**
     * 
     * @return width of monster. Normally is width of associated sprite.
     */
    float getWidth();

    /**
     * 
     * @return height of monster. Normally is height of associated sprite.
     */
    float getHeight();

    /**
     * Set direction the monster should be facing.
     * @param direction enum (north,west,east,south)
     */
    void setDirection(DirectionEnum direction);

    /**
     * Get the direction the monster is currently facing.
     * @return enum (north,west,south,east).
     */
    DirectionEnum getDirection();

    /**
     * Sets the X and Y coordinates of monster based on bounds found in map object. 
     * Randomizes within bounds. 
     */
    void setXYFromSpawnBounds();

    /**
     * 
     * @return a vector2 object containing X and Y coordinates of monster. 
     * NB: Coordinates are in the lower left corner of sprite.
     */
    Vector2 getPosition();
    
    /**
     * 
     * @return list of Monster created in Spawn() method.
     * 
     */
    Rectangle getRect();
    
    public String getName();

    int getDamage();

    void takeDamage(int damage);
    
    Integer getCurrentHitpoints();

    boolean isDead();
}
