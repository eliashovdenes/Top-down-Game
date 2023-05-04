package inf112.skeleton.app.Mapfolder;

// Maps is used to determine which map to load
public enum Maps {
    House("assets/maps/House.tmx"),
    Level1Mini("assets/maps/MiniLevel1.tmx"),
    GrassMini("assets/maps/grassMini.tmx");

    public String source;

    Maps(String source) {
        this.source = source;
    }
}
