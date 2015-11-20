package scripthis.towerdefence.Towers;

import com.badlogic.gdx.math.Vector2;
import scripthis.towerdefence.model.Game;
import scripthis.towerdefence.model.ID;
import scripthis.towerdefence.Minions.Minion;

/**
 * Created by brunodeluca on 11/17/15.
 */
public class CanonTower extends Tower {
    public CanonTower(Vector2 position, Game game) {
        super(position, game);
        setVelocity(4);
        setId(ID.IceTower);
    }

    @Override
    public void attack(Minion m) {
        m.damage(getDamage(), this);
    }

    @Override
    public void update(float timedelta) {
        attackUpdate.updateMulti(timedelta/getVelocity());
    }
}
