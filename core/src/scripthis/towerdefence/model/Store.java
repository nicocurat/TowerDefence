package scripthis.towerdefence.model;

import scripthis.towerdefence.Towers.Tower;

import java.util.NoSuchElementException;

/**
 * Created by brunodeluca on 11/19/15.
 */
public class Store {

    private boolean available = true;
    private Game game;
    protected Tower towerSelected;

    public Store(Game game, boolean available){
        this.game = game;
        this.available = available;
    }

    public void selectTower(Tower t){
        if(available){
            this.towerSelected = t;
            System.out.println(towerSelected.getId() + " selected" );
        }
    }

    public Tower buyTower(){
        if(available){
            if(towerSelected != null){
                if(game.getMoney() >= towerSelected.getCost()){
                    game.takeMoney(towerSelected.getCost());
                    return towerSelected;
                }else{
                    throw new RuntimeException("No money! \n" + "Your money: " + game.getMoney() + "\nTower cost: " + towerSelected.getCost());
                }

            }else{
                throw new NoSuchElementException("No tower selectected!");
            }
        }
        throw new RuntimeException("store not available");

    }

    public void available(boolean available){
        this.available = available;
    }





}