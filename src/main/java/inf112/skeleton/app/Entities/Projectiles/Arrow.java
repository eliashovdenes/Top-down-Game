package inf112.skeleton.app.Entities.Projectiles;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Entities.AbstractGameObject;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Enums.PlayerPics;
import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Entities.Player.PlayerInterface;
import inf112.skeleton.app.Mapfolder.MapInterface;

public class Arrow extends AbstractGameObject implements ProjectileInterface  {

    protected float speed = 2;
    protected Sprite sprite;
    protected TiledMap map;
    protected Vector2 velocity;
    private Player player;
    

    public Arrow(Vector2 position, MapInterface map, Vector2 velocity, Player player) {
        super(position, map);
        this.map = map.getMap();
        this.player = player;
        this.velocity = velocity;
        setCorrectSprite();
        sprite.setSize(10,10);
        
       
    }

    //* setVelocity() is a method that returns a Vector2 with the correct velocity for the arrow. */
    public Vector2 setVelocity() {
        Vector2  veloVector = new Vector2();
        //DirectionEnum direction = player.getPlayerDirection();
       // if (direction == DirectionEnum.NORTH){veloVector = new Vector2(0*speed,1*speed);}
       // if (direction == DirectionEnum.SOUTH){veloVector = new Vector2(0*speed,-1*speed);}
      //  if (direction == DirectionEnum.WEST){veloVector = new Vector2(-1*speed,0*speed);}
      //  if (direction == DirectionEnum.EAST){veloVector = new Vector2(1*speed,0*speed);}
        return veloVector;
    }

    @Override
    // update() is a method that updates the position of the arrow. */
    public void update(float delta) {

        if (velocity.x == 0 && velocity.y==0){
            velocity.y = -1;
        }
        
        position.x+=velocity.x;
        position.y+=velocity.y;
        
        sprite.setPosition(position.x,position.y);
    }

   
   //Setters and getters ->>>>>>>>>>>>
    @Override
    public void setSprite(String string) {
        sprite = new Sprite(new Texture(string));
    }

    @Override
    public Sprite getSprite() {
        return sprite;
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
    
    private void setCorrectSprite(){
        String sprite = "";
        if (player.getPlayerDirection()==DirectionEnum.NORTH)  sprite = PlayerPics.UPARROW.source;
        if (player.getPlayerDirection()==DirectionEnum.EAST) sprite = PlayerPics.RIGHTARROW.source; 
        if (player.getPlayerDirection()==DirectionEnum.WEST) sprite = PlayerPics.LEFTARROW.source;
        if (player.getPlayerDirection()==DirectionEnum.SOUTH)  sprite = PlayerPics.DOWNARROW.source;
   
        setSprite(sprite);
    }
}