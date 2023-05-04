package inf112.skeleton.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import inf112.skeleton.app.Controller.Controller;

public class SouthGameTest {

    private static Southgame game;
    private static Controller controller;

    
    @BeforeAll
	static void setUpBeforeAll() {
        
        game = mock(Southgame.class);
        controller = new Controller();
	}

    @Test
    public void testGetController() {
        
        assertNotNull(controller);
        assertTrue(controller instanceof Controller);
    }
    

   
}