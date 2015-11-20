package scripthis.towerdefence;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;
import scripthis.towerdefence.Minions.Minion;
import scripthis.towerdefence.model.*;
import scripthis.towerdefence.ui.UIManager;

import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TowerDefenceMain extends ApplicationAdapter {

	private Game game;
	private UIManager uiManager;
	private long lastBalloonTime;
	private LinkedList<Minion> level;
	private	int i = 0;

	@Override
	public void create () {
		uiManager = new UIManager();
		game = new Game();
		game.addGameListeners(uiManager);
	}

	@Override
	public void render () {
		game.init();
		game.update(Gdx.graphics);
		uiManager.draw(game.getWave().getLevel()+1, game.getLives(), game.getMoney());
	}
}
