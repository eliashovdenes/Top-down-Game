package inf112.skeleton.app.Entities.Projectiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Entities.AbstractGameObject;
import inf112.skeleton.app.Entities.PlayerInterface;
import inf112.skeleton.app.Entities.ProjectileInterface;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Enums.PlayerPics;
import inf112.skeleton.app.Mapfolder.MapInterface;

public class Lightning extends AbstractGameObject implements ProjectileInterface {

    protected float speed = 1;
    protected Sprite sprite;
    protected PlayerInterface player;
    protected TiledMap map;
    protected Vector2 velocity;
    private float rotationSpeed = 200;
    private float rotation = 0;
    
    public Lightning(Vector2 position, MapInterface map, PlayerInterface player) {
        super(position, map);
        this.map = map.getMap();
        this.player = player;
        velocity = setVelocity();
        setSprite(PlayerPics.LIGHTNING.source);
        sprite.setSize(15,15);

    }
       
    @Override
    public void update(float delta) {
        
        position.x+=velocity.x;
        position.y+=velocity.y;
        
        sprite.setPosition(this.position.x,this.position.y);
        sprite.setOrigin(this.getWidth()/2,this.getHeight()/2);
        rotation += rotationSpeed*delta;
        if (rotation>= 360){
            rotation -= 360;
        }
        sprite.setRotation(rotation);
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
        Vector2  veloVector = new Vector2();
        DirectionEnum direction = player.getPlayerDirection();
        if (direction == DirectionEnum.NORTH){veloVector = new Vector2(0*speed,1*speed);}
        if (direction == DirectionEnum.SOUTH){veloVector = new Vector2(0*speed,-1*speed);}
        if (direction == DirectionEnum.WEST){veloVector = new Vector2(-1*speed,0*speed);}
        if (direction == DirectionEnum.EAST){veloVector = new Vector2(1*speed,0*speed);}
        return veloVector;
    }

    
}
