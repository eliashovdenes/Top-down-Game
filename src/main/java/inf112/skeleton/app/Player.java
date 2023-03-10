package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Player extends GameObject {

    private Controller controller;
    private Collision collision;

    private View view;

    

    public Player(Sprite sprite, float x, float y, ID id, Controller controller, TiledMap map, View view) {
        super(x, y, id, sprite, map, view);
        this.controller = controller;
        collision = new Collision(map, this, view); 
    }

    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    public void setmap(TiledMap tileMap, Controller controller){
        this.map = tileMap;
        collision.setMap(tileMap);
        this.controller = controller;
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
        }
        else if (!controller.isDown()) {
            velY = 0;
        }

        if (controller.isDown()) {
            velY = - speed;
            setTexture(new Texture(PlayerPics.DOWN.source));
        }
        else if (!controller.isUp()) {
            velY = 0;
        }

        if (controller.isRight()) {
            velX = speed;
            setTexture(new Texture(PlayerPics.RIGHT.source));
        }
        else if (!controller.isLeft()) {
            velX = 0;
        }

        if (controller.isLeft()) {
            velX = -speed;
            setTexture(new Texture(PlayerPics.LEFT.source));
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
            // System.out.println(oldX);
            velX = 0;
            // System.out.println(oldX);
        }

        setY(getY() + velY * deltaTime);

        if (collision.chechYDirection(velY, oldY)) {
            y = oldY;
            velY = 0;
            // System.out.println("y");
        }


        // //When pressing "q" it changes the map here
        // if (controller.isMapShift()) {
        //     view.changeMap("src/main/java/inf112/skeleton/app/assets/Level 2.tmx");
        // }
        
    }

    public void setOldXNdY(float oldX, float oldY) {
        this.oldX = oldX;
        this.oldY = oldY;
    }

    public float getOldX() {
        return oldX;
    }
    public float getOldY() {
        return oldY;
    }
    
}
