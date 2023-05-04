package inf112.skeleton.app.Entities.Projectiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public interface ProjectileInterface {

    /**
     * Update changable variables in accordance with
     * 
     * @param delta time
     */
    public void update(float delta);

    /**
     * @return projectile sprite
     */
    public Sprite getSprite();

    /**
     * Set projectile sprite.
     * 
     * @param string path
     */
    public void setSprite(String string);

    /**
     * @return width of projectile
     */
    public float getWidth();

    /**
     * 
     * @return height of the projectile
     */
    public float getHeight();

    /**
     * 
     * @return movementspeed of projectile
     */
    public float getMovementSpeed();

    /**
     * 
     * @return rectangle associated with projectile (for collision handling)
     */
    public Rectangle getRect();

    /**
     * 
     * @return amount of damage a projectile does upon collision.
     */
    public int getDamage();

    /**
     * 
     * @return position of projectile.
     */
    public Vector2 getPosition();

}
