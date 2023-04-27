package inf112.skeleton.app.Sound;

public class SoundManager {
    public aSound mainMenuMusic;
    public aSound arrowSound;
    public aSound lightningMultiShotSound;
    public aSound arenaSound;
    public aSound safeZone;
    
    public SoundManager(){
        this.mainMenuMusic = new aSound("src/main/resources/assets/soundfiles/Main.mp3");
        this.arrowSound = new aSound("assets/soundfiles/bow-release.mp3");
        this.lightningMultiShotSound = new aSound("assets/soundfiles/electric-shock.mp3");
        this.arenaSound = new aSound("src/main/resources/assets/soundfiles/arena.mp3");
        this.safeZone = new aSound("src/main/resources/assets/soundfiles/deep_south-night-sounds-115466.mp3");
    }
}
