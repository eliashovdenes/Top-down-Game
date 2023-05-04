package inf112.skeleton.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import inf112.skeleton.app.Controller.Controller;

public class ZeldaTest {

    private static Southgame game;
    private static Controller controller;

    
    @BeforeAll
	static void setUpBeforeAll() {
        
        game = new Southgame();
        controller = new Controller();
	}

    @Test
    public void testGetController() {
        
        assertNotNull(controller);
        assertTrue(controller instanceof Controller);
    }

   
}