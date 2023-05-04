package inf112.skeleton.app.Sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class aSound {
    private Music sound;
    private String fileString;

    public aSound(String soundString, boolean loop) {
        this.fileString = soundString;
        sound = Gdx.audio.newMusic(Gdx.files.internal(fileString));
        sound.setLooping(loop);

    }

    /**
     * Starts the play back of the music stream.
     * In case the stream was paused this will resume the play back.
     * In case the music stream is finished playing this will restart the play back.
     */
    public void play() {
        sound.play();
    }

    /**
     * Stops a playing or paused Music instance.
     * Next time play() is invoked the Music will start from the beginning.
     */
    public void stop() {
        sound.stop();
    }

    /**
     * Needs to be called when the Music is no longer needed.
     */
    public void dispose() {
        sound.dispose();
    }

    /**
     * @return path string for music-file.
     */
    public String getSoundString() {
        return fileString;
    }
}
