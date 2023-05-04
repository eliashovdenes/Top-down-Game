package inf112.skeleton.app;


import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;





public class Main {
    public static int screenWidth = 1920 ;
    public static int screenHeight = 1080;
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        // cfg.setResizable(false);
        DisplayMode disp = Lwjgl3ApplicationConfiguration.getDisplayMode();
        cfg.setWindowedMode(1920, 1080);

        if(disp.width < 1920 || disp.height < 1080){
            cfg.setWindowedMode(disp.width, disp.height);
        }

        new Lwjgl3Application(new Southgame(), cfg);
    }

    public int getDefaultWidth(){
        return screenWidth;
    }


    public int getDefaultHeight(){
        return screenHeight;
    }

    
}

