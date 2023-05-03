package inf112.skeleton.app.Entities.EnumsTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import inf112.skeleton.app.Entities.Enums.PlayerAnimation;

public class PlayerAnimationTest {
    @Test
    public void testUpAnimation() {
        assertNotNull(PlayerAnimation.UP.animation);
    }

    @Test
    public void testDownAnimation() {
        assertNotNull(PlayerAnimation.DOWN.animation);
    }

    @Test
    public void testRightAnimation() {
        assertNotNull(PlayerAnimation.RIGHT.animation);
    }

    @Test
    public void testLeftAnimation() {
        assertNotNull(PlayerAnimation.LEFT.animation);
    }

    @Test
    public void testRunUpAnimation() {
        assertNotNull(PlayerAnimation.RUNUP.animation);
    }

    @Test
    public void testRunDownAnimation() {
        assertNotNull(PlayerAnimation.RUNDOWN.animation);
    }

    @Test
    public void testRunRightAnimation() {
        assertNotNull(PlayerAnimation.RUNRIGHT.animation);
    }

    @Test
    public void testRunLeftAnimation() {
        assertNotNull(PlayerAnimation.RUNLEFT.animation);
    }

    @Test
    public void testAttackDownAnimation() {
        assertNotNull(PlayerAnimation.ATTACKDOWN.animation);
    }

    @Test
    public void testAttackLeftAnimation() {
        assertNotNull(PlayerAnimation.ATTACKLEFT.animation);
    }
}