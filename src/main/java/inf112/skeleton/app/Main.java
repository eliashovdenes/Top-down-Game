package inf112.skeleton.app;


import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;





public class Main {
    // public static final int screenWidth = 1920 ;
    // public static final int screenHeight = 1080;
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        // cfg.setResizable(false);
        DisplayMode disp = Lwjgl3ApplicationConfiguration.getDisplayMode();
        cfg.setWindowedMode(disp.width, disp.height);

        new Lwjgl3Application(new Southgame(), cfg);
    }

    
}

