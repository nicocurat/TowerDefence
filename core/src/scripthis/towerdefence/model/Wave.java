package scripthis.towerdefence.model;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.utils.TimeUtils;
import scripthis.towerdefence.Minions.ElectricMinion;
import scripthis.towerdefence.Minions.Minion;
import scripthis.towerdefence.Minions.SimpleMinion;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Wave {
    private Game game;
    private LinkedList<Minion> wave1, wave2, wave3,wave4, wave5;
    private LinkedList<LinkedList<Minion>> levels;
    private int CurrentLevel = 0, i = 0;
    private boolean waveHasEnded = false;
    private long lastBalloonTime;

    public Wave(Game game){
        this.game = game;
        this.levels = new LinkedList<LinkedList<Minion>>();

        this.wave1 = new LinkedList<Minion>();
        this.wave2 = new LinkedList<Minion>();
        this.wave3 = new LinkedList<Minion>();
        this.wave4 = new LinkedList<Minion>();
        this.wave5 = new LinkedList<Minion>();

        for(int i=0; i<5; i++){ wave1.add(new SimpleMinion(2,game));}
        for(int i = 0; i<7;i++){ wave2.add(new SimpleMinion(2,game));}
        for(int i = 0; i<20; i++){ wave3.add(new SimpleMinion(2,game));}
        for(int i = 0; i<30; i++){wave4.add(new SimpleMinion(3,game));}
        for(int i = 0; i<40; i++){wave5.add(new SimpleMinion(3, game));}

        levels.add(wave1);
        levels.add(wave2);
        levels.add(wave3);
        levels.add(wave4);
        levels.add(wave5);

    }

    public void endGameWave(){
        waveHasEnded = true;
    }

    public boolean getWaveEnded(){return this.waveHasEnded;}

    public int getLevel(){return this.CurrentLevel; }

    public void throwMinionToScreen(){
        if(!waveHasEnded){
            if(TimeUtils.millis() - lastBalloonTime > 1000/2.5){
                if(i <= levels.get(CurrentLevel).size()-1){
                    game.addMinion(next());
                }
            }
        }else{
            endGameWave();
        }
    }

    public LinkedList<Minion> getWave(){
        return levels.get(CurrentLevel);
    }

    public Minion next(){
        lastBalloonTime = TimeUtils.millis();
        Minion m = levels.get(CurrentLevel).get(i++);
        return m;
    }

    public void nextLevel(){
        if(CurrentLevel < levels.size()-1){
            this.CurrentLevel++;
            i = 0;
        }else{
            System.out.println("Game ended");
        }
    }

}
