package inf112.skeleton.app.game.Entities.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import inf112.skeleton.app.game.Entities.AbstractEntity;

public class Player extends AbstractEntity {

    /*
     * The Player class will extend the Entity class and represent the player character. 
     * It will have methods for handling player input and updating the player's state.
     */

    public float y;
    public float x;
    public Texture playerTexture;
    public SpriteBatch playerBatch;
    public float playerRotation;


    public Player(){
        this.y = 250;
        this.x = 250;
        this.playerTexture = new Texture(Gdx.files.internal("assets/Screenshot 2023-02-13 125338.png"));
        this.playerBatch = new SpriteBatch();
        this.playerRotation = 0;
    }

    public void setY(float newY){
        this.y = newY;
    }
    public void setX(float newX){
        this.x = newX;
    }
}
