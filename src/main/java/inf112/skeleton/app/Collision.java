package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Collision {
    
    private TiledMap map;
    private Player player;
    private float tileWidth;
    private float tileHeight;

    public Collision(TiledMap map, Player player) {
        this.map = map;
        this.player = player;
        tileWidth = ((TiledMapTileLayer) map.getLayers().get(0)).getTileWidth();
        tileHeight = ((TiledMapTileLayer) map.getLayers().get(0)).getTileWidth();
    }

    public boolean chechXDirection(float velX, float oldX) {
        boolean collisionX = false;
        // when moving to the left
        if (velX < 0) {
            // top left tile
            collisionX = checkCollisionWith((int) (player.getX() / tileWidth), (int) ((player.getY() + player.getHeight() / 1.5) / tileHeight));

            // middle left tile
            if (!collisionX)
                collisionX = checkCollisionWith((int) (player.getX() / tileWidth), (int) ((player.getY() + player.getHeight() / 2) / tileHeight));

            // bottom left tile
            if (!collisionX)
                collisionX = checkCollisionWith((int) (player.getX() / tileWidth), (int) ((player.getY() + player.getHeight() / 5) / tileHeight));
        }

        // when moving to the right
        else if (velX > 0) {
            // top right tile
            collisionX = checkCollisionWith((int) ((player.getX() + player.getWidth()) / tileWidth), (int) ((player.getY() + player.getHeight() / 1.5) / tileHeight));

            //middle right tile
            if (!collisionX)
                collisionX = checkCollisionWith((int) ((player.getX() + player.getWidth()) / tileWidth), (int) ((player.getY() + player.getHeight() / 2) / tileHeight));

            //bottom right
            if (!collisionX)
                collisionX = checkCollisionWith((int) ((player.getX() + player.getWidth()) / tileWidth), (int) ((player.getY() + player.getHeight() / 4) / tileHeight));
            }

            if (collisionX) return true;
            return false;
        
    }

    public boolean chechYDirection(float velY, float oldY) { 
        boolean collisionY = false;

        // when moving downwards
        if (velY < 0) {

            // bottom left
            collisionY = checkCollisionWith((int) ((player.getX() + player.getWidth() / 4) / tileWidth), (int) (player.getY() / tileHeight));

            // bottom middle
            if (!collisionY)
                collisionY = checkCollisionWith((int) ((player.getX() + player.getWidth() / 2) / tileWidth), (int) (player.getY() / tileHeight));

            //bottom right
            if (!collisionY)
                collisionY =  checkCollisionWith((int) ((player.getX() + player.getWidth() / 1.5) / tileWidth), (int) (player.getY() / tileHeight));
        }

        // moving upwards
        else if (velY > 0) {

            // top left
            collisionY = checkCollisionWith((int) ((player.getX() + player.getWidth() / 4) / tileWidth), (int) ((player.getY() + player.getHeight()) / tileHeight));

            //top middle
            if (!collisionY)
                collisionY = checkCollisionWith((int) ((player.getX() + player.getWidth() / 2) / tileWidth), (int) ((player.getY() + player.getHeight()) / tileHeight));

            //top right
            if (!collisionY)
                collisionY = checkCollisionWith((int) ((player.getX() + player.getWidth() / 1.5) / tileWidth), (int) ((player.getY() + player.getHeight()) / tileHeight));


        }

        if (collisionY) return true;

            return false;

    }
    
   
    public boolean checkCollisionWith(int xpos, int ypos) {
        int size = map.getLayers().size();

        for (int i = 0; i < size; i++) {
            TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(i);
            // System.out.println(layer);
            
            try {
                if (layer.getCell((int) xpos, (int) ypos).getTile().getProperties().containsKey("blocked")) { 
                    System.out.println("blocked tile");
                    return true;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return false;
    }



   
}
