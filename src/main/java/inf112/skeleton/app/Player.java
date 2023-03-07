package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Player extends GameObject {

    private float speed = 1;
    private Controller controller;
    private TiledMap map;
    private Collision collision;

    

    public Player(Sprite sprite, float x, float y, ID id, Controller controller, TiledMap map) {
        super(x, y, id, sprite, map);
        setPosition(x, y);
        this.controller = controller;
        this.map = map;
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
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tick'");
    }

    @Override
    public void render() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }
    
}
