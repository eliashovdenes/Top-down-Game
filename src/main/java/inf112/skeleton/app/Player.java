package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Player extends GameObject {

    private float speed = 1;
    private Controller controller;
    private Collision collision;
    private String  lastPlayerPics;

    

    public Player(Sprite sprite, float x, float y, ID id, Controller controller, TiledMap map, String lastPlayerPics) {
        super(x, y, id, sprite, map);
        setPosition(x, y);
        this.controller = controller;
        this.map = map;
        this.lastPlayerPics = lastPlayerPics;
        collision = new Collision(map, this); 
    }

    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }


    private void update(float deltaTime) {
        x += velX;
        y += velY;

        //save recent position
        float oldX = getX(), oldY = getY();

        //if(controlleri)

        if (controller.isUp()){ 
            velY = speed;
            setTexture(new Texture(PlayerPics.UP.source));
            lastPlayerPics = PlayerPics.UP.source;
           
        }
        else if (!controller.isDown()) {
            velY = 0;
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

        //Denne er nok ikke så godt optimalisert, MTP hvordan update metoden funker.
        if(!controller.isAttack()){
            setScale(1); 
            setTexture(new Texture(lastPlayerPics));
        }
        setX(getX() + velX * deltaTime);

        if (collision.chechXDirection(velX, oldX)) {
            setX(oldX);
            velX = 0;
            System.out.println(oldX);
        }

        setY(getY() + velY * deltaTime);

        if (collision.chechYDirection(velY, oldY)) {
            setY(oldY);
            velY = 0;
            System.out.println("y");
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
            
            System.out.println(lastPlayerPics);
        
        
            
        }
        // TODO må skrive en funskjon som holder følge på hvilke retning spilleren sist beveget seg
    }

    //trenger ikke disse?
    @Override
    public void tick() {
        
        throw new UnsupportedOperationException("Unimplemented method 'tick'");
    }

    @Override
    public void render() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }
    
}
