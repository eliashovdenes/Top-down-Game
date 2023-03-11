package inf112.skeleton.app;


import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;





public class Main {
    public static final int screenWidth = 1920;
    public static final int screenHeight = 1080;
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("South game");
        cfg.setWindowedMode(screenWidth,screenHeight);

        new Lwjgl3Application(new Zelda(), cfg);
    }

}

