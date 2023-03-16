package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;




public class Map extends TiledMap{

    

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    float toX,fromX,toY,fromY,startX,startY;
    public Map(String string,int enemies){

        map = new TmxMapLoader().load(string);
        renderer = new OrthogonalTiledMapRenderer(map);

    }
        public void changeMap(String mapFilename, int playerX, int playerY, int fromX, int toX, int fromY, int toY, int amountOfEnemies, Player player) {

        // Sets bounds for where enemies can spawn
        this.toX = toX;
        this.fromX = fromX;
        this.toY = toY;
        this.fromY = fromY;

        startX = playerX;
        startY = playerY;

        // Load the new map from file
        Map newMappie = new Map("",0);
        TmxMapLoader mapLoader = new TmxMapLoader();
        TiledMap newMap = mapLoader.load(mapFilename);
        player.setX(playerX*16);
        player.setY(playerY*16);

        // generates new enemies according to the new map rules.
        
        //generateEnemies(amountOfEnemies, newMap);
    
        // Create a new instance of Player with the new map
        player.setmap(newMap);
        
        // Player newPlayer = new Player(new Sprite(new Texture(PlayerPics.DOWN.source)), playerX*16, playerY*16, ID.Player, this.controller, newMap,this, PlayerPics.DOWN.source);

        // Dispose of the old instance of Player
        // player.getTexture().dispose();
        map.dispose();
    
        //Change the local values of map and player to the new ones
        this.map = newMap;
        // this.player = newPlayer;


        //render the new map 
        renderer.setMap(map);
    }
}
