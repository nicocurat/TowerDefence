package scripthis.towerdefence.Minions;

public class SpecialDamage {

    private Minion m;

    public SpecialDamage(Minion m) {this.m = m;}

    public void froze(){
        m.setVelocity(0);
    }

    public void unFroze(){
        m.setVelocity(m.getPartialVelocity());
        m.isBeingDamaged(false);
    }


}
