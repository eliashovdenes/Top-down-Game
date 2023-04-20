package inf112.skeleton.app.Mapfolder;

// Maps is used to determine which map to load
public enum Maps {
    //For main game cycle
    Level1("assets/maps/Level 1.tmx"),
    Level2("assets/maps/Level 2.tmx"), 
    House("assets/maps/House.tmx"),
    Cave("assets/maps/Cave.tmx"),
    Grass("assets/maps/grass.tmx"),
    Level3("assets/maps/Level 3.tmx"),
    
    //For mini map cycle
    Level1Mini("assets/maps/MiniLevel1.tmx"), 
    GrassMini("assets/maps/grassMini.tmx");
    

    public String source;

    Maps(String source) {
        this.source = source;
    }
}

