package scripthis.towerdefence.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import scripthis.towerdefence.Minions.Minion;
import scripthis.towerdefence.Towers.Tower;
import scripthis.towerdefence.model.*;

import java.util.HashMap;


public class UIManager implements GameListener{

    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private Texture towerTexture;
    private Texture AreaTower;
    private Texture minionTexture;
    private Texture minionGreen;
    private Texture minionBlue;
    private Texture background;
    private final Vector2 boundaries = new Vector2(600, 400);
    private HashMap<Entity, UIEntity> entities = new HashMap<Entity, UIEntity>();

    private OrthographicCamera camera;

    public Vector2 getBoundaries() {
        return this.boundaries;
    }
    public UIManager() {
        background = new Texture("assets/background.png");
        towerTexture = new Texture("assets/tower_.png");
        AreaTower = new Texture("assets/AreaTower.png");
        minionGreen = new Texture("assets/globo_green.png");
        minionBlue = new Texture("assets/globo_blue.png");
        minionTexture = new Texture("assets/globo.png");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, boundaries.x, boundaries.y);
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();


    }

    public void draw(String text){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen.
        camera.update();
        //batch.setProjectionMatrix(camera.combined);

//        batch.begin();
//        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        batch.end();
        BitmapFont font = new BitmapFont();
        batch.begin();
        font.draw(batch,text, 260,300);
        batch.end();

//        for(UIEntity uiEntity: entities.values()) {
//            uiEntity.draw(this);
//        }
    }

    public void draw(int level, int lives, int money) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen.
        camera.update();
        //batch.setProjectionMatrix(camera.combined);


        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        BitmapFont font = new BitmapFont();
        batch.begin();
        font.draw(batch,"Level" + " " + level, 520,440);
        font.draw(batch, "Lives:" + " " + lives, 520, 420);
        font.draw(batch, "Money:" + " $" + money, 520, 400);
        batch.end();

        for(UIEntity uiEntity: entities.values()) {
            uiEntity.draw(this);
        }
    }

    @Override
    public void minionKilled(Minion minion) {
        entities.remove(minion);
    }

    @Override
    public void towerAdded(Tower tower) {
        if(tower.getId() == ID.AreaTower){
            entities.put(tower, new UITowerEntity<Tower>(AreaTower, tower));
        }else if(tower.getId() == ID.SimpleTower){
            entities.put(tower, new UITowerEntity<Tower>(towerTexture, tower));
        }else{
            entities.put(tower, new UITowerEntity<Tower>(towerTexture, tower));
        }
    }

    @Override
    public void minionAdded(Minion minion) {
        entities.put(minion, new UIEntity<Minion>(minionTexture, minion));
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }

}
