package scripthis.towerdefence.Minions;

import com.badlogic.gdx.utils.TimeUtils;
import scripthis.towerdefence.Point2D.Point;
import scripthis.towerdefence.Towers.Tower;
import scripthis.towerdefence.model.Entity;
import scripthis.towerdefence.model.Game;
import scripthis.towerdefence.model.Road;

import java.util.LinkedList;

public abstract class Minion extends Entity {

    private boolean killed = false, isBeingDamaged, finishedRoad = false;
    private int velocity; //distintas velocidades
    protected long lastFrozenTime;
    private int partialVelocity;
    private final static float WIDTH = 35;
    private final static float HEIGHT = 47;
    protected int hitpoints; //distintos hitpoints
    private int i = 0;
    private SpecialDamage specialDamage;
    private Point currentPosition;

    public Minion(int velocity, Game game){
        super(game);
        setPartialVelocity(velocity);
        getPosition().setHeight(HEIGHT);
        getPosition().setWidth(WIDTH);
        getPosition().setCenter(getRoad(0).getX(), getRoad(0).getY());
        specialDamage = new SpecialDamage(this);
    }

    @Override
    public void update(float timedelta) {
        if(i < getRoadList().size() - 1){
            Point p = getRoadList().get(i = i + velocity);
            currentPosition = p;
            getPosition().setCenter((float) p.getX(),(float) p.getY());
        }
        if(getCurrentPosition().getDistance(getRoad().getFinishLine()) > 0){
            finishedRoad = true;
        }

        if(isBeingDamaged()){
            specialDamage.froze();
            if(TimeUtils.millis() - lastFrozenTime > 2000){
                specialDamage.unFroze();
            }
        }
    }
    public boolean finishedRoad(){return this.finishedRoad;}

    public Point getCurrentPosition(){return this.currentPosition;}

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public int getPartialVelocity() {
        return partialVelocity;
    }

    public void setPartialVelocity(int partialVelocity) {
        this.partialVelocity = partialVelocity;
    }

    public void isBeingDamaged(boolean damaged){
        this.isBeingDamaged = damaged;
    }

    public boolean isBeingDamaged(){
        return isBeingDamaged;
    }

    public void specialDamage(){
        isBeingDamaged = true;
        lastFrozenTime = TimeUtils.millis();
    }

    public LinkedList<Point> getRoadList(){
        return super.getGame().getRoad().getList();
    }
    public Road getRoad(){return super.getGame().getRoad();}

    public Point getRoad(int i){
        return super.getGame().getRoad().getList().get(i);
    }

    public void isKilled(boolean k){this.killed = k;}

    public boolean isKilled() {
        return killed;
    }

    public abstract void damage(int damage, Tower tower);

    public int getHitpoints(){return this.hitpoints;}

    public int getVelocity(){
        return this.velocity;
    }

    public void setVelocity(int vel){this.velocity = vel;}

}
