package inf112.skeleton.app;

public enum PlayerPics {
    RIGHT("src/main/java/inf112/skeleton/app/assets/playerPics/playerR.png"),
    LEFT("src/main/java/inf112/skeleton/app/assets/playerPics/playerL.png"),
    UP("src/main/java/inf112/skeleton/app/assets/playerPics/playerUP.png"),
    DOWN("src/main/java/inf112/skeleton/app/assets/playerPics/playerDOWN.png");

    String source;

    PlayerPics(String source) {
        this.source = source;
    }
}
