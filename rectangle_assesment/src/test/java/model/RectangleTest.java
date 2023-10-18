package model;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


@RunWith(MockitoJUnitRunner.class)
public class RectangleTest {
    @Mock
    private Point2D pointA;
    @Mock
    private Point2D pointD;

    private Rectangle rectangle;

    @Before
    public void setUp() {
        pointA = new Point2D.Double(1,4);
        pointD = new Point2D.Double(5,1);
        rectangle = new Rectangle(pointA, pointD);
    }
    @Test
    public void testConstructorWithInvalidArguments() {

        Point2D pointA = new Point2D.Double(4.0, 3.0);
        Point2D pointD = new Point2D.Double(1.0, 4.0);

        assertThrows(IllegalArgumentException.class, () -> new Rectangle(pointA, pointD));
    }
    @Test
    public void testGetPointA() {
        assertEquals(pointA, rectangle.getPointA());
    }

    @Test
    public void testGetPointB() {
        Point2D expectedPointB = new Point2D.Double(5.0, 4.0);
        assertEquals(expectedPointB, rectangle.getPointB());
    }

    @Test
    public void testGetPointC() {
        Point2D expectedPointC = new Point2D.Double(1.0, 1.0);
        assertEquals(expectedPointC, rectangle.getPointC());
    }

    @Test
    public void testGetPointD() {
        assertEquals(pointD, rectangle.getPointD());
    }

    @Test
    public void testGetHeight() {
        double expectedHeight = 3.0;
        assertEquals(expectedHeight, rectangle.getHeight(), 0.001);
    }

    @Test
    public void testGetWidth() {
        double expectedWidth = 4.0;
        assertEquals(expectedWidth, rectangle.getWidth(), 0.001);
    }
}