package inf112.skeleton.app;


import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;


public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("South game");
        cfg.setWindowedMode(1920,1080);

        new Lwjgl3Application(new Zelda(), cfg);
    }

}

