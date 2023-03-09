package inf112.skeleton.app;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

public class Controller implements InputProcessor{

    private boolean isUp = false, isDown = false, isRight = false, isLeft = false, isAttack = false;

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Keys.W) isUp = true;
        if (keycode == Keys.S) isDown = true;
        if (keycode == Keys.A) isLeft = true;
        if (keycode == Keys.D) isRight = true;
        if (keycode == Keys.X) isAttack = true;
        // if (keycode == Keys.Q) mapShift = true;
        return true;
    }
    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Keys.W) isUp = false;
        if (keycode == Keys.S) isDown = false;
        if (keycode == Keys.A) isLeft = false;
        if (keycode == Keys.D) isRight = false;
        if (keycode == Keys.X) isAttack = false;
        // if (keycode == Keys.Q) mapShift = false;
        return true;
    }
    @Override
    public boolean keyTyped(char character) {
        return false;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }


    public boolean isUp() {
        return isUp;
    }
    public void setUp(boolean isUp) {
        this.isUp = isUp;
    }
    public boolean isDown() {
        return isDown;
    }
    public void setDown(boolean isDown) {
        this.isDown = isDown;
    }
    public boolean isRight() {
        return isRight;
    }
    public void setRight(boolean isRight) {
        this.isRight = isRight;
    }
    public boolean isLeft() {
        return isLeft;
    }
    public void setLeft(boolean isLeft) {
        this.isLeft = isLeft;
    }

    //setter attack
    public void setAttack(boolean isAttack){
        this.isAttack = isAttack;
    }
    public boolean isAttack(){
        return isAttack;
    }



    
}
