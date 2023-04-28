package inf112.skeleton.app.Sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
// import com.badlogic.gdx.audio.Sound;

public class aSound {
    private Music sound;

    public aSound(String soundString, boolean loop){
        sound = Gdx.audio.newMusic(Gdx.files.internal(soundString));
        sound.setLooping(loop);
    }

    public void play(){
        sound.play();
    }
    public void stop(){
        sound.stop();
    }

    public void dispose(){
        sound.dispose();
    }
}
