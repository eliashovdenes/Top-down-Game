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
        this.mainMenuMusic = new aSound("src/main/resources/assets/soundfiles/Main.mp3", true);
        this.arrowSound = new aSound("assets/soundfiles/bow-release.mp3", false);
        this.lightningMultiShotSound = new aSound("src/main/resources/assets/soundfiles/electric-shock.mp3", false);
        this.arenaSound = new aSound("src/main/resources/assets/soundfiles/arena-2.mp3", true);
        this.safeZone = new aSound("src/main/resources/assets/soundfiles/grasshopper.mp3", true);
        this.buttonClick = new aSound("src/main/resources/assets/soundfiles/KnappeLyd.mp3", false);
        this.house = new aSound("src/main/resources/assets/soundfiles/HouseMusic.mp3", true);
    }

    
}
