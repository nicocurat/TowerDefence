package scripthis.towerdefence.Point2D;

/**
 * Created by brunodeluca on 11/7/15.
 */
public class PolyLine {

    public PolyLine(Point[] points){
        if(points != null){
            for(Point p: points){
                addPoint(p);
            }
        }
    }


    public void addPoint(Point point){
        ListPoint newEnd = new ListPoint(point);
        if(start == null){
            start = newEnd;
        } else {
            end.setNext(newEnd);
        }

        end = newEnd;
    }

    public String toString(){
        StringBuffer str = new StringBuffer("PolyLine:");
        ListPoint nextPoint = start;
        while(nextPoint != null){
            str.append(" " + nextPoint);
            nextPoint = nextPoint.getNext();
        }

        return str.toString();
    }

    protected ListPoint start;
    protected ListPoint end;

}
