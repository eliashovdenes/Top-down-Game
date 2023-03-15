package inf112.skeleton.app;

import org.junit.jupiter.api.*;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TideMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {


    
    private static OrthographicCamera camera;
    private static TiledMapRenderer renderer;

    private HeadlessApplication app;
    private Player player;
    private Controller controller;
    private View view;
    TmxMapLoader mapLoader;
    TiledMap map; 

    public void setup() {
        
        // Create a HeadlessApplication with the mock Application object
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        app = new HeadlessApplication(new Zelda(), config);
        Gdx.gl = mock(GL20.class);
        Gdx.gl20 = mock(GL20.class);
        //Gdx.graphics = mock(Graphics.class);
        
        //controller = new Controller();
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("src/main/java/inf112/skeleton/app/assets/Level 1.tmx");

        player = new Player(new Sprite(new Texture(PlayerPics.DOWN.source)), 12*16, 25*16, ID.Player, this.controller, map, view, PlayerPics.DOWN.source);
        
    }

   
    @Test
    public void testLoadObject(){

        MapObject playerObject = map.getLayers().get("objects").getObjects().get("player");
        //sjekk at den har forventede egenskaper
        assertEquals("player",playerObject.getName());
        //assertEquals(andre egenskaper)

    }

    
    @Test
    public void testRenderTile() {
        camera.setToOrtho(false,800,700);
        renderer.setView(camera);
        renderer.renderTileLayer((TiledMapTileLayer) map.getLayers().get(0));
        int tileWidth = ((TiledMapTileLayer) map.getLayers().get(0)).getTileWidth();
        int tileHeight = ((TiledMapTileLayer) map.getLayers().get(0)).getTileHeight();
        int expX = 1* tileWidth;
        int expY = 1* tileHeight;

        boolean isTileRendered = false;
        
        //går igjennomhvert layer og sjekker om cellen
        //helt nede til venstre (1,1) render riktig i hvert layer i map.
        for (MapLayer layer : map.getLayers()){
            if (layer instanceof TiledMapTileLayer){
                TiledMapTileLayer tileLayer = (TiledMapTileLayer) layer;
                TiledMapTile tile = tileLayer.getCell(1,1).getTile();

                if (tile != null && tile.getTextureRegion().getRegionX() == expX && tile.getTextureRegion().getRegionY() == expY) {
                                     
                                    isTileRendered = true;
                                    break;
                        }
                }

            }assertTrue(isTileRendered);
        }
        
        
}
    
    