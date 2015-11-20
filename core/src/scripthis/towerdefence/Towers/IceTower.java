package scripthis.towerdefence.Towers;

import com.badlogic.gdx.math.Vector2;
import scripthis.towerdefence.model.Game;
import scripthis.towerdefence.model.ID;
import scripthis.towerdefence.Minions.Minion;

public class IceTower extends Tower {

    public IceTower(Vector2 position, Game game) {
        super(position, game);
        setVelocity(3f);
        setId(ID.IceTower);
    }

    @Override
    public void attack(Minion m) {
        m.specialDamage();
    }

    @Override
    public void update(float timedelta) {
        attackUpdate.updateMulti(timedelta/getVelocity());
    }
}
