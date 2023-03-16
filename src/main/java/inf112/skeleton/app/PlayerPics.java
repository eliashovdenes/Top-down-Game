package inf112.skeleton.app;

public enum PlayerPics {
    RIGHT("src/main/java/inf112/skeleton/app/assets/playerPics/playerR.png"),
    LEFT("src/main/java/inf112/skeleton/app/assets/playerPics/playerL.png"),
    UP("src/main/java/inf112/skeleton/app/assets/playerPics/playerUP.png"),
    DOWN("src/main/java/inf112/skeleton/app/assets/playerPics/playerDOWN.png"),
    ENEMYDOWN("src/main/java/inf112/skeleton/app/assets/enemyPics/enemyDown.png"),
    ENEMYUP("src/main/java/inf112/skeleton/app/assets/enemyPics/enemyUp.png"),
    ENEMYLEFT("src/main/java/inf112/skeleton/app/assets/enemyPics/enemyLeft.png"),
    ENEMYRIGHT("src/main/java/inf112/skeleton/app/assets/enemyPics/enemyRight.png"),
    ATTACKUP("src/main/java/inf112/skeleton/app/assets/playerPics/linkattacktop.png"),
    ATTACKDOWN("src/main/java/inf112/skeleton/app/assets/playerPics/linkAttack_down.png"),
    ATTACKLEFT("src/main/java/inf112/skeleton/app/assets/playerPics/linkattackleft.png"),
    ATTACKRIGHT("src/main/java/inf112/skeleton/app/assets/playerPics/linkattack_right.png"),
    RIGHTARROW ("src/main/java/inf112/skeleton/app/assets/projectilePics/RightArrow.png"),
    LEFTARROW ("src/main/java/inf112/skeleton/app/assets/projectilePics/LeftArrow.png"),
    UPARROW ("src/main/java/inf112/skeleton/app/assets/projectilePics/UpArrow.png"),
    DOWNARROW ("src/main/java/inf112/skeleton/app/assets/projectilePics/DownArrow.png");


    

    String source;

    PlayerPics(String source) {
        this.source = source;
    }
}
