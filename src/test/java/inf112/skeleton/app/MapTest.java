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
    private static TiledMap map;
    private static OrthographicCamera camera;
    private static TiledMapRenderer renderer;
    @BeforeAll
    static void setUpbeforeAll(){
    //greier ikke laste inn map..    
    map = new TideMapLoader().load("TOP-DOWN-SQUAD/src/main/java/inf112/skeleton/app/assets/mapet.tmx");
    camera = new OrthographicCamera();
    renderer = new OrthogonalTiledMapRenderer(map);
}
    
    @Test
    public void testRenderTile() {
        camera.setToOrtho(false,800,700);
        renderer.setView(camera);
        renderer.renderTileLayer((TiledMapTileLayer) map.getLayers().get(0));
        int tileWidth = ((TiledMapTileLayer) map.getLayers().get(0)).getTileWidth();
        int tileHeight = ((TiledMapTileLayer) map.getLayers().get(0)).getTileHeight();
        int expectedX = 1* tileWidth;
        int expectedY = 1* tileHeight;

        boolean isTileRendered = false;
        
        for (MapLayer layer : map.getLayers()){
            if (layer instanceof TiledMapTileLayer){
                TiledMapTileLayer tileLayer = (TiledMapTileLayer) layer;
                TiledMapTile tile = tileLayer.getCell(1,1).getTile();

                if (tile != null && tile.getTextureRegion().getRegionX() == expectedX && tile.getTextureRegion().getRegionY() == expectedY) {
                                     
                                    isTileRendered = true;
                                    break;
                        }
                }

            }assertTrue(isTileRendered);
        }   
        

        @Test
        public void testLoadObject(){

            MapObject playerObject = map.getLayers().get("objects").getObjects().get("player");
            //sjekk at den har forventede egenskaper
            assertEquals("player",playerObject.getName());
            //assertEquals(andre egenskaper)

        }
        
}