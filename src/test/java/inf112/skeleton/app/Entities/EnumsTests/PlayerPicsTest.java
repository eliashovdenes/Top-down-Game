package inf112.skeleton.app.Entities.EnumsTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import inf112.skeleton.app.Entities.Enums.PlayerPics;

public class PlayerPicsTest {
    
    @Test
    public void testRightPic() {
        assertEquals("assets/playerPics/playerR.png", PlayerPics.RIGHT.source);
    }

    @Test
    public void testLeftPic() {
        assertEquals("assets/playerPics/playerL.png", PlayerPics.LEFT.source);
    }

    @Test
    public void testUpPic() {
        assertEquals("assets/playerPics/playerUP.png", PlayerPics.UP.source);
    }

    @Test
    public void testDownPic() {
        assertEquals("assets/playerPics/playerDOWN.png", PlayerPics.DOWN.source);
    }

    @Test
    public void testRightArrowPic() {
        assertEquals("assets/projectilePics/RightArrow.png", PlayerPics.RIGHTARROW.source);
    }

    @Test
    public void testLeftArrowPic() {
        assertEquals("assets/projectilePics/LeftArrow.png", PlayerPics.LEFTARROW.source);
    }

    @Test
    public void testUpArrowPic() {
        assertEquals("assets/projectilePics/UpArrow.png", PlayerPics.UPARROW.source);
    }

    @Test
    public void testDownArrowPic() {
        assertEquals("assets/projectilePics/DownArrow.png", PlayerPics.DOWNARROW.source);
    }

    @Test
    public void testLightningPic() {
        assertEquals("assets/projectilePics/lightning.png", PlayerPics.LIGHTNING.source);
    }
}