package inf112.skeleton.app.Sound;

public class SoundManager {
    public aSound mainMenuMusic;
    public aSound arrowSound;
    public aSound lightningMultiShotSound;
    public aSound arenaSound;
    public aSound safeZone;
    public aSound buttonClick;
    public aSound house;
    
    public SoundManager(){
        this.mainMenuMusic = new aSound("assets/soundfiles/Main.mp3", true);
        this.arrowSound = new aSound("assets/soundfiles/bow-release.mp3", false);
        this.lightningMultiShotSound = new aSound("assets/soundfiles/electric-shock.mp3", false);
        this.arenaSound = new aSound("assets/soundfiles/arena-2.mp3", true);
        this.safeZone = new aSound("assets/soundfiles/grasshopper.mp3", true);
        this.buttonClick = new aSound("assets/soundfiles/KnappeLyd.mp3", false);
        this.house = new aSound("assets/soundfiles/HouseMusic.mp3", true);
    }

    
}
