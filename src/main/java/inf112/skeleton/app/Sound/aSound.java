package inf112.skeleton.app.Sound;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class aSound {
    private Music sound;
    private String fileString;

    public aSound(String soundString, boolean loop){
        this.fileString = soundString;
        sound = Gdx.audio.newMusic(Gdx.files.internal(fileString));
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
    public String getSoundString(){
        return fileString;
    }
}
