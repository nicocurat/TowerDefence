package scripthis.towerdefence.Point2D;

/**
 * Created by brunodeluca on 11/7/15.
 */
public class Point {

    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(Point point){
        this.x = point.x;
        this.y = point.y;
    }

    public String toString(){
        return x+ "," + y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public float getDistance(Point point){
        float x = getX() - point.getX();
        float y = getY() - point.getY();
        return x + y;
    }
}
