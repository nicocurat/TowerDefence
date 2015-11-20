package scripthis.towerdefence.Towers;

public class AttackUpdate {

    private Tower tower;

    public AttackUpdate(Tower tower){
        this.tower = tower;
    }

    public void updateIndividual(float timedelta){
        tower.timer += timedelta;
        tower.target = tower.getGame().getMinionsInRange(tower);

        if(tower.getTimer() > tower.getDelay()){

            if(!tower.getTarget().isEmpty() && tower.getDistance(tower.getTarget().get(0)) > tower.getRange()){
                tower.update(timedelta);
            }

            if(!tower.getTarget().isEmpty() && !tower.getTarget(0).isKilled()){
                tower.attack(tower.getTarget(0));

                if(tower.getTarget(0).isKilled()){
                    tower.getTarget().clear();
                    //tower.getGame().addMoney(10);
                    tower.getGame().setScore(1);
                }
            }
            tower.timer = 0;
        }
    }

    public void updateMulti(float timedelta){
        tower.timer += timedelta;
        tower.target = tower.getGame().getMinionsInRange(tower);

        if(tower.getTimer() > tower.getDelay()){

            if(!tower.getTarget().isEmpty() && !tower.getTarget(0).isKilled()){

                tower.attack(tower.getTarget());

                if(tower.getTarget(0).isKilled()){
                    tower.getTarget().clear();
                    tower.setTarget(tower.getTarget());
                    //tower.getGame().addMoney(10*tower.getTarget().size());
                    tower.getGame().setScore(1);
                }
            }
            tower.setTimer(0);
        }
    }


}
