package scripthis.towerdefence.ui;



import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.math.Vector2;
import scripthis.towerdefence.Towers.Tower;


public class UITowerEntity<T extends Tower> extends UIEntity<T> {

    public UITowerEntity(Texture texture, T model) {
        super(texture, model);
    }


    @Override
    public void draw(UIManager uiManager) {
        super.draw(uiManager);

        if(getModel().isAttacking()) {
            uiManager.getShapeRenderer().setColor(Color.RED);
        } else  {
            uiManager.getShapeRenderer().setColor(Color.YELLOW);
        }
        uiManager.getShapeRenderer().begin(ShapeRenderer.ShapeType.Line);
        Vector2 vect = getModel().getPosition().getCenter(new Vector2());
        uiManager.getShapeRenderer().circle(vect.x, vect.y, getModel().getRange());

        uiManager.getShapeRenderer().end();

    }
}
