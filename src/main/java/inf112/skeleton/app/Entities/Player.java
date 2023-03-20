package inf112.skeleton.app.Entities;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Animation;
import inf112.skeleton.app.Collision;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Enums.PlayerAnimation;
import inf112.skeleton.app.Entities.Enums.PlayerPics;
import inf112.skeleton.app.Entities.Projectiles.Arrow;
import inf112.skeleton.app.Mapfolder.MapInterface;

public class Player extends AbstractGameObject implements PlayerInterface {
    private Animation playerAnimation;
    private Sprite sprite;
    private float speed = 1;
    public Arrow arrow;
    private TiledMap map;
    public ArrayList<AbstractProjectile> projectileList;
    private int shootTimer;
    DirectionEnum direction;
    public MapInterface nextMap;
    public boolean onPortal;

    public Player(Vector2 position, TiledMap map) {
        super(position, map);
        this.playerAnimation = PlayerAnimation.DOWN.animation;
        this.map = map;
        setSprite(PlayerPics.ATTACKDOWN.source);
        sprite.setPosition(position.x,position.y);
        
        //sprite.setScale(0.1f);
        sprite.setSize(12,17);

        projectileList = new ArrayList<AbstractProjectile>();
        shootTimer = 0;
        direction = DirectionEnum.SOUTH;

    }

    @Override
    public void update(float delta) {

        //maybe make a controller class

        // Movement in x-direction
        if (Gdx.input.isKeyPressed(Keys.A)) {
            velocity.x = -speed;
            setPlayerDirection(DirectionEnum.WEST);
        } else if (Gdx.input.isKeyPressed(Keys.D)) {
            velocity.x = +speed;
            setPlayerDirection(DirectionEnum.EAST);
        } else
            velocity.x = 0;

        // Movement in y-direction
        if (Gdx.input.isKeyPressed(Keys.S)) {
            velocity.y = -speed;
            setPlayerDirection(DirectionEnum.SOUTH);
        } else if (Gdx.input.isKeyPressed(Keys.W)) {
            setPlayerDirection(DirectionEnum.NORTH);
            velocity.y = +speed;
        } else
            velocity.y = 0;

        if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
            
            setMovementSpeed(2);
        } else
            setMovementSpeed(1);
            

        if (Gdx.input.isKeyJustPressed(Keys.E)){
            if (shootTimer <= 0){
                shootArrow();
            }
        }
        if (shootTimer >0){shootTimer -=delta;}

        for (AbstractProjectile arrow : projectileList){
            arrow.update(delta);
        }

        animate(delta);
        ApplyMovement();
        sprite.setPosition(position.x, position.y);
        
    }

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

    private void animate(float delta) {
        if (speed ==1){
        if (direction == DirectionEnum.NORTH)      this.playerAnimation = PlayerAnimation.UP.animation;
        if (direction == DirectionEnum.EAST)     this.playerAnimation = PlayerAnimation.RIGHT.animation;
        if (direction == DirectionEnum.WEST)    this.playerAnimation = PlayerAnimation.LEFT.animation;
        if (direction == DirectionEnum.SOUTH)    this.playerAnimation = PlayerAnimation.DOWN.animation;
        }
        //running
        if (speed == 2){
            if (direction == DirectionEnum.NORTH)       this.playerAnimation = PlayerAnimation.RUNUP.animation;
            if (direction == DirectionEnum.EAST)     this.playerAnimation = PlayerAnimation.RUNRIGHT.animation;
            if (direction == DirectionEnum.WEST)    this.playerAnimation = PlayerAnimation.RUNLEFT.animation;
            if (direction == DirectionEnum.SOUTH)    this.playerAnimation = PlayerAnimation.RUNDOWN.animation;
            
        }

        sprite.setRegion(playerAnimation.getFrame());
        playerAnimation.update(delta);
    }

    private void shootArrow(){
        
        Vector2 arrowPos = new Vector2(position.x,position.y);
        this.arrow = new Arrow(arrowPos, map,this);
        projectileList.add(this.arrow);
        shootTimer+=7;
        }
        
    
    @Override
    public ArrayList<AbstractProjectile> getArrows(){
        return projectileList;
    }   

    @Override
    public void setPlayerDirection(DirectionEnum direction){
        this.direction = direction;
    }

    @Override
    public DirectionEnum getPlayerDirection(){
        return this.direction;
    }
    //Overrides method from AbstractGameObject to check for portal collision in Y-direction
    @Override 
    public boolean yCollision(){
        
        if (collision.isCellAPortal()){
            onPortal = true;
            nextMap = collision.nextMap;
            this.map = nextMap.getMap();
            collision = new Collision(map,this);
            spawn(nextMap.getPlayerSpawnX()*16,nextMap.getPlayerSpawnY()*16);
            return false;
        }
        return collision.checkYDirection(velocity.y);
    }
    
    @Override
    public void spawn(float x,float y){
        position.x=x;
        position.y=y;
    }

    @Override 
    public boolean onPortal(){
        return onPortal;
    }
    @Override
    public MapInterface nextMap(){
        return nextMap;
    }
    @Override
    

    public Vector2 getPosition() {
        return super.getPosition();
    }
}
