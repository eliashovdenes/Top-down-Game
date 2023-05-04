package inf112.skeleton.app.SoundTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;

import inf112.skeleton.app.Zelda;
import inf112.skeleton.app.Sound.SoundManager;

public class SoundManagerTest {

    private SoundManager soundManager;
    Zelda zelda;
    HeadlessApplication app;


    @BeforeAll
	static void setUpBeforeAll() {
        Gdx.gl = mock(GL20.class);       
        Gdx.gl20 = mock(GL20.class);
        
	}

	@BeforeEach
	void setUpBeforeEach() {
        zelda = mock(Zelda.class);
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        app = new HeadlessApplication(zelda, config);
        soundManager = new SoundManager();
        
	}

    

    @Test
    public void testMainMenuMusic() {
        soundManager.mainMenuMusic.play();
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        soundManager.mainMenuMusic.stop();
    }

    @Test
    public void testArrowSound() {
        soundManager.arrowSound.play();


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        soundManager.arrowSound.stop();
    }

    @Test
    public void testLightningMultiShotSound() {
        soundManager.lightningMultiShotSound.play();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        soundManager.lightningMultiShotSound.stop();
    }

    @Test
    public void testArenaSound() {
        soundManager.arenaSound.play();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        soundManager.arenaSound.stop();
    }

    @Test
    public void testSafeZone() {
        soundManager.safeZone.play();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        soundManager.safeZone.stop();
    }

    @Test
    public void testButtonClick() {
        soundManager.buttonClick.play();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        soundManager.buttonClick.stop();
    }

    @Test
    public void testHouse() {
        soundManager.house.play();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        soundManager.house.stop();
    }

    
}
