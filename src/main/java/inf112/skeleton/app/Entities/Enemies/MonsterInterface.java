package inf112.skeleton.app.Entities.Enemies;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.Entities.Enums.DirectionEnum;
import inf112.skeleton.app.Entities.Projectiles.ProjectileInterface;

public interface MonsterInterface {

    /**
     * Update monster object. Call before draw.
     * 
     * @param delta time elapsed since last frame was rendered.
     */
    void update(float delta);

    /**
     * Set monster sprite.
     * 
     * @param string is a path to an image in resources. Intended for enum with png.
     */
    void setSprite(String string);

    /**
     * 
     * @return the sprite associated with the monster object.
     */
    Sprite getSprite();

    /**
     * Set base movement speed of monster.
     * 
     * @param speed
     */
    void setMovementSpeed(float speed);

    /**
     * 
     * @return width of monster. Normally is width of associated sprite.
     */
    float getWidth();

    /**
     * 
     * @return height of monster. Normally is height of associated sprite.
     */
    float getHeight();

    /**
     * Set direction the monster should be facing.
     * 
     * @param direction enum (north,west,east,south)
     */
    void setDirection(DirectionEnum direction);

    /**
     * Get the direction the monster is currently facing.
     * 
     * @return enum (north,west,south,east).
     */
    DirectionEnum getDirection();

    /**
     * Sets the X and Y coordinates of monster based on bounds found in map object.
     * Randomizes within bounds.
     */
    void setXYFromSpawnBounds();

    /**
     * Changes the velocity of the enemy.
     * Made to set the velocity according to th eplayers position.
     * 
     * @param x
     * @param y
     */
    public void followPlayer(float x, float y);

    /**
     * 
     * @return a vector2 object containing X and Y coordinates of monster.
     *         NB: Coordinates are in the lower left corner of sprite.
     */
    Vector2 getPosition();

    /**
     * 
     * @return list of Monster created in Spawn() method.
     * 
     */
    Rectangle getRect();

    /**
     * The name of the monster
     * 
     * @return String - the name of the monster
     */
    public String getName();

    /**
     * The amount of damage the monster does when colliding with it
     * 
     * @return int - amount of collision damage
     */
    int getDamage();

    /**
     * Reduces the current hitpoints of the monster by a given amount
     * 
     * @param damage - int: amount of damage
     */
    void takeDamage(int damage);

    /**
     * Gets the currentHitPoints of the monster
     * 
     * @return Integer - amount of currentHitPoints
     */
    Integer getCurrentHitpoints();

    /**
     * Checks if the monster is dead
     * 
     * @return boolean - true if monster is dead, false otherwise
     */
    boolean isDead();

    /**
     * Checks if a monster drops a healthPotion
     * 
     * @return boolean - true if enemy drops healthPotion, false otherwise
     */
    public boolean dropHealthPotion();

    /**
     * Get the monster's chance of dropping a health potion
     * 
     * @return double - a value between 0 and 1
     */
    public double getHealthPotionDropChance();

    /**
     * Set the monser's health potion drop chance
     * 
     * @param chance - double: value between 0 and 1
     */
    public void setHealthPotionDropChance(double chance);

    /**
     * Get the arraylist containing all the projectiles the monster has shot
     * 
     * @return ArrayList of projectiles
     */
    ArrayList<ProjectileInterface> getProjectiles();

    /**
     * Activate the shooting ability of the monster
     */
    void giveShootingPermission();
}
