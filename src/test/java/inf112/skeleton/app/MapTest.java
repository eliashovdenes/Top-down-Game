package inf112.skeleton.app;

import org.junit.jupiter.api.*;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;
import inf112.skeleton.app.Entities.Enemies.BlueEnemy;
import inf112.skeleton.app.Entities.Enemies.MonsterInterface;
import inf112.skeleton.app.Entities.Enemies.RedEnemy;
import inf112.skeleton.app.Mapfolder.TestMap;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;


public class MapTest {

    @Test
    public void testMonsterList() {
        TestMap testMap = new TestMap();
        
        // Create expectedList
        ArrayList<MonsterInterface> expectedList = new ArrayList<>();
        expectedList.add(new RedEnemy());
        expectedList.add(new RedEnemy());
        expectedList.add(new RedEnemy());
        expectedList.add(new BlueEnemy());

        // Assert that the spawn method created the right monsters
        assertEquals(expectedList, testMap.getMonsterList());
        
    }

}
    
    