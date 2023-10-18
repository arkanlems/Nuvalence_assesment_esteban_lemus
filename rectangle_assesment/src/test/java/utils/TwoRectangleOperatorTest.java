package utils;

import model.Rectangle;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertEquals;


public class TwoRectangleOperatorTest {
    Rectangle rectangleA;
    Rectangle rectangleB;

    @Test
    public void noIntersectionTest(){
        rectangleA = createRectangle(1,3,4,1);
        rectangleB = createRectangle(5,3,7,1.5);
        assertEquals(TwoRectangleOperator.NO_INTERSECTION,TwoRectangleOperator.itsIntersection(rectangleA,rectangleB));
    }
    @Test
    public void completeIntersectionTest(){
        rectangleA = createRectangle(1,3,5,1);
        rectangleB = createRectangle(1.5,4,4,0.5);
        assertEquals(TwoRectangleOperator.COMPLETE_INTERSECTION,TwoRectangleOperator.itsIntersection(rectangleA,rectangleB));
    }
    @Test
    public void partialIntersectionTest(){
        rectangleA = createRectangle(2,4,4,2);
        rectangleB = createRectangle(1,3,5,1);
        assertEquals(TwoRectangleOperator.PARTIAL_INTERSECTION,TwoRectangleOperator.itsIntersection(rectangleA,rectangleB));
    }
    @Test
    public void heightWidthIntersectionTest(){
        rectangleA = createRectangle(2,5,6,2.5);
        rectangleB = createRectangle(1,4,4,2);
        assertEquals(TwoRectangleOperator.HEIGHT_WIDTH_INTERSECTION,TwoRectangleOperator.itsIntersection(rectangleA,rectangleB));
    }
    @Test
    public void itsContained(){
        rectangleA = createRectangle(1,3.5,5,1);
        rectangleB = createRectangle(1.5,3,4,2);
        assertEquals(TwoRectangleOperator.ITS_CONTAINMENT,TwoRectangleOperator.itsCointeinment(rectangleA,rectangleB));
    }
    @Test
    public void notContained(){
        rectangleA = createRectangle(1,3.5,5,1);
        rectangleB = createRectangle(0.5,3,4,2);
        assertEquals(TwoRectangleOperator.NOT_CONTAINMENT,TwoRectangleOperator.itsCointeinment(rectangleA,rectangleB));
    }
    private Rectangle createRectangle(double pointAx, double pointAy, double pointDx, double pointDy){
        return new Rectangle(new Point2D.Double(pointAx,pointAy),new Point2D.Double(pointDx,pointDy));
    }
}
