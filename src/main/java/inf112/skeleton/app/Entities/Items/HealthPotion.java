package inf112.skeleton.app.Entities.Items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Entities.Enums.Items;
import inf112.skeleton.app.Mapfolder.MapInterface;

public class HealthPotion implements ItemImpl{

    private Sprite sprite;
    private Vector2 position;
    private Rectangle rectangle;
    private int healAmount;

    public HealthPotion(Vector2 position, MapInterface map) {
        this.position = position;
        this.setSprite(Items.HEALTHPOTION.source);
        rectangle = new Rectangle(position.x, position.y, getWidth(), getHeight());
        setHealAmount(50);
    }
    
    // Getters and setters
    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return this.healAmount;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void setSprite(String string) {
        sprite = new Sprite(new Texture(string));
    }

    @Override
    public float getWidth() {
        return sprite.getWidth();
    }

    @Override
    public float getHeight() {
        return sprite.getHeight();
    }  

    @Override
    public Rectangle getRect() {
        return rectangle;
    }

    @Override
    public Vector2 getPosition() {
        return this.position;
    }

    
    @Override
    public void update(float delta) {
        sprite.setPosition(position.x, position.y);
    }  
}
