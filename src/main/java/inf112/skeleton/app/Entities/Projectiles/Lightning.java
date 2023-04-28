package inf112.skeleton.app.Entities.Projectiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Entities.AbstractGameObject;
import inf112.skeleton.app.Entities.Enums.PlayerPics;
import inf112.skeleton.app.Entities.Player.PlayerInterface;
import inf112.skeleton.app.Mapfolder.MapInterface;

public class Lightning extends AbstractGameObject implements ProjectileInterface {

    protected float speed = 1;
    protected Sprite sprite;
    protected PlayerInterface player;
    protected MapInterface map;
    protected Vector2 velocity;
    private float rotationSpeed = 1000;
    private float rotation = 0;
    private int attackDamage = 45;
    
    
    public Lightning(Vector2 position, MapInterface map, Vector2 velocity){
        super(position,map);
        this.map = map;
        this.velocity = velocity;
        setSprite(PlayerPics.LIGHTNING.source);
        sprite.setSize(40, 40);
        rectangle = new Rectangle(position.x, position.y, sprite.getWidth(), sprite.getHeight());
    }
       
    @Override
    // update() is a method that updates the position of the lightning */
    public void update(float delta) {
        
        position.x+=velocity.x;
        position.y+=velocity.y;
        
        sprite.setPosition(this.position.x,this.position.y);
        
        //setter origin for sprite før rotering for at den skal spinne rundt egen akse.
        //kanskje litt kult hvis den ikke stemmer?
        
        

        sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
        
        rectangle.setPosition(position.x, position.y);


        rotation += rotationSpeed*delta;
        if (rotation>= 360){
            rotation -= 360;
        }
        sprite.setRotation(rotation);
        
        
        
       // ApplyMovement();
         
    }

    //Setters and getters -->>>>
    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void setSprite(String string) {
        sprite = new Sprite(new Texture(string));
    }

    @Override
    public void setMovementSpeed(float speed) {
        this.speed = speed;
    }


    @Override
    public float getWidth() {
        return sprite.getWidth();
    }

    @Override
    public float getHeight() {
        return sprite.getHeight();
    }

    public Vector2 setVelocity() {
        return null;
  

    }

    @Override
    public int getDamage() {
        return attackDamage;
    }
}
