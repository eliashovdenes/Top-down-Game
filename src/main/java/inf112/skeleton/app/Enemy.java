package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Setter;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Enemy extends GameObject {

    private Collision collision;

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
            if (velX < 0) velX = speed;
            else if (velX > 0) velX = -speed;
            
            // System.out.println(oldX);
        }

        setY(getY() + velY * deltaTime);

        if (collision.chechYDirection(velY, oldY)) {
            setY(oldY);
            if (velY < 0) velY = speed;
            else if (velY > 0) velY = -speed;
            // System.out.println("y");
        }


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

    
    
}
