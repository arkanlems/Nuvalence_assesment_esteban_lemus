package utils;

import model.Rectangle;

public abstract class TwoRectangleOperator {
    public static final String NO_INTERSECTION = "theres no intersection between the rectangles";
    public static final String COMPLETE_INTERSECTION = "the rectangles split each other";
    public static final String PARTIAL_INTERSECTION = "two sides of one rectangle intersects one side of the other rectangle";
    public static final String HEIGHT_WIDTH_INTERSECTION = "one height cross with the other width and inverse";

    private TwoRectangleOperator(){
        throw new IllegalStateException("Utility class");
    }
    public static String itsIntersection(Rectangle rectangleA, Rectangle rectangleB){
        return null;
    }
}
