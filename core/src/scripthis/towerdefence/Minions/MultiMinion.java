package scripthis.towerdefence.Minions;

import com.badlogic.gdx.math.Vector2;
import scripthis.towerdefence.Towers.Tower;
import scripthis.towerdefence.model.Game;

public class MultiMinion extends Minion{

    private int numMulti;

    public MultiMinion(int velocity, Game game, int num) {
        super(velocity, game);
        this.numMulti = num;
    }

    @Override
    public void damage(int damage, Tower tower) {
        hitpoints-= damage;
        if(hitpoints<= 0){
            if(numMulti != 0){
                //getGame().addMinion(new MultiMinion(this.getPosition().getCenter(new Vector2()), getGame(), numMulti-1));
            }else{
                isKilled(true);
            }
        }
    }
}
