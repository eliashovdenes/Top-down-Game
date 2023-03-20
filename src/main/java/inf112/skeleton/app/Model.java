package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;

import inf112.skeleton.app.Mapfolder.Cave;
import inf112.skeleton.app.Mapfolder.House;
import inf112.skeleton.app.Mapfolder.Level2;
import inf112.skeleton.app.Mapfolder.MapInterface;

public class Model {

    private Collision collision;
    private MapInterface currMap;

    

    public MapInterface changeMap(){

        if (collision.cave){
            currMap = new Cave();
        }
        if (collision.level2){
            currMap = new Level2();
        }
        if (collision.housePortal){
            currMap = new House();
        }
        return currMap;
    }

    public MapInterface getCurrMap(){
        return currMap;
    }
    
}

