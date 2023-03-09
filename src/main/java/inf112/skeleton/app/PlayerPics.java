package inf112.skeleton.app;

public enum PlayerPics {
    RIGHT("src/main/java/inf112/skeleton/app/assets/playerPics/playerR.png"),
    LEFT("src/main/java/inf112/skeleton/app/assets/playerPics/playerL.png"),
    UP("src/main/java/inf112/skeleton/app/assets/playerPics/playerUP.png"),
    DOWN("src/main/java/inf112/skeleton/app/assets/playerPics/playerDOWN.png"),
    ATTACKDOWN("src/main/java/inf112/skeleton/app/assets/playerPics/linkAttack_down.png"),
    ATTACKLEFT("src/main/java/inf112/skeleton/app/assets/playerPics/linkattackleft.png"),
    ATTACKUP("src/main/java/inf112/skeleton/app/assets/playerPics/linkattacktop.png"),
    ATTACKRIGHT("src/main/java/inf112/skeleton/app/assets/playerPics/linkattack_right.png");

    String source;

    PlayerPics(String source) {
        this.source = source;
    }
}
