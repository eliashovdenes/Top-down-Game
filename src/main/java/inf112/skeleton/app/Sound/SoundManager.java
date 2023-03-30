package inf112.skeleton.app.Sound;

public class SoundManager {
    public aSound mainMenuMusic;
    public aSound arrowSound;
    public aSound lightningMultiShotSound;
    
    public SoundManager(){
        this.mainMenuMusic = new aSound("src/main/java/inf112/skeleton/app/assets/soundfiles/wrong-place.mp3");
        this.arrowSound = new aSound("src/main/java/inf112/skeleton/app/assets/soundfiles/bow-release.mp3");
        this.lightningMultiShotSound = new aSound("src/main/java/inf112/skeleton/app/assets/soundfiles/electric-shock.mp3");
    }
}
