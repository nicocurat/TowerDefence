package scripthis.towerdefence.Towers;

import com.badlogic.gdx.math.Vector2;
import scripthis.towerdefence.model.Game;
import scripthis.towerdefence.model.ID;
import scripthis.towerdefence.Minions.Minion;


public class SimpleTower extends Tower {

    public SimpleTower(Vector2 position, Game game) {
        super(position, game);
        setVelocity(1/1.11f);
        setId(ID.SimpleTower);
    }

    @Override
    public void attack(Minion m) {
        m.damage(damage, this);
    }


    @Override
    public void update(float timedelta) {
        attackUpdate.updateIndividual(timedelta/getVelocity());
    }

}
