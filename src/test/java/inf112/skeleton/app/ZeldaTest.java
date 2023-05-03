package inf112.skeleton.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import inf112.skeleton.app.Controller.Controller;

public class ZeldaTest {

    private static Zelda game;
    private static Controller controller;

    
    @BeforeAll
	static void setUpBeforeAll() {
        
        game = new Zelda();
        controller = new Controller();
	}

    @Test
    public void testGetController() {
        
        assertNotNull(controller);
        assertTrue(controller instanceof Controller);
    }

    @Test
    public void testCreate(){
        //TODO: implement test (fikk det ikke til!)
        fail();
    }
}