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
import com.badlogic.gdx.math.Vector3;

import inf112.skeleton.app.Southgame;
import inf112.skeleton.app.Controller.Controller;
import inf112.skeleton.app.Entities.Player.PlayerInterface;

public class Shop extends ScreenAdapter {

    private SpriteBatch batch;
    private Southgame game;
    private BitmapFont font;
    private Controller controller;
    private PlayerInterface playerI;
    private ShapeRenderer shape;
    Rectangle upgradeArrowRect, upgradeLightningRect, upgradePlayerHealthRect, upgradeMovementSpeed;
    OrthographicCamera camera;
    Rectangle newGameRect, instructionsRect, quitRect, creditsRect;
    private Texture background = new Texture(Gdx.files.internal("src/main/resources/assets/shop.png"));
    private Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
    private DisplayMode disp = Lwjgl3ApplicationConfiguration.getDisplayMode();

    private float upgradeCooldown = 0.5f;
    private float timeSinceUpgrade = 0;
    private float screenWidth = disp.width;
    private float screenHeight = disp.height;

    public Shop(Southgame southGame, Controller controller, PlayerInterface playerI) {
        this.game = southGame;
        this.controller = controller;
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.playerI = playerI;

        upgradeArrowRect = new Rectangle(screenWidth / 22, screenHeight / 6, screenWidth / 6, screenHeight / 6);
        upgradeLightningRect = new Rectangle(screenWidth / 3.5f, screenHeight / 6, screenWidth / 5, screenHeight / 6);
        upgradePlayerHealthRect = new Rectangle(screenWidth / 1.9f, screenHeight / 6, screenWidth / 5,
                screenHeight / 6);
        upgradeMovementSpeed = new Rectangle(screenWidth / 1.3f, screenHeight / 6, screenWidth / 5, screenHeight / 6);
        this.shape = new ShapeRenderer();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f, 0);
        camera.update();
    }

    @Override
    public void render(float delta) {
        // Clear the screen with a solid color
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // draw boxes

        // Draw the title
        batch.begin();
        batch.draw(background, 0, 0, disp.width, (int) (disp.height * 0.9));
        font.getData().setScale(3);
        font.setColor(Color.BLACK);
        font.draw(batch, "" + playerI.getAbilityPoints() + "", (float) (screenWidth / 3.95),
                (float) (screenHeight / 1.375));

        // draw text on buttons
        font.getData().setScale(2.5f);
        font.draw(batch, "" + playerI.getArrowAbilityLevel() + "", upgradeArrowRect.x + upgradeArrowRect.width / 1.2f,
                upgradeArrowRect.y + upgradeArrowRect.height / 4);
        font.draw(batch, "" + playerI.getLightningAbilityLevel() + "",
                upgradeLightningRect.x + upgradeLightningRect.width / 1.4f,
                upgradeLightningRect.y + upgradeLightningRect.height / 4);
        font.draw(batch, "" + playerI.getHealthAbilityLevel() + "",
                upgradePlayerHealthRect.x + upgradePlayerHealthRect.width / 1.3f,
                upgradePlayerHealthRect.y + upgradePlayerHealthRect.height / 4);
        font.draw(batch, "" + playerI.getMovementAbilityLevel() + "",
                upgradeMovementSpeed.x + upgradeMovementSpeed.width / 1.23f,
                upgradeMovementSpeed.y + upgradeMovementSpeed.height / 4);
        batch.end();

        timeSinceUpgrade += delta;

        if (!controller.isShop()) {
            game.setScreen(new View(game, controller, playerI, 0, 0));
        }
        if (controller.getJustTouched()) {

            Vector3 hei = new Vector3(controller.getMenuClick(), 0);
            camera.unproject(hei);

            if (upgradeArrowRect.contains(hei.x, hei.y) && playerI.getAbilityPoints() > 0
                    && timeSinceUpgrade >= upgradeCooldown) {
                playerI.upgradeArrow();
                playerI.removeAbilityPoints();
                timeSinceUpgrade = 0;
            }
            if (upgradeLightningRect.contains(hei.x, hei.y) && playerI.getAbilityPoints() >= 3
                    && timeSinceUpgrade >= upgradeCooldown) {
                playerI.upgradeLightning();
                for (int i = 0; i < 3; i++) {
                    playerI.removeAbilityPoints();
                }
                timeSinceUpgrade = 0;
            }
            if (upgradePlayerHealthRect.contains(hei.x, hei.y) && playerI.getAbilityPoints() >= 5
                    && timeSinceUpgrade >= upgradeCooldown) {
                playerI.upgradeHealth();
                for (int i = 0; i < 5; i++) {
                    playerI.removeAbilityPoints();
                }
                timeSinceUpgrade = 0;
            }
            if (upgradeMovementSpeed.contains(hei.x, hei.y) && playerI.getAbilityPoints() >= 10
                    && timeSinceUpgrade >= upgradeCooldown) {
                playerI.upgradeMovement();
                for (int i = 0; i < 10; i++) {
                    playerI.removeAbilityPoints();
                }
                timeSinceUpgrade = 0;
            }

        }
    }

    @Override
    public void dispose() {

        batch.dispose();
    }
}
