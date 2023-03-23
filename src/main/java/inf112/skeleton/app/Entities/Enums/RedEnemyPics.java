package inf112.skeleton.app.Entities.Enums;

public enum RedEnemyPics {
    ENEMYDOWN("src/main/java/inf112/skeleton/app/assets/enemyPics/RedEnemyDOWN.png"),
    ENEMYUP("src/main/java/inf112/skeleton/app/assets/enemyPics/RedEnemyUP.png"),
    ENEMYLEFT("src/main/java/inf112/skeleton/app/assets/enemyPics/RedEnemyLEFT.png"),
    ENEMYRIGHT("src/main/java/inf112/skeleton/app/assets/enemyPics/RedEnemyRIGHT.png");

    public String source;

    RedEnemyPics(String source) {
        this.source = source;
    }
}
