package scripthis.towerdefence.model;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import scripthis.towerdefence.Towers.*;

public class InputManager implements InputProcessor {

    private Game game;

    public InputManager(Game game) {
        Gdx.input.setInputProcessor(this);
        this.game = game;
    }

    @Override
    public boolean keyDown(int keycode) {
        Store store = game.getStore();
        try{
            switch (keycode){
                case Input.Keys.A:
                    store.selectTower(new SimpleTower(new Vector2(0,0), game));
                    break;
                case Input.Keys.S:
                    store.selectTower(new AreaTower(new Vector2(0,0), game));
                    break;
                case Input.Keys.D:
                    store.selectTower(new IceTower(new Vector2(0,0), game));
                    break;
                case Input.Keys.F:
                    store.selectTower(new ElectricTower(new Vector2(0,0), game));
                    break;
                case Input.Keys.R:
                    game.runGame();
                    break;
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        try{
            int y = 480 - screenY;
            Tower boughtTower = game.getStore().buyTower();
            boughtTower.getPosition().setCenter(screenX, y);
            game.addTower(boughtTower);
            game.getStore().towerSelected = null;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        int y = 480 - screenY;
        if(game.getStore().towerSelected != null){
            Tower t =  game.getStore().towerSelected;
            t.getPosition().setCenter(screenX, y);
            game.addTower(t);
        }
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
