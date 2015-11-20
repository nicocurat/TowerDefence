package scripthis.towerdefence.Towers;

import com.badlogic.gdx.math.Vector2;
import scripthis.towerdefence.model.Entity;
import scripthis.towerdefence.model.Game;
import scripthis.towerdefence.model.ID;
import scripthis.towerdefence.Minions.Minion;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public abstract class Tower extends Entity{

    private Vector2 position;
    private float WIDTH, HEIGHT, delay;
    private int cost;
    private ID id;

    protected LinkedList<Minion> target;
    protected int damage;
    protected AttackUpdate attackUpdate;
    protected float velocity, range, timer;

    public Tower(Vector2 position, Game game){
        super(game);
        this.position = position;
        getPosition().setCenter(position);
        setHEIGHT(32f);
        setWIDTH(32f);
        setDelay(1);
        setDamage(2);
        setCost(100);
        setRange(100);
        setTimer(0);
        getPosition().setWidth(getWIDTH());
        getPosition().setHeight(getHEIGHT());
        attackUpdate = new AttackUpdate(this);
    }

    public Vector2 getTowerPosition(){return this.position;}

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public float getDelay() {
        return delay;
    }

    public void setDelay(float delay) {
        this.delay = delay;
    }

    public float getTimer() {
        return timer;
    }

    public void setTimer(float timer) {
        this.timer = timer;
    }

    public float getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(float WIDTH) {
        this.WIDTH = WIDTH;
    }

    public float getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(float HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public LinkedList<Minion> getTarget() {
        return target;
    }

    public Minion getTarget(int position){
        if(!getTarget().isEmpty())
            return getTarget().get(position);
        throw new NoSuchElementException("There is no target");
    }

    public void setTarget(LinkedList<Minion> target) {
        this.target = target;
    }

    public boolean isAttacking(){
        return !target.isEmpty() && !target.get(0).isKilled();
    }

    public abstract void attack(Minion m);

    public void attack(LinkedList<Minion> minions){
        for(Minion m: minions){
            attack(m);
            if(m.isKilled()){
                getGame().addMoney(1);
            }
        }
    }

    @Override
    public abstract void update(float timedelta);
}
