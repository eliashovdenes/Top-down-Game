package inf112.skeleton.app.Controller;
import com.badlogic.gdx.Input.Keys;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class ControllerTest {

    
    
//checks if the controller class recieves the attack information.
  /*  @Test
    void testInputAttack(){
        Controller controll = new Controller();
        assertFalse(controll.isAttack());
        controll.keyDown(Keys.P);
        assertTrue(controll.isAttack());
        controll.keyUp(Keys.P);
        assertFalse(controll.isAttack());
    }
 */
    @Test
    void testInputUp(){
        Controller controll = new Controller();
        assertFalse(controll.isUp());
        controll.keyDown(Keys.W);
        assertTrue(controll.isUp());
        controll.keyUp(Keys.W);
        assertFalse(controll.isUp());
    }

    @Test
    void testInputDown(){
        Controller controll = new Controller();
        assertFalse(controll.isDown());
        controll.keyDown(Keys.S);
        assertTrue(controll.isDown());
        controll.keyUp(Keys.S);
        assertFalse(controll.isDown());
    }

    @Test
    void testInputLeft(){
        Controller controll = new Controller();
        assertFalse(controll.isLeft());
        controll.keyDown(Keys.A);
        assertTrue(controll.isLeft());
        controll.keyUp(Keys.A);
        assertFalse(controll.isLeft());
    }

    @Test
    void testInputRight(){
        Controller controll = new Controller();
        assertFalse(controll.isRight());
        controll.keyDown(Keys.D);
        assertTrue(controll.isRight());
        controll.keyUp(Keys.D);
        assertFalse(controll.isRight());
    }
    @Test
    void testInputSpace(){
        Controller controll = new Controller();
        assertFalse(controll.isSpace());
        controll.keyDown(Keys.SPACE);
        assertTrue(controll.isSpace());
        controll.keyUp(Keys.SPACE);
        assertFalse(controll.isSpace());
    }
    @Test
    void testInputEnter(){
        Controller controll = new Controller();
        assertFalse(controll.isEnter());
        controll.keyDown(Keys.ENTER);
        assertTrue(controll.isEnter());
        controll.keyUp(Keys.ENTER);
        assertFalse(controll.isEnter());
    }
    @Test
    void testInputShop(){
        Controller controll = new Controller();
        assertFalse(controll.isShop());
        controll.keyDown(Keys.TAB); //TAB
        controll.keyUp(Keys.TAB);
        assertTrue(controll.isShop());
        controll.keyDown(Keys.TAB);
        controll.keyUp(Keys.TAB);
        assertFalse(controll.isShop());
    }
    @Test
    void testInputPause(){
        Controller controll = new Controller();
        assertFalse(controll.isPaused());
        controll.keyDown(Keys.ESCAPE);
        controll.keyUp(Keys.ESCAPE);
        assertTrue(controll.isPaused());
        controll.keyDown(Keys.ESCAPE);
        controll.keyUp(Keys.ESCAPE);
        assertFalse(controll.isPaused());
    }
}
