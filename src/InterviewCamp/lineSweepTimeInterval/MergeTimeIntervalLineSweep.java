package InterviewCamp.lineSweepTimeInterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Level: Medium Merge Intervals - Given a list of intervals, merge all overlapping intervals.
// At the end of the merge, there should be no overlapping intervals.
public class MergeTimeIntervalLineSweep {

    public static void main(String[] args) {

        Interval interval = new Interval(3, 4);
        Interval interval2 = new Interval(5, 8);
        Interval interval3 = new Interval(6, 9);
        Interval interval4 = new Interval(10, 12);
        Interval interval5 = new Interval(11, 14);

        Interval[] intervals = {interval, interval2, interval3, interval4, interval5};

        mergeIntervals(intervals).forEach(s -> System.out.print(s.getStart() + " " + s.getEnd()));

    }

    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // Turn Interval into points
        List<Point> points = new ArrayList<>();

        for (Interval interval : intervals) {
            points.add(new Point(interval.getStart(), true));
            points.add(new Point(interval.getEnd(), false));
        }

        points.forEach(point -> System.out.print(" " + point.getTime()));

        // Sort points in order of time
        // Sort order is defined by the comparable interface
        Collections.sort(points);
        System.out.println();
        points.forEach(point -> System.out.print(" " + point.getTime()));
        System.out.println();

        List<Interval> result = new ArrayList<Interval>();

        // Loop through points
        int numIntervals = 0;
        Point startPoint = null;
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            if (point.isStart) {
                numIntervals++;
                if (numIntervals == 1) {
                    startPoint = point;
                }
            } else {
                numIntervals--;
                if (numIntervals == 0) {
                    result.add(new Interval(startPoint.getTime(), point.getTime()));
                }
            }
        }
        return result;
    }
}