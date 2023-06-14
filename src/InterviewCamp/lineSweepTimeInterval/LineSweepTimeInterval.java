package InterviewCamp.lineSweepTimeInterval;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

//Level: Medium Given a list of time intervals, find if any of them overlap.
public class LineSweepTimeInterval {

    public static void main(String[] args) {

        Interval interval = new Interval(3, 4);
        Interval interval2 = new Interval(5, 8);
        Interval interval3 = new Interval(6, 9);
        Interval interval4 = new Interval(10, 12);
        Interval interval5 = new Interval(11, 14);

        Interval [] intervals = { interval, interval2, interval3, interval4, interval5 };

        System.out.println(hasOverlap(intervals));

    }

    public static boolean hasOverlap(Interval[] intervals) {
        // Turn Interval into points
        List<Point> points = new ArrayList<>();

        for (Interval interval: intervals) {
            points.add(new Point(interval.getStart(), true));
            points.add(new Point(interval.getEnd(), false));
        }

        points.forEach(point -> System.out.print(" " + point.getTime()));


        // Sort points in order of time
        // Sort order is defined by the comparable interface
        Collections.sort(points);
        System.out.println();
        points.forEach(point -> System.out.print(" " + point.getTime()));

        // Loop through Points
        int count = 0;
        for (int i = 0; i < points.size(); i++) {
            count = points.get(i).isStart() ? count + 1 : count - 1;
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

}
