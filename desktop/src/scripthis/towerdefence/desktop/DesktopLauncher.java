package scripthis.towerdefence.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import scripthis.towerdefence.TowerDefenceMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new TowerDefenceMain(), config);
		config.title = "Bloons Tower Defense - BDL, MDLAC, MC";
		config.resizable = false;
		config.height = 480;
		config.width = 640;
	}
}
