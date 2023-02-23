package inf112.skeleton.app.Game;

import inf112.skeleton.app.Input.UserInput;
import inf112.skeleton.app.Game.Entities.Entities.Player;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class SouthGame implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;
    private Player player;
    private int num;
/*
 * The GameWorld class will represent the game world and contain all of the objects that exist in it. 
 * It will have methods for rendering the world, updating the state of the world, and handling events.
 */
    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);
        player = new Player();
        
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render() {

        num = UserInput.returnKeyPressed();
        //tror denne switch-greien gjør at den kun reagerer på 1 input av gangen (man kan ikke gå skrått).
        //vet ikke om man skal drite i å ha en egen input-klasse også bare ha alt her inne..
        switch (num) {
            case 1:
                player.setY(player.y+1);
                break;
            case 2:
                player.setX(player.x-1);
                break;
            case 3:
                player.setX(player.x+1);
                break;
            case 4:
                player.setY(player.y-1);
                break;
            
        }
        
        // tok meg lang tid å skjønne at disse 2 linjene under må kalles før alt annet tegnes
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        player.playerBatch.begin();
        player.playerBatch.draw(player.playerTexture,player.x,player.y, 25,25,50,50,1,1,player.playerRotation,0,0,260,260,false,false);
        player.playerBatch.end();

        
        batch.begin();
        font.draw(batch, "Hello World", 200, 200);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}


