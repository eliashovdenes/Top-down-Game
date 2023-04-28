package inf112.skeleton.app.Entities.Enums;

//*BlueEnemyPics is used to determine which picture to use for the red enemy*/
public enum BlueEnemyPics {
    ENEMYDOWN("assets/enemyPics/enemyDown.png"),
    ENEMYUP("assets/enemyPics/enemyUp.png"),
    ENEMYLEFT("assets/enemyPics/enemyLeft.png"),
    ENEMYRIGHT("assets/enemyPics/enemyRight.png");

    public String source;

    BlueEnemyPics(String source) {
        this.source = source;
    }
}
