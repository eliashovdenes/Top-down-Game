package inf112.skeleton.app;
import com.badlogic.gdx.Input.Keys;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class ControllerTest {
    
//checks if the controller class recieves the attack informasjon.
    @Test
    void testInputAttack(){
        Controller controll = new Controller();
        assertFalse(controll.isAttack());
        controll.keyDown(Keys.X);
        assertTrue(controll.isAttack());
        controll.keyUp(Keys.X);
        assertFalse(controll.isAttack());
    }

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
    
}
