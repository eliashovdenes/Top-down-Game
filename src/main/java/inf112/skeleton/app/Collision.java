package inf112.skeleton.app;

import javax.swing.text.html.parser.Entity;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Collision {


    private boolean housePortal = false, level2 = false;
    
    private TiledMap map;
    public TiledMap getMap() {
        return map;
    }

    public void setMap(TiledMap map) {
        this.map = map;
    }


    private GameObject entity;

    private float tileWidth;
    private float tileHeight;
    private View view;

    public Collision(TiledMap map, GameObject entity, View view) {
        this.view = view;
        this.map = map;
        this.entity = entity;
        tileWidth = ((TiledMapTileLayer) map.getLayers().get(0)).getTileWidth();
        tileHeight = ((TiledMapTileLayer) map.getLayers().get(0)).getTileWidth();
    }

    public boolean chechXDirection(float velX, float oldX) {
        boolean collisionX = false;

        
        // when moving to the left
        if (velX < 0) {
            // top left tile
            collisionX = checkCollisionWith((int) (entity.getX() / tileWidth), (int) ((entity.getY() + entity.getHeight() / 1.5) / tileHeight));

            // middle left tile
            if (!collisionX)
                collisionX = checkCollisionWith((int) (entity.getX() / tileWidth), (int) ((entity.getY() + entity.getHeight() / 2) / tileHeight));

            // bottom left tile
            if (!collisionX)
                collisionX = checkCollisionWith((int) (entity.getX() / tileWidth), (int) ((entity.getY() + entity.getHeight() / 5) / tileHeight));

            
        }

        // when moving to the right
        else if (velX > 0) {
            // top right tile
            collisionX = checkCollisionWith((int) ((entity.getX() + entity.getWidth()) / tileWidth), (int) ((entity.getY() + entity.getHeight() / 1.5) / tileHeight));

            //middle right tile
            if (!collisionX)
                collisionX = checkCollisionWith((int) ((entity.getX() + entity.getWidth()) / tileWidth), (int) ((entity.getY() + entity.getHeight() / 2) / tileHeight));

            //bottom right
            if (!collisionX)
                collisionX = checkCollisionWith((int) ((entity.getX() + entity.getWidth()) / tileWidth), (int) ((entity.getY() + entity.getHeight() / 4) / tileHeight));
            }


            if (collisionX) return true;
            return false;
        
    }

    public boolean chechYDirection(float velY, float oldY) { 
        boolean collisionY = false;

        // when moving downwards
        if (velY < 0) {

            // bottom left
            collisionY = checkCollisionWith((int) ((entity.getX() + entity.getWidth() / 4) / tileWidth), (int) (entity.getY() / tileHeight));

            // bottom middle
            if (!collisionY)
                collisionY = checkCollisionWith((int) ((entity.getX() + entity.getWidth() / 2) / tileWidth), (int) (entity.getY() / tileHeight));

            //bottom right
            if (!collisionY)
                collisionY =  checkCollisionWith((int) ((entity.getX() + entity.getWidth() / 1.5) / tileWidth), (int) (entity.getY() / tileHeight));
        }

        // moving upwards
        else if (velY > 0) {

            // top left
            collisionY = checkCollisionWith((int) ((entity.getX() + entity.getWidth() / 4) / tileWidth), (int) ((entity.getY() + entity.getHeight()) / tileHeight));

            //top middle
            if (!collisionY)
                collisionY = checkCollisionWith((int) ((entity.getX() + entity.getWidth() / 2) / tileWidth), (int) ((entity.getY() + entity.getHeight()) / tileHeight));

            //top right
            if (!collisionY)
                collisionY = checkCollisionWith((int) ((entity.getX() + entity.getWidth() / 1.5) / tileWidth), (int) ((entity.getY() + entity.getHeight()) / tileHeight));


        }


        //House portal
        if (housePortal){
            entity.setOldXNdY(18*16, 42*16);
            view.changeMap(Maps.House.source, 18, 42, 13, 30, 42, 54, 1);
            housePortal = false;
            
        }


        //Level 2 portal
        if (level2){
            entity.setOldXNdY(12*16, 23*16);
            view.changeMap(Maps.Level2.source, 12, 23, 23, 40, (45-31), (45-12), 4); 
            level2 = false;
            

            
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
                if (entity.getId() == ID.Player) {
                if (layer.getCell((int) xpos, (int) ypos).getTile().getProperties().containsKey("portal")) { 
                    // System.out.println("portal tile");
                    
                    if (layer.getCell((int) xpos, (int) ypos).getTile().getProperties().containsKey("house")) {
                        // System.out.println("house portal");
                        housePortal = true;
                        return false;
                    }

                    if (layer.getCell((int) xpos, (int) ypos).getTile().getProperties().containsKey("level2")) {
                        // System.out.println("level2");
                        level2 = true;
                        return false;
                    }

                    
            
                }
            }
            
                if (layer.getCell((int) xpos, (int) ypos).getTile().getProperties().containsKey("blocked")) { 
                    
                    return true;
                    
                }
            } catch (Exception e) {
                continue;
            }
        }
        return false;
    }



   
}
