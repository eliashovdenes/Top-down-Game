package inf112.skeleton.app;

public enum PlayerPics {
    RIGHT("src/main/java/inf112/skeleton/app/assets/playerPics/playerR.png"),
    LEFT("src/main/java/inf112/skeleton/app/assets/playerPics/playerL.png"),
    UP("src/main/java/inf112/skeleton/app/assets/playerPics/playerUP.png"),
    DOWN("src/main/java/inf112/skeleton/app/assets/playerPics/playerDOWN.png"),
    ENEMYDOWN("src/main/java/inf112/skeleton/app/assets/enemyPics/enemyDown.png"),
    ENEMYUP("src/main/java/inf112/skeleton/app/assets/enemyPics/enemyUp.png"),
    ENEMYLEFT("src/main/java/inf112/skeleton/app/assets/enemyPics/enemyLeft.png"),
    ENEMYRIGHT("src/main/java/inf112/skeleton/app/assets/enemyPics/enemyRight.png");

    

    String source;

    PlayerPics(String source) {
        this.source = source;
    }
}
