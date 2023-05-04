package inf112.skeleton.app.Entities.Enums;

/**
 * Enum for red boss
 */
public enum RedBossPics {
    BOSSDOWN("assets/enemyPics/redbossDwon.png"),
    BOSSUP("assets/enemyPics/redbossUp.png"),
    BOSSLEFT("assets/enemyPics/redbossLeft.png"),
    BOSSRIGHT("assets/enemyPics/redbossRight.png");

    public String source;

    RedBossPics(String source) {
        this.source = source;
    }
}
