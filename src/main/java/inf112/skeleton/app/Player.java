package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Player extends GameObject {

    private Controller controller;
    private Collision collision;
    private String  lastPlayerPics;
    public int lives;
    public int maxHitPoints;
    public int currentHitPoints;


    

    public Player(Sprite sprite, float x, float y, ID id, Controller controller, TiledMap map, View view, String lastPLayerPics) {
        super(x, y, id, sprite, map, view);
        this.controller = controller;
        this.lastPlayerPics = lastPLayerPics;
        collision = new Collision(map, this, view); 
        this.lives = 3;
        this.maxHitPoints = 100;
        this.currentHitPoints = 100;
    }

    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    public void setmap(TiledMap tileMap){
        this.map = tileMap;
        collision = new Collision(tileMap, this, view);
    }


    private void update(float deltaTime) {
       
        x += velX;
        y += velY;

        
        //save recent position
        oldX = getX();
        oldY = getY();
        

        if (controller.isUp()){ 
            velY = speed;
            setTexture(new Texture(PlayerPics.UP.source));
            lastPlayerPics = PlayerPics.UP.source;
           
        }
        else if (!controller.isDown()) {
            velY = 0;
        }
        
        if(!controller.isAttack()){
            setScale(1); 
            setTexture(new Texture(lastPlayerPics));
        }

        if (controller.isDown()) {
            velY = - speed;
            setTexture(new Texture(PlayerPics.DOWN.source));
            lastPlayerPics = PlayerPics.DOWN.source;
            
        }
        else if (!controller.isUp()) {
            velY = 0;
        }


        if (controller.isRight()) {
            velX = speed;
            setTexture(new Texture(PlayerPics.RIGHT.source));
            lastPlayerPics = PlayerPics.RIGHT.source;
        }
        else if (!controller.isLeft()) {
            velX = 0;
            
        }

        if (controller.isLeft()) {
            velX = -speed;
            setTexture(new Texture(PlayerPics.LEFT.source));
            lastPlayerPics = PlayerPics.LEFT.source;
        }
        else if (!controller.isRight()) {
            velX = 0;
        }

        if (controller.isFast()) {
            speed = 2;
        }
        else 
        speed = 1;

        

        setX(getX() + velX * deltaTime);

        if (collision.chechXDirection(velX, oldX)) { 
             x = oldX;
            velX = 0;
        }

        setY(getY() + velY * deltaTime);

        if (collision.chechYDirection(velY, oldY)) {
            y = oldY;
            velY = 0;
        }


        
        if (controller.isAttack()) {
            if(lastPlayerPics==PlayerPics.DOWN.source){
                setTexture(new Texture(PlayerPics.ATTACKDOWN.source));
                setScale((float) 1.8,(float) 1.8); 
            }
            if(lastPlayerPics==PlayerPics.UP.source){
                setTexture(new Texture(PlayerPics.ATTACKUP.source));
                setScale((float) 1.3,( float) 1.3); 
            }
            if(lastPlayerPics==PlayerPics.LEFT.source){
                setTexture(new Texture(PlayerPics.ATTACKLEFT.source));
                setScale((float) 1.8,(float) 1.8); 
            }
            if(lastPlayerPics==PlayerPics.RIGHT.source){
                setTexture(new Texture(PlayerPics.ATTACKRIGHT.source));
                setScale((float) 1.8,(float) 1.8); 
            }
            
            // System.out.println(lastPlayerPics);
        
        
            
        }
        // TODO må skrive en funskjon som holder følge på hvilke retning spilleren sist beveget seg
    }

    //trenger ikke disse?

    public float getOldX() {
        return oldX;
    }
    public float getOldY() {
        return oldY;
    }

    @Override
    public void setOldXNdY(float oldX, float oldY) {
        this.oldX = oldX;
        this.oldY = oldY;
    }
    
    public int getCurrentHitPoints() {
        return this.currentHitPoints;
    }

    public void setCurrentHitPoints(int newHitPoints) {
        if (newHitPoints > this.maxHitPoints) {
            this.currentHitPoints = maxHitPoints;
        }
        else if (newHitPoints < 0) {
            this.currentHitPoints = 0;
        }
        else {
            this.currentHitPoints = newHitPoints;
        }
    }

    public void takeDamage(int damage) {
        this.setCurrentHitPoints(this.currentHitPoints - damage);
        if (this.isDead()) {
            this.setLives(this.getLives() - 1);
        }
    }

    public boolean isDead() {
        return getCurrentHitPoints() <= 0;
    } 

    public void heal(int healing) {
        this.setCurrentHitPoints(this.currentHitPoints + healing);
    }

    public int getLives() {
        return this.lives;
    }
    

    public void setLives(int newLives) {
        if (newLives < 0) {
            this.lives = 0;
        }
        else {
            this.lives = newLives;
            this.setCurrentHitPoints(this.maxHitPoints);
        }
    }

    public int getMaxHitPoints() {
        return this.maxHitPoints;
    }

    public ID getId() {
        return id;
    }
    
}
