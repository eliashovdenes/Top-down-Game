package inf112.skeleton.app;

public enum Maps {
    Level1("src/main/java/inf112/skeleton/app/assets/Level 1.tmx"),
    Level2("src/main/java/inf112/skeleton/app/assets/Level 2.tmx"), //src\main\java\inf112\skeleton\app\assets\Level 2.tmx
    House("src/main/java/inf112/skeleton/app/assets/House.tmx");
    

    String source;

    Maps(String source) {
        this.source = source;
    }
}

