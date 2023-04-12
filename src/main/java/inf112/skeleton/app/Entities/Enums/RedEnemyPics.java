package inf112.skeleton.app.Entities.Enums;

//*RedEnemyPics is used to determine which picture to use for the red enemy*/
public enum RedEnemyPics {
    ENEMYDOWN("src/resources/assets/enemyPics/RedEnemyDOWN.png"),
    ENEMYUP("src/resources/assets/enemyPics/RedEnemyUP.png"),
    ENEMYLEFT("src/resources/assets/enemyPics/RedEnemyLEFT.png"),
    ENEMYRIGHT("src/resources/assets/enemyPics/RedEnemyRIGHT.png");

    public String source;

    RedEnemyPics(String source) {
        this.source = source;
    }
}
