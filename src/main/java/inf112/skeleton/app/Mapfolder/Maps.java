package inf112.skeleton.app.Mapfolder;

public enum Maps {
    Level1("src/main/java/inf112/skeleton/app/assets/maps/Level 1.tmx"),
    Level2("src/main/java/inf112/skeleton/app/assets/maps/Level 2.tmx"), //src\main\java\inf112\skeleton\app\assets\Level 2.tmx
    House("src/main/java/inf112/skeleton/app/assets/maps/House.tmx"),
    Cave("src/main/java/inf112/skeleton/app/assets/maps/Cave.tmx"),
    Grass("src/main/java/inf112/skeleton/app/assets/maps/grass.tmx"),
    Level3("src/main/java/inf112/skeleton/app/assets/maps/Level 3.tmx");
    

    public String source;

    Maps(String source) {
        this.source = source;
    }
}

