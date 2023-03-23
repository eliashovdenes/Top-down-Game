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

    void setDirection(DirectionEnum direction);

    DirectionEnum getDirection();

    void spawn();

    void setXYFromSpawnBounds();

    Vector2 getPosition();

}
