package run;

import model.Rectangle;
import utils.TwoRectangleOperator;

import java.awt.geom.Point2D;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Hello to rectangle Assessment!!!");
        System.out.println("please put x coordinate from A point of rectangle 1: ");
        double xPointARectangle1 = in.nextDouble();
        System.out.println("please put y coordinate from A point of rectangle 1: ");
        double yPointARectangle1 = in.nextDouble();
        System.out.println("please put x coordinate from D point of rectangle 1: ");
        double xPointDRectangle1 = in.nextDouble();
        System.out.println("please put y coordinate from D point of rectangle 1: ");
        double yPointDRectangle1 = in.nextDouble();

        Rectangle rectangle1 = new Rectangle(new Point2D.Double(xPointARectangle1,yPointARectangle1),
                new Point2D.Double(xPointDRectangle1,yPointDRectangle1));

        System.out.println("please put x coordinate from A point of rectangle 2: ");
        double xPointARectangle2 = in.nextDouble();
        System.out.println("please put y coordinate from A point of rectangle 2: ");
        double yPointARectangle2 = in.nextDouble();
        System.out.println("please put x coordinate from D point of rectangle 2: ");
        double xPointDRectangle2 = in.nextDouble();
        System.out.println("please put y coordinate from D point of rectangle 2: ");
        double yPointDRectangle2 = in.nextDouble();

        Rectangle rectangle2 = new Rectangle(new Point2D.Double(xPointARectangle2,yPointARectangle2),
                new Point2D.Double(xPointDRectangle2,yPointDRectangle2));

        System.out.println("Intersection:");
        System.out.println(TwoRectangleOperator.itsIntersection(rectangle1,rectangle2));
        System.out.println("Contained:");
        System.out.println(TwoRectangleOperator.itsCointeinment(rectangle1,rectangle2));
        System.out.println("Adjacent:");
        System.out.println(TwoRectangleOperator.itsAdjecent(rectangle1,rectangle2));
    }
}