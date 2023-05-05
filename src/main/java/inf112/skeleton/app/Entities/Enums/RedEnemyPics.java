package inf112.skeleton.app.Entities.Enums;

//*RedEnemyPics is used to determine which picture to use for the red enemy*/
public enum RedEnemyPics {
    ENEMYDOWN("assets/enemyPics/redEnemyDown.png"),
    ENEMYUP("assets/enemyPics/redEnemyUP.png"),
    ENEMYLEFT("assets/enemyPics/redEnemyLEFT.png"),
    ENEMYRIGHT("assets/enemyPics/redEnemyRIGHT.png"),
    REDPROJECTILE("assets/projectilePics/RedProjectile.png");

    public String source;

    RedEnemyPics(String source) {
        this.source = source;
    }
}
