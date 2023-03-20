package inf112.skeleton.app.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import inf112.skeleton.app.Entities.Enums.DirectionEnum;

public interface MonsterInterface {

    void update(float delta);

    void setSprite(String string);

    Sprite getSprite();

    void setMovementSpeed(float speed);

    float getWidth();

    float getHeight();

    void setMonsterDirection(DirectionEnum direction);

    DirectionEnum getPlayerDirection();

    //Overrides method from AbstractGameObject to check for portal collision in Y-direction
    boolean yCollision();

    void spawn(float x, float y);

    boolean onPortal();

    Vector2 getPosition();
    
}
