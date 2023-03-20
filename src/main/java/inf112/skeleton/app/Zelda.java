package inf112.skeleton.app;

import com.badlogic.gdx.Game;

import inf112.skeleton.app.Screens.MainMenuScreen;

public class Zelda extends Game{

    
    @Override
    public void create() {
        setScreen(new MainMenuScreen(this));
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
