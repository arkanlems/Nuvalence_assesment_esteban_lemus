package assesment.rectangle.imlementation.model;

import java.awt.geom.Point2D;

import static com.google.common.base.Preconditions.checkArgument;

public class Rectangle {
    private final Point2D pointA;
    private Point2D pointB;
    private Point2D pointC;
    private final Point2D pointD;
    private double height;
    private double width;

    public Rectangle(Point2D pointA, Point2D pointD) {
        checkArgument(pointA.getX() < pointD.getX() && pointD.getY() < pointA.getY()
                ,"Point A must be on left upper corner of the rectangle and point D must be on lower right corner" +
                        " and size of height and width must be greater than 0");
        this.pointA = pointA;
        this.pointD = pointD;
        calculateCBPoints();
        calculateHeightWidth();
    }
    private void calculateCBPoints(){
        this.pointB = new Point2D.Double(this.pointD.getX(),this.pointA.getY());
        this.pointC = new Point2D.Double(this.pointA.getX(),this.pointB.getY());
    }
    private void calculateHeightWidth(){
        this.height = this.pointA.distance(this.pointC);
        this.width = this.pointA.distance(this.pointB);
    }

    public Point2D getPointA() {
        return pointA;
    }

    public Point2D getPointB() {
        return pointB;
    }

    public Point2D getPointC() {
        return pointC;
    }

    public Point2D getPointD() {
        return pointD;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
