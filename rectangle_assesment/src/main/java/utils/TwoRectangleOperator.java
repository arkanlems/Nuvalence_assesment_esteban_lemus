package utils;

import model.Rectangle;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.operation.relate.RelateOp;

import java.awt.geom.Point2D;


public abstract class TwoRectangleOperator {
    public static final String NO_INTERSECTION = "theres no intersection between the rectangles";
    public static final String COMPLETE_INTERSECTION = "the rectangles split each other";
    public static final String PARTIAL_INTERSECTION = "two sides of one rectangle intersects one side of the other rectangle";
    public static final String HEIGHT_WIDTH_INTERSECTION = "one height cross with the other width and inverse";
    public static final String ITS_CONTAINMENT = "one rectangle its contained";
    public static final String NOT_CONTAINMENT = "no rectangle is contained";

    private TwoRectangleOperator(){
        throw new IllegalStateException("Utility class");
    }

    /*
    * this function take two points of each rectangle the A and the D point to be exact with this information is in off
    * to say if one rectangle is contained
    * @param rectangle1 represents the first rectangle
    * @param rectangle 2 represents the second rectangle
    * @return return the static value that represent the kind of containment
    * */
    public static String itsCointeinment(Rectangle rectangle1, Rectangle rectangle2){
        if(rectangle1.getPointA().getX()<rectangle2.getPointA().getX()&&
                rectangle1.getPointA().getY()>rectangle2.getPointA().getY()&&
                rectangle1.getPointD().getX()>rectangle2.getPointD().getX()&&
                rectangle1.getPointD().getY()<rectangle2.getPointD().getY()
        )return ITS_CONTAINMENT;
        if(rectangle2.getPointA().getX()<rectangle1.getPointA().getX()&&
                rectangle2.getPointA().getY()>rectangle1.getPointA().getY()&&
                rectangle2.getPointD().getX()>rectangle1.getPointD().getX()&&
                rectangle2.getPointD().getY()<rectangle1.getPointD().getY()
        )return ITS_CONTAINMENT;
        return NOT_CONTAINMENT;
    }
    /*
    * this function count the number of intersections between the different sides and depending on the result it says
    * which kind of intersection is or is not
    * @param rectangle1 represents the first rectangle
    * @param rectangle 2 represents the second rectangle
    * @return return the static value that represent the kind of intersection
    **/
    public static String itsIntersection(Rectangle rectangle1, Rectangle rectangle2){
        int numberIntersectionsRectangle1ACside = numberInterSectionsOneVerticalSideAginstTwoHorizontal(rectangle1.getPointA(),
                rectangle1.getPointC(),rectangle2);
        int numberIntersectionsRectangle1BDside = numberInterSectionsOneVerticalSideAginstTwoHorizontal(rectangle1.getPointB(),
                rectangle1.getPointD(),rectangle2);
        int numberIntersectionsRectangle1ABside = numberInterSectionsTwoVerticalSideAginstOneHorizontal(rectangle1.getPointA(),
                rectangle1.getPointB(),rectangle2);
        int numberIntersectionsRectangle1CDside = numberInterSectionsTwoVerticalSideAginstOneHorizontal(rectangle1.getPointC(),
                rectangle1.getPointD(),rectangle2);
        if(numberIntersectionsRectangle1ACside+numberIntersectionsRectangle1BDside
                +numberIntersectionsRectangle1ABside+numberIntersectionsRectangle1CDside == 0) return NO_INTERSECTION;
        if(numberIntersectionsRectangle1ACside+numberIntersectionsRectangle1BDside
                +numberIntersectionsRectangle1ABside+numberIntersectionsRectangle1CDside == 4) return COMPLETE_INTERSECTION;
        if(numberIntersectionsRectangle1ABside+numberIntersectionsRectangle1CDside == 2) return PARTIAL_INTERSECTION;
        if(numberIntersectionsRectangle1ACside+numberIntersectionsRectangle1BDside == 2) return PARTIAL_INTERSECTION;

        return HEIGHT_WIDTH_INTERSECTION;
    }

    private static int numberInterSectionsTwoVerticalSideAginstOneHorizontal(Point2D rectangle1HeightSidePoint1,
                                                                             Point2D rectangle1HeightSidePoint2,
                                                                             Rectangle rectangle2){
        int numberIntersections =0;

        if(doLinesIntersect(rectangle1HeightSidePoint1,rectangle1HeightSidePoint2,
                rectangle2.getPointA(),rectangle2.getPointC())) numberIntersections++;
        if(doLinesIntersect(rectangle1HeightSidePoint1,rectangle1HeightSidePoint2,
                rectangle2.getPointB(),rectangle2.getPointD())) numberIntersections++;

        return numberIntersections;
    }
    private static int numberInterSectionsOneVerticalSideAginstTwoHorizontal(Point2D rectangle1HeightSidePoint1,
                                                                             Point2D rectangle1HeightSidePoint2,
                                                                             Rectangle rectangle2){
        int numberIntersections =0;

        if(doLinesIntersect(rectangle1HeightSidePoint1,rectangle1HeightSidePoint2,
                rectangle2.getPointA(),rectangle2.getPointB())) numberIntersections++;
        if(doLinesIntersect(rectangle1HeightSidePoint1,rectangle1HeightSidePoint2,
                rectangle2.getPointC(),rectangle2.getPointD())) numberIntersections++;

        return numberIntersections;
    }

    private static boolean doLinesIntersect(Point2D p1, Point2D p2, Point2D q1, Point2D q2) {
        Coordinate[] line1Coordinates = new Coordinate[]{
                new Coordinate(p1.getX(), p1.getY()),
                new Coordinate(p2.getX(), p2.getY())
        };

        Coordinate[] line2Coordinates = new Coordinate[]{
                new Coordinate(q1.getX(), q1.getY()),
                new Coordinate(q2.getX(), q2.getY())
        };

        LineString line1 = new GeometryFactory().createLineString(line1Coordinates);
        LineString line2 = new GeometryFactory().createLineString(line2Coordinates);

        RelateOp relateOp = new RelateOp(line1, line2);
        return relateOp.getIntersectionMatrix().isIntersects();
    }
}
