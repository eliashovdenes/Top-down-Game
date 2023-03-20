package inf112.skeleton.app.Entities.Enums;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import inf112.skeleton.app.Animation;

public enum PlayerAnimation {

    // WALKING ANIMATION
    UP(new Animation(new TextureRegion(new Texture("src/main/java/inf112/skeleton/app/assets/playerPics/animationUP.png")), 12, 0.5f)),
    DOWN(new Animation(new TextureRegion(new Texture("src/main/java/inf112/skeleton/app/assets/playerPics/animationDOWN.png")), 12, 0.5f)),
    RIGHT(new Animation(new TextureRegion(new Texture("src/main/java/inf112/skeleton/app/assets/playerPics/animationRIGHT.png")), 12, 0.5f)),
    LEFT(new Animation(new TextureRegion(new Texture("src/main/java/inf112/skeleton/app/assets/playerPics/animationLEFT.png")), 12, 0.5f)),

    // RUNNING ANIMATION
    RUNUP(new Animation(new TextureRegion(new Texture("src/main/java/inf112/skeleton/app/assets/playerPics/animationRUNUP.png")), 12, 0.5f)),
    RUNDOWN(new Animation(new TextureRegion(new Texture("src/main/java/inf112/skeleton/app/assets/playerPics/animationRUNDOWN.png")), 12, 0.5f)),
    RUNRIGHT(new Animation(new TextureRegion(new Texture("src/main/java/inf112/skeleton/app/assets/playerPics/animationRUNRIGHT.png")), 12, 0.5f)),
    RUNLEFT(new Animation(new TextureRegion(new Texture("src/main/java/inf112/skeleton/app/assets/playerPics/animationRUNLEFT.png")), 12, 0.5f)),


    ATTACKDOWN(new Animation(new TextureRegion(new Texture("src/main/java/inf112/skeleton/app/assets/playerPics/attackDown.png")), 8, 0.1f)),
    ATTACKLEFT(new Animation(new TextureRegion(new Texture("src/main/java/inf112/skeleton/app/assets/playerPics/attackLeft.png")), 12, 0.1f));


    public Animation animation;

    PlayerAnimation(Animation animation) {
        this.animation = animation;
    }

}
