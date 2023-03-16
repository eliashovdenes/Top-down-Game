package inf112.skeleton.app;

public enum Maps {
    Level1("src/main/java/inf112/skeleton/app/assets/maps/Level 1.tmx"),
    Level2("src/main/java/inf112/skeleton/app/assets/maps/Level 2.tmx"), //src\main\java\inf112\skeleton\app\assets\Level 2.tmx
    House("src/main/java/inf112/skeleton/app/assets/maps/House.tmx"),
    Cave("src/main/java/inf112/skeleton/app/assets/maps/Cave.tmx");
    

    String source;

    Maps(String source) {
        this.source = source;
    }
}

