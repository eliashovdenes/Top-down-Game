package inf112.skeleton.app;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import inf112.skeleton.app.Controller.Controller;
import inf112.skeleton.app.Screens.MainMenuScreen;

public class Zelda extends Game{
    private Controller controller = new Controller();

    
    @Override
    public void create() {
        Gdx.input.setInputProcessor(controller);
        setScreen(new MainMenuScreen(this, controller));
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }
    
}
