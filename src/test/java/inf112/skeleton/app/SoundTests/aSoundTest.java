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
import inf112.skeleton.app.Sound.aSound;

public class aSoundTest {


    @BeforeAll
	static void setUpBeforeAll() {
        Gdx.gl = mock(GL20.class);       
        Gdx.gl20 = mock(GL20.class);
        
	}

    private Zelda zelda;
    private HeadlessApplication app;
    private SoundManager SM;


    
	@BeforeEach
	void setUpBeforeEach() {
        zelda = mock(Zelda.class);
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        app = new HeadlessApplication(zelda, config);
        SM = new SoundManager();
        
	}
    
    @Test
    public void testPlayAndStop() {

        aSound sound = new aSound("sound.mp3", false);
        
        sound.play();
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        sound.stop();
        
        sound.dispose();
    }
    
    @Test
    public void testDispose() {

        aSound sound = new aSound("src/main/resources/assets/soundfiles/Main.mp3", false);
        
        sound.dispose();
        Assertions.assertThrows(Exception.class, () -> {
            sound.play();
        });
    }
    
    @Test
    public void testLooping() {

        aSound sound  = new aSound("src/main/resources/assets/soundfiles/Main.mp3", true);
        
        //sound.play();

        Assertions.assertTrue(sound.getMusicObject().isLooping());
        
        
        sound.dispose();
    }
}
