package inf112.skeleton.app;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Setter;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Enemy extends GameObject {

    private Collision collision;
    private Random rand = new Random();

    public Enemy(float x, float y, ID id, Sprite sprite, TiledMap map, View view) {
        super(x, y, id, sprite, map, view);
        collision = new Collision(map, this, view);
        velX = 1;
        velY = 0;
    }

    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    

    public void update(float deltaTime) {
        x += velX;
        y += velY;

        float oldX = getX(), oldY = getY();


        setX(getX() + velX * deltaTime);
        if (velY < 0) {
            setTexture(new Texture(PlayerPics.ENEMYDOWN.source));
        }
        else if (velY > 0) {
            setTexture(new Texture(PlayerPics.ENEMYUP.source));
        }

        if (velX < 0) {
            setTexture(new Texture(PlayerPics.ENEMYLEFT.source));
        }
        else if (velX > 0) {
            setTexture(new Texture(PlayerPics.ENEMYRIGHT.source));
        }

        if (collision.chechXDirection(velX, oldX)) {
            setX(oldX);
            newDeirection();
            // if (velX < 0) velX = speed;
            // else if (velX > 0) velX = -speed;
            
            // System.out.println(oldX);
        }

        setY(getY() + velY * deltaTime);

        if (collision.chechYDirection(velY, oldY)) {
            setY(oldY);
            newDeirection();
            // if (velY < 0) velY = speed;
            // else if (velY > 0) velY = -speed;
            // System.out.println("y");
        }


    }

    public void newDeirection() {
        int dir = rand.nextInt(1,9);
        System.out.println(dir);
        if (dir == 1) {velX = speed; velY = 0;}
        if (dir == 2) {velX = -speed; velY = 0;}
        if (dir == 3) {velY = speed; velX = 0;}
        if (dir == 4) {velY = -speed; velX = 0;}
        if (dir == 5) {velY = speed; velX = speed;}
        if (dir == 6) {velY = -speed; velX = speed;}
        if (dir == 7) {velY = speed; velX = -speed;} 
        if (dir == 8) {velY = -speed; velX = -speed;}
    }

    @Override
    public void setOldXNdY(float oldX, float oldY) {
        this.oldX = oldX;
        this.oldY = oldY;

    }

    @Override
    public float getOldX() {
        return oldX;
    }

    @Override
    public float getOldY() {
        return oldY;
    }

    public ID getId() {
        return id;
    }

    
    
}
