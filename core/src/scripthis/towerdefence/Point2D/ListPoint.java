package scripthis.towerdefence.Point2D;

/**
 * Created by brunodeluca on 11/7/15.
 */
public class ListPoint {

    private ListPoint next;
    private Point point;

    public ListPoint(Point point){
        this.point = point;
        this.next = null;
    }

    public Point getPoint(){ return this.point; }

    public void setNext(ListPoint next){
        this.next = next;
    }

    public ListPoint getNext(){
        return this.next;
    }

    public String toString(){
        return "(" + point + ")";
    }


}
