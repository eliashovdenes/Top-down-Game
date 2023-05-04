package inf112.skeleton.app.Entities.Items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public interface ItemImpl {
    
    /**
     * 
     * @return the sprite associated with the monster object.
     */
    Sprite getSprite();

   /**
     * Set monster sprite.
     * @param string is a path to an image in resources. Intended for enum with png.
     */
    void setSprite(String string);

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

     * @return rectangle of item
     */
    public Rectangle getRect();

    /**
     * 
     * @return position-vector of item
     */
    public Vector2 getPosition();

    
    /**
     * update changable variables of item
     * @param delta time
     */
    public void update(float delta);

}
