package inf112.skeleton.app.Entities.Enums;

//*PlayerPics is used to determine what picture the player and enemies should have*/
public enum PlayerPics {
    RIGHT("assets/playerPics/playerR.png"),
    LEFT("assets/playerPics/playerL.png"),
    UP("assets/playerPics/playerUP.png"),
    DOWN("assets/playerPics/playerDOWN.png"),

    RIGHTARROW("assets/projectilePics/RightArrow.png"),
    LEFTARROW("assets/projectilePics/LeftArrow.png"),
    UPARROW("assets/projectilePics/UpArrow.png"),
    DOWNARROW("assets/projectilePics/DownArrow.png"),
    LIGHTNING("assets/projectilePics/lightning.png");

    public String source;

    PlayerPics(String source) {
        this.source = source;
    }
}
