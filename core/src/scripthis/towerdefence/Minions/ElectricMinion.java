package scripthis.towerdefence.Minions;

import scripthis.towerdefence.Towers.Tower;
import scripthis.towerdefence.model.Game;
import scripthis.towerdefence.model.ID;

/**
 * Created by brunodeluca on 11/17/15.
 */
public class ElectricMinion extends Minion{


    public ElectricMinion(int velocity, Game game) {
        super(velocity, game);
        setVelocity(velocity);
        setHitpoints(5);
        setID(ID.ElectricMinion);
    }

    @Override
    public void damage(int damage, Tower tower) {
        ID id = tower.getId();

        if(id == ID.ElectricTower){
            hitpoints-= damage;
        }else {
            hitpoints -= damage / 2;
        }

        if(hitpoints<= 0){
            isKilled(true);
        }
    }
}
