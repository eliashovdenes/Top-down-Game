package inf112.skeleton.app.Sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class aSound {
    private Sound sound;

    public aSound(String asdf){
        sound = Gdx.audio.newSound(Gdx.files.internal(asdf));
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
