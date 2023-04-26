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

    public Rectangle getRect();

    Vector2 getPosition();

    void update(float delta);

    public void setHealAmount(int healAmount);

    public int getHealAmount();
}
