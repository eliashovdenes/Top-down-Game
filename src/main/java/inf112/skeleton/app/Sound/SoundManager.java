package inf112.skeleton.app.Sound;

public class SoundManager {
    public aSound mainMenuMusic;
    public aSound arrowSound;
    public aSound lightningMultiShotSound;
    
    public SoundManager(){
        this.mainMenuMusic = new aSound("src/resources/assets/soundfiles/wrong-place.mp3");
        this.arrowSound = new aSound("src/resources/assets/soundfiles/bow-release.mp3");
        this.lightningMultiShotSound = new aSound("src/resources/assets/soundfiles/electric-shock.mp3");
    }
}
