package inf112.skeleton.app.Input;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Gdx;


public class UserInput {

    //Hei kjekken
    


    public static int returnKeyPressed(){
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            return 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            return 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            return 3;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            return 4;
        }
        else {return 0;}
    }
    
}
