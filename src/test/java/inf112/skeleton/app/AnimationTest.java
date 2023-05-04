package inf112.skeleton.app;

import org.junit.jupiter.api.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.GraphicsType;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
public class AnimationTest {
    
    private HeadlessApplication app;
    private Animation animation; 
    private Array<TextureRegion> frames;
    
    @BeforeAll
	static void setUpBeforeAll() {
        // Gdx.files = mock(Files.class);
        Gdx.gl = mock(GL20.class);       
        Gdx.gl20 = mock(GL20.class);
        // Gdx.graphics = mock(Graphics.class);   
	}

	/**
	 * Setup method called before each of the test methods
	 */
	@BeforeEach
	void setUpBeforeEach() {
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        app = new HeadlessApplication(new Southgame(), config);
        animation = new Animation(new TextureRegion(new Texture("assets/playerPics/animationUP.png")), 12, 0.5f);
        
	}

    /**
     * Tests that the tests are running headless
    */
    @Test
    void testRunningHeadless() {
        assertTrue(Gdx.graphics.getType() == GraphicsType.Mock);
    }

    @Test
    public void testUpdate() {
        // Sjekker at oppdatering av animasjonen går riktig ved å sjekke den første rammen
        TextureRegion frame1 = animation.getFrame();
        animation.update(0.2f);
        TextureRegion frame2 = animation.getFrame();
        assertEquals(false, frame1 == frame2);
    }
    
    @Test
    public void testSetCycleTime() {
        // Sjekker at endring av syklustiden gir riktig maks rammetid
        animation.setCycleTime(1f);
        assertEquals(0.083333336, animation.getMaxFrameTime(), 0.001f);
    }
}
