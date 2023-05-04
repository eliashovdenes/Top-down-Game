package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import inf112.skeleton.app.Southgame;
import inf112.skeleton.app.Controller.Controller;
import inf112.skeleton.app.Entities.Player.Player;
import inf112.skeleton.app.Mapfolder.Level1Mini;
import inf112.skeleton.app.Mapfolder.MapInterface;
import inf112.skeleton.app.Sound.SoundManager;

public class MainMenuScreen extends ScreenAdapter {

    private SpriteBatch batch;
    private Southgame game;
    private Controller controller;
    private SoundManager SM;
    MapInterface mapI;
    ShapeRenderer shape;
    Rectangle newGameRect, instructionsRect, quitRect, creditsRect;
    OrthographicCamera camera;
    private Texture background = new Texture(Gdx.files.internal("src/main/resources/assets/mainmenu.png"));
    private Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
    private DisplayMode disp = Lwjgl3ApplicationConfiguration.getDisplayMode();

    public MainMenuScreen(Southgame southGame, Controller controller) {
        this.game = southGame;
        this.controller = controller;
        batch = new SpriteBatch();
        this.SM = new SoundManager();
        SM.mainMenuMusic.play();
        this.shape = new ShapeRenderer();

        // creating rectangles based on app graphics

        float screenWidth = disp.width;
        float screenHeight = disp.height;

        newGameRect = new Rectangle(screenWidth / 22, screenHeight / 6, screenWidth / 6, screenHeight / 10);
        instructionsRect = new Rectangle(screenWidth / 4, screenHeight / 6, screenWidth / 4, screenHeight / 10);
        creditsRect = new Rectangle((float) (screenWidth / 1.8), screenHeight / 6, screenWidth / 6, screenHeight / 10);
        quitRect = new Rectangle((float) (screenWidth / 1.3), screenHeight / 6, screenWidth / 6, screenHeight / 10);

        // Create the camera and set its position to the center of the screen
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f, 0);
        camera.update();
    }

    @Override
    public void render(float delta) {

        // Clear the screen with a solid color
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, disp.width, (int) (disp.height * 0.9));
        batch.end();
        // shape.setColor(Color.RED);
        // shape.begin(ShapeRenderer.ShapeType.Filled);
        // shape.rect(newGameRect.x,newGameRect.y,newGameRect.width,newGameRect.height);
        // shape.rect(instructionsRect.x,instructionsRect.y,instructionsRect.width,instructionsRect.height);
        // shape.rect(creditsRect.x,creditsRect.y,creditsRect.width,creditsRect.height);
        // shape.rect(quitRect.x,quitRect.y,quitRect.width,quitRect.height);
        // shape.end();

        if (controller.getJustTouched()) {

            Vector3 menuClick = new Vector3(controller.getMenuClick(), 0);
            camera.unproject(menuClick);
            SM.buttonClick.play();

            if (newGameRect.contains(menuClick.x, menuClick.y)) {
                mapI = new Level1Mini(123, 76);
                game.setScreen(new View(game, controller, new Player(new Vector2(0, 0), mapI, controller)));
                SM.start.play();
                SM.mainMenuMusic.stop();
            }
            if (instructionsRect.contains(menuClick.x, menuClick.y)) {
                game.setScreen(new InstructionScreen(game, controller));
                SM.mainMenuMusic.stop();
            }

            if (creditsRect.contains(menuClick.x, menuClick.y)) {
                game.setScreen(new CreditScreen(game, controller));
                SM.mainMenuMusic.stop();
            }
            if (quitRect.contains(menuClick.x, menuClick.y)) {
                Gdx.app.exit();
            }
            controller.setJustTouched(false);

        }
    }

    @Override
    public void dispose() {

        batch.dispose();
    }
}