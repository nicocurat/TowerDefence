package scripthis.towerdefence.model;

import scripthis.towerdefence.Minions.Minion;
import scripthis.towerdefence.Towers.Tower;

/**
 * Created by anizzomc on 2015-10-29.
 */
public interface GameListener {

    public void minionKilled(Minion minion);

    public void towerAdded(Tower tower);

    public void minionAdded(Minion minion);
}
