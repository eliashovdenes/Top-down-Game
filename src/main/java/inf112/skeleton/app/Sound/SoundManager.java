package inf112.skeleton.app.Sound;

public class SoundManager {
    public aSound mainMenuMusic;
    public aSound arrowSound;
    public aSound lightningMultiShotSound;
    
    public SoundManager(){
        this.mainMenuMusic = new aSound("assets/soundfiles/wrong-place.mp3");
        this.arrowSound = new aSound("assets/soundfiles/bow-release.mp3");
        this.lightningMultiShotSound = new aSound("assets/soundfiles/electric-shock.mp3");
    }
}
