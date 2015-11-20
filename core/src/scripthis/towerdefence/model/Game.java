package scripthis.towerdefence.model;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.math.Vector2;
import scripthis.towerdefence.Minions.Minion;
import scripthis.towerdefence.Towers.SimpleTower;
import scripthis.towerdefence.Towers.Tower;
import scripthis.towerdefence.ui.UIManager;

import java.util.*;


public class Game{
    private Collection<Tower> towers = new HashSet<Tower>();
    private LinkedList<Minion> minions = new LinkedList<Minion>();
    private LinkedList<UIManager> listeners = new LinkedList<UIManager>();
    private Collection<Minion> deadMinion = new HashSet<Minion>();
    private Road road;
    private int lives, deads, endBalloon = 0, level = 2;
    protected int money, score;
    private Wave wave;
    private boolean waveHasEnded = false;
    private InputManager inputManager;
    private Store store;
    private boolean pause = true;
    private Streams streams;

    public Game() {
        this.road = new Road();
        this.streams =new Streams(this);
        this.lives = 20;
        this.money = 450;
        this.score = 0;
        this.wave = new Wave(this);
        this.deads = 0;
        this.inputManager = new InputManager(this);
        this.store = new Store(this, true);
    }

    public Wave getWave(){return this.wave;}

    public Store getStore() {
        return store;
    }

    public int getDeads(){return this.deads;}

    public int getLevel(){return this.level;}

    public int getLives(){return this.lives;}

    public void takeLive(int livesLost){ this.lives -= livesLost;}

    public int getMoney(){return this.money;}

    public void addMoney(int money){this.money += money;}

    public void takeMoney(int money){this.money = this.money - money;}

    public void init() {
        if(!pause){
            store.available(false);
            wave.throwMinionToScreen();
        }else{
            store.available(true);
        }
        if(lives<=0 ){
            endGame();
        }else if(wave.getWaveEnded()){
            endGame();
        }
    }

    public void setScore(int score){this.score += score;}

    public int getScore(){return this.score;}

    public void update(Graphics graphics) {

        for(Tower t: towers){
            t.update(graphics.getDeltaTime());
        }
            for(Minion m: minions){
                m.update(graphics.getDeltaTime());
                if(m.isKilled()){
                    killBalloon(m);
                    addMoney(10);
                }
                if(m.finishedRoad()){
                    killBalloon(m);
                    takeLive(1);
                }
            }
        for (Minion m: deadMinion){
            minions.remove(m);
        }
        finishedRace();
    }

    public void finishedRace(){
        if(endBalloon == wave.getWave().size()){
            setWaveState(true);
            pauseGame();
            wave.nextLevel();
            endBalloon = 0;
        }
    }

    public void killBalloon(Minion m){
        endBalloon++;
        deadMinion.add(m);
        for(UIManager gl: listeners){
            gl.minionKilled(m);
        }
    }

    public void endGame(){
        pauseGame();
        clearMinions();
        streams.writeFile();
    }

    public void clearMinions(){
        minions.clear();
        listeners.clear();
    }

    public void setWaveState(boolean state){this.waveHasEnded = state;}

    public Road getRoad(){ return this.road; }

    public LinkedList<Minion> getMinionsInRange(Tower tower) {
        LinkedList<Minion> ret = new LinkedList<Minion>();
        for(Minion m:minions) {
            if (tower.getDistance(m) < tower.getRange()) {
                ret.add(m);
            }
        }
        return ret;
    }

    public void addTower(Tower tower) {
        this.towers.add(tower);
        for(GameListener gl: listeners)
            gl.towerAdded(tower);
    }

    public void addMinion(Minion minion) {
        minions.add(minion);
        for(GameListener gl: listeners)
            gl.minionAdded(minion);
    }

    public void addGameListeners(UIManager gameListener) {
        listeners.add(gameListener);
    }

    public void runGame(){
        this.pause = false;
    }

    public void pauseGame(){
        this.pause = true;
    }
}
