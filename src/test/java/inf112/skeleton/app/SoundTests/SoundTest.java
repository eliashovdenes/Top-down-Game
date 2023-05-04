package inf112.skeleton.app.SoundTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.*;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;

import com.badlogic.gdx.graphics.GL20;

import inf112.skeleton.app.Southgame;
import inf112.skeleton.app.Sound.SoundManager;

public class SoundTest {

    private SoundManager soundManager;
    inf112.skeleton.app.Southgame Southgame;
    HeadlessApplication app;


    @BeforeAll
	static void setUpBeforeAll() {
        Gdx.gl = mock(GL20.class);       
        Gdx.gl20 = mock(GL20.class);
        Gdx.audio = mock(Audio.class);
        Gdx.files = mock(Files.class);
	}   

	@BeforeEach
	void setUpBeforeEach() {
        Southgame = mock(Southgame.class);
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        app = new HeadlessApplication(Southgame, config);
        soundManager = new SoundManager();
        
        
	}

    @Test
    public void testMainMenuMusic() {
        soundManager.mainMenuMusic.play();
        assertTrue(soundManager.mainMenuMusic.getSoundString()=="assets/soundfiles/Main.mp3");
        soundManager.mainMenuMusic.stop();
        soundManager.mainMenuMusic.dispose();
    }

    @Test
    public void testArrowSound() {
        soundManager.arrowSound.play();
        assertTrue(soundManager.arrowSound.getSoundString()=="assets/soundfiles/bow-release.mp3");
        soundManager.arrowSound.stop();
        soundManager.arrowSound.dispose();

    }

    @Test
    public void testLightningMultiShotSound() {
        soundManager.lightningMultiShotSound.play();
        assertTrue(soundManager.lightningMultiShotSound.getSoundString()=="assets/soundfiles/electric-shock.mp3");
        soundManager.lightningMultiShotSound.stop();
        soundManager.lightningMultiShotSound.dispose();
    }

    @Test
    public void testArenaSound() {
        soundManager.arenaSound.play();
        assertTrue(soundManager.arenaSound.getSoundString()=="assets/soundfiles/arena-2.mp3");
        soundManager.arenaSound.stop();
        soundManager.arenaSound.dispose();
    }

    @Test
    public void testSafeZone() {
        soundManager.safeZone.play();
        assertTrue(soundManager.safeZone.getSoundString()=="assets/soundfiles/grasshopper.mp3");
        soundManager.safeZone.stop();
        soundManager.safeZone.dispose();
    }

    @Test
    public void testButtonClick() {
        soundManager.buttonClick.play();
        assertTrue(soundManager.buttonClick.getSoundString()=="assets/soundfiles/KnappeLyd.mp3");
        soundManager.buttonClick.stop();
        soundManager.buttonClick.dispose();
    }

    @Test
    public void testHouse() {
        soundManager.house.play();
        assertTrue(soundManager.house.getSoundString()=="assets/soundfiles/HouseMusic.mp3");
        soundManager.house.stop();
        soundManager.house.dispose();
    }    

    @Test
    public void testHit(){
        soundManager.hit.play();
        assertTrue(soundManager.hit.getSoundString()=="assets/soundfiles/takehit.mp3");
        soundManager.hit.stop();
        soundManager.hit.dispose();
    }
    @Test
    public void testkillAllEnemies(){
        soundManager.killedAllEnemies.play();
        assertTrue(soundManager.killedAllEnemies.getSoundString()=="assets/soundfiles/dead.mp3");
        soundManager.killedAllEnemies.stop();
        soundManager.killedAllEnemies.dispose();
    }
    @Test
    public void testStart(){
        soundManager.start.play();
        assertTrue(soundManager.start.getSoundString()=="assets/soundfiles/start.mp3");
        soundManager.start.stop();
        soundManager.start.dispose();
    }
    @Test
    public void testMonsterDied(){
        soundManager.monsterdied.play();
        assertTrue(soundManager.monsterdied.getSoundString()=="assets/soundfiles/monsterdied.mp3");
        soundManager.monsterdied.stop();
        soundManager.monsterdied.dispose();
    }
    @Test
    public void testKill(){
        soundManager.kill.play();
        assertTrue(soundManager.kill.getSoundString()=="assets/soundfiles/killed.mp3");
        soundManager.kill.stop();
        soundManager.kill.dispose();
    }
}
