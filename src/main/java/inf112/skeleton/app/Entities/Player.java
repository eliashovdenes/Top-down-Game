package inf112.skeleton.app.Entities;

import java.util.ArrayList;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Animation;
import inf112.skeleton.app.Collision;
import inf112.skeleton.app.Controller.Controller;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Enums.PlayerAnimation;
import inf112.skeleton.app.Entities.Enums.PlayerPics;
import inf112.skeleton.app.Entities.Projectiles.Arrow;
import inf112.skeleton.app.Entities.Projectiles.Lightning;
import inf112.skeleton.app.Mapfolder.MapInterface;
import inf112.skeleton.app.Sound.SoundManager;
import inf112.skeleton.app.Sound.aSound;

public class Player extends AbstractGameObject implements PlayerInterface {
    private Animation playerAnimation;
    private Sprite sprite;
    private float speed = 1;
    public Arrow arrow;
    public Lightning lightning;
    private MapInterface map;
    public ArrayList<ProjectileInterface> projectileList;
    private int shootTimer;
    DirectionEnum direction;
    public MapInterface nextMap;
    public boolean onPortal;
    private Controller controller;
    private Integer playerHP = 100;
    private SoundManager SM;
    
    


    public Player(Vector2 position, MapInterface map, Controller controller) {
        super(position, map);
        this.playerAnimation = PlayerAnimation.DOWN.animation;
        this.map = map;
        this.controller = controller;
        setSprite(PlayerPics.ATTACKDOWN.source);
        sprite.setPosition(position.x,position.y);
        setHP(playerHP);
        this.SM = new SoundManager();
        sprite.setSize(16,16);

        projectileList = new ArrayList<ProjectileInterface>();
        shootTimer = 0;
        direction = DirectionEnum.SOUTH;

    }

    @Override
    //**Updates the player's position and animation. */
    public void update(float delta) {

        // Movement in x-direction
        if (controller.isLeft()) {
            velocity.x = -speed;
            setPlayerDirection(DirectionEnum.WEST);
        } else if (controller.isRight()) {
            velocity.x = +speed;
            setPlayerDirection(DirectionEnum.EAST);
        } else
            velocity.x = 0;

        // Movement in y-direction
        if (controller.isDown()) {
            velocity.y = -speed;
            setPlayerDirection(DirectionEnum.SOUTH);
        } else if (controller.isUp()) {
            setPlayerDirection(DirectionEnum.NORTH);
            velocity.y = +speed;
        } else
            velocity.y = 0;

        if (controller.isFast()) {
            
            setMovementSpeed(2);
        } else
            setMovementSpeed(1);
            
        if (controller.isSpace()){
            shootArrow();
        }
        /*if (controller.isEnter()){
            shootLightning();
        }
        */
        if (controller.isEnter()){
            lightningMultiShot();
        }
        if (shootTimer >0){shootTimer -=delta;}

        for (ProjectileInterface projectile : projectileList){
            projectile.update(delta);
        }

        animate(delta);
        ApplyMovement();
        sprite.setPosition(position.x, position.y);
        
    }


    //**Getters and setters for Sprite */
    @Override
    public void setSprite(String string) {
        sprite = new Sprite(new Texture(string));
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    //**Setter for movement speed */
    @Override
    public void setMovementSpeed(float speed) {
        this.speed = speed;
    }


    //**Getters for width and height */
    @Override
    public float getWidth() {
        return sprite.getWidth();
    }

    @Override
    public float getHeight() {
        return sprite.getHeight();
    }

    //**animate does the animation of the player */
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

    //**shootArrow creates a new arrow and adds it to the projectileList */
    private void shootArrow(){
            if (shootTimer<=0){
            Vector2 arrowPos = new Vector2(position.x,position.y);
            this.arrow = new Arrow(arrowPos, map,this);
            projectileList.add(this.arrow);
            
            
            shootTimer=15;
            SM.arrowSound.play();
        }
    }

    //**shootLightning creates a new lightning and adds it to the projectileList */
    private void shootLightning(){
        if (shootTimer<=0){
            Vector2 lightningPos = new Vector2(position.x,position.y);
            this.lightning = new Lightning(lightningPos, map,this);
            projectileList.add(this.lightning);
            shootTimer=15;
        }
    }    

    //**lightningMultiShot creates 4 new lightnings in each direction and adds them to the projectileList */
    private void lightningMultiShot(){
        if (shootTimer<=0){

            ProjectileInterface northLightning =  new Lightning(new Vector2(position.x,position.y),map,new Vector2(0,1));
            ProjectileInterface southLightning =  new Lightning(new Vector2(position.x,position.y),map,new Vector2(0,-1));
            ProjectileInterface eastLightning =  new Lightning(new Vector2(position.x,position.y),map,new Vector2(1,0));
            ProjectileInterface westLightning =  new Lightning(new Vector2(position.x,position.y),map,new Vector2(-1,0));

            
            projectileList.add(westLightning);
            projectileList.add(northLightning);
            projectileList.add(southLightning);
            projectileList.add(eastLightning);

            shootTimer = 30;
            SM.lightningMultiShotSound.play();
        }
    }


    //*Getter for projectilelist/arrows*/
    @Override
    public ArrayList<ProjectileInterface> getArrows(){
        return projectileList;
    }   

    //**Setter and getter for player direction */
    @Override
    public void setPlayerDirection(DirectionEnum direction){
        this.direction = direction;
    }

    @Override
    public DirectionEnum getPlayerDirection(){
        return this.direction;
    }


    
    @Override 
    //**Overrides method from AbstractGameObject to check for portal collision in Y-direction */
    public boolean yCollision(){
        
        if (collision.isCellAPortal()){
            onPortal = true;
            nextMap = collision.nextMap;
            this.map = nextMap;
            collision = new Collision(map,this);
            spawn(nextMap.getPlayerSpawnX()*16,nextMap.getPlayerSpawnY()*16);
            return false;
        }
        return collision.checkYDirection(velocity.y);
    }
    
    @Override
    // Overrides method from AbstractGameObject to spawn player at a certain position
    public void spawn(float x,float y){
        position.x=x;
        position.y=y;
    }

    @Override 
    //**Overrides method from AbstractGameObject to check if the player is on a portal */
    public boolean onPortal(){
        return onPortal;
    }

    //**Sets onPortal to false */
    public void setOffPortal(){
        onPortal = false;
    }

    @Override
    //**Overrides method from AbstractGameObject to get the next map */
    public MapInterface nextMap(){
        return nextMap;
    }
    
    @Override
    //**Overrides method from AbstractGameObject to get the position of the player */
    public Vector2 getPosition() {
        return super.getPosition();
    }
    
}
