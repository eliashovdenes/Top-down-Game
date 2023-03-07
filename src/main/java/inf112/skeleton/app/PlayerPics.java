package inf112.skeleton.app;

public enum PlayerPics {
    RIGHT("/Users/brorby/Documents/V23/projects/inf-112-23-v-libgdx-template-magnus/src/main/java/inf112/skeleton/app/assets/playerPics/playerR.png"),
    LEFT("/Users/brorby/Documents/V23/projects/inf-112-23-v-libgdx-template-magnus/src/main/java/inf112/skeleton/app/assets/playerPics/playerL.png"),
    UP("/Users/brorby/Documents/V23/projects/inf-112-23-v-libgdx-template-magnus/src/main/java/inf112/skeleton/app/assets/playerPics/playerUP.png"),
    DOWN("/Users/brorby/Documents/V23/projects/inf-112-23-v-libgdx-template-magnus/src/main/java/inf112/skeleton/app/assets/playerPics/playerDOWN.png");

    String source;

    PlayerPics(String source) {
        this.source = source;
    }
}
