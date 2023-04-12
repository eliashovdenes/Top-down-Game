package inf112.skeleton.app.Entities.Enums;

//*PlayerPics is used to determine what picture the player and enemies should have*/
public enum PlayerPics {
    RIGHT("src/resources/assets/playerPics/playerR.png"),
    LEFT("src/resources/assets/playerPics/playerL.png"),
    UP("src/resources/assets/playerPics/playerUP.png"),
    DOWN("src/resources/assets/playerPics/playerDOWN.png"),
    ENEMYDOWN("src/resources/assets/enemyPics/enemyDown.png"),
    ENEMYUP("src/resources/assets/enemyPics/enemyUp.png"),
    ENEMYLEFT("src/resources/assets/enemyPics/enemyLeft.png"),
    ENEMYRIGHT("src/resources/assets/enemyPics/enemyRight.png"),
    ATTACKUP("src/resources/assets/playerPics/linkattacktop.png"),
    ATTACKDOWN("src/resources/assets/playerPics/linkAttack_down.png"),
    ATTACKLEFT("src/resources/assets/playerPics/linkattackleft.png"),
    ATTACKRIGHT("src/resources/assets/playerPics/linkattack_right.png"),
    RIGHTARROW ("src/resources/assets/projectilePics/RightArrow.png"),
    LEFTARROW ("src/resources/assets/projectilePics/LeftArrow.png"),
    UPARROW ("src/resources/assets/projectilePics/UpArrow.png"),
    DOWNARROW ("src/resources/assets/projectilePics/DownArrow.png"),
    LIGHTNING ("src/resources/assets/projectilePics/lightning.png");

    

    public String source;

    PlayerPics(String source) {
        this.source = source;
    }
}
