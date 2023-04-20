package inf112.skeleton.app.Entities.Enums;

//*RedEnemyPics is used to determine which picture to use for the red enemy*/
public enum RedEnemyPics {
    ENEMYDOWN("assets/enemyPics/RedEnemyDOWN.png"),
    ENEMYUP("assets/enemyPics/RedEnemyUP.png"),
    ENEMYLEFT("assets/enemyPics/RedEnemyLEFT.png"),
    ENEMYRIGHT("assets/enemyPics/RedEnemyRIGHT.png");

    public String source;

    RedEnemyPics(String source) {
        this.source = source;
    }
}
