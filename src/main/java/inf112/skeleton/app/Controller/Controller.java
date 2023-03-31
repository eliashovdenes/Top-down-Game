package inf112.skeleton.app.Controller;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Controller implements InputProcessor{

    private boolean isUp = false,
    isDown = false,
    isRight = false,
    isLeft = false,
    fast = false,
    isAttack = false,
    isSpace = false,
    enter = false,
    isPaused = false,
    wasEscJustPressed,
    wasKjustPressed,
    isShop,
    justTouched = false;

    private Vector2 menuClick = new Vector2(0,0);
    
    @Override
    //*This method is called when a key is pressed */
    public boolean keyDown(int keycode) {
        if (keycode == Keys.W) isUp = true;
        if (keycode == Keys.S) isDown = true;
        if (keycode == Keys.A) isLeft = true;
        if (keycode == Keys.D) isRight = true;
        if (keycode == Keys.L) fast = true;
        if (keycode == Keys.P) isAttack = true;
        if (keycode == Keys.SPACE) isSpace = true;
        if (keycode == Keys.ENTER) enter = true;
        if (keycode == Keys.ESCAPE) {
            if(!wasEscJustPressed){
                wasEscJustPressed = true;
                if (isPaused){
                    isPaused = false;
                    }
                    else {
                        isPaused = true;
                    }
                }
            }
        if(keycode == Keys.K){
            if(!wasKjustPressed){
                wasKjustPressed = true;
                if (isShop){
                    isShop = false;
                }
                else{
                    isShop = true;
                }
            }
        }
        return true;
    }


    @Override
    //*This method is called when a key is released */
    public boolean keyUp(int keycode) {
        if (keycode == Keys.W) isUp = false;
        if (keycode == Keys.S) isDown = false;
        if (keycode == Keys.A) isLeft = false;
        if (keycode == Keys.D) isRight = false;
        if (keycode == Keys.L) fast = false;
        if (keycode == Keys.P) isAttack = false;
        if (keycode == Keys.SPACE) isSpace = false;
        if (keycode == Keys.ENTER) enter = false;
        if (keycode == Keys.ESCAPE) wasEscJustPressed = false;
        if (keycode == Keys.K) wasKjustPressed = false;
        
        return true;
    }

    
    @Override
    //*This method is called when a key is typed, we do not use this method*/
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        menuClick = new Vector2(screenX,screenY);
        justTouched = true;
        return true;
    }
    @Override
    //*This method is called when the mouse is released, we do not use this method*/
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        justTouched = false;
        return false;
    }
    @Override
    //*This method is called when the mouse is dragged, we do not use this method*/
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }
    @Override
    //*This method is called when the mouse is moved, we do not use this method*/
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
    @Override
    //*This method is called when the mouse is scrolled, we do not use this method*/
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    public boolean getJustTouched(){
        return justTouched;
    }

    // Getters and setters ----->>>>
    public boolean isPaused(){
        return isPaused;
    }
    public void setPaused(boolean isPaused){
        this.isPaused = isPaused;
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
    public void setAttack(boolean isAttack){
        this.isAttack = isAttack;
    }
    public boolean isAttack(){
        return isAttack;
    }

    public boolean isEnter() {
        return enter;
    }
    public void setEnter(boolean enter) {
        this.enter = enter;
    }
    public boolean isSpace() {
        return isSpace;
    }
    public void setSpace(boolean isSpace) {
        this.isSpace = isSpace;
    }
    public boolean isFast() {
        return fast;
    }
    public void setFast(boolean fast) {
        this.fast = fast;
    }


    public boolean isShop() {
        return isShop;
    }
    public void setShop(boolean isShop){
        this.isShop = isShop;
    }

    public Vector2 getMenuClick(){
        return menuClick;
    }
}

