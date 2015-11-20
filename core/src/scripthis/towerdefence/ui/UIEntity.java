package scripthis.towerdefence.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.*;
import scripthis.towerdefence.model.Entity;


/**
 * Created by anizzomc on 2015-10-26.
 */
public class UIEntity<T extends Entity> {

    private T model;
    private Texture texture;
    private Rectangle r;

    public UIEntity(Texture texture, T model){
        this.model = model;
        this.texture = texture;
        this.r = getModel().getPosition();
    }

    public Rectangle getR(){return this.r;}

    public void draw(UIManager uiManager) {


        uiManager.getBatch().begin();
        uiManager.getBatch().draw(texture, r.x, r.y, r.getWidth(), r.getHeight());
        uiManager.getBatch().end();

        uiManager.getShapeRenderer().setColor(Color.YELLOW);
        uiManager.getShapeRenderer().begin(ShapeRenderer.ShapeType.Line);
        uiManager.getShapeRenderer().rect(r.x, r.y, r.getWidth(), r.getHeight());
        uiManager.getShapeRenderer().end();
    }

    public T getModel() {
        return model;
    }


}
