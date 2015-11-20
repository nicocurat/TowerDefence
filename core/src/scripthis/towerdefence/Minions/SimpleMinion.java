package scripthis.towerdefence.Minions;

import scripthis.towerdefence.Towers.Tower;
import scripthis.towerdefence.model.Game;
import scripthis.towerdefence.model.ID;


public class SimpleMinion extends Minion{

    public SimpleMinion(int velocity, Game game) {
        super(velocity, game);
        setVelocity(velocity);
        setHitpoints(5);
        setID(ID.SimpleMinion);
    }

    @Override
    public void damage(int damage, Tower tower) {
        ID id = tower.getId();

        if(id == ID.ElectricTower){
            hitpoints-= damage/2;
        }else{
            hitpoints-= damage;
        }

        if(hitpoints<= 0){
            isKilled(true);
        }
    }
}
