package scripthis.towerdefence.model;

import scripthis.towerdefence.Point2D.ListPoint;
import scripthis.towerdefence.Point2D.Point;
import scripthis.towerdefence.Point2D.PolyLine;

import java.util.LinkedList;

public class Road{
    protected ListPoint start;
    protected ListPoint end;
    private Point finishLine;
    LinkedList<Point> points = new LinkedList<Point>();


    public Road(){
        Point[] points = {new Point(0,220), new Point(105,220), new Point(105,360), new Point(230,360), new Point(230,170), new Point(400,170), new Point(400, 260), new Point(650,260)};
        for(Point p: points){
            addPoint(p);
        }
        finishLine = new Point(645,260);
        createRoad();
    }

    public Point getFinishLine() {
        return finishLine;
    }

    public void setFinishLine(Point finishLine) {
        this.finishLine = finishLine;
    }

    public Point getLastPoint(){return points.get(points.size()-1);}

    public void addPoint(Point point){

        ListPoint newEnd = new ListPoint(point);
        if(start == null){
            start = newEnd;
        } else {
            end.setNext(newEnd);
        }
        end = newEnd;
    }

    public void createRoad() {

        ListPoint nextPoint = start;

        while(nextPoint != null && nextPoint.getNext() != null){
            int aX = nextPoint.getPoint().getX();
            int bX = nextPoint.getNext().getPoint().getX();

            int aY = nextPoint.getPoint().getY();
            int bY = nextPoint.getNext().getPoint().getY();

            int x = bX - aX;
            int y = bY - aY;

            int omega = Math.abs(x) + Math.abs(y);

            for(int i = 0; i <= omega; i++){
                int newX = (i*x)/(omega) + aX;
                int newY = (i*y)/(omega) + aY;
                points.add(new Point(newX, newY));
            }

            nextPoint = nextPoint.getNext();

        }

    }

    public LinkedList<Point> getList(){ return this.points; }

}
