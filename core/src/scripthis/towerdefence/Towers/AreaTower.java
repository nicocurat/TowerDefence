package scripthis.towerdefence.Towers;

import com.badlogic.gdx.math.Vector2;
import scripthis.towerdefence.model.Game;
import scripthis.towerdefence.model.ID;
import scripthis.towerdefence.Minions.Minion;

public class AreaTower extends Tower {

    public AreaTower(Vector2 center, Game game){
        super(center, game);
        setVelocity(1f);
        setId(ID.AreaTower);
    }

    @Override
    public void attack(Minion m) {
        m.damage(getDamage(), this);
    }

    public void update(float timedelta) {
        attackUpdate.updateMulti(timedelta/getVelocity());
    }

}

