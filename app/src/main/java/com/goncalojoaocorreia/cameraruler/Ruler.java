package com.goncalojoaocorreia.cameraruler;

import android.graphics.Point;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gonçalo on 13/02/2015.
 */
public class Ruler {

    private Ruler(){}

    public static double compute(List<Point> points, double scale){
        if(points.size() < 4) return -1;

        //Get reference points
        Point ref1 = points.get(0);
        Point ref2 = points.get(1);
        //Get the measurement points
        Point m1 = points.get(2);
        Point m2 = points.get(3);

        double reference = getDistance(ref1, ref2);
        double measurement = getDistance(m1, m2);

        return (measurement * scale) / reference;
    }

    /**
     * Get the distance between 2 points
     * @param p1 First point
     * @param p2 Second point
     * @return Distance between the 2 points
     */
    private static double getDistance(Point p1, Point p2){
        double x = Math.pow(p2.x - p1.x, 2);
        double y = Math.pow(p2.y - p1.y, 2);
        return Math.sqrt(x+y);
    }
}
