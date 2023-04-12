package inf112.skeleton.app.Mapfolder;

// Maps is used to determine which map to load
public enum Maps {
    //For main game cycle
    Level1("src/resources/assets/maps/Level 1.tmx"),
    Level2("src/resources/assets/maps/Level 2.tmx"), 
    House("src/resources/assets/maps/House.tmx"),
    Cave("src/resources/assets/maps/Cave.tmx"),
    Grass("src/resources/assets/maps/grass.tmx"),
    Level3("src/resources/assets/maps/Level 3.tmx"),
    
    //For mini map cycle
    Level1Mini("src/resources/assets/maps/MiniLevel1.tmx"), 
    GrassMini("src/resources/assets/maps/grassMini.tmx");
    

    public String source;

    Maps(String source) {
        this.source = source;
    }
}

