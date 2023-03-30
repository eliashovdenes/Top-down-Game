package inf112.skeleton.app.Mapfolder;

// Maps is used to determine which map to load
public enum Maps {
    //For main game cycle
    Level1("src/main/java/inf112/skeleton/app/assets/maps/Level 1.tmx"),
    Level2("src/main/java/inf112/skeleton/app/assets/maps/Level 2.tmx"), 
    House("src/main/java/inf112/skeleton/app/assets/maps/House.tmx"),
    Cave("src/main/java/inf112/skeleton/app/assets/maps/Cave.tmx"),
    Grass("src/main/java/inf112/skeleton/app/assets/maps/grass.tmx"),
    Level3("src/main/java/inf112/skeleton/app/assets/maps/Level 3.tmx"),
    
    //For mini map cycle
    Level1Mini("src/main/java/inf112/skeleton/app/assets/maps/MiniLevel1.tmx"), 
    GrassMini("src/main/java/inf112/skeleton/app/assets/maps/grassMini.tmx");
    

    public String source;

    Maps(String source) {
        this.source = source;
    }
}

